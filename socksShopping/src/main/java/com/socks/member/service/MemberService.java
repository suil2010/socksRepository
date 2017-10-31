package com.socks.member.service;

import java.util.List;

import com.socks.member.exception.DuplicatedIdException;
import com.socks.member.exception.MemberNotFoundException;
import com.socks.member.vo.Member;


public interface MemberService {
	/**
	 *  한명의 회원 추가하는 메소드
	 *  기본흐름
	 *   1. 매개변수로 추가할 회원의 정보를 받는다. 
	 *   2. 회원정보를 회원정보들 저장소에 추가한다.
	 *   
	 *  예외흐름
	 *  2A. 기존 저장된 회원과 같은 ID의 회원은 추가하지 않는다. (ID중복검사) 
	 *  
	 * @param member : 추가할 한명의 회원정보. 회원의 type이 Member이므로 매개변수로 Member 선언.
	 */
	void addMember(Member member) throws DuplicatedIdException;

	/**
	 * 회원 정보를 삭제하는 메소드
	 * 기본흐름
	 *  1. 매개변수로 삭제할 회원의 ID를 받는다.
	 *  2. 회원정보 저장소에서 id의 회원정보를 삭제한다.
	 *  
	 * 예외흐름
	 *  2A - 삭제하려는 ID의 회원정보가 없는 경우 caller에게 알려주고 삭제 처리를 하지 않는다.
	 *   
	 * @param 삭제할 id.
	 */
	void removeMemberById(String id) throws MemberNotFoundException;

	/**
	 * 회원 정보를 수정하는 메소드
	 *  설명 : 수정정보에서 받은 ID의 회원의 나머지 정보(password, 이름, 이메일, 포인트)를 수정(변경) 처리한다. (기존회원의 일부 정보를 변경.)
	 *  기본흐름
	 *   1. 매개변수로 수정할 회원의 정보를 받는다.
	 *   2. 회원정보 저장소에서 받은 id의 회원의 나머지 정보를 수정한다.
	 *   
	 *  예외흐름
	 *   2A - 수정하려는 ID의 회원정보가 없는 경우 caller에게 알려주고 수정 처리를 하지 않는다.
	 *   
	 * @param newData 변경할 회원 정보.  (호출한 쪽(caller) 변경할 instance변수의 값은 변경할 값으로 나머지는 기존값을 넣어 Member객체를 만들어 전달.) 
	 */
	void updateMember(Member newData) throws MemberNotFoundException;

	/**
	 * 저장된 모든 회원의 정보를 알려주는 메소드.
	 * 기본흐름
	 *  1. 저장소에 저장된 모든 회원의 정보를 caller에게 리턴한다.
	 *  
	 * @return 모든 회원의 정보
	 */
	List<Member> getMemberList();

	/**
	 * 저장된 회원중 id로 회원정보 찾아 주는 메소드.
	 * 기본흐름
	 * 1. 조회할 회원의 ID를 매개변수로 받는다.
	 * 2. 회원정보 저장소에서 id의 회원 정보를 찾아서 caller에게 리턴한다. 없으면 없다고 리턴한다.
	 * 
	 * @param id 찾을 회원의 ID
	 * @return 조회한 회원객체를 리턴. 단 찾는 ID의 회원이 없으면 null를 리턴한다.
	 */
	Member findMemberById(String id);

	
}
