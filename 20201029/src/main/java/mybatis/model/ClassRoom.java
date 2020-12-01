package mybatis.model;

import com.sun.tracing.dtrace.ModuleAttributes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-10-29
 * Time: 14:26
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClassRoom {

    private int tid;
    private String tname;
    private List<Student> students;
}
