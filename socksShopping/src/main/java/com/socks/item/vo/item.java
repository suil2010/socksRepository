package com.socks.item.vo;

public class item {
	private String itemId;
	private int itemPrice;
	private int itemQuantity;
	private String itemName;
	private String mainCut;
	private String detailCut;
	public item() {
	}
	public item(String itemId, int itemPrice, int itemQuantity, String itemName, String mainCut, String detailCut) {
		this.itemId = itemId;
		this.itemPrice = itemPrice;
		this.itemQuantity = itemQuantity;
		this.itemName = itemName;
		this.mainCut = mainCut;
		this.detailCut = detailCut;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public int getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}
	public int getItemQuantity() {
		return itemQuantity;
	}
	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getMainCut() {
		return mainCut;
	}
	public void setMainCut(String mainCut) {
		this.mainCut = mainCut;
	}
	public String getDetailCut() {
		return detailCut;
	}
	public void setDetailCut(String detailCut) {
		this.detailCut = detailCut;
	}
	@Override
	public String toString() {
		return "item [itemId=" + itemId + ", itemPrice=" + itemPrice + ", itemQuantity=" + itemQuantity + ", itemName="
				+ itemName + ", mainCut=" + mainCut + ", detailCut=" + detailCut + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((detailCut == null) ? 0 : detailCut.hashCode());
		result = prime * result + ((itemId == null) ? 0 : itemId.hashCode());
		result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
		result = prime * result + itemPrice;
		result = prime * result + itemQuantity;
		result = prime * result + ((mainCut == null) ? 0 : mainCut.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		item other = (item) obj;
		if (detailCut == null) {
			if (other.detailCut != null)
				return false;
		} else if (!detailCut.equals(other.detailCut))
			return false;
		if (itemId == null) {
			if (other.itemId != null)
				return false;
		} else if (!itemId.equals(other.itemId))
			return false;
		if (itemName == null) {
			if (other.itemName != null)
				return false;
		} else if (!itemName.equals(other.itemName))
			return false;
		if (itemPrice != other.itemPrice)
			return false;
		if (itemQuantity != other.itemQuantity)
			return false;
		if (mainCut == null) {
			if (other.mainCut != null)
				return false;
		} else if (!mainCut.equals(other.mainCut))
			return false;
		return true;
	}
	
}
