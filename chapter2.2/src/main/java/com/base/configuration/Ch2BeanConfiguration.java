package com.base.configuration;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//Spring Bean定义类
/**
 * 
 * @author lindi
 * @Configuration注解告诉Spring，该类是一个Bean并且包含配置元数据
 * 创建两个工厂方法并用Bean注解标记
 */
@Configuration
public class Ch2BeanConfiguration {

	//方法的名称就是Bean的名称
//	@Bean
//	public AccountService accountService()
//	{
//		//使用具体类创建一个Bean
//		//工厂方法的返回类型被定义为接口而不是具体类，这样做可以更容易地使用不同的Bean实现类来配置系统
//		AccountServiceImpl bean = new AccountServiceImpl();
//		//调用setter方法设置所需的依赖项
//		//accountDao是有单实例作用域的单个实例，连续调用accountDao()的话，工厂方法只会返回相同的Bean实例
//		bean.setAccounDao(accountDao());
//		//返回bean
//		return bean;
//	}

	@Bean(autowire=Autowire.BY_TYPE)
	public AccountService accountService()
	{
		AccountServiceImpl bean = new AccountServiceImpl();
		return bean;
	}
	
	@Bean
	@Qualifier
	//自动装配模式变为byName
	public AccountDao accountDao()
	{
		//使用具体类创建一个Bean并将其返回
		AccountDaoInMemoryImpl bean = new AccountDaoInMemoryImpl();
		return bean;
	}
	
	@Bean
	public AccountDao accountDaoJdbc()
	{
		AccountDaoJdbcImpl bean = new AccountDaoJdbcImpl();
		return bean;
	}
}


