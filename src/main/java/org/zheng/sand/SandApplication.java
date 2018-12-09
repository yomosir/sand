package org.zheng.sand;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
@MapperScan("org.zheng.sand.*.dao")
public class SandApplication {

	public static void main(String[] args) {
		SpringApplication.run(SandApplication.class, args);
	}
}
