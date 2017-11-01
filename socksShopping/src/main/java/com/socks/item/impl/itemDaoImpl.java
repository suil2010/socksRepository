package com.socks.item.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.socks.item.dao.itemDao;
import com.socks.item.vo.Item;

public class itemDaoImpl implements itemDao{
	private static itemDaoImpl instance;

	private itemDaoImpl() {

	}

	public static itemDaoImpl getInstance() {
		if (instance == null)
			instance = new itemDaoImpl();
		return instance;
	}
	
	public String makeSqlId(String id) {
		return "config.mapper.itemMapper." + id;
	}
	
	public int insertItem(SqlSession session,Item item) {
		return session.insert(makeSqlId("insertItem"),item);
	}
	
	public int deleteItemById(SqlSession session, String itemId) {
		return session.delete(makeSqlId("deleteItemById"),itemId);
	}
	
	public int updateItemById(SqlSession session,Item item) {
		return session.update(makeSqlId("updateItemById"),item);
	}
	
	public Item selectItemById(SqlSession session,String itemId) {
		return session.selectOne(makeSqlId("selectItemById"),itemId);
	}
	public List<Item> selectAllItem(SqlSession session) {
		return session.selectList(makeSqlId("selectAllItem"));
	}
}
