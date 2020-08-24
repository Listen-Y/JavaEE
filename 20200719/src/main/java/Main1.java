import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n=in.nextInt();
            HashSet<String> set=new HashSet<String>();
            while(n--!=0){
                String str=in.next();
                char[] cA = str.toCharArray();
                int len=cA.length;
                StringBuilder sb=new StringBuilder();
                int count=0;
                for (int i = 0; i < len; i++) {
                    char c = cA[i];
                    if(c!='-'){
                        switch (c) {
                            case '1':
                            case '0':
                                break;
                            case 'A':
                            case 'B':
                            case 'C':
                                c='2';
                                break;
                            case 'D':
                            case 'E':
                            case 'F':
                                c='3';
                                break;
                            case 'G':
                            case 'H':
                            case 'I':
                                c='4';
                                break;
                            case 'J':
                            case 'K':
                            case 'L':
                                c='5';
                                break;
                            case 'M':
                            case 'N':
                            case 'O':
                                c='6';
                                break;
                            case 'P':
                            case 'Q':
                            case 'R':
                            case 'S':
                                c='7';
                                break;
                            case 'T':
                            case 'U':
                            case 'V':
                                c='8';
                                break;
                            case 'W':
                            case 'X':
                            case 'Y':
                            case 'Z':
                                c='9';
                                break;
                        }
                        count++;
                        sb.append(c);
                        if(count==3){
                            sb.append('-');
                        }
                    }
                }
                set.add(sb.toString());
            }
            int size=set.size();
            String[] sArr =new String[size];
            int k=0;
            for (String ts:set) {
                sArr[k++]=ts;
            }

            Arrays.sort(sArr);

//          System.out.println(Arrays.toString(sArr));

            for (int i = 0; i < size; i++) {
                System.out.println(sArr[i]);
            }
            System.out.println();
        }
    }
}