package net.luis.nero.api.config.value;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ConfigIntegerRangeValue {
	
	String comment() default "";
	
	String name();
	
	int minValue();
	
	int defaultValue();
	
	int maxValue();

}
