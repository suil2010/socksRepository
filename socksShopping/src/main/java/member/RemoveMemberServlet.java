package member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.socks.member.exception.MemberNotFoundException;
import com.socks.member.service.MemberService;
import com.socks.member.service.impl.MemberServiceImpl;
import com.socks.member.vo.Member;

/**
 * Servlet implementation class RemoveMemberServlet
 */
@WebServlet("/removeMember")
public class RemoveMemberServlet extends HttpServlet {
private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Member member = (Member)request.getAttribute("member");
		MemberService service = MemberServiceImpl.getInstance();
		try {
			service.removeMemberById(member.getMemberId());
		} catch (MemberNotFoundException e) {
			request.setAttribute("errorMessage", e.getMessage());
			request.getRequestDispatcher("/member/deleteMemberView.jsp").forward(request, response);
			e.printStackTrace();
		}
		request.getRequestDispatcher("/member/memberDeleteSuccess.jsp").forward(request, response);// 회원탈퇴 성공페이지로 간다.
	}
	

}
