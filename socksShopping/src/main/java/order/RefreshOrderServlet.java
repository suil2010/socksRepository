package order;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.socks.member.service.impl.MemberServiceImpl;
import com.socks.member.vo.Member;
import com.socks.ordermember.vo.OrderMember;

/**
 * Servlet implementation class RefreshOrderServlet
 */
@WebServlet("/RefreshOrder")
public class RefreshOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(); 
		MemberServiceImpl serviceMember = MemberServiceImpl.getInstance();
		
		Member member = (Member)session.getAttribute("loginMember");
		String memberId = member.getMemberId();
		member = serviceMember.findOrderMemberById(memberId);
		System.out.println("member : "+member);
		
		member = serviceMember.findOrderMemberById(memberId);
		System.out.println("member : "+member);
		
		List<OrderMember> listOrderMember;
		//null.getOrderList(); -> NullpointExcoption 발생
		if(member != null) {
			//상품이 있으면 requestScope에 저장
			listOrderMember = member.getOrderMemberList();
			session.setAttribute("checkListOrder", listOrderMember);
		} else {
			//상품이 없으면 null을 리턴
			session.setAttribute("checkListOrder", null);
		}
		
		response.sendRedirect("/socksShopping/order/OrderView.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
