import java.util.*;
class Solution3 {

    private List<List<Integer>> ret;


    private void DFS(int[] candidates, List<Integer> list, int cur, int target, int prevPose) {
        if (cur >= target) {
            if (cur == target) {
                //需要将链表中的值拷贝一份 不然引用的是同一个变量
                List<Integer> curList = new ArrayList<>(list);
                ret.add(curList);
            }
            return;
        }
        //遍历累加数字可以重复取  而且避免重复组合 直接从上次位置开始累加
        for (int i = prevPose; i < candidates.length; i++) {
            //将当前数字加到链表中
            list.add(candidates[i]);
            //进行递归处理
            DFS(candidates, list, cur + candidates[i], target, i);
            //回溯
            list.remove(list.size() - 1);
        }
    }

    /**
     * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     *
     * candidates 中的数字可以无限制重复被选取。
     *
     * 说明：
     *
     * 所有数字（包括 target）都是正整数。
     * 解集不能包含重复的组合。 
     * 示例 1：
     *
     * 输入：candidates = [2,3,6,7], target = 7,
     * 所求解集为：
     * [
     *   [7],
     *   [2,2,3]
     * ]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/combination-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //初始化返回结果
        ret = new ArrayList<>();
        //保存当前结果
        List<Integer> list = new ArrayList<>();
        DFS(candidates, list, 0, target, 0);
        return ret;
    }
}