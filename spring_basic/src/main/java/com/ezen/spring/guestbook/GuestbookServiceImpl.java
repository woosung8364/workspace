package com.ezen.spring.guestbook;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class GuestbookServiceImpl implements GuestbookService {


	private final GuestbookRepository guestbookRepository;
	
	public GuestbookServiceImpl(GuestbookRepository guestbookRepository) {
		this.guestbookRepository = guestbookRepository;
	}

	public void register(Guestbook guestbook) {
		guestbookRepository.create(guestbook);		
	}

	public List<Guestbook> findGuestbooks() {
		return guestbookRepository.findAll();
	}
}
