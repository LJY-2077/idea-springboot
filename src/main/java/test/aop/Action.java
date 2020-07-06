package test.aop;

import java.lang.annotation.*;

/**
 * @author lijy
 * @descriptin
 * @since
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Action {
    String name ();
}
