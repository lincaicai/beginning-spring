package com.base.configuration;

import java.util.Collections;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args)
	{
		AnnotationConfigApplicationContext applicationContext = 
				new AnnotationConfigApplicationContext();
		//指定了作为元数据源的配置类
		applicationContext.register(Ch2Configuration.class);
		
		//获取ConfigurableEnvironment实例
		ConfigurableEnvironment environment = applicationContext.getEnvironment();
		//讲活动配置文件值设置为dev
		environment.setActiveProfiles("dev");
		
		//获取MutablePropertySources实例
		MutablePropertySources propertySources = environment.getPropertySources();
		//添加新的作为名称占位符的MapPropertySource值为Map对象来确定
		propertySources.addLast(new MapPropertySource("mapSource", Collections.singletonMap("name", (Object)"my foo")));
		
		//初始化Spring容器
		applicationContext.refresh();
		
		Foo foo = applicationContext.getBean(Foo.class);
		System.out.println(foo.getName());

	}
}
