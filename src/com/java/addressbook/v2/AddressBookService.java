package com.java.addressbook.v2;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;


public class AddressBookService {
	static final String rootPath = System.getProperty("user.dir") + "\\";
	static final String filename = rootPath + "AdressBook.txt";

	protected void addressList() {
		List<AddressBook> adr = addressBookList();
		for (int i = 0; i < adr.size(); i++) {
			System.out.print((i + 1) + ". " + adr.get(i).getName() + "\t" + adr.get(i).getHp() + "\t"
					+ adr.get(i).getTel() + "\n");
		}

	}

	protected void addressInsert(AddressBook address) {
		Writer writer = null;
		BufferedWriter bw = null;
		try {
			writer = new FileWriter(filename, true);
			bw = new BufferedWriter(writer);
			bw.newLine();
			bw.append(address.getName() + "," + address.getHp() + "," + address.getTel());
			bw.flush();

		} catch (IOException e) {
			System.err.println("에러발생");
			e.printStackTrace();
		} finally {
			try {
				writer.close();
				bw.close();
			} catch (Exception e) {

			}
		}
	}

	protected AddressBook addressInfo(Scanner sc) {

		System.out.print(">이름 : ");
		String name = sc.next();
		System.out.print(">휴대전화 : ");
		String hp = sc.next();
		System.out.print(">집전화 : ");
		String tel = sc.next();
		AddressBook address = new AddressBook(name, hp, tel);
		return address;
	}

	protected List<AddressBook> addressBookList() {
		Reader reader = null;
		BufferedReader br = null;

		List<AddressBook> list = new ArrayList<>();
		try {
			reader = new FileReader(filename);
			br = new BufferedReader(reader);
			String line = null;
			while ((line = br.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(line, ",");
				AddressBook address = new AddressBook(st.nextToken(), st.nextToken(), st.nextToken());
				list.add(address);
			}
		} catch (FileNotFoundException e) {
			System.err.println("파일을 찾을 수 없습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	protected void addressDelete(int num) {
		Writer writer = null;
		BufferedWriter bw = null;
		try {
			List<AddressBook> list = addressBookList();
			list.remove(num - 1); // 리스트는 0부터 시작이기때문에 +1

			writer = new FileWriter(filename);
			bw = new BufferedWriter(writer);

			for (int i = 0; i < list.size(); i++) {
				if (i == list.size() - 1) {
					bw.write(list.get(i).getName() + "," + list.get(i).getHp() + "," + list.get(i).getTel());
				} else {
					bw.write(list.get(i).getName() + "," + list.get(i).getHp() + "," + list.get(i).getTel());
					bw.newLine();
				}
			}
			bw.flush();
		} catch (IOException e) {
			System.err.println("에러발생");
			e.printStackTrace();
		} finally {
			try {
				bw.close();
			} catch (Exception e) {

			}
		}
	}

	protected void addressSearch(String str) {

		List<AddressBook> list = addressBookList();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getName().contains(str)) {
				System.out.println((i + 1) + ". " + list.get(i).toString());
			}
		}
		System.out.println();

	}
}