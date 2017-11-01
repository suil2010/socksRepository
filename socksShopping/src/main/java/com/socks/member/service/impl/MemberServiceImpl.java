package com.socks.member.service.impl;

import java.util.List;

import com.socks.member.exception.DuplicatedIdException;
import com.socks.member.exception.MemberNotFoundException;
import com.socks.member.service.MemberService;
import com.socks.member.vo.Member;

public class MemberServiceImpl implements MemberService {
	private static MemberServiceImpl instance;

	private MemberServiceImpl() {

	}

	public static MemberServiceImpl getInstance() {
		if (instance == null)
			instance = new MemberServiceImpl();
		return instance;
	}
	@Override
	public void addMember(Member member) throws DuplicatedIdException {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeMemberById(String id) throws MemberNotFoundException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateMember(Member newData) throws MemberNotFoundException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Member> getMemberList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member findMemberById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
