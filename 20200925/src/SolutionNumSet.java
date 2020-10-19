import java.util.*;
class Solution1 {

    private void DFS(String tiles, Set<String> ret, List<Integer> usedIndex, String cur) {
        //如果此时cur不为空就加入到set中
        if (cur.length() != 0) {
            ret.add(cur);
        }
        //遍历title是中的每一个字母
        for (int i = 0; i < tiles.length(); i++) {
            //每个字母不能重复使用 所以下标只要用过就不能再用
            if (usedIndex.contains(i)) {
                continue;
            }
            //使用这个下标
            usedIndex.add(i);
            DFS(tiles, ret, usedIndex, cur + tiles.charAt(i));
            //回溯 取消这个下标的使用
            usedIndex.remove(usedIndex.size() - 1);
        }

    }

    /**
     * 你有一套活字字模 tiles，其中每个字模上都刻有一个字母 tiles[i]。返回你可以印出的非空字母序列的数目。
     *
     * 注意：本题中，每个活字字模只能使用一次。
     *
     *  
     *
     * 示例 1：
     *
     * 输入："AAB"
     * 输出：8
     * 解释：可能的序列为 "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA"。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/letter-tile-possibilities
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param tiles
     * @return
     */
    public int numTilePossibilities(String tiles) {
        //初始化一个set保存单词
        Set<String> ret = new HashSet<>();
        //使用一个链表保存使用过得下标
        List<Integer> usedIndex = new ArrayList<>();
        DFS(tiles, ret, usedIndex, "");
        return ret.size();

    }
}