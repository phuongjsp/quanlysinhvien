package hoang.phuong.server.config;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import hoang.phuong.server.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.nio.charset.Charset;
import java.util.List;

/**
 *
 */

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"hoang.phuong.server.controller", "hoang.phuong.server.handler"})
public class WebConfig extends WebMvcConfigurationSupport {
   @Bean
   public StringHttpMessageConverter stringHttpMessageConverter() {
      return new StringHttpMessageConverter(Charset.forName("UTF-8"));
   }

   @Override
   public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
      MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
      converter.setObjectMapper(objectMapper());
      converters.add(converter);
      super.configureMessageConverters(converters);
   }

   @Bean
   @Primary
   public ObjectMapper objectMapper() {
      ObjectMapper mapper = new ObjectMapper();
      SimpleModule module = new SimpleModule();
      module.addDeserializer(User.class, new UserDeserializer());
      mapper.registerModule(module);
      mapper.registerModule(new Hibernate5Module());
      mapper.enable(MapperFeature.DEFAULT_VIEW_INCLUSION);
      mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
      mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
      mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
      return mapper;
   }
}
