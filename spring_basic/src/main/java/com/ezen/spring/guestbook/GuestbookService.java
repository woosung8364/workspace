package com.ezen.spring.guestbook;

import java.util.List;

public interface GuestbookService {
	
	public void register(Guestbook guestbook);
	public List<Guestbook> findGuestbooks();
	
}
