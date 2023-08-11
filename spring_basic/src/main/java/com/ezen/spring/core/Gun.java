package com.ezen.spring.core;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class Gun implements Weapon{

	@Override
	public void attack() {
		log.info("개머리판으로 뚝배기 내려 찍습니다...");
	}

}
