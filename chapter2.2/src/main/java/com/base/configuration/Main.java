package com.base.configuration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args)
	{
		//创建Spring容器实例
		
		//ClassPathXmlApplicationContext加载xml配置元数据
//		ClassPathXmlApplicationContext applicationContext = 
//				new ClassPathXmlApplicationContext("/com/base/configuration/ch2-beans.xml");
		
		AnnotationConfigApplicationContext applicationContext = 
				new AnnotationConfigApplicationContext(Ch2BeanConfiguration.class);
		//getBean()方法用来执行Bean查找，参数提供要查找的Bean名称和类型
		AccountService accountService = applicationContext.getBean("accountService", AccountService.class);
		
		System.out.println("Before money transfer");
		System.out.println("Account 1 balance :" + accountService.getAccount(1).getBalance());
		System.out.println("Account 2 balance :" + accountService.getAccount(2).getBalance());
	
		accountService.transferMoney(1, 2, 5.0);
		
		System.out.println("After money transfer");
		System.out.println("Account 1 balance :" + accountService.getAccount(1).getBalance());
		System.out.println("Account 2 balance :" + accountService.getAccount(2).getBalance());
		
		//通过检查Configuration2和Configuration1传入ApplicationContext的构造函数的顺序
		//实例化的时候Spring容器调用了第二个类的foo()方法
//		AnnotationConfigApplicationContext applicationContext = 
//				new AnnotationConfigApplicationContext(Configuration2.class, Configuration1.class);
		
//		Foo foo = applicationContext.getBean(Foo.class);
//		System.out.println(foo.getName());
	}
}
