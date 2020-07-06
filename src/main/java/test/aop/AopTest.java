package test.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author lijy
 * @descriptin
 * @since
 */
public class AopTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);
        ActionMethodService methodService = context.getBean(ActionMethodService.class);
        ActionAnnotationService actionAnnotationService = context.getBean(ActionAnnotationService.class);
        methodService.add();
        actionAnnotationService.add();
        context.close();
    }
}
