package listen.example3.serviceDemo.personController;

import listen.example3.serviceDemo.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-08-23
 * Time: 15:54
 */
@RestController
@RequestMapping(value = "per")
public class PersonController {

    //注入对象
    @Autowired
    private PersonService personService;

    //演示获取缓存
    @RequestMapping(value = "get")
    public Object getPerson(int id) throws InterruptedException {
        return personService.getPersonById(id);
    }

    //演示修改
    @RequestMapping(value = "update")
    public Object updatePerson(int id, String newName) {
        return personService.updatePerson(id, newName);
    }

    //演示删除
    @RequestMapping(value = "del")
    public Object delPerson(int id) {
        return personService.delPerson(id);
    }

}
