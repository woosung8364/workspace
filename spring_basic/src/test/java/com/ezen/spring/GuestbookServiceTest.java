package com.ezen.spring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ezen.spring.guestbook.Guestbook;
import com.ezen.spring.guestbook.GuestbookService;


@SpringBootTest
public class GuestbookServiceTest {
	
	
	@Autowired
	GuestbookService guestbookService;
	
	@Test
	void registTest() {
		Guestbook guestbook=Guestbook.builder().writer("송우성").message("졸았다...").build();
		guestbookService.register(guestbook);
	}
}
