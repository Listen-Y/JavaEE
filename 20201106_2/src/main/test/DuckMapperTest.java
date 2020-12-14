import com.duck.pojo.Duck;
import com.duck.service.DuckService;
import com.duck.util.IDUtil;
import com.duck.util.Time;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-11-06
 * Time: 14:14
 */
public class DuckMapperTest {

    ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
    DuckService duckService = context.getBean("duckService", DuckService.class);

    @Test
    public void select() {
        for (Duck duck : duckService.select()) {
            System.out.println(duck);
        }
    }

    @Test
    public void insert() {
        Duck duck = new Duck();
        duck.setId(IDUtil.getID());
        duck.setName("李宏宇宇宇宇");
        duck.setFood(new BigDecimal("2.239"));
        duck.setHeight(new BigDecimal("3.349"));
        duck.setBirthday(Time.getTime());
        duck.setWeight(new BigDecimal("2.999"));
        System.out.println(duckService.insert(duck));
    }

    @Test
    public void update() {
        Duck duck = new Duck();
        duck.setId("b8a43fdf");
        duck.setName("李宏宇宇宇");
        duck.setFood(new BigDecimal("1.999"));
        duck.setHeight(new BigDecimal("0.999"));
        duck.setBirthday(Time.getTime());
        duck.setWeight(new BigDecimal("0.999"));
        System.out.println(duckService.update(duck));
    }

    @Test
    public void delete() {

        System.out.println(duckService.delete("b8a43fdf"));
    }

    @Test
    public void selectByLike() {
        for (Duck duck : duckService.selectByLike("%李%")) {
            System.out.println(duck);
        }
    }

    @Test
    public void selectByRange() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("minHeight", 0.1);
        map.put("maxHeight", 9.9);
        map.put("minWeight", 1.0);
        map.put("maxWeight", 4);
        for (Duck duck : duckService.selectByRange(map)) {
            System.out.println(duck);
        }
    }

    @Test
    public void selectOne() {

        System.out.println(duckService.selectOne("1aa82caf"));
    }
}