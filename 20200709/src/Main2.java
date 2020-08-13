public class Main2 {
    public static void main(String[] args) {
        /*System.out.println(10 * 30 + " " + (int)(Math.pow(2, 30) - 1));*/
        int[] prices = new int[]{3,8,5,1,7,8};
        System.out.println(calculateMax(prices));
    }

    public static int calculateMax(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
//        初始化变量，分别表示第一次购买、出售，第二次购买、出售时的最大收益
        int firstBuy;
        int secondBuy;
        firstBuy = secondBuy = Integer.MIN_VALUE;

        int firstSell;
        int secondSell;
        firstSell = secondSell = 0;
        for (int price : prices) {
//            第一次购买，收益
            firstBuy = Math.max(firstBuy, -price);
//            第一次出售，收益
            firstSell = Math.max(firstSell, firstBuy + price);
//            第二次购买，收益
            secondBuy = Math.max(secondBuy, firstSell - price);
//            第二次出售，收益
            secondSell = Math.max(secondSell, secondBuy + price);
        }
        return secondSell;
    }
}
