package com.example.SpringScheduler;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.scheduling.support.PeriodicTrigger;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

@Component
@Slf4j
@EnableAsync
public class Scheduler {

    @Autowired
    private ThreadPoolTaskScheduler taskScheduler;

//    @Scheduled(fixedDelay = 1000)
//    public void scheduler() throws InterruptedException {
//        LocalDateTime current = LocalDateTime.now();
//        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
//        String formattedDateTime = current.format(format);
//        log.info("Scheduler time " + formattedDateTime);
//        Thread.sleep(1000);
//    }
//
//    @Scheduled(fixedRate = 1000)
//    public void scheduler1() throws InterruptedException {
//        LocalDateTime current = LocalDateTime.now();
//        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
//        String formattedDateTime = current.format(format);
//        log.info("Scheduler time " + formattedDateTime);
//        Thread.sleep(1000);
////        won't wait for the sleep time
//    }
//
//    @Scheduled(fixedRate = 1000, initialDelay = 1000)
//    public void scheduler2() throws InterruptedException {
//        LocalDateTime current = LocalDateTime.now();
//        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
//        String formattedDateTime = current.format(format);
//        log.info("Scheduler time " + formattedDateTime);
//        Thread.sleep(1000);
//    }
//
////    for larger rates
////    executed after every 2 hours PT02H ( after every 2s PT02S )
//    @Scheduled(fixedRateString = "PT02S", initialDelay = 1000)
//    public void scheduler3() throws InterruptedException {
//        LocalDateTime current = LocalDateTime.now();
//        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
//        String formattedDateTime = current.format(format);
//        log.info("Scheduler time " + formattedDateTime);
//        Thread.sleep(1000);
//    }
//
////    For parallel execution we need to use @Async and @EnableAsync Annotations
//    @Async
//    @Scheduled(fixedRateString = "PT02S", initialDelay = 1000)
//    public void scheduler4() throws InterruptedException {
//        LocalDateTime current = LocalDateTime.now();
//        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
//        String formattedDateTime = current.format(format);
//        log.info("Scheduler time " + formattedDateTime);
//        Thread.sleep(1000);
//    }
//
////    we can add the schedulers via cron expression
////    will be executed after every 2 seconds
//    @Scheduled(cron = "*/2 * * * * *")
//    public void scheduler5() throws InterruptedException {
//        LocalDateTime current = LocalDateTime.now();
//        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
//        String formattedDateTime = current.format(format);
//        log.info("Scheduler time " + formattedDateTime);
//        Thread.sleep(1000);
//    }
////    0 */2 * * * *
////    0 0 */2 * * *
////    0 */2 * * * TUE
//
//    @Scheduled(cron = "${cron.expression.value}")
//    public void scheduler6() throws InterruptedException {
//        LocalDateTime current = LocalDateTime.now();
//        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
//        String formattedDateTime = current.format(format);
//        log.info("Scheduler time " + formattedDateTime);
//        Thread.sleep(1000);
//    }

    public int noOfThreads1(){
        taskScheduler.setPoolSize(3);
        return 3;
    }

    public int noOfThreads2(){
        taskScheduler.setPoolSize(5);
        return 5;
    }

    @PostConstruct()
    public void schedule7() throws InterruptedException{
        taskScheduler.scheduleWithFixedDelay(
                new RunnableTask("Specific time, 3 Seconds from now"),
                3000
        );
        taskScheduler.scheduleWithFixedDelay(
                new RunnableTask("Fixed 1 second Delay"), 1000);
        taskScheduler.scheduleAtFixedRate(
                new RunnableTask("Fixed Rate of 2 seconds") , 2000);
        taskScheduler.scheduleAtFixedRate(new RunnableTask(
                "Fixed Rate of 2 seconds"), 3000);
        CronTrigger cronTrigger
                = new CronTrigger("10 * * * * ?");
        taskScheduler.schedule(new RunnableTask("Cron Trigger"), cronTrigger);
        PeriodicTrigger periodicTrigger
                = new PeriodicTrigger(2000, TimeUnit.MICROSECONDS);
        taskScheduler.schedule(
                new RunnableTask("Periodic Trigger"), periodicTrigger);
        periodicTrigger.setFixedRate(true);
        periodicTrigger.setInitialDelay(1000);
    }


}
