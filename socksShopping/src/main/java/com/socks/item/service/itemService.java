package com.socks.item.service;

import java.util.List;

import com.socks.item.exception.DuplicatedItemIdException;
import com.socks.item.exception.ItemNotFoundException;
import com.socks.item.vo.Item;

public interface itemService {
	
	void addItem(Item item) throws DuplicatedItemIdException;
	
	void removeItemById(String itemId) throws ItemNotFoundException;
	
	void updateItemById(Item newItem) throws ItemNotFoundException;
	
	//전체 상품수에서 주문한 상품 수를 빼는 메소드
	void managerOrderList(String[] orderId) throws ItemNotFoundException;
	//전체 상품수에서 주문한 상품 수를 더하는 메소드
	void cancelManagerOrderList(String[] orderDetailId) throws RuntimeException;
	//id로 item조회
	Item findItemById(String itemId);
	//item name으로 상품 조회
	List<Item> findItemByName(String itemName);
	//모든 상품조회
	List<Item> findAllItem();

}
