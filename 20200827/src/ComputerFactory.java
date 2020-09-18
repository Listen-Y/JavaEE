/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-08-28
 * Time: 15:24
 */
public class ComputerFactory extends AbstractFactory  {

    @Override
    public Phone makePhone(String cpu, String ram, String system, int battery) {
        return null;
    }

    @Override
    public Computer makeComputer(String type) {
         if (type.equalsIgnoreCase("apple")) {
             return new IPhone();
         } else if (type.equalsIgnoreCase("HuaWei")) {
             return new HuaWei();
         }
         return null;
    }
}
