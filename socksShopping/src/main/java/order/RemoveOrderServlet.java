package order;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.socks.item.service.impl.itemServiceImpl;
import com.socks.member.service.impl.MemberServiceImpl;
import com.socks.member.vo.Member;
import com.socks.order.service.impl.OrderServiceImpl;
import com.socks.ordermember.OrderMemberServiceImpl;
import com.socks.ordermember.vo.OrderMember;

/**
 * Servlet implementation class RemoveOrderServlet
 */
@WebServlet("/removeOrder")
public class RemoveOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//주문하기를 누르면 동작
				HttpSession session = request.getSession(); 
				OrderServiceImpl service = OrderServiceImpl.getInstance(); //OrderServiceImpl
				itemServiceImpl serviceItem = itemServiceImpl.getInstance();
				OrderMemberServiceImpl serviceOrder = OrderMemberServiceImpl.getInstance();
				MemberServiceImpl serviceMember = MemberServiceImpl.getInstance();
				
				Member member = (Member)session.getAttribute("loginMember");
				String memberId = member.getMemberId();
				
				String[] orderNum = request.getParameterValues("checkOrder");
				
				//orderNum을 주면 삭제를 실행하는 메소드
				
				
				//주문 수에서 재고를 다사 더하는 메소드
				
				//삭제 후 findOrder를 회원의 정보를 조회
				
	}

}
