package member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.socks.member.service.MemberService;
import com.socks.member.service.impl.MemberServiceImpl;
import com.socks.member.vo.Member;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginMember")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		MemberService service = MemberServiceImpl.getInstance();
		String id = request.getParameter("memberId");
		String password = request.getParameter("password");
		Member member = service.findMemberById(id);
		System.out.println(member);
		if(id.equals("socks")){
			if(password.equals("appeal")) {
				request.getSession().setAttribute("loginMember", true);
				response.sendRedirect("/admin"); //관리자페이지
			}else {
				request.setAttribute("errorMessage", "비밀번호가 일치하지 않습니다");
				request.getRequestDispatcher("/member/loginView.jsp").forward(request, response);
			}
		}else if(member != null) {
			if(password.equals(member.getPassword())) {
				//세션 가져와서
				HttpSession session = request.getSession();
				//세션에 loginMember 속성을 넣는다.
				session.setAttribute("loginMember", member);
				request.getRequestDispatcher("/member/loginSuccessView.jsp").forward(request, response);
			}else {
			request.setAttribute("errorMessage", "비밀번호가 일치하지 않습니다");
			request.getRequestDispatcher("/member/loginView.jsp").forward(request, response);
			}
			
		}else {
			request.setAttribute("errorMessage", "아이디를 확인하세요");
			request.getRequestDispatcher("/member/loginView.jsp").forward(request, response);
			
		}
	}
}


