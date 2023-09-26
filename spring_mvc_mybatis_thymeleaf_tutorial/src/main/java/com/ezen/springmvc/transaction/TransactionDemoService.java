package com.ezen.springmvc.transaction;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TransactionDemoService {

	
	@Transactional
	public void applyTransaction () {
//		현재 스레드에 트랜잭션이 적용되어 있는지 확인
//		트랜잭션 동기화 매니저를 통해 true 면 트랜잭션이 적용됨을 말한다
		
		Boolean txActive = false;
		txActive = TransactionSynchronizationManager.isActualTransactionActive();
	
		log.info("트랜잭션 활성화 상태 : {}" , txActive);
	}
	
	public void nonApplyTransaction () {
		Boolean txActive = false;
		txActive = TransactionSynchronizationManager.isActualTransactionActive();
	
		log.info("트랜잭션 활성화 상태 : {}" , txActive);
	}
}
