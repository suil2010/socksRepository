package com.socks.item.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.socks.item.vo.Item;

public interface itemDao {
	
	int insertItem(SqlSession session,Item item);
	
	int deleteItemById(SqlSession session, String memberName);
	
	int updateItemById(SqlSession session,Item item);
	
	Item selectItemById(SqlSession session,String itemId);
}
