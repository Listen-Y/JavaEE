import java.util.*;
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};


class Solution1 {
    /**
     * 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
     *
     * 例如，给定一个 3叉树 :
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(Node root) {

        //创建一个队列保存每一层的节点数据
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) return ret;
        while (!queue.isEmpty()) {
            //获取当前层的结点个数
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            while (size-- > 0) {
                //将该层所有结点的数据保存在链表中
                Node cur = queue.poll();
                list.add(cur.val);
                //如果当前结点下一层还有结点就入队列
                if (cur.children != null) {
                    for (Node node : cur.children) {
                        queue.offer(node);
                    }
                }
            }
            ret.add(list);
        }
        return ret;
    }
}