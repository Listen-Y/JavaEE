/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-08-28
 * Time: 14:37
 */
public class TestPhoneFactory {

    public static void main(String[] args) {

        AbstractFactory phoneFactory = FactoryProducer.getFactory("phone");

        assert phoneFactory != null;
        Phone phone = phoneFactory.makePhone("A14", "4G", "ios14", 2500);
        Phone phone1 = phoneFactory.makePhone("麒麟990", "8G", "Android7", 4500);
        if (phone != null) {
            System.out.println(phone.showCPU());
            System.out.println(phone.showRAM());
            System.out.println(phone.showSystem());
            System.out.println(phone.showBattery());
        }
        System.out.println("========================");
        if (phone1 != null) {
            System.out.println(phone1.showCPU());
            System.out.println(phone1.showRAM());
            System.out.println(phone1.showSystem());
            System.out.println(phone1.showBattery());
        }

        System.out.println("========================");
        AbstractFactory computerFactory = FactoryProducer.getFactory("computer");
        assert computerFactory != null;
        Computer computer = computerFactory.makeComputer("HuaWei");
        Computer computer1 = computerFactory.makeComputer("apple");
        System.out.println(computer.showComputer());
        System.out.println(computer1.showComputer());

    }

}
