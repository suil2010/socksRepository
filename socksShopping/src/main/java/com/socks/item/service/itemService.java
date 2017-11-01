package com.socks.item.service;

import java.util.List;

import com.socks.item.vo.Item;

public interface itemService {
	
	void addItem(Item item);
	
	void removeItemById(String itemId);
	
	void updateItemById(Item newItem);
	
	Item selectItemById(String itemId);
	
	List<Item> selectAllItem();
}
