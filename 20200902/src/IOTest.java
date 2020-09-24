import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
//车的类
class Car {
    public String carNum;
    public String carBrand;
    public String carModel;

    public Car(String carNum, String carBrand, String carModel) {
        this.carNum = carNum;
        this.carBrand = carBrand;
        this.carModel = carModel;
    }

    @Override
    public String toString() {
        return carNum + "，" + carBrand + "，" + carModel;
    }
}
//管理我的车库
class ManagePark {

    //通过车牌号判断车库里是否有这辆车
    public Boolean findCarByCarNum(Car car) throws IOException {
        if(car == null) {
            return false;
        }
        FileReader fileReader = new FileReader("e:\\MyCarPark.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String findCar = bufferedReader.readLine();
        while (findCar != null) {
            String[] strings = findCar.split("，");
            if(strings[0].equals(car.carNum)) {
                return true;
            }
            findCar = bufferedReader.readLine();
        }
        bufferedReader.close();
        fileReader.close();
        return false;
    }

    //停车入库 在构建FileWriter是加上true表示不覆盖 bufferedWriter.newline表是加在新的一行中
    public void stopAtPark(Car car) throws IOException {
        if(car == null) {
            return;
        }
        if(findCarByCarNum(car)) {
            return;
        }
        FileWriter fileWriter = new FileWriter("e:\\MyCarPark.txt", true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        String carString = car.toString();
        bufferedWriter.newLine();
        bufferedWriter.write(carString);
        bufferedWriter.close();
        fileWriter.close();
    }

    //离开车库 将除要离开的车全部插入链表 然后进行覆盖式的输入到文本中
    public void LeavePark(Car car) throws IOException {
        if( ! findCarByCarNum(car)) {
            return;
        }
        List<Car> listCar = new LinkedList<>();
        FileReader fileReader = new FileReader("e:\\MyCarPark.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String findCar = bufferedReader.readLine();
        while (findCar != null) {
            String[] strings = findCar.split("，");
            if(strings.length > 1) {
                if (!strings[0].equals(car.carNum)) {
                    listCar.add(new Car(strings[0], strings[1], strings[2]));
                }
            }
            findCar = bufferedReader.readLine();
        }
        bufferedReader.close();
        fileReader.close();
        FileWriter fileWriter = new FileWriter("e:\\MyCarPark.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        for (Car c: listCar
        ) {
            String sCar = c.toString();
            bufferedWriter.newLine();
            bufferedWriter.write(sCar);
        }
        bufferedWriter.close();
        fileWriter.close();
    }

    //通过车品牌Brand得到车库所有该品牌的车的对象
    public Car[] getCarByBrand(String brand) throws IOException {
        ArrayList<Car> carList = new ArrayList<>();
        FileReader fileReader = new FileReader("e:\\MyCarPark.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String findCar = bufferedReader.readLine();
        while (findCar != null) {
            String[] strings = findCar.split("，");
            if(strings.length > 1) {
                if (strings[1].equals(brand)) {
                    carList.add(new Car(strings[0], strings[1], strings[2]));
                }
            }
            findCar = bufferedReader.readLine();
        }
        bufferedReader.close();
        fileReader.close();
        return carList.toArray(new Car[0]);
    }

    //输出现在车库的所有车辆信息
    public void displayMyParkCar() throws IOException  {
        FileReader fileReader = new FileReader("e:\\MyCarPark.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String findCar = bufferedReader.readLine();
        while (findCar != null) {
            System.out.println(findCar);
            findCar = bufferedReader.readLine();
        }
        System.out.println();
        bufferedReader.close();
        fileReader.close();
    }
}

public class IOTest {
    public static void main(String[] args) {
        try {
            Car car = new Car("陕A33333", "宝马", "宝马X6");
            Car car1 = new Car("陕A66666", "奔驰", "黑色G500");
            ManagePark managePark = new ManagePark();
            System.out.println("===初始车库===");
            managePark.displayMyParkCar();
            System.out.println("===找是否有陕A33333===");
            System.out.println(managePark.findCarByCarNum(car));
            System.out.println("===找是否有陕A66666===");
            System.out.println(managePark.findCarByCarNum(car1));
            System.out.println("===找车库中所有劳斯莱斯的车===");
            Car[] cars =  managePark.getCarByBrand("劳斯莱斯");
            System.out.println(Arrays.toString(cars));
            System.out.println();
            System.out.println("===陕A66666离开车库陕A33333进入车库===");
            managePark.LeavePark(car1);
            managePark.stopAtPark(car);
            System.out.println("===最终车库===");
            managePark.displayMyParkCar();
        }catch (IOException e) {
            e.getStackTrace();
        }

    }
}

