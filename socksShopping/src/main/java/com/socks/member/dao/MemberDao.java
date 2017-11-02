package com.socks.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.socks.member.vo.Member;

public interface MemberDao {

	/*
	 * 한 회원 정보를 insert 처리하는 메소드. 등록된 row 수를 리턴한다.
	 * 
	 * @param session
	 *            Transaction 처리는 Business Service 에서 하므로 TX 처리를 하는
	 *            객체(Connection/SqlSession)를 매개변수로 받는다.
	 * @param member
	 *            등록할 회원 정보
	 * @return 처리 결과 수
	 * 
	 */
	int insertMember(SqlSession session, Member member);

	/**
	 * 한 회원 정보를 update 하는 메소드. id가 일치하는 행의 다른 컬럼의 값들을 update한다. update가 적용된 row 수를
	 * 리턴한다.
	 * 
	 * @param session
	 * @param member
	 * @return
	 * 
	 */
	int updateMemberById(SqlSession session, Member member);

	/**
	 * 회원 id로 회원테이블의 row를 삭제 하는 메소드 삭제된 row 수를 리턴한다.
	 * 
	 * @param session
	 * @param memberId
	 * @return
	 * 
	 */
	int deleteMemberById(SqlSession session, String memberId);

	/**
	 * 매개변수로 받은 ID와 일치하는 회원정보를 회원 테이블에서 조회하는 메소드.
	 * 
	 * @param session
	 * @param memberId
	 * @return
	 * 
	 */

	// 전체조회
	List<Member> selectAll(SqlSession session);

	// 전체조인조회
	List<Member> selectAllByJoin(SqlSession session);

	Member selectMemberById(SqlSession session, String memberId);

	List<Member> selectAllMember(SqlSession session);

}
