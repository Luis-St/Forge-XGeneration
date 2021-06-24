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
public @interface ConfigStringValue {
	
	ConfigValueType valueType() default ConfigValueType.UTIL;
	
	String name();
	
	String comment() default "";
	
	String value();
	
}
