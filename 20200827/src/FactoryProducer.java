/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-08-28
 * Time: 15:39
 */
public class FactoryProducer {

    public static AbstractFactory getFactory(String type) {
        if (type.equalsIgnoreCase("computer")) {
            return new ComputerFactory();
        } else if (type.equalsIgnoreCase("phone")) {
            return new PhoneFactory();
        }
        return null;
    }

}
