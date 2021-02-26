package com.vinlen.cloudStore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.vinlen.cloudStore.mapper")  //扫描此包
public class ItemApplication {
	public static void main(String[] args) {
		SpringApplication.run(ItemApplication.class,args);
	}
}
