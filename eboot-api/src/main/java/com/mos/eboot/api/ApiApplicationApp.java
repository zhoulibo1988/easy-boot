package com.mos.eboot.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author 小尘哥
 */
@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
public class ApiApplicationApp {
	private static final Logger LOGGER = LoggerFactory.getLogger(ApiApplicationApp.class);
	/**
	* @Title: bCryptPasswordEncoder 
	* @Description:BCryptPasswordEncoder使用强哈希方法来加密密码
	* @param @return    设定文件 
	* @return BCryptPasswordEncoder    返回类型 
	* @throws
	 */
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
    public static void main(String[] args) {
    	LOGGER.info("--------------------API系统启动--------------------");
        SpringApplication.run(ApiApplicationApp.class, args);
    }
}
