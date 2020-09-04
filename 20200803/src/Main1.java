import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-08-03
 * Time: 10:44
 */
public class Main1 {

    static class Customer {
        int num;
        int money;

        public void setNum(int num) {
            this.num = num;
        }

        public void setMoney(int money) {
            this.money = money;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] tables = new int[n];
            for (int i = 0; i < n; i++) {
                tables[i] = scanner.nextInt();
            }
            Customer[] customers = new Customer[m];
            for (int i = 0; i < m; i++) {
                customers[i] = new Customer();
                customers[i].setNum(scanner.nextInt());
                customers[i].setMoney(scanner.nextInt());
            }

            Arrays.sort(tables);
            Arrays.sort(customers, new Comparator<Customer>() {
                @Override
                public int compare(Customer o1, Customer o2) {
                    return o1.num - o2.num;
                }
            });
            int sum = 0;

            for (int table : tables
                 ) {
                sum += findBestVal(table, customers);
            }
            System.out.println(sum);

        }
    }

    private static int findBestVal(int table, Customer[] customers) {

        int ret = 0;
        Integer index = null;

        for (int i = 0; i < customers.length; i++) {

            if (customers[i].num > table) {
                if (index != null) {
                    customers[index].money = 0;
                }
                break;
            }
            if (customers[i].money > ret) {
                ret = customers[i].money;
                index = i;
            }

        }

        return ret;

    }

}
