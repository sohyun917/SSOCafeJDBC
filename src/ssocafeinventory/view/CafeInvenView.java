package ssocafeinventory.view;

import java.util.List;
import java.util.Scanner;

import ssocafeinventory.model.vo.CafeInven;

public class CafeInvenView {
	Scanner sc = new Scanner(System.in);
	public int mainMenu() {
		System.out.println("====== 재고관리 프로그램 ======");
		System.out.println("1. 입출고내역");
		System.out.println("2. 재고내역확인");
		System.out.println("3. 발주프로그램");
		System.out.println("0. 프로그램 종료");
		System.out.print("어떤 메뉴로 들어가시겠습니까 ? : ");
		int result = sc.nextInt();
		return result;
	}
	
	public CafeInven inoutMenu() {
		System.out.println("====== 입출고내역 ======");
		System.out.print("제품명을 입력하세요 : ");
		String name = sc.next();
		System.out.print("입출고수량을 입력하세요 : ");
		int inoutStock = sc.nextInt();
		CafeInven cafe = new CafeInven(name, inoutStock, null);
		return cafe;
	}
	
	public void successMsg(String message) {
		System.out.println("서비스 성공 : " + message);
	}
	
	public void failMsg(String message) {
		System.out.println("서비스 실패 : " + message);
	}
	
	public void printStock(List<CafeInven> cList) {
		System.out.println("====== 재고내역 ======");
		for(CafeInven cafe : cList) {
			System.out.println("제품명 : " + cafe.getName());
			System.out.println("제품수량 : " + cafe.getInoutStock());
			System.out.println("입출고날짜  : " + cafe.getInoutTime());
			System.out.println("--------------------------------");
		}
	}
	
	public void orderSys(List<CafeInven> cList) {
		System.out.println("====== 발주목록 ======");
		for(CafeInven cafe : cList) {
			System.out.println(cafe.getName() + "이/가 " + cafe.getInoutStock() + "개 남았습니다.");
			System.out.println("발주하셔야합니다.");
		}
	}
}
