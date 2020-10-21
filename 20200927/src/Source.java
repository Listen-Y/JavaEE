/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-09-27
 * Time: 16:23
 */
public class Source {

    public class ArrayList<E> {
        //将添加的数据传入给
        e public boolean add(E e) {
            //调用方法对内部容量进行校验
            ensureCapacityInternal(size + 1);
            elementData[size++] = e;
            return true; }
            private void ensureCapacityInternal(int minCapacity) {
            //判断集合存数据的数组是否等于空容量的数组
            if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
                //通过最小容量和默认容量 求出较大值 (用于第一次扩容)
                minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);
            }
                // 将if中计算出来的容量传递给下一个方法,继续校验
                ensureExplicitCapacity(minCapacity);
        }private void ensureExplicitCapacity(int minCapacity) {
            //实际修改集合次数++ (在扩容的过程中没用,主要是用于迭代器中)
            modCount++;
            //判断最小容量 - 数组长度是否大于 0
            if (minCapacity - elementData.length > 0)
                将第一次计算出来的容量传递给 核心扩容方法
        grow(minCapacity);
        }
            }
       private void grow(int minCapacity) { 
//记录数组的实际长度,此时由于木有存储元素,长度为0 
int oldCapacity = elementData.length; 
//核心扩容算法 原容量的1.5倍 
int newCapacity = oldCapacity + (oldCapacity >> 1); 
//判断新容量 - 最小容量 是否小于 0, 如果是第一次调用add方法必然小于
 if (newCapacity - minCapacity < 0) 
//还是将最小容量赋值给新容量 
newCapacity = minCapacity; 
//判断新容量-最大数组大小 是否>0,如果条件满足就计算出一个超大容量
 if (newCapacity - MAX_ARRAY_SIZE > 0) 
newCapacity = hugeCapacity(minCapacity); 
// 调用数组工具类方法,创建一个新数组,将新数组的地址赋值给
elementData elementData = Arrays.copyOf(elementData, newCapacity);
 } 
}
}
