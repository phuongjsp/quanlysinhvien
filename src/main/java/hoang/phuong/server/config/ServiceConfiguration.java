package hoang.phuong.server.config;

import hoang.phuong.server.config.security.PermissionEvaluator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

@Configuration
@EnableAsync
@ComponentScan("hoang.phuong.server.service")
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class ServiceConfiguration extends GlobalMethodSecurityConfiguration {
    private final ApplicationContext applicationContext;
    private final PermissionEvaluator permissionEvaluator;

    public ServiceConfiguration(ApplicationContext applicationContext, PermissionEvaluator permissionEvaluator) {
        this.applicationContext = applicationContext;
        this.permissionEvaluator = permissionEvaluator;
    }


    @Override
    protected MethodSecurityExpressionHandler createExpressionHandler() {
        DefaultMethodSecurityExpressionHandler handler = new DefaultMethodSecurityExpressionHandler();
        handler.setPermissionEvaluator(permissionEvaluator);
        handler.setApplicationContext(applicationContext);
        return handler;
    }

}
