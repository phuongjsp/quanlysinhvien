package hoang.phuong.server.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import java.util.Properties;

import static org.hibernate.cfg.Environment.*;

@Configuration
@PropertySource("classpath:db.properties")
@PropertySource(value = {"classpath:email/email.properties"})
@EnableTransactionManagement
@ComponentScans(value = {@ComponentScan("hoang.phuong.server")})

public class AppConfig {

    @Autowired
    private Environment env;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public JavaMailSenderImpl mailSender(@Value("${mail.host}") String mailHost,
                                         @Value("${mail.port}") Integer mailPort,
                                         @Value("${mail.username}") String mailUsername,
                                         @Value("${mail.password}") String mailPassword,
                                         @Value("${mail.smtp.auth}") String mailSmtpAuth,
                                         @Value("${mail.smtp.port}") String mailSmtpPort,
                                         @Value("${mail.smtp.socketFactory.class}")
                                                 String mailSmtpSocketFactoryClass,
                                         @Value("${mail.smtp.socketFactory.port}")
                                                 String mailSmtpSocketFactoryPort) {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        Properties props = new Properties();
        props.put("mail.smtp.auth", mailSmtpAuth);
        props.put("mail.smtp.port", mailSmtpPort);
        props.put("mail.smtp.socketFactory.class", mailSmtpSocketFactoryClass);
        props.put("mail.smtp.socketFactory.port", mailSmtpSocketFactoryPort);
        javaMailSender.setJavaMailProperties(props);
        javaMailSender.setHost(mailHost);
        javaMailSender.setPort(mailPort);
        javaMailSender.setUsername(mailUsername);
        javaMailSender.setPassword(mailPassword);
        return javaMailSender;
    }


    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    @Resource(name = "getSessionFactory")
    public LocalSessionFactoryBean getSessionFactory() {
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();

        Properties props = new Properties();
        // Setting JDBC properties
        props.put(DRIVER, env.getProperty("mysql.driver"));
        props.put(URL, env.getProperty("mysql.url"));
        props.put(USER, env.getProperty("mysql.user"));
        props.put(PASS, env.getProperty("mysql.password"));

        // Setting Hibernate properties
        props.put(SHOW_SQL, env.getProperty("hibernate.show_sql"));
        props.put(HBM2DDL_AUTO, env.getProperty("hibernate.hbm2ddl.auto"));
        props.put(DIALECT, "org.hibernate.dialect.MySQL5InnoDBDialect");
        props.put("hibernate.enable_lazy_load_no_trans", true);
        // Setting C3P0 properties
        props.put(C3P0_MIN_SIZE, env.getProperty("hibernate.c3p0.min_size"));
        props.put(C3P0_MAX_SIZE, env.getProperty("hibernate.c3p0.max_size"));
        props.put(C3P0_ACQUIRE_INCREMENT,
                env.getProperty("hibernate.c3p0.acquire_increment"));
        props.put(C3P0_TIMEOUT, env.getProperty("hibernate.c3p0.timeout"));
        props.put(C3P0_MAX_STATEMENTS, env.getProperty("hibernate.c3p0.max_statements"));
        factoryBean.setHibernateProperties(props);
        factoryBean.setPackagesToScan("hoang.phuong.server.model");
        return factoryBean;
    }



    @Bean
    public HibernateTransactionManager getTransactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(getSessionFactory().getObject());
        return transactionManager;
    }
}
