import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    static class Charcount {
        public char winChar;
        public int count;

        public Charcount(char winChar, int count) {
            this.winChar = winChar;
            this.count = count;
        }
    }

    private static Charcount[] AwinChar = new Charcount[3];
    private static Charcount[] BwinChar = new Charcount[3];

    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = Integer.parseInt(scanner.nextLine());
            String[] strings = new String[n];
            for (int i = 0; i < n; i++) {
                strings[i] = scanner.nextLine();
            }
            int Awin = 0;
            int Bwin = 0;
            int noWinLose = 0;

            AwinChar[0] = new Charcount('J', 0);
            AwinChar[1] = new Charcount('C', 0);
            AwinChar[2] = new Charcount('B', 0);
            BwinChar[0] = new Charcount('J', 0);
            BwinChar[1] = new Charcount('C', 0);
            BwinChar[2] = new Charcount('B', 0);

            for (int i = 0; i < n; i++) {
                String[] line = strings[i].split(" ");
                char A = line[0].charAt(0);
                char B = line[1].charAt(0);

                char who = whoWin(A, B);
                if (who == 'A') {
                    Awin++;
                } else if (who == 'B') {
                    Bwin++;
                } else {
                    noWinLose++;
                }
            }

            Arrays.sort(AwinChar, new Comparator<Charcount>() {
                @Override
                public int compare(Charcount o1, Charcount o2) {
                    if (o1.count != o2.count) {
                        return o2.count - o1.count;
                    }
                    return o1.winChar - o2.winChar;
                }
            });
            Arrays.sort(BwinChar, new Comparator<Charcount>() {
                @Override
                public int compare(Charcount o1, Charcount o2) {
                    if (o1.count != o2.count) {
                        return o2.count - o1.count;
                    }
                    return o1.winChar - o2.winChar;
                }
            });

            System.out.println(Awin + " " + noWinLose + " " + Bwin);
            System.out.println(Bwin + " " + noWinLose + " " + Awin);
            System.out.println(AwinChar[0].winChar + " " + BwinChar[0].winChar);

        }
    }

    private static char whoWin(char a, char b) {
        if (a == b) {
            return 'C';
        }
        if (a == 'J') {
            if (b == 'C') {
                BwinChar[1].count++;
                return 'B';
            } else {
                AwinChar[0].count++;
                return 'A';
            }
        }
        if (a == 'C') {
            if (b == 'J') {
                AwinChar[1].count++;
                return 'A';
            } else {
                BwinChar[2].count++;
                return 'B';
            }
        }
        if (a == 'B') {
            if (b == 'J') {
                BwinChar[0].count++;
                return 'B';
            } else {
                AwinChar[2].count++;
                return 'A';
            }
        }
        return 'C';
    }


    public static int countWays(int n) {
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        int a = 1;
        int b = 1;
        int c = 2;
        for(int i=3;i<=n;i++){
            int temp = ((a+b)%1000000007+c)%1000000007;
            a = b;
            b = c;
            c = temp;
        }
        return c;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            System.out.println(countWays(n));
        }
    }
}
