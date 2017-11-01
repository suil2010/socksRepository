package com.socks.item.service;

import java.util.List;

import com.socks.item.exception.DuplicatedItemIdException;
import com.socks.item.exception.ItemNotFoundException;
import com.socks.item.vo.Item;

public interface itemService {
	
	void addItem(Item item) throws DuplicatedItemIdException;
	
	void removeItemById(String itemId) throws ItemNotFoundException;
	
	void updateItemById(Item newItem) throws ItemNotFoundException;
	
	Item findItemById(String itemId);
	
	Item findItemByName(String itemName);
	
	List<Item> findAllItem();
}
