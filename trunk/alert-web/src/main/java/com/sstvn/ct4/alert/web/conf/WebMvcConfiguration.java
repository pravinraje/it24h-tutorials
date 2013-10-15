package com.sstvn.ct4.alert.web.conf;

import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles2.TilesConfigurer;
import org.springframework.web.servlet.view.tiles2.TilesView;


@Configuration
@EnableWebMvc
public class WebMvcConfiguration extends WebMvcAutoConfigurationAdapter{
	 public @Override void addResourceHandlers(ResourceHandlerRegistry registry) {
	        registry.addResourceHandler("/**").addResourceLocations("classpath:/META-INF/web-resources/");
	    }

//	    public @Bean UrlBasedViewResolver tilesViewResolver() {
//	    	UrlBasedViewResolver resolver = new UrlBasedViewResolver();
//	    	resolver.setViewClass(TilesView.class);
//	        return resolver;
//	    }
//
//	    public @Bean TilesConfigurer tilesConfigurer() {
//	        TilesConfigurer ret = new TilesConfigurer();
//	        ret.setDefinitions(new String[] { "classpath:/WEB-INF/layouts/layouts.xml", "classpath:/WEB-INF/views/**/views.xml" });
//	        return ret;
//	    }
}
