import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main1{

    private static String charAt(String str, int index){
        if( str == null || index >= str.length() || index < 0){
            return "";
        }
        return str.substring(index, index+1);
    }
    public static void main(String[] args) throws Exception{
        Map<String,String> digitMap = new HashMap<>();
        digitMap.put("0","零");
        digitMap.put("1","壹");
        digitMap.put("2","贰");
        digitMap.put("3","叁");
        digitMap.put("4","肆");
        digitMap.put("5","伍");
        digitMap.put("6","陆");
        digitMap.put("7","柒");
        digitMap.put("8","捌");
        digitMap.put("9","玖");
        String[] unitStr = new String[]{"拾","佰","仟","万","亿"};
        String[] moneyUnit = new String[]{"分","角","元","整"};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while((line=br.readLine())!=null){
            String[] inputArr = line.split("\\.");
            StringBuilder bd = new StringBuilder("人民币");
            String part1 = inputArr[0];
            String part2 = inputArr[1];
            if(!part1.equals("0")){
                for(int i =0;i < part1.length();i++){
                    int unitLen = part1.length()-i-1;
                    String number = digitMap.get(charAt(part1, i));
                    String unit = "";
                    if( unitLen == 0){
                        unit = moneyUnit[2];
                    } else if(unitLen == 1){
                        unit = unitStr[0];
                    } else if(unitLen == 2){
                        unit = unitStr[1];
                    } else if(unitLen == 3){
                        unit = unitStr[2];
                    } else if(unitLen >= 4 && unitLen < 8){
                        unit = unitStr[3];
                    } else if(unitLen >= 8){
                        unit = unitStr[4];
                    }
                    if(part1.length() == 2 && i == 0){
                        bd.append(unit);
                    } else {
                        bd.append(number).append(unit);
                    }
                }
            }
            if(!part2.equals("00")){
                for(int j =0;j < part2.length();j++){
                    String number2 = digitMap.get(charAt(part2, j));
                    if(number2.equals("零")){
                        continue;
                    }
                    String unit2 = "";
                    if( j == 0 ){
                        unit2 = moneyUnit[1];
                    } else if(j == 1){
                        unit2 = moneyUnit[0];
                    }
                    bd.append(number2).append(unit2);
                }
            } else{
                bd.append("整");
            }
            System.out.println(bd);
        }
    }
}
