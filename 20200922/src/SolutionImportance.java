import java.util.*;
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};




class Solution {

    /**
     * 给定一个保存员工信息的数据结构，它包含了员工唯一的id，重要度 和 直系下属的id。
     *
     * 比如，员工1是员工2的领导，员工2是员工3的领导。他们相应的重要度为15, 10, 5。那么员工1的数据结构是[1, 15, [2]]，员工2的数据结构是[2, 10, [3]]，员工3的数据结构是[3, 5, []]。注意虽然员工3也是员工1的一个下属，但是由于并不是直系下属，因此没有体现在员工1的数据结构中。
     *
     * 现在输入一个公司的所有员工信息，以及单个员工id，返回这个员工和他所有下属的重要度之和。
     *
     * 示例 1:
     *
     * 输入: [[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
     * 输出: 11
     * 解释:
     * 员工1自身的重要度是5，他有两个直系下属2和3，而且2和3的重要度均为3。因此员工1的总重要度是 5 + 3 + 3 = 11。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/employee-importance
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param employees
     * @param id
     * @return
     */
    public int getImportance(List<Employee> employees, int id) {
        //将所有员工保存在map中
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee em : employees) {
            map.put(em.id, em);
        }
        //需要返回的重要性
        int importance = 0;
        //创建一个队列保存下属员工
        Queue<Employee> queue = new LinkedList<>();
        queue.offer(map.get(id));
        while (!queue.isEmpty()) {
            //获得当前有队列里有几个下属员工
            int size = queue.size();
            while (size-- > 0) {
                //获取下属
                Employee employ = queue.poll();
                importance += employ.importance;
                //判断当前员工还有没有下属 如果有就加到队列中
                if (employ.subordinates != null) {
                    for (int curId : employ.subordinates) {
                        queue.offer(map.get(curId));
                    }
                }
            }
        }
        return importance;
    }
}