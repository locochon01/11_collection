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
			System.out.println("7. 지역으로 검색");
			System.out.println("0, 프로그램 종료");
			System.out.print("\n메뉴 번호 선택>>");
			
			try {
				menuNum = cl.nextInt();
				System.out.println();
				
				switch(menuNum) {
				case 1: System.out.println(addClient()); break; 
				case 2: showAll(); break; 
				case 3: System.out.println(updateClient()); break; 
				case 4: removeClient(); break; 
				case 5: searchName1(); break; 
				case 6: searchName2(); break; 
				case 7: searchRegion(); break; 
				case 0: System.out.println("프로그램 종료"); break; 
				default: System.out.println("원하시는 메뉴의 번호를 입력해주세요");
				}
			}catch(InputMismatchException e) {
				System.out.println("\nerror: 입력 형식이 유효하지 않습니다. 다시 시도해주세요.");
				cl.nextLine();
				menuNum = -1;
			}
		}while(menuNum != 0);
	}
	
	public String addClient() throws InputMismatchException {
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
		
		// Student 객체 생성 후 List에 추가
		
		if (clientList.add(new Client(name,age,region,gender))) {
			return "성공";
		}else {
			return "실패";
		}
	}
	public void showAll() {
		
		System.out.println("=====학생 전체 조회=====");
		
			if(clientList.isEmpty()) {
				System.out.println("고객 정보가 없습니다.");
				
				return;
			}
			int index = 0;
			for(Client clt : clientList) {
				System.out.print(((index++)+1) + "번 ");
				System.out.println(clt);
			}
	}
	
	public String updateClient() {
		System.out.println("=====고객정보수정=====");
		
		System.out.print("고객 번호 입력: ");
		int index = cl.nextInt()-1;
		cl.nextLine();
		
		
		// 1)고객정보가 clientList에 있는가
		if(clientList.isEmpty()) {
			return"입력된 정보가 없습니다. 회원 가입을 해주세요";
			
		// 2)입력된 숫자가 0보다 작은가(음수)?
		} else if (index < 0) {
			return"잘못 입력하셨습니다. 다시 해주세요";
		}else if(index>=clientList.size()) {
			return"잘못 입력하셨습니다. 다시 해주세요";
		}else {
			System.out.println( (index+1) + "번 손님"); 
			System.out.println( clientList.get(index));
			
			System.out.print("이름: ");
			String name = cl.next();
			
			System.out.print("나이: ");
			int age = cl.nextInt();
			cl.nextLine();
			
			System.out.print("지역: ");
			String region = cl.nextLine();
			
			System.out.print("성별(M/F): ");
			char gender = cl.next().charAt(0);
			
			Client temp = clientList.set(index, new Client(name, age, region, gender));
			
			return temp.getName() + "님의 정보가 변경 되었습니다";
		}
	}
	
	public String removeClient() throws InputMismatchException {
		System.out.println("========고객 정보 제거=======");
		
		System.out.println("고객번호 입력: ");
		int index = cl.nextInt()-1;
		cl.nextLine();
		
		if(clientList.isEmpty()) {
			return "입력된 고객정보가 없습니다.";
		}else if(index<0) {
			return "잘못 입력하셨습니다. 다시 해주세요";
		}else if(index >= clientList.size()) {
			return "잘못 입력하셨습니다. 다시 해주세요";
		}else {
			System.out.println("정말 삭제하시겠습니까? (Y/N): ");
			char ch= cl.next().toUpperCase().charAt(0);
			if(ch=='Y') {
				Client temp = clientList.remove(index);
				return temp.getName() + "님의 정보가 제거되었습니다.";
			}else {
				return "취소";
			}
		}
	}
	
	public void searchName1() {
		System.out.println("======= 고객 이름 검색 (이름 일치)=======");
		
		System.out.println("이름을 입력해주세요: ");
		String input = cl.next();
		
		boolean flag = true;
		
		for(Client clt : clientList) {
			if(input.equals(clt.getName())) {
				System.out.println(clt);
				flag = false;
			}
		}
		if(flag) {
			System.out.println("검색 결과가 없습니다.");
		}
	}
	
	public void searchName2() {
		System.out.println("=====고객 이름 검색 (문자열 포함)=====");
		
		System.out.println("이름에 포함된 문자열 입력: ");
		String input = cl.next();
		
		boolean flag = true;
		
		for (Client clt : clientList) {
			if(clt.getName().contains(input)) {
				System.out.println(clt);
				flag = false;
			}
		}
		if(flag) {
			System.out.println("검색결과가 없습니다.");
		}
	}
	
	public void searchRegion() {
		System.out.println("=====지역별 검색=====");
		
		System.out.print("지역을 입력 해 주세요: ");
		String input = cl.next();
		
		boolean flag = true;
		
		for(Client clt : clientList) {
			if(clt.getRegion().contains(input)) {
				System.out.println(clt);
				flag = false;
			}
		}
		if(flag) {
			System.out.println("결과가 없습니다.");
		}
	}
	
	
}
