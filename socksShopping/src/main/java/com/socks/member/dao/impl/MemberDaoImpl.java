package com.socks.member.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.socks.member.dao.MemberDao;
import com.socks.member.vo.Member;

public class MemberDaoImpl implements MemberDao{

	@Override
	public Member selectMemberById(SqlSession session, String memberId) {
		return session.selectOne(makeId("selectMemberById"), memberId);
	}

	@Override
	public List<Member> selectAllMember(SqlSession session) {
		return session.selectList(makeId("selectAllMember"));
	}

	@Override
	public int insertMember(SqlSession session, Member member) {
		return session.insert(makeId("insertMember"), member);
	}

	@Override
	public int updateMemberById(SqlSession session, Member member) {
		return session.update(makeId("updateMemberById"), member);
	}

	@Override
	public int deleteMemberById(SqlSession session, String memberId) {
		return session.delete(makeId("deleteMemberById"), memberId);
	}
	
	private String makeId(String id) {
		return "member."+id;
	}

}
