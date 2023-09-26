package com.ezen.springmvc.domain.member.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
//@Aspect
@Slf4j
public class TimeTraceAspect {
	
	// 공통기능 메소드
	@Around("execution(* com.ezen.springmvc..*(..))")
	public Object timeCheck(ProceedingJoinPoint joinPoint) {
		String className = joinPoint.getTarget().getClass().getName();
		String methodName = joinPoint.getSignature().toShortString();
		long start = System.currentTimeMillis();
		log.info(methodName + "메소드 요청됨....");
		Object object = null;
		try {
			object = joinPoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}finally {
			long end = System.currentTimeMillis();
			long time = end - start;
			log.info(className+ " 클래스의 "+methodName+" 메소드 수행시간 : {} 소요", time);
		}
		return object;
	}
}











