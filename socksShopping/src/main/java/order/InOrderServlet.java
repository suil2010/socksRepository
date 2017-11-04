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
		OrderServiceImpl service = OrderServiceImpl.getInstance();
		itemServiceImpl serviceItem = itemServiceImpl.getInstance();
		//주문테이블을 값 저장하는 메소드
		MemberServiceImpl serviceMember = MemberServiceImpl.getInstance();
		OrderMemberServiceImpl serviceOrder = OrderMemberServiceImpl.getInstance();
		OrderDetailServiceImpl serviceDetail = OrderDetailServiceImpl.getInstance();
		
		Member member = (Member)session.getAttribute("loginMember");
		String memberId = member.getMemberId();
		//checkbox값이 여러개 이다.
		String[] orderId = request.getParameterValues("check");
		for(String i : orderId) {
			System.out.println(i);
		}
		//List<Order> list = new ArrayList<Order>();
		
		Order order = null;
		//삭제 후 findOrder를 회원의 정보를 조회
		member = service.findOrder(memberId);
		String orderNum = "orderNum-"+System.currentTimeMillis();
		//주문 등록
		serviceOrder.addOrderMember(new OrderMember(orderNum, memberId, new Date()));
		
		//주문 작업 check한 주문상품의 수를 재고(DB)에서 뺀다.
			for(int i = 0 ; i < orderId.length ; i++) {
				System.out.println(orderId[i]);
				//orderId로 orderId의 주문개수를 조회 (item의 전체제품수도 조회)
				order = service.findOrderById(orderId[i]);
				//list.add() : 등록
				//list.set() : 변경
				//list.add(i, order);
				//주문 상세 등록
				serviceDetail.addOrderDetail(new OrderDetail("orderDetailId"+System.currentTimeMillis(),orderNum,
							order.getItem().getItemId(),order.getOrderQuantity(),order.getItem().getItemPrice(),
							order.getItem().getItemName(),order.getItem().getMainCut()));
				//전체제품수와 주문개수를 뺀 뒤에 Modify메소드 사용
				int number = order.getItem().getItemQuantity() - order.getOrderQuantity();
				try {
					serviceItem.updateItemById(new Item(order.getItem().getItemId()
							,order.getItem().getItemPrice(),number,order.getItem().getItemName(),order.getItem().getMainCut(),order.getItem().getDetailCut()));
				} catch (ItemNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			member = serviceMember.findOrderMemberById(memberId);
			List<OrderMember> list = member.getOrderMemberList();
			session.setAttribute("checkListOrder", list);
		response.sendRedirect("/socksShopping/order/OrderView.jsp");
	}

}
