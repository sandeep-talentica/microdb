package com.sandeep.ws.aop.api.advice;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class MethodLogger {
	@Around("execution(* *(..)) && @annotation(LogMethodParam)")
	public Object around(ProceedingJoinPoint point) throws Throwable {
		Object result = point.proceed();

		String methodname = MethodSignature.class.cast(point.getSignature()).getMethod().getName();
		log.info("Passed Parameter to method"+"->" + methodname + " are->" + Arrays.toString(point.getArgs()));

		return result;
	}
}