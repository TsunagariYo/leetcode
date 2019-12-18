package UtileS.Timer;

import UtileS.HttpUtile;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

/**
 * spring定时器
 */

public class SpringTimer {
        @Scheduled(cron = "*/1 * * * * ?")
        public void test(){
            System.out.println(new Date()+"定时器启动");
        }
}
