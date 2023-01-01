package ssocafeinventory.model.vo;

import java.sql.Date;

public class CafeInven {
	private String name;
	private int inoutStock;
	private Date inoutTime;
	
	public CafeInven() {
		super();
	}

	public CafeInven(String name, int inoutStock, Date inoutTime) {
		super();
		this.name = name;
		this.inoutStock = inoutStock;
		this.inoutTime = inoutTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getInoutStock() {
		return inoutStock;
	}

	public void setInoutStock(int inoutStock) {
		this.inoutStock = inoutStock;
	}

	public Date getInoutTime() {
		return inoutTime;
	}

	public void setInoutTime(Date inoutTime) {
		this.inoutTime = inoutTime;
	}
	
	
}

