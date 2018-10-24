package org.casper.aop;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;


@Aspect
@Log4j
public class NullAdvice {

	@Around("execution(* org.casper.service.SampleService*.*(..))")
	public Object checkNull(ProceedingJoinPoint pjp) {
		log.info("checkNull........................");
		log.info("checkNull........................");
		log.info("checkNull........................");
			
		Object result = null;
		try {
			
			boolean checkNull = false;
			Object[] params = pjp.getArgs();
			
			for(Object object : params) {
				if(object == null) {
					throw new Exception("Null");
				}
			}
			//invoke
			result = pjp.proceed();	// 메소드를 실행함
		} catch (Throwable e) {
			
			e.printStackTrace();
		}
		
		return null;
	}
}
