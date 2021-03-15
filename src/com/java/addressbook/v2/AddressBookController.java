package com.java.addressbook.v2;

import java.util.Scanner;

public class AddressBookController {

	protected void addressBook() {
		
		AddressBookService adressService = new AddressBookService();
		AddressBookView adressView = new AddressBookView();
				
		adressView.addressViewStart();
		Scanner sc = new Scanner(System.in);
		while (true) {
			adressView.addressViesMenu();

			switch (sc.nextInt()) {
			case 1:
				adressView.addressViewList();
				continue;
			case 2:
				adressView.addressViewInsert();
				adressService.addressInsert(adressService.addressInfo(sc));
				System.out.println("[등록되었습니다.]\n");
				continue;
			case 3:
				adressView.addressViewDelete();
				adressService.addressDelete(sc.nextInt());
				System.out.println("[삭제되었습니다.]\n");
				continue;
			case 4:
				adressView.addressViewSearch();
				adressService.addressSearch(sc.next());
				continue;
			case 5:
				adressView.addressViewEnd();
				break;
			default:
				adressView.addressViewEr();
				continue;
			}
			sc.close();
			break;
		}

	}

	/*
	 * 테스트용 강지형,010-2209-8728,02-2123-0910 일지형,010-2209-8728,02-2123-0910
	 * 이지형,010-2209-8728,02-2123-0910 삼지형,010-2209-8728,02-2123-0910
	 */

}