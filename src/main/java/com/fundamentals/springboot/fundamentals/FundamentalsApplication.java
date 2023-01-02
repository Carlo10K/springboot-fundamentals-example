package com.fundamentals.springboot.fundamentals;

import com.fundamentals.springboot.fundamentals.bean.MyBean;
import com.fundamentals.springboot.fundamentals.component.ComponentDependency;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundamentalsApplication implements CommandLineRunner {

	private ComponentDependency componentDependency;
	private MyBean myBean;

	public FundamentalsApplication(@Qualifier("componentImplement") ComponentDependency componentDependency, MyBean myBean){
		this.componentDependency = componentDependency;
		this.myBean = myBean;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentalsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
			componentDependency.sayHi();
			myBean.print();
	}
}
