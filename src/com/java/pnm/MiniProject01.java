package com.java.pnm;

public class MiniProject01 {	//	PhoneInfo
	 private String name;	//	이름
	 private String num;	//	핸드폰번호
	 private String tel;	//	집전화번호
	 
	 public MiniProject01(String name, String num, String tel){
	  this.name = name;
	  this.num = num;
	  this.tel = tel;
	  
	 }
	 public MiniProject01(String name, String num){
	  this.name = name;
	  this.num = num;
	  this.tel = null;
	 }
	 public void showInfo(){
	  System.out.print(name + "," + num);
	  if(tel != null)
	   System.out.println("," + tel);
	 
	  System.out.println();
	  
	 }
	 public String getName(){
		  return name;
	}
}