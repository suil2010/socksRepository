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
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		MemberService service = MemberServiceImpl.getInstance();
		Member member = service.findMemberById(id);
		
		if(member != null) {
			if(password.equals(member.getPassword())) {
				HttpSession session = request.getSession();
				session.setAttribute("loginMember", member);
				request.getRequestDispatcher("/main/mainPage.jsp").forward(request, response);
			}else {
			request.setAttribute("errorMessage", "비밀번호가 일치하지 않습니다");
			request.getRequestDispatcher("/member/loginView.jsp").forward(request, response);
			}
			
		}else if(member == null) {
			request.setAttribute("errorMessage", "아이디가 일치하지 않습니다");
			request.getRequestDispatcher("/member/loginView.jsp").forward(request, response);
			
		}
	}
}


