package order;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.socks.member.vo.Member;
import com.socks.order.service.OrderService;
import com.socks.order.service.impl.OrderServiceImpl;
import com.socks.order.vo.Order;

/**
 * Servlet implementation class InOrderServlet
 */
@WebServlet("/InOrder")
public class InOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//주문하기를 누르면 동작
		HttpSession session = request.getSession();
		OrderServiceImpl service = OrderServiceImpl.getInstance();
		
		Member member = (Member)session.getAttribute("loginMember");
		String memberId = member.getMemberId();
		//checkbox값이 여러개 이다.
		String[] orderId = request.getParameterValues("check");
		
		Order order = null;
		//삭제 후 findOrder를 회원의 정보를 조회
		member = service.findOrder(memberId);
		
		List<Order> listOrder = null;
		//null.getOrderList(); -> NullpointExcoption 발생
		if(member != null) {
			//상품이 있으면 requestScope에 저장
			listOrder = member.getOrderList();
			session.setAttribute("listOrder", listOrder);
		} else {
			//상품이 없으면 null을 리턴
			session.setAttribute("listOrder", null);
		}
		
		//주문 작업 check한 주문상품의 수를 재고(DB)에서 뺀다.
		for(int i = 0 ; i < orderId.length ; i++) {
			System.out.println(orderId[i]);
			//orderId로 orderId의 주문개수를 조회 (item의 전체제품수도 조회)
			order = service.findOrderById(orderId[i]);
			//전체제품수와 주문개수를 뺀 뒤에 Modify메소드 사용
			int number = order.getItem().getItemQuantity() - order.getOrderQuantity();
			service.ModifyOrder(new Order(order.getOrderId(),number,
					order.getMemberId(),order.getItemId(),order.getOrderDate()));
		}
		
		
		//request.getRequestDispatcher("/order/OrderView.jsp").forward(request, response);
		response.sendRedirect("/socksShopping/order/OrderView.jsp");
	}

}
