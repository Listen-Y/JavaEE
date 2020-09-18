/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-08-28
 * Time: 14:27
 */
public class HuaWei implements Phone, Computer {

    private String cpu;
    private String ram;
    private String system;
    private int battery;

    public HuaWei(String cpu, String ram, String system, int battery) {
        this.cpu = cpu;
        this.ram = ram;
        this.system = system;
        this.battery = battery;
    }

    public HuaWei(){};

    @Override
    public String showCPU() {
        return "HuaWei:" + this.cpu;
    }

    @Override
    public String showRAM() {
        return "HuaWei:" + this.ram;
    }

    @Override
    public String showSystem() {
        return "HuaWei:" + this.system;
    }

    @Override
    public String showBattery() {
        return "HuaWei:" + this.battery;
    }

    @Override
    public String showComputer() {
        return "HuaWei: Computer";
    }
}
