package ezen.oop;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 사용자 정의 애노테이션
 * @author 김기정
 */
@Target(value = {ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
public @interface MyAnnotation {
	String value();
	int num() default 1; 
	String[] tools();
	Direction direction();
}






