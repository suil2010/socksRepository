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
	
	private SqlSession session =null;
	
	private Item item;
	
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
		try {
			session = factory.openSession();
			dao.insertItem(session, item);
			session.commit();
		} finally {
			session.close();
		}
	}
	
	public void removeItemById(String itemId) {
		try {
			session = factory.openSession();
			dao.deleteItemById(session, itemId);
			session.commit();
		} finally {
			session.close();
		}
	}
	
	public void updateItemById(Item newItem) {
		try {
			session = factory.openSession();
			dao.updateItemById(session, newItem);
			session.commit();
		} finally {
			session.close();
		}
	}
	
	public Item selectItemById(String itemId) {
		try {
			session = factory.openSession();
			item = dao.selectItemById(session, itemId);
			session.commit();
			return item;
		} finally {
			session.close();
		}
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
