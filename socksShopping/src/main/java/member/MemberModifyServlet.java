package member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.socks.member.exception.MemberNotFoundException;
import com.socks.member.service.MemberService;
import com.socks.member.service.impl.MemberServiceImpl;
import com.socks.member.vo.Member;

/**
 * Servlet implementation class MemberModifyServlet
 */
@WebServlet("/modifyMember")
public class MemberModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		Member member = (Member)request.getAttribute("member");
		MemberService service = MemberServiceImpl.getInstance();
		session.setAttribute("loginMember", member);
		try {
			service.updateMember(member);
		} catch (MemberNotFoundException e) {
			request.setAttribute("errorMessage", e.getMessage());
			request.getRequestDispatcher("/member/MemberShowView.jsp").forward(request, response);
			e.printStackTrace();
		}
		request.getRequestDispatcher("/member/MemberModifySuccess.jsp").forward(request, response);// 회원가입 성공페이지로 간다.
	}
}
