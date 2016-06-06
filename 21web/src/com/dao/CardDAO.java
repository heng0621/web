package com.dao;

import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.entity.Card;
import com.uitl.DBHelper;

public class CardDAO {
	
	
	public List<Card> findAllCard() {

		String sql = "select * from card ";
		return DBHelper.query(sql, new BeanListHandler<Card>(Card.class));

	}

	public void save(Card card) {

		String sql = "insert into card(code, name, tel) values(?,?,?)";
		DBHelper.update(sql, card.getCode(),card.getName(),card.getTel());
	}

	public void deleteCard(Integer id) {
		String sql = "delete from card where id = ?";
		DBHelper.update(sql, id);
	}

	public Card findCardById(Integer id) {
		String sql = "select * from card where id = ?";
		return DBHelper.query(sql, new BeanHandler<Card>(Card.class), id);

	}

	public void update(Card card) {

		String sql = "update Card set code=?,name=?,tel=? where id =?";
		DBHelper.update(sql, card.getCode(),card.getName(),card.getTel());
	}


}
