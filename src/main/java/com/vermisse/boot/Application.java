package com.vermisse.boot;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.context.embedded.*;
import org.springframework.context.annotation.*;
import org.springframework.scheduling.annotation.*;

// 开启控件扫描，无须指定包
@ComponentScan
// 开启自动配置
@EnableAutoConfiguration
// 开启定时器
@EnableScheduling
public class Application implements EmbeddedServletContainerCustomizer {
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	/**
	 * 设置服务器启动端口
	 */
	public void customize(ConfigurableEmbeddedServletContainer container) {
		container.setPort(99);
	}
}