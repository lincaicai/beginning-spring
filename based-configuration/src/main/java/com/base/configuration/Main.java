package com.base.configuration;

//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args)
	{
		//创建Spring容器实例
		//AnnotationConfigApplicationContext被用于处理基于Java的配置元数据
//		AnnotationConfigApplicationContext applicationContext = 
//				new AnnotationConfigApplicationContext(Ch2BeanConfiguration.class);
		
		//ClassPathXmlApplicationContext加载xml配置元数据
		ClassPathXmlApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext("/com/base/configuration/ch2-beans.xml");
		//getBean()方法用来执行Bean查找，参数提供要查找的Bean名称和类型
		AccountService accountService = applicationContext.getBean("accountServiceImpl", AccountService.class);
		
		System.out.println("Before money transfer");
		System.out.println("Account 1 balance :" + accountService.getAccount(1).getBalance());
		System.out.println("Account 2 balance :" + accountService.getAccount(2).getBalance());
		
		accountService.transferMoney(1, 2, 5.0);
		
		System.out.println("After money transfer");
		System.out.println("Account 1 balance :" + accountService.getAccount(1).getBalance());
		System.out.println("Account 2 balance :" + accountService.getAccount(2).getBalance());
	}
}
