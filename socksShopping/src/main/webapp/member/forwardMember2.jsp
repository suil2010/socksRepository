<%@ page contentType="text/html;charset=utf-8"%>
<jsp:useBean scope="request" id="member" class="com.socks.member.vo.Member" />
<jsp:setProperty property="*" name="member"/>
<jsp:forward page="/modifyMember"/>
