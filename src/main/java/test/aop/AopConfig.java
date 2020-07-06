package test.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author lijy
 * @descriptin
 * @since
 */
@Configuration
@ComponentScan("test")
@EnableAspectJAutoProxy
public class AopConfig {
}
