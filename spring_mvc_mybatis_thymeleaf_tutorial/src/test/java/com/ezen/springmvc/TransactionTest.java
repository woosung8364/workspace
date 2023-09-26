package com.ezen.springmvc;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.ezen.springmvc.transaction.TransactionDemoService;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class TransactionTest {
	
	private TransactionDemoService service;
	
	@Test
	public void applyTransactionDemoTest () {
		Object proxy = service.getClass();
		log.info("AOP 프록시객체 : {}", proxy);
		}
	
	
	
	
}
