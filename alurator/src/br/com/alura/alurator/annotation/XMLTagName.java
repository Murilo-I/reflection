package br.com.alura.alurator.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface XMLTagName {

	public String value();
	//quando a annotation possui apenas um atributo, é convenção chama-lo de value
}
