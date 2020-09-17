package listen.example3.serviceDemo;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-08-23
 * Time: 16:21
 */
@Component //表示这是一个组件
public class SchedulingService {

    //下面的cron表达式表示不管何时何月何年从启动开始 每三秒执行一次
    //每位代表含义：秒 分钟 ⼩时 ⽇ ⽉ 周 年
    @Scheduled(cron = "0/3 * * * * ?")
    public void schedule() {
        System.out.println("定时任务执行中...");
    }

}
