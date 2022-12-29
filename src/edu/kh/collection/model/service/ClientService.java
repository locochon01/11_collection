package edu.kh.collection.model.service;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import edu.kh.collection.model.vo.Client;
import edu.kh.collection.model.vo.Student;

/**
 * @author user1
 *
 */
/**
 * @author user1
 *
 */
public class ClientService {
	
	private Scanner cl = new Scanner(System.in);
	
	private List<Client> clientList = new ArrayList<Client>();
	
	public ClientService() {
		clientList.add(new Client("홍길동", 25, "서울", 'M'));
		clientList.add(new Client("홍나나", 25, "부산", 'F'));
		clientList.add(new Client("김나나", 28, "대구", 'F'));
		clientList.add(new Client("임꺽정", 28, "대구", 'M'));
		clientList.add(new Client("김삿갓", 30, "수원", 'M'));
		clientList.add(new Client("박콩쥐", 29, "서울", 'F'));
		clientList.add(new Client("황진이", 23, "부산", 'F'));
	}
	public void displayMenu() {
		
		int menuNum = 0;
		
		do {
			System.out.println("\n======고객 관리 프로그램======\n");
			System.out.println("1. 고객 정보 추가");
			System.out.println("2. 고객 전체 조회");
			System.out.println("3. 고객 정보 수정");
			System.out.println("4. 고객 정보 제거");
			System.out.println("5. 이름으로 검색 (일치)");
			System.out.println("6. 이름으로 검색 (포함)");
			System.out.println("0, 프로그램 종료");
			System.out.print("\n메뉴 번호 선택>>");
			
			try {
				menuNum = cl.nextInt();
				System.out.println();
				
				switch(menuNum) {
				case 1: System.out.println(addClient()); break; 
				case 2: selectAll(); break; 
				case 3: break; 
				case 4: break; 
				case 5: break; 
				case 6: break; 
				case 0: break; 
				}
			}catch(InputMismatchException e) {
				System.out.println("\nerror: 입력 형식이 유효하지 않습니다. 다시 시도해주세요.");
				cl.nextLine();
				menuNum = -1;
			}
		}while(menuNum != 0);
	}
	
	public String addClient() {
		System.out.println("=====고객 정보 추가=====");
		
		System.out.println("이름: ");
		String name = cl.next();
		
		System.out.print("나이: ");
		int age = cl.nextInt();
		cl.nextLine();
		
		System.out.print("지역: ");
		String region = cl.nextLine();
		
		System.out.print("성별(M/F):" );
		char gender = cl.next().charAt(0); // String -> char
		
		System.out.print("점수: ");
		int score = cl.nextInt();
		
		// Student 객체 생성 후 List에 추가
		
		if (clientList.add(new Client(name,age,region,gender))) {
			return "성공";
		}else {
			return "";
		}
	}
	public void selectAll() {
		
		System.out.println("=====학생 전체 조회=====");
		
			if(clientList.isEmpty()) {
				System.out.println("고객 정보가 없습니다.");
				
				return;
			}
			int index = 0;
			for(Client clt : clientList) {
				System.out.print((index++) + "번 ");
				System.out.println(clt);
			}
	}
	
	
}
