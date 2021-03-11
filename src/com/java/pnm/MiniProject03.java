package com.java.pnm;

import java.util.Scanner;

public class MiniProject03 {
	MiniProject01 [] phoneBook;
	 private int count;//전화번호부에 저장되잇는 사람수
	 Scanner keyboard = new Scanner(System.in);
	 
	 public MiniProject03(){
	  phoneBook=new MiniProject01[100];
	  count=0;  
	 }
	 //데이터의 검색
	 public void searchBook(){
	  
	  int index;
	  System.out.println("<검색>");
	  System.out.print("> 이름:");
	  String name = keyboard.nextLine();
	  index = search(name);
	  if(index < 0)
	   System.out.println("해당하는 값이 없습니다");
	  else{
	   phoneBook[index].showInfo();
	  }
	 }
	 
	 public int search(String name){//이름찾기
	  
	  for(int index=0;index<count;index++){
	   if(name.compareTo(phoneBook[index].getName())==0){
	    return index;
	   }
	  }
	  return -1;
	 }
	 //데이터의 삭제
	 public void removeBook(){

	  int index;
	  System.out.print("삭제할 이름 입력:");
	  String name=keyboard.nextLine();
	  index=search(name);
	  if(index<0)
	   System.out.println("해당하는 값이 없습니다.");
	  else{
	   for(int i=index;i<count-1;i++){
	    phoneBook[i]=phoneBook[i+1];    
	   }
	   count--;
	   System.out.println("[삭제되었습니다]\n");
	  }
	   
	 }
	 //데이터의 저장
	 public void readBook(){//입력처리
	  System.out.print("> 이름:");
	  String name = keyboard.nextLine();
	  System.out.print("> 휴대전화:");
	  String num = keyboard.nextLine();
	  System.out.print("> 집전화:");
	  String tel = keyboard.nextLine();
	  phoneBook[count++] = new MiniProject01(name,num,tel);
	 }
	 
	 


}
