import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};


class SolutionImportance {

    private int DFS(Map<Integer, Employee> map, int id) {

        //通过id找到对应员工
        Employee employee = map.get(id);
        for (int emId : employee.subordinates) {
            //累加所有员工的重要性
            employee.importance += DFS(map, emId);
        }
        return employee.importance;
    }

    /**
     * 给定一个保存员工信息的数据结构，它包含了员工唯一的id，重要度 和 直系下属的id。
     *
     * 比如，员工1是员工2的领导，员工2是员工3的领导。他们相应的重要度为15, 10, 5。那么员工1的数据结构是[1, 15, [2]]，员工2的数据结构是[2, 10, [3]]，员工3的数据结构是[3, 5, []]。注意虽然员工3也是员工1的一个下属，但是由于并不是直系下属，因此没有体现在员工1的数据结构中。
     *
     * 现在输入一个公司的所有员工信息，以及单个员工id，返回这个员工和他所有下属的重要度之和。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/employee-importance
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param employees
     * @param id
     * @return
     */
    public int getImportance(List<Employee> employees, int id) {

        if (employees == null) return 0;
        if (employees.size() == 0) return 0;
        //使用map保存此时所有的员工id和与其对应的员工
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee e : employees) {
            map.put(e.id, e);
        }
        return DFS(map, id);
    }
}