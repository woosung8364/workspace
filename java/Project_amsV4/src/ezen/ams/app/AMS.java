package ezen.ams.app;

import ezen.ams.gui.AMSFrame;

public class AMS {

	public static void main(String[] args) {
		AMSFrame frame = new AMSFrame("EZEN_BANK_AMS");
		frame.init();
		frame.pack();
		frame.setResizable(false);
		frame.setVisible(true);
		frame.addEventListener();
	}	

}
