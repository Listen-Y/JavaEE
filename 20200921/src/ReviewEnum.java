/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-09-21
 * Time: 9:31
 */

enum Day {
    Sun,
    Mon,
    Tus,
    Win,
    Third,
    File,
    Stu,
}

public class ReviewEnum {

    //在switch中使用
    public static void enumForSwitch(Day day) {
        switch (day) {
            case Mon:
                System.out.println(day + "1");
                break;
            case Stu:
                System.out.println(day + "2");
                break;
            case Sun:
                System.out.println(day + "3");
                break;
            case Tus:
                System.out.println(day + "4");
                break;
            case Win:
                System.out.println(day + "5");
                break;
            case File:
                System.out.println(day + "6");
                break;
            case Third:
                System.out.println(day + "7");
                break;
        }
    }

    //values方法 以数组的形式返回所有枚举成员
    public static void enumToArray() {

        Day[] days = Day.values();
        for (Day day : days
             ) {
            System.out.print(day + "");
        }
    }
    //ordinal 返回枚举成员的索引位置
    public static void enumForIndex(Day day) {
        System.out.println(day.ordinal());
    }

    //valueOf 将普通字符串转换为枚举类型
    public static void strToEnum(String enumStr) {
        Day day = Day.valueOf(enumStr);
        System.out.println(day.ordinal());
    }

    //compareTo 对比俩个枚举成员的定义顺序
    public static void compareToEnum(Day dayPre, Day dayLas) {
        System.out.println(dayPre.compareTo(dayLas));
    }

    public static void main(String[] args) {
        compareToEnum(Day.Mon, Day.Third);
        strToEnum("Mon");
        strToEnum("Third");
        //strToEnum("sss");
        enumForIndex(Day.Win);
        enumToArray();
        enumForSwitch(Day.Sun);
    }
}
