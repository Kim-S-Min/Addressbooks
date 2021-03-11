package com.java.pnm;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Scanner;

public class PNMMainData {
	static final String rootPath = System.getProperty("user.dir") + "\\file\\";
	static final String filename = rootPath + "PhoneNumberManagement.txt";
	static final String target = rootPath + "PhoneNumberManagement.txt";
	
	
	PNMData[]  phoneBook;
	private int count;
	Scanner keyboard = new Scanner(System.in);
	

	public PNMMainData() {
		phoneBook = new PNMData[1000];
		count = 0;
		
		
	}
	//	명단보기
	public void viewList() {
		Reader reader = null;
		try {
			reader = new FileReader(filename);
			
			int data = 0;
			int i = 0;
			System.out.println();
			System.out.println("<1.리스트>");
			
			while((data = reader.read()) != -1) {
				System.out.print((char)data);	
			}
			System.out.println();
		} catch (FileNotFoundException e) {
			System.err.println("파일을 찾지 못했습니다...");
		} catch (IOException e) {
		} finally {
			try {
				reader.close();
			} catch (Exception e) {	
			}
		}
		
		
	}
	//	명단추가
	public void saveList() {
		Writer writer = null;
	
		System.out.print("> 이름: ");
		String name = keyboard.nextLine();
		System.out.print("> 휴대전화:");
		String num = keyboard.nextLine();
		System.out.print("> 집전화:");
		String tel = keyboard.nextLine();
		phoneBook[count++] = new PNMData(name,num,tel);
		
		try {
			writer = new BufferedWriter(new FileWriter("filename", true));	//	초기화되는것만 막으면 되는데
			writer.write(name + ",");
			writer.write(num + ",");
			writer.write(tel + "\n");
			
			
			//	내부 버퍼 비우기
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch (Exception e) {
				
			}
		}
		
		
	}
	//	명단삭제
/*	public void deleteList() {
		  int index;
		  System.out.print("> 이름 : ");
		  String name = keyboard.nextLine();
		  index = search(name);
		  if(index<0)
		   System.out.println("검색되지 않습니다");
		  else{
		   for(int i = index; i < count -1; i++) {
		    phoneBook[i] = phoneBook[i + 1];    
		   }
		   count--;
		   System.out.println("[삭제되었습니다]\n");
		  }
		  
		  
	}	*/
	//	명단검색
	public void searchList() {
		Reader reader = null;
		Writer writer = null;
		BufferedReader br = null;
		BufferedWriter bw = null;
		
	
		try {
		//	reader = new FileReader(source);
			writer = new FileWriter(target);
			
			br = new BufferedReader(reader);
			bw = new BufferedWriter(writer);
			String line = null;
			
			System.out.print("> 이름: ");
			String kw = keyboard.nextLine();
			while((line = br.readLine()) != null) {
				if (line.toLowerCase().contains(kw)) {
					System.out.println(line);
					bw.write(line);		//	줄단위(한줄로) 출력
					bw.newLine();	//	개행하여 출력
				}
			}
		} catch (FileNotFoundException e) {
			System.err.println("파일을 찾지 못했습니다...");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				bw.close();
			} catch (Exception e) {
				
			}
		}
	}
	
}
