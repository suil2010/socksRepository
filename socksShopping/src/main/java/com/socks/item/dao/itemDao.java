package com.socks.item.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.socks.item.vo.Item;

public interface itemDao {
	
	int insertItem(SqlSession session,Item item);
	
	int deleteItemById(SqlSession session, String memberName);
	
	int updateItemById(SqlSession session,Item item);
	//id로 상품 조회
	Item selectItemById(SqlSession session,String itemId);
	//itemName으로 상품 조회
	List<Item> selectItemByName(SqlSession session,String itemName);
	//모든 상품 조회
	List<Item> selectAllItem(SqlSession session);

}
