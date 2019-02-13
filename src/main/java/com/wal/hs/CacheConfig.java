package com.wal.hs;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
@EnableCaching
public class CacheConfig {

	@Bean
	public CacheManager cacheManger() {
		return new EhCacheCacheManager(factory().getObject());

	}

	@Bean
	public EhCacheManagerFactoryBean factory() {
		EhCacheManagerFactoryBean f = new EhCacheManagerFactoryBean();
		f.setConfigLocation(new ClassPathResource("ehcache.xml"));
		f.setShared(true);
		return f;

	}

}
