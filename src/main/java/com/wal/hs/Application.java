package com.wal.hs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}
	
	@Scheduled(initialDelay=10000,fixedDelay=20000)
	public void clearCache()
	{
		System.out.println("clearing cache");
		evitAllCache();
		System.out.println("cahce cleared");
	}
	
	@CacheEvict(allEntries=true)
	public static void evitAllCache()
	{
		
	}

}
