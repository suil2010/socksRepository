package com.socks.member.service.impl;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.socks.member.dao.MemberDao;
import com.socks.member.dao.impl.MemberDaoImpl;
import com.socks.member.exception.DuplicatedIdException;
import com.socks.member.exception.MemberNotFoundException;
import com.socks.member.service.MemberService;
import com.socks.member.vo.Member;
import com.socks.util.SqlSessionFactoryManager;

public class MemberServiceImpl implements MemberService{
   private static SqlSessionFactory sessionFactory;
   private static MemberDao dao;
   
   private static MemberServiceImpl instance;
   private MemberServiceImpl() throws IOException {
      sessionFactory = SqlSessionFactoryManager.getInstance().getSqlSessionFactory();
      dao = MemberDaoImpl.getInstance();
   }
   public static MemberServiceImpl getInstance() throws IOException {
      if (instance == null)
         instance = new MemberServiceImpl();
      return instance;
   }
   @Override
   public void addMember(Member member) throws DuplicatedIdException {
      SqlSession session = null;
      try {
         session = sessionFactory.openSession();
         if (dao.selectMemberById(session, member.getMemberId()) != null) {
            throw new DuplicatedIdException("중복된 ID 입니다", member.getMemberId());
         }
         dao.insertMember(session, member);

         session.commit();
      } finally {

      }      
   }

   @Override
   public void removeMemberById(String id) throws MemberNotFoundException {
      SqlSession session = null;
      try {
         session = sessionFactory.openSession();
         if (dao.selectMemberById(session, id) == null) {
            throw new MemberNotFoundException(String.format("ID %s 는 없는 회원입니다", id));
         }
         dao.deleteMemberById(session, id);
         session.commit();
      } finally {
         session.close();
      }      
   }

   @Override
   public void updateMember(Member newData) throws MemberNotFoundException {
      SqlSession session = null;
      try {
         session = sessionFactory.openSession();
         if (dao.selectMemberById(session, newData.getMemberId()) == null) {
            throw new MemberNotFoundException(String.format("ID %s 인 회원이 없습니다.", newData.getMemberId()));
         }
         dao.updateMemberById(session, newData);
         session.commit();
      } finally {
         session.close();
      }      
   }

   @Override
   public List<Member> getMemberList() {
      SqlSession session = null;
      try {
         session = sessionFactory.openSession();
         return dao.selectAllMember(session);
      } finally {
         session.close();
      }
   }

   @Override
   public Member findMemberById(String id) {
      SqlSession session = null;
      try {
         session = sessionFactory.openSession();
         return dao.selectMemberById(session, id);
      } finally {
         session.close();
      }
   }
   
   
}
