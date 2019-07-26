package com.qrqs.spring.application.context;

import com.qrqs.spring.application.context.beans.TestBean;
import com.qrqs.spring.application.context.foo.FooConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SuppressWarnings("all")
@SpringBootApplication
@Slf4j
public class SpringApplicationContextDemoApplication implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringApplicationContextDemoApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		ApplicationContext fooContext = new AnnotationConfigApplicationContext(FooConfig.class);
		ClassPathXmlApplicationContext barContext = new ClassPathXmlApplicationContext(
				new String[] {"applicationContext.xml"}, fooContext);
		TestBean bean = fooContext.getBean("testBeanX", TestBean.class);
		bean.hello();

		log.info("========================");

		bean = barContext.getBean("testBeanX", TestBean.class);
		bean.hello();

		bean = barContext.getBean("testBeanY", TestBean.class);
		bean.hello();
	}
}
