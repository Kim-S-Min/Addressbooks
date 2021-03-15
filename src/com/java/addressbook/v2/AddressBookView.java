package com.java.addressbook.v2;

public class AddressBookView {

	AddressBookService adressService = new AddressBookService();

	public void addressViewStart() {
		System.out.println("********************************");
		System.out.println("*       전화번호 관리 프로그램       *");
		System.out.println("********************************");

	}

	public void addressViesMenu() {
		System.out.println("1.리스트 2.등록 3.삭제 4.검색 5.종료");
		System.out.println("--------------------------------");
		System.out.println(">메뉴 번호 : ");
	}

	public void addressViewEnd() {
		System.out.println("********************************");
		System.out.println("*           감사합니다            *");
		System.out.println("********************************");
	}

	public void addressViewEr() {
		System.out.println("[다시 입력해주세요.]");
	}

	public void addressViewList() {
		System.out.println("<1. 리스트>");
		adressService.addressList();
		System.out.println();
	}

	public void addressViewInsert() {
		System.out.println("<2. 등록>");
	}

	public void addressViewDelete() {
		System.out.println("<3. 삭제>");
		System.out.print(">번호 : ");
	}

	public void addressViewSearch() {
		System.out.println("<4. 검색>");
		System.out.print(">이름 : ");
	}

}