/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-08-28
 * Time: 14:19
 */
public class IPhone implements Phone, Computer {

    private String cpu;
    private String ram;
    private String system;
    private int battery;

    public IPhone(String cpu, String ram, String system, int battery) {
        this.cpu = cpu;
        this.ram = ram;
        this.system = system;
        this.battery = battery;
    }

    public IPhone(){};

    @Override
    public String showCPU() {
        return "IPhone:" + this.cpu;
    }

    @Override
    public String showRAM() {
        return "IPhone:" + this.ram;
    }

    @Override
    public String showSystem() {
        return "IPhone:" + this.system;
    }

    @Override
    public String showBattery() {
        return "IPhone:" + this.battery;
    }

    @Override
    public String showComputer() {
        return "Apple: Computer";
    }
}
