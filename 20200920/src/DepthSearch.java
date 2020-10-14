import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-09-21
 * Time: 20:30
 */
public class DepthSearch {

    //用于存放所有的放置方法
    private List<List<Integer>> all = new ArrayList<>();

    private void DFS (int[] boxes, int[] cards, int index) {
        //如果此时下标为数组长度, 那么表示牌已发完
        if (index == cards.length) {
            List<Integer> list = new ArrayList<>();
            for (int i = 1; i < cards.length; i++) {
                list.add(boxes[i]);
            }
            all.add(list);
            return;
        }
        //依次处理每张牌
        for (int i = 1; i < cards.length; i++) {
            //判断此时的牌是否被用过
            if (cards[i] == 0) {
                //使用此时的盒子
                boxes[index] = i;
                //使用牌
                cards[i] = 1;
                //处理下一个盒子
                DFS(boxes, cards, index + 1);
                //回退这张牌
                cards[i] = 0;
            }
        }
    }

    /**
     * 扑克的放置方法
     * @param num
     * @return
     */
    public List<List<Integer>> allStyles(int num) {
        //获取所有扑克牌的放置顺序
        int[] boxes = new int[num + 1];
        int[] cards = new int[num + 1];
        DFS(boxes, cards, 1);
        return all;

    }


}
