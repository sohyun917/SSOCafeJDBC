package ssocafeinventory.controller;

import java.util.List;

import ssocafeinventory.model.dao.CafeInvenDAO;
import ssocafeinventory.model.vo.CafeInven;

public class CafeInvenController {

	CafeInvenDAO cDao = new CafeInvenDAO();
	
	public int inoutMenu(CafeInven cafe) {
		int result = cDao.inoutMenu(cafe);
		return result;
	}
	
	public List<CafeInven> printStock() {
		List<CafeInven> cList = cDao.printStock();
		return cList;
	}
	
	public List<CafeInven> orderSys() {
		List<CafeInven> cList = cDao.orderSys();
		return cList;
	}
}
