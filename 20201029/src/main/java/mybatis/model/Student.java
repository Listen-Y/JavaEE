package mybatis.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-10-28
 * Time: 21:48
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private int id;
    private String name;
    private Teacher teacher;
}
