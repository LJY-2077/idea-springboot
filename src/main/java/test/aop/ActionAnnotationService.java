package test.aop;

import org.springframework.stereotype.Service;
import test.aop.Action;
import test.test;

/**
 * @author lijy
 * @descriptin
 * @since
 */
@Service
public class ActionAnnotationService {
    @Action(name = "注解拦截的add测试方法")
    public void add() {
    }

    ;
}
