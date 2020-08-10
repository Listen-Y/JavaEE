import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main1 {

    static class ExeRem {
        public String name;
        public int errorLines;
        public int count;

        public ExeRem(String name, int errorLines, int count) {
            this.name = name;
            this.errorLines = errorLines;
            this.count = count;
        }

        @Override
        public String toString() {
            //文件名称不能超过16个字符
            if (this.name.length() > 16) {
                this.name = this.name.substring(this.name.length() - 16);
            }
            return this.name + " " + this.errorLines + " " + this.count;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<ExeRem> list = new ArrayList<>();

        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] lineTokens = line.split(" ");
            String name = makeName(lineTokens[0]);

            ExeRem exeRem = new ExeRem(name, Integer.parseInt(lineTokens[1]), 1);

            //遍历链表是否已存在这个错误 如果有就计数器++ 如果没有就放进去
            ExeRem sameExe = contains(list, exeRem);
            if (sameExe == null) {
                //此时说明这个错误是一个新的错误
                    list.add(exeRem);
            } else {
                //此时说明错误是出现过的
                //让其计数器++
                sameExe.count++;
            }
        }

        //对链表进行计数器排序
        list.sort((o1, o2) -> o2.count - o1.count);

        //输出最多8条
        int count = 0;
        for (ExeRem e : list
        ) {
            if (count != 8) {
                System.out.println(e);
                count++;
            }
        }
    }

    private static ExeRem contains(List<ExeRem> list, ExeRem exeRem) {
        for (ExeRem e : list
             ) {
            if (e.name.equals(exeRem.name) && e.errorLines == exeRem.errorLines) {
                return e;
            }
        }
        return null;
    }

    private static String makeName(String lineToken) {
        StringBuilder name = new StringBuilder();

        for (int i = lineToken.length() - 1; i >= 0; i--) {
            if (lineToken.charAt(i) == '\\') {
                break;
            }
            name.append(lineToken.charAt(i));
        }
        name.reverse();
        return name.toString();
    }
}
