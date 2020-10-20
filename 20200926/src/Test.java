import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-09-26
 * Time: 16:16
 */
public class Test {

    /**
     * The default initial capacity - MUST be a power of two.
     */
    //初始化容量相当于 16, 1 << 4就是16
            //为什么必须是2的n次幂 这是一个数学问题 懒得研究了
    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16


    /*
    1)、首先，为什么要对cap做减1操作。int n = cap - 1;
这是为了防止，cap已经是2的幂。如果cap已经是2的幂， 又没有执行这个减1操作，则执行完后面的几条无符号右移操作之后，
返回的capacity将是这个cap的2倍。如果不懂，要看完后面的几个无符号右移之后再回来看看。
下面看看这几个无符号右移操作：
    2）、如果n这时为0了（经过了cap-1之后），则经过后面的几次无符号右移依然是0，最后返回的capacity是1（最后有个n+1的操作）。
这里只讨论n不等于0的情况。

     3）、注意：|（按位或运算）：运算规则：相同的二进制数位上，都是0的时候，结果为0，否则为1。
     */
    private static final int MAXIMUM_CAPACITY = 1 << 30; //集合最大容量
    private final float loadFactor;

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    //桶中结构转化为红黑树对应的数组长度最小的值
    static final int MIN_TREEIFY_CAPACITY = 64;

    //存储元素的数组
    transient Node<K,V>[] table;

    public HashMap() {
        this.loadFactor = DEFAULT_LOAD_FACTOR; // 将默认的负载因子赋值
    }



    public HashMap(int initialCapacity, float loadFactor) {
        //判断初始容量是否为0
        if (initialCapacity < 0)
            //为0抛出异常
            throw new IllegalArgumentException("Illegal initial capacity: " +
                    initialCapacity);
        //判断初始容量是否大于hashMap允许的最大值2的30次幂
        if (initialCapacity > MAXIMUM_CAPACITY)
            initialCapacity = MAXIMUM_CAPACITY;
        //判断负载因子是否小于0 或者等于0 或者是一个非数值
        if (loadFactor <= 0 || Float.isNaN(loadFactor))
            throw new IllegalArgumentException("Illegal load factor: " +
                    loadFactor);
        //指定初始容量和负载因子
        this.loadFactor = loadFactor;
        //hashMap的容量必须是2的n次幂 这个算法实现在上面有说到
        this.threshold = tableSizeFor(initialCapacity);
    }

