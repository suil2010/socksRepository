package com.socks.item.service;

import com.socks.item.vo.Item;

public interface itemService {
	
	void addItem(Item item);
	
	void removeItemById(String itemId);
	
	void updateItemById(Item newItem);
	
	Item selectItemById(String itemId);
}
