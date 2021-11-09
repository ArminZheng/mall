package com.az.mall.seckill;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 配置类
 *
 * @author AZ
 * @since 2021-11-02
 */
@Slf4j
@Component
// @EnableScheduling
@EnableAsync
public class ScheduledConfig {

    /**
     *  一、与Quarts的区别
     *      1、Spring中的定时任务由6位组成，不支持第7位的年
     *      2、第6位的数字格式，1-7，代表周一到周日，当然也可以写成MON-SUN
     *      3、其它普遍与Quarts一致
     */
    @Async
    @Scheduled(cron = "*/2 * * * * ?") // 开启定时任务
    public void hello() throws InterruptedException {
        log.info("hello");
        Thread.sleep(20000);
    }
/*
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0;
        while(l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;

            carry = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);c

            cur = cur.next;
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
        }
        if(carry == 1) {
            cur.next = new ListNode(carry);
        }
        return pre.next;
    }*/
}
