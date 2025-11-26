package util;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface InfoAutor {
    String nome();
    String matricula();
    String versao() default "1.0";
}