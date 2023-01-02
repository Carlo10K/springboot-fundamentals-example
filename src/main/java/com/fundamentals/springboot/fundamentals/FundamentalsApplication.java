package com.fundamentals.springboot.fundamentals;

import com.fundamentals.springboot.fundamentals.bean.BeanWithProperties;
import com.fundamentals.springboot.fundamentals.bean.MyBean;
import com.fundamentals.springboot.fundamentals.bean.MyBeanWithDependency;
import com.fundamentals.springboot.fundamentals.component.ComponentDependency;
import com.fundamentals.springboot.fundamentals.pojo.UserPojo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundamentalsApplication implements CommandLineRunner {

	private ComponentDependency componentDependency;
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;
	private BeanWithProperties beanWithProperties;
	private UserPojo userPojo;

	public FundamentalsApplication(@Qualifier("componentImplement") ComponentDependency componentDependency, MyBean myBean, MyBeanWithDependency myBeanWithDependency, BeanWithProperties beanWithProperties, UserPojo userPojo){
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.beanWithProperties = beanWithProperties;
		this.userPojo = userPojo;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentalsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
			componentDependency.sayHi();
			myBean.print();
			myBeanWithDependency.printWithDependency();
			System.out.println(beanWithProperties.function());
			System.out.println(userPojo.getEmail()+"-"+userPojo.getPassword());
	}
}
