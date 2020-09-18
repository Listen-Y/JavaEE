/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-08-28
 * Time: 14:30
 */
public class PhoneFactory extends AbstractFactory {

    @Override
    public Phone makePhone(String cpu, String ram, String system, int battery) {

        if (system != null && (system.contains("ios") || system.contains("IOS"))) {
            return new IPhone(cpu, ram, system, battery);
        } else if (system != null && (system.contains("Android") || system.contains("android"))) {
            return new HuaWei(cpu, ram, system, battery);
        }
        return null;

    }

    @Override
    public  Computer makeComputer(String type) {
        return null;
    }

}
