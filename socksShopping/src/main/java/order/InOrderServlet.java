package order;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.ServiceMode;

import com.socks.item.exception.ItemNotFoundException;
import com.socks.item.service.impl.itemServiceImpl;
import com.socks.item.vo.Item;
import com.socks.member.service.impl.MemberServiceImpl;
import com.socks.member.vo.Member;
import com.socks.order.service.impl.OrderServiceImpl;
import com.socks.order.vo.Order;
import com.socks.orderdetail.OrderDetailServiceImpl;
import com.socks.orderdetail.vo.OrderDetail;
import com.socks.ordermember.OrderMemberServiceImpl;
import com.socks.ordermember.vo.OrderMember;

/**
 * Servlet implementation class InOrderServlet
 * 
 */
@WebServlet("/InOrder")
public class InOrderServlet extends HttpServlet {
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
		member = serviceMember.findOrderMemberById(memberId);
		
		String[] orderId = request.getParameterValues("check");
		System.out.println(orderId);
		//삭제 후 findOrder를 회원의 정보를 조회 (장바구니)
		member = service.findOrder(memberId);
		
		// 주문처리된 상품의 주문 상품 수 와 전체 상품 수를 뺀다.
		try {
			serviceItem.managerOrderList(orderId);
		} catch (ItemNotFoundException e) {
			throw new ServletException(e);
		}
		
		//주문을 처리하는 메소드(주문테이블, 주문 상세테이블 column추가, 장바구니테이블 column삭제)
		serviceOrder.orderProcessing(orderId, memberId); 
		
		member = serviceMember.findOrderMemberById(memberId);
		List<OrderMember> list = member.getOrderMemberList();
		session.setAttribute("checkListOrder", list);
		response.sendRedirect("/socksShopping/order/OrderView.jsp");
	}
}
