/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-08-28
 * Time: 15:19
 */
public abstract class AbstractFactory {

    public abstract Phone makePhone(String cpu, String ram, String system, int battery);
    public abstract Computer makeComputer(String type);
}
