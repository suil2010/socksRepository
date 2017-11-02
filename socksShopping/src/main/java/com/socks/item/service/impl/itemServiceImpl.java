package com.socks.item.service.impl;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.socks.item.dao.impl.itemDaoImpl;
import com.socks.item.exception.DuplicatedItemIdException;
import com.socks.item.exception.ItemNotFoundException;
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

	public void addItem(Item item) throws DuplicatedItemIdException {
		if(findItemById(item.getItemId())!=null){//이미 있는 ID이면. 추가를 하지 않는다.
			throw new DuplicatedItemIdException("상품ID가 중복됩니다.",item.getItemId());
		} 
		else {
			try {
				session = factory.openSession();
				dao.insertItem(session, item);
				session.commit();
			} finally {
				session.close();
			}
		}
	}
	
	public void removeItemById(String itemId) throws ItemNotFoundException{
		if(findItemById(itemId)==null){//삭제할 ID의 회원이 없으면 삭제 작업을 처리하지 않는다.
			//return;
			throw new ItemNotFoundException("삭제할 상품이 없습니다.", itemId);
		} else {
			try {
				session = factory.openSession();
				dao.deleteItemById(session, itemId);
				session.commit();
			} finally {
				session.close();
			}
		}
	}
	
	public void updateItemById(Item newItem) throws ItemNotFoundException {
		if(findItemById(newItem.getItemId()) == null) {
			throw new ItemNotFoundException("수정할 상품이 없습니다.",newItem.getItemId());
		}
		else {
			try {
				session = factory.openSession();
				dao.updateItemById(session, newItem);
				session.commit();
			} finally {
				session.close();
			}
		}
	}
	
	public Item findItemById(String itemId) {
		try {
			session = factory.openSession();
			item = dao.selectItemById(session, itemId);
			session.commit();
			return item;
		} finally {
			session.close();
		}
	}

	
	public List<Item> findItemByName(String itemName) {
		try {
			session = factory.openSession();
			List<Item> list = dao.selectItemByName(session, itemName);
			session.commit();
			return list;
		} finally {
			session.close();
		}
	}
	
	public List<Item> findAllItem() {
		
		try {
			session = factory.openSession();
			List<Item> list = dao.selectAllItem(session);
			session.commit();
			return list;	
		}finally {
			session.close();
		}
	}
	
>>>>>>> branch 'master' of https://github.com/suil2010/socksRepository.git
}
