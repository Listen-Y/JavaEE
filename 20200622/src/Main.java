import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
public class Main{
    static class Stu{
        String name;
        int grade;
        public Stu(String name,int grade){
            this.name=name;
            this.grade=grade;
        }

        @Override
        public String toString() {
            return name + " " + grade;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        while(br.ready()){
            int n=Integer.parseInt(br.readLine());
            int s=Integer.parseInt(br.readLine());
            Stu[] stus=new Stu[n];
            for(int i=0;i<n;i++){
                String[] str=br.readLine().split(" ");
                stus[i]=new Stu(str[0],Integer.parseInt(str[1]));
            }
            Arrays.sort(stus,new Comparator<Stu>(){
                @Override
                public int compare(Stu stu1,Stu stu2){
                    if(s==1)
                        return stu1.grade-stu2.grade;
                    return stu2.grade-stu1.grade;
                }
            });
            /*StringBuilder sb=new StringBuilder();
            for(int i=0;i<n;i++)
                sb.append(stus[i].name).append(" ").append(stus[i].grade).append("\n");
            System.out.println(sb.substring(0,sb.length()-1));*/
            for (Stu stu : stus
                 ) {
                System.out.println(stu);
            }
        }
    }
}