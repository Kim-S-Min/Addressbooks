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
	Scanner keyboard = new Scanner(System.in);

	//	명단보기	//	명단에 개행이 안되어 있는 상태로 등록을 한다면 개행이 되지 않고 연락처가 추가된다
	public void viewList() {
		Reader reader = null;
		try {
			reader = new FileReader(filename);	
			
			System.out.println();
			System.out.println("<1.리스트>");
			
			FileReader fin = null;
			try {
				fin = new FileReader("C:\\Users\\BIT_R45\\git\\Addressbooks\\file\\PhoneNumberManagement.txt");
				//	저장소의 위치(사용자의 컴퓨터가 바뀔때)를 고려해야 한다
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
		System.out.println();
		} catch (FileNotFoundException e) {
			System.err.println("[파일을 찾을 수 없습니다]");
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
		//	명단삭제
		Reader reader = null;
		Writer writer = null;
		BufferedReader br = null;
		BufferedWriter bw = null;
	
		System.out.print("> 번호: ");
		int cn = keyboard.nextInt();	
		
		try {
			reader = new FileReader(filename);
			writer = new FileWriter(target);
			br = new BufferedReader(reader);
			bw = new BufferedWriter(writer);
			String line = null;
			int counter = 0;
			
			while((line = br.readLine()) != null) {
				counter++;
				if (counter == cn) {
					System.out.println(line);
					//	삭제하기 데이터 넣을 공간
					System.out.println("[삭제가 완료되었습니다]");
				} 
			}		
		} catch (FileNotFoundException e) {
			System.err.println("[파일을 찾을 수 없습니다]");
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
			System.err.println("[파일을 찾을 수 없습니다]");
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