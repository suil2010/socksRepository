package com.socks.member.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.socks.member.dao.MemberDao;
import com.socks.member.vo.Member;

import org.apache.ibatis.session.SqlSession;

import com.socks.member.vo.Member;

public class MemberDaoImpl implements MemberDao{
		
	   private static MemberDaoImpl instance;

		private MemberDaoImpl() {
	
		}
	
		public static MemberDaoImpl getInstance() {
			if (instance == null)
				instance = new MemberDaoImpl();
			return instance;
		}
		
		public String makeSqlId(String id) {
			return "config.mapper.memberMapper." + id;
		}
	
	   public int insertMember(SqlSession session, Member member) {
		   return session.insert(makeSqlId("insertMember"),member);
	   }
	   
	   /**
	    * 한 회원 정보를 update 하는 메소드. id가 일치하는 행의 다른 컬럼의 값들을 update한다.
	    * update가 적용된 row 수를 리턴한다.
	    * @param session
	    * @param member
	    * @return
	    * 
	    */
	   public int updateMemberById(SqlSession session, Member member) {
		   return session.update(makeSqlId("updateMemeberById"),member);
	   }
	   
	   /**
	    * 회원 id로 회원테이블의 row를 삭제 하는 메소드
	    * 삭제된 row 수를 리턴한다.
	    * @param session
	    * @param memberId
	    * @return
	    * 
	    */
	   public int deleteMemberById(SqlSession session, String memberId) {
		   return session.delete(makeSqlId("deleteMemberById"),memberId);
	   }
	   
	   /**
	    * 매개변수로 받은 ID와 일치하는 회원정보를 회원 테이블에서 조회하는 메소드.
	    * @param session
	    * @param memberId
	    * @return
	    * 
	    */
	   
	   //전체조회
	   public List<Member> selectAll(SqlSession session){
		   return session.selectList(makeSqlId("selectAll"));
	   }
	   
	   //전체조인조회
	   public List<Member> selectAllByJoin(SqlSession session){
		   return session.selectList(makeSqlId("selectAllByJoin"));
	   }

	@Override
	public Member selectMemberById(SqlSession session, String memberId) {
		
		return session.selectOne(makeSqlId("selectMemberById"), memberId);
	}

	@Override
	public List<Member> selectAllMember(SqlSession session) {
		return session.selectList(makeSqlId("selectAllMember"));
	}
	   
}
