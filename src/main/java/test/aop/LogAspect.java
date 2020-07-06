package test.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author lijy
 * @descriptin
 * @since
 */
@Aspect
@Component
public class LogAspect {
    @Pointcut("@annotation(Action)")
    public void annotationPointCut() {

    }

    @After("annotationPointCut()")
    public void after(JoinPoint joinPoint) {
        MethodSignature signature= (MethodSignature) joinPoint.getSignature();
        Method method=signature.getMethod();
        Action action = method.getAnnotation(Action.class);
        System.out.println("注解拦截"+action.name());
     }


    @Before("execution(public * test.aop.ActionMethodService.*(..))")
    public void before(JoinPoint joinPoint) {
        MethodSignature signature= (MethodSignature) joinPoint.getSignature();
        Method method=signature.getMethod();
        System.out.println("方法规则拦截"+method.getName());
    }

}
