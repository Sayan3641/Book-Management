package com.example.book.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class LoggingAspect {
	
//	@Before("execution (* com.example.book.service.BookService.addBook(..))")
//	public void logHandlerBefore() {
//		System.out.println("Logger added before");
//	}
//	
//	@After("execution (* com.example.book.service.BookService.addBook(..))")
//	public void logHandlerAfter() {
//		System.out.println("Logger added after");
//	}
	
	@Around("execution (* com.example.book.service.BookService.addBook(..))")
	public Object loggerAddedAround(ProceedingJoinPoint p) throws Throwable {
		log.info("Logger added before "+p.getSignature().getName());
		Object result = p.proceed();
		log.info("Logger added after "+p.getSignature().getName());
		return result;
	}
	
	@AfterThrowing("execution(* com.example.book.service.*.*(..))")
	public void logAfterException() {
		log.info("Log after exception");
	}
	
	@AfterReturning("execution(* com.example.book.service.*.*(..))")
	public void logAfterReturn() {
		log.info("Log after Return");
	}

}
