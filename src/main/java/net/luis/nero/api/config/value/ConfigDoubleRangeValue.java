package net.luis.nero.api.config.value;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import net.luis.nero.api.config.ConfigValueType;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ConfigDoubleRangeValue {
	
	ConfigValueType valueType() default ConfigValueType.UTIL;
	
	String name();
	
	String comment() default "";
	
	double minValue();
	
	double defaultValue();
	
	double maxValue();

}
