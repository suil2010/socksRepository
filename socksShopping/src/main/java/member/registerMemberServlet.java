package member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.socks.member.exception.DuplicatedIdException;
import com.socks.member.service.MemberService;
import com.socks.member.service.impl.MemberServiceImpl;
import com.socks.member.vo.Member;

/**
 * Servlet implementation class registerMemberServlet
 */
@WebServlet("/registerMember")
public class registerMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Member member = (Member)request.getAttribute("member");
		MemberService service = MemberServiceImpl.getInstance();
		try {
			service.addMember(member);
			// 3. 처리결과 응답
		} catch (DuplicatedIdException e) {
			request.setAttribute("errorMessage", e.getMessage());
			request.getRequestDispatcher("/member/registerMemberView.jsp").forward(request, response);
			e.printStackTrace();
		}
		request.getRequestDispatcher("/member/registerMemberSuccess.jsp").forward(request, response);// 회원가입 성공페이지로 간다.
	}

}
