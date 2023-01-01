package ssocafeinventory.run;

import java.util.List;

import ssocafeinventory.controller.CafeInvenController;
import ssocafeinventory.model.vo.CafeInven;
import ssocafeinventory.view.CafeInvenView;

public class CafeInvenRun {
	public static void main(String [] args) {
		CafeInvenView cView = new CafeInvenView();
		CafeInvenController cConn = new CafeInvenController();
		CafeInven cafe = null;
		List<CafeInven> cList = null;
		
		DONE :
		while(true) {
			int result = cView.mainMenu();
			switch(result) {
				case 1 : 
					cafe = cView.inoutMenu();
					result = cConn.inoutMenu(cafe);
					if(result > 0) {
						cView.successMsg("수량입력 성공!");
					}else {
						cView.failMsg("수량입력 실패!");
					}
					break;
				case 2 : 
					cList = cConn.printStock();
					cView.printStock(cList);
					break;
				case 3 : 
					cList = cConn.orderSys();
					cView.orderSys(cList);
					break;
				case 0 : break DONE;
				default : break;
			}
		}
		
	}
}
