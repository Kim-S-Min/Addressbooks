package com.java.pnm;

public class PNMData {
	static final String rootPath = System.getProperty("user.dir") + "\\file\\";
	static final String filename = rootPath + "PhoneNumberManagement.txt";
	static final String target = rootPath + "PhoneNumberManagement.txt";
	
	private String name;
	private String num;
	private String tel;
	private String kw;
	
	public PNMData(String name, String num, String tel) {
		this.name = name;
		this.num = num;
		this.tel = tel;
		
		
	}
	public PNMData(String kw) {
		this.kw = kw;
	}
	public String getName() {
		return name;
		
	}
}
