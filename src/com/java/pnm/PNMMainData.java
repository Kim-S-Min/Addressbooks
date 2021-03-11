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
	static final String target = rootPath + "PhoneNumberManagementfiltered.txt";
	
	PNMData[]  phoneBook;
	private int count;
	Scanner keyboard = new Scanner(System.in);
	
	public PNMMainData() {
		phoneBook = new PNMData[1000];
		count = 0;
		
		
	}
	//	명단보기	//	명단보고 등록하고 명단보면 개행이 안되서 줄번호가 제대로 안들어감
	public void viewList() {
		Reader reader = null;
		try {
			reader = new FileReader(filename);	
			
			int data = 0;
			System.out.println();
			System.out.println("<1.리스트>");
			
			FileReader fin = null;
			try {
				fin = new FileReader("C:\\Users\\wrt78\\eclipse-workspace\\Addressbooks\\file\\PhoneNumberManagement.txt");

				int c;
				int count = 1; 
				while((c = fin.read()) != -1) { 
					if(count == 1){ 
						System.out.print(count++ + " ");
						continue;
					}
					System.out.print((char)c); // 읽은 문자를 버퍼 출력 스트림에 쓴다. 근데 이해가 안된다
					if(c == '\n') { 
						System.out.print(count++ + " ");
					}
				}
			} catch(IOException e) {
				System.out.println("파일 입출력 오류");
			}
			System.out.println("\n");
		} catch (FileNotFoundException e) {
			System.err.println("파일을 찾지 못했습니다");
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
		
		try {
			writer = new FileWriter(filename, true);	
			writer.write(name + ",");
			writer.write(num + ",");
			writer.write(tel + "\n");
			
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch (Exception e) {
				
			}
		System.out.println("[명단이 추가되었습니다]");
		}
		
		
	}
	//	명단삭제
	public void deleteList() {
		Reader reader = null;
		Writer writer = null;
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		System.out.print("> 번호: ");
		int cn = keyboard.nextInt();	//	줄번호를 인지할 수 있는 명령어를 사용해야 한다
		
		try {	//	이렇게 출력을하게되면 줄번호가 달라도 행안에 입력된 번호가 있으면 같이 삭제된다
		reader = new FileReader(filename);
		writer = new FileWriter(target);
		br = new BufferedReader(reader);
		bw = new BufferedWriter(writer);
		String line = null;
	
		while((line = br.readLine()) != null) {
			if (line.toLowerCase().contains(cn)) {
				cn.remove(line);
				System.out.println("[삭제되었습니다]");
				bw.write(line);	
				bw.newLine();	
			}
		}
		} catch (FileNotFoundException e) {
			System.err.println("잘못입력하셨습니다");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				bw.close();
			} catch (Exception e) {
			
			}
		}
		//	if () {
		//	1 ~ 저장된 번호를 제외한 다른 번호를 입력시
		//	- "잘못 입력하셨습니다" 출력
		//	} else { 
		//	1 ~ 저장된 번호를 입력시
		//	해당 번호의 행 데이터를 전부 조회 및 삭제
		//	System.out.println("[삭제되었습니다]");
		//	}
		
		
	}	
	//	명단검색
	public void searchList() {
		Reader reader = null;
		Writer writer = null;
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		System.out.print("> 이름: ");
		String kw = keyboard.nextLine();
		try {
			reader = new FileReader(filename);
			writer = new FileWriter(target);
			br = new BufferedReader(reader);
			bw = new BufferedWriter(writer);
			String line = null;
		
			

			while((line = br.readLine()) != null) {
				if (line.toLowerCase().contains(kw)) {
					System.out.println(line);
					bw.write(line);	
					bw.newLine();	
				}
			}
		} catch (FileNotFoundException e) {
			System.err.println("잘못 입력하셨습니다");
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
