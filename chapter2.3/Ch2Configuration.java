package com.base.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
public class Ch2Configuration {

	//@Profile注解，以便当dev值在活动配置文件中可用时可以调用devFoo方法
	@Bean
	@Profile("dev")
	public Foo devFoo(@Value("${name}") String name)
	{
		Foo foo = new Foo();
		foo.setName("dev " + name);
		return foo;
	}
	
	@Bean
	@Profile("prod")
	public Foo prodFoo(@Value("${name}") String name)
	{
		Foo foo = new Foo();
		foo.setName("prod " + name);
		return foo;
	}
	
	//添加一个静态Bean工厂方法，启用属性占位符解析机制
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer()
	{
		return new PropertySourcesPlaceholderConfigurer();
	}
}