    final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                   boolean evict) {
        HashMap.Node<K,V>[] tab; HashMap.Node<K,V> p; int n, i;
        if ((tab = table) == null || (n = tab.length) == 0)
            n = (tab = resize()).length;
        /*
        1）transient Node<K,V>[] table; 表示存储Map集合中元素的数组。
    	2）(tab = table) == null 表示将空的table赋值给tab,然后判断tab是否等于null，第一次肯定是			null
    	3）(n = tab.length) == 0 表示将数组的长度0赋值给n,然后判断n是否等于0，n等于0
    	由于if判断使用双或，满足一个即可，则执行代码 n = (tab = resize()).length; 进行数组初始化。
    	并将初始化好的数组长度赋值给n.
    	4）执行完n = (tab = resize()).length，数组tab每个空间都是null
         */
        if ((p = tab[i = (n - 1) & hash]) == null)
            tab[i] = newNode(hash, key, value, null);
        /*
        	1）i = (n - 1) & hash 表示计算数组的索引赋值给i，即确定元素存放在哪个桶中
    	2）p = tab[i = (n - 1) & hash]表示获取计算出的位置的数据赋值给节点p
    	3) (p = tab[i = (n - 1) & hash]) == null 判断节点位置是否等于null，如果为null，则执行代码：
    	tab[i] = newNode(hash, key, value, null);
    	根据键值对创建新的节点放入该位置的桶中
         */
        else {
            // 执行else说明tab[i]不等于null，表示这个位置已经有值了。
            HashMap.Node<K,V> e; K k;
            /*
            比较桶中第一个元素(数组中的结点)的hash值和key是否相等
        	1）p.hash == hash ：p.hash表示原来存在数据的hash值  hash表示后添加数据的hash值 比较两个hash值是否相等
                 说明：p表示tab[i]，即 newNode(hash, key, value, null)方法返回的Node对象。
                    Node<K,V> newNode(int hash, K key, V value, Node<K,V> next)
                    {
                        return new Node<>(hash, key, value, next);
                    }
                    而在Node类中具有成员变量hash用来记录着之前数据的hash值的
             2）(k = p.key) == key ：p.key获取原来数据的key赋值给k  key 表示后添加数据的key 比较两个key的地址值是否相等
             3）key != null && key.equals(k)：能够执行到这里说明两个key的地址值不相等，那么先判断后添加的key是否等于null，
             如果不等于null再调用equals方法判断两个key的内容是否相等
             */
            if (p.hash == hash &&
                    ((k = p.key) == key || (key != null && key.equals(k))))
                e = p;
            else if (p instanceof HashMap.TreeNode)
                //第一个节点就是树的节点 那就将e也转为树的节点
                e = ((HashMap.TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
            else {
                // 说明是链表节点
                /*
                1)如果是链表的话需要遍历到最后节点然后插入
            	2)采用循环遍历的方式，判断链表中是否有重复的key
                 */
                for (int binCount = 0; ; ++binCount) {
                    if ((e = p.next) == null) {
                        p.next = newNode(hash, key, value, null);
                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                            treeifyBin(tab, hash);
                        break;
                    }
                    if (e.hash == hash &&
                            ((k = e.key) == key || (key != null && key.equals(k))))
                        break;
                    p = e;
                }
            }
            if (e != null) { // existing mapping for key
                V oldValue = e.value;
                if (!onlyIfAbsent || oldValue == null)
                    e.value = value;
                afterNodeAccess(e);
                return oldValue;
            }
        }
        ++modCount;
        // 判断实际大小是否大于threshold阈值，如果超过则扩容
        if (++size > threshold)
            resize();
        afterNodeInsertion(evict);
        return null;
    }

    final void treeifyBin(HashMap.Node<K,V>[] tab, int hash) {
        int n, index; HashMap.Node<K,V> e;
        if (tab == null || (n = tab.length) < MIN_TREEIFY_CAPACITY)
            /*
            如果当前数组为空或者数组的长度小于进行树形化的阈值(MIN_TREEIFY_CAPACITY = 64),
        	就去扩容。而不是将节点变为红黑树。
             */
            resize();
        else if ((e = tab[index = (n - 1) & hash]) != null) {
            /*
            1）执行到这里说明哈希表中的数组长度大于阈值64，开始进行树形化
            2）e = tab[index = (n - 1) & hash]表示将数组中的元素取出赋值给e,
            e是哈希表中指定置桶里的链表节点，从第一个开始
             */
            HashMap.TreeNode<K,V> hd = null, tl = null;
            //hd表示红黑树头, tl表示尾
            do {
                HashMap.TreeNode<K,V> p = replacementTreeNode(e, null);
                if (tl == null)
                    hd = p;
                else {
                    p.prev = tl;
                    tl.next = p;
                }
                tl = p;
            } while ((e = e.next) != null);
            if ((tab[index] = hd) != null)
                hd.treeify(tab);
        }

        final HashMap.TreeNode<K,V> find(int h, Object k, Class<?> kc) {
            HashMap.TreeNode<K,V> p = this;
            do {
                int ph, dir; K pk;
                HashMap.TreeNode<K,V> pl = p.left, pr = p.right, q;
                if ((ph = p.hash) > h)
                    p = pl;
                else if (ph < h)
                    p = pr;
                else if ((pk = p.key) == k || (k != null && k.equals(pk)))
                    //找到之后直接返回
                    return p;
                else if (pl == null)
                    p = pr;
                else if (pr == null)
                    p = pl;
                else if ((kc != null ||
                        (kc = comparableClassFor(k)) != null) &&
                        (dir = compareComparables(kc, k, pk)) != 0)
                    p = (dir < 0) ? pl : pr;
                    //递归查找
                else if ((q = pr.find(h, k, kc)) != null)
                    return q;
                else
                    p = pl;
            } while (p != null);
            return null;
        }


        final HashMap.Node<K,V> getNode(int hash, Object key) {
            HashMap.Node<K,V>[] tab; HashMap.Node<K,V> first, e; int n; K k;
            //如果哈希表不为空并且key对应的桶上不为空
            if ((tab = table) != null && (n = tab.length) > 0 &&
                    (first = tab[(n - 1) & hash]) != null) {
                /*
                判断数组元素是否相等
        	    根据索引的位置检查第一个元素
                 */
                if (first.hash == hash && // always check first node
                        ((k = first.key) == key || (key != null && key.equals(k))))
                    return first;
                // 如果不是第一个元素，判断是否有后续节点
                if ((e = first.next) != null) {
                    if (first instanceof HashMap.TreeNode)

                        return ((HashMap.TreeNode<K,V>)first).getTreeNode(hash, key);
                    do {
                        // 不是红黑树的话，那就是链表结构了，通过循环的方法判断链表中是否存在该key
                        if (e.hash == hash &&
                                ((k = e.key) == key || (key != null && key.equals(k))))
                            return e;
                    } while ((e = e.next) != null);
                }
            }
            return null;
        }

        final HashMap.Node<K,V> removeNode(int hash, Object key, Object value,
        boolean matchValue, boolean movable) {
            HashMap.Node<K,V>[] tab; HashMap.Node<K,V> p; int n, index;
            //根据hash找到位置
            //如果当前key映射到的桶不为空
            if ((tab = table) != null && (n = tab.length) > 0 &&
                    (p = tab[index = (n - 1) & hash]) != null) {
                HashMap.Node<K,V> node = null, e; K k; V v;
                //如果桶上的节点就是要找的key，则将node指向该节点
                if (p.hash == hash &&
                        ((k = p.key) == key || (key != null && key.equals(k))))
                    node = p;
                else if ((e = p.next) != null) {
                    //说明节点存在下一个节点
                    if (p instanceof HashMap.TreeNode)
                        //说明是以红黑树来处理的冲突，则获取红黑树要删除的节点
                        node = ((HashMap.TreeNode<K,V>)p).getTreeNode(hash, key);
                    else {
                        do {
                            if (e.hash == hash &&
                                    ((k = e.key) == key ||
                                            (key != null && key.equals(k)))) {
                                node = e;
                                break;
                            }
                            p = e;
                        } while ((e = e.next) != null);
                    }
                }
                if (node != null && (!matchValue || (v = node.value) == value ||
                        (value != null && value.equals(v)))) {
                    if (node instanceof HashMap.TreeNode)
                        ((HashMap.TreeNode<K,V>)node).removeTreeNode(this, tab, movable);
                    else if (node == p)
                        //链表删除
                        tab[index] = node.next;
                    else
                        p.next = node.next;
                    ++modCount;
                    --size;
                    afterNodeRemoval(node);
                    return node;
                }
            }
            return null;
        }

        //扩容
        final HashMap.Node<K,V>[] resize() {
            //得到当前数组
            HashMap.Node<K,V>[] oldTab = table;
            //如果当前数组等于null长度返回0，否则返回当前数组的长度
            int oldCap = (oldTab == null) ? 0 : oldTab.length;
            //当前阀值点 默认是12(16*0.75)
            int oldThr = threshold;
            int newCap, newThr = 0;
            //如果老的数组长度大于0
            //开始计算扩容后的大小
            if (oldCap > 0) {
                // 超过最大值就不再扩充了
                if (oldCap >= MAXIMUM_CAPACITY) {
                    threshold = Integer.MAX_VALUE;
                    return oldTab;
                }
                else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY &&
                        oldCap >= DEFAULT_INITIAL_CAPACITY)
                    /*
                    没超过最大值，就扩充为原来的2倍
        	1)(newCap = oldCap << 1) < MAXIMUM_CAPACITY 扩大到2倍之后容量要小于最大容量
        	2）oldCap >= DEFAULT_INITIAL_CAPACITY 原数组长度大于等于数组初始化长度16
                     */
                    newThr = oldThr << 1; // double threshold
            }
            else if (oldThr > 0) // initial capacity was placed in threshold
                //老阈值点大于0 直接赋值
                newCap = oldThr;
            else {               // zero initial threshold signifies using defaults
                newCap = DEFAULT_INITIAL_CAPACITY;
                newThr = (int)(DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);
            }
            // 计算新的resize最大上限
            if (newThr == 0) {
                float ft = (float)newCap * loadFactor;
                newThr = (newCap < MAXIMUM_CAPACITY && ft < (float)MAXIMUM_CAPACITY ?
                        (int)ft : Integer.MAX_VALUE);
            }
            //新的阀值 默认原来是12 乘以2之后变为24
            threshold = newThr;
            @SuppressWarnings({"rawtypes","unchecked"})
            HashMap.Node<K,V>[] newTab = (HashMap.Node<K,V>[])new HashMap.Node[newCap];
            table = newTab;
            //判断旧数组是否等于空
            if (oldTab != null) {
                // 把每个bucket都移动到新的buckets中
                //遍历旧的哈希表的每个桶，重新计算桶里元素的新位置
                for (int j = 0; j < oldCap; ++j) {
                    HashMap.Node<K,V> e;
                    if ((e = oldTab[j]) != null) {
                        oldTab[j] = null;
                        if (e.next == null)
                            newTab[e.hash & (newCap - 1)] = e;
                        else if (e instanceof HashMap.TreeNode)
                            ((HashMap.TreeNode<K,V>)e).split(this, newTab, j, oldCap);
                        else { // preserve order
                            HashMap.Node<K,V> loHead = null, loTail = null;
                            HashMap.Node<K,V> hiHead = null, hiTail = null;
                            HashMap.Node<K,V> next;
                            do {
                                next = e.next;
                                if ((e.hash & oldCap) == 0) {
                                    if (loTail == null)
                                        loHead = e;
                                    else
                                        loTail.next = e;
                                    loTail = e;
                                }
                                else {
                                    if (hiTail == null)
                                        hiHead = e;
                                    else
                                        hiTail.next = e;
                                    hiTail = e;
                                }
                            } while ((e = next) != null);
                            if (loTail != null) {
                                loTail.next = null;
                                newTab[j] = loHead;
                            }
                            if (hiTail != null) {
                                hiTail.next = null;
                                newTab[j + oldCap] = hiHead;
                            }
                        }
                    }
                }
            }
            return newTab;
        }
    }

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
    }
}
