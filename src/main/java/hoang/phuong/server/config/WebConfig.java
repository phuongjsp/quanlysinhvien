package hoang.phuong.server.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.nio.charset.Charset;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"hoang.phuong.server.controller"})
public class WebConfig extends WebMvcConfigurerAdapter {
   @Bean
   public StringHttpMessageConverter stringHttpMessageConverter() {
      return new StringHttpMessageConverter(Charset.forName("UTF-8"));
   }
   }
