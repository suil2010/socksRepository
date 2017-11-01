package com.socks.item.service.impl;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.socks.item.impl.itemDaoImpl;
import com.socks.item.service.itemService;
import com.socks.item.vo.Item;
import com.socks.util.SqlSessionFactoryManager;

public class itemServiceImpl implements itemService{
	
	private static itemServiceImpl instance;
	
	private SqlSessionFactory factory;
	
	private itemDaoImpl dao;
	
	private itemServiceImpl() throws IOException {
		factory = SqlSessionFactoryManager.getInstance().getSqlSessionFactory();
		dao = itemDaoImpl.getInstance();
	}

	public static itemServiceImpl getInstance() throws IOException {
		if (instance == null)
			instance = new itemServiceImpl();
		return instance;
	}

	public void addItem(Item item) {
		
	}
	
	public void removeItemById(String itemId) {
		
	}
	
	public void updateItemById(Item newItem) {
		
	}
	
	public Item selectItemById(String itemId) {
		return null;
	}
	
	public List<Item> selectAllItem() {
		
		SqlSession session = factory.openSession();
		try {
			return dao.selectAllItem(session);
		}finally {
			session.close();
		}
	}
}
