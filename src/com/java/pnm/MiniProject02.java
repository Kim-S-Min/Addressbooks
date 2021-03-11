package com.java.pnm;

import java.util.Scanner;

public class MiniProject02 {	//	PhoneMain
	static Scanner keyboard = new Scanner(System.in);

	 public static void showMenu(){//메뉴를 보여주는화면
	  System.out.println("---------전화번호부관리프로그램ver3----------");
	  System.out.println("선택하세요..");
	  System.out.println("1. 데이터 입력");
	  System.out.println("2. 데이터 검색");
	  System.out.println("3. 데이터 삭제");
	  System.out.println("4. 데이터 종료");
	  
	 }
	 
	 public static void main(String ar[]){
	 // PhoneInfo phone;
		 MiniProject03 phoneManager = new MiniProject03();
	  
	  while(true){//무한루프
	   
	   showMenu();
	   int input=keyboard.nextInt();
	   keyboard.nextLine();
	  
	   switch(input){
	   case 1://입력
	     phoneManager.readBook();
	     break;
	   case 2://찾기
	     phoneManager.searchBook();
	     break;
	   case 3://삭제
	     phoneManager.removeBook();
	     break;
	   case 4: System.out.println("프로그램을종료합니다.");
	     return;
	   }
	      
	  }
	  
	 }
}
