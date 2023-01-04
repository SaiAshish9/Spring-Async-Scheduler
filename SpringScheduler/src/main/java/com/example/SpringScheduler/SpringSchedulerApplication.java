package com.example.SpringScheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

@SpringBootApplication
@EnableScheduling
public class SpringSchedulerApplication extends SpringBootServletInitializer {


	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringSchedulerApplication.class, args);
		context.getBean(SpringSchedulerApplication.class).onInitialLoad();
	}

	public void onInitialLoad() {
		System.out.println("onInitialLoad SpringSchedulerApplication");
	}


	@Bean
	public ThreadPoolTaskScheduler taskScheduler(){
		ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
//		threadPoolTaskScheduler.setPoolSize(5);
		threadPoolTaskScheduler.setThreadNamePrefix("ThreadPoolTaskScheduler");
		return threadPoolTaskScheduler;
	}

}
