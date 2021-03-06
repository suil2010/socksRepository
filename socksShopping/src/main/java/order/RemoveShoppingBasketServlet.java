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
import com.socks.order.service.impl.OrderServiceImpl;
import com.socks.order.vo.Order;

/**
 * Servlet implementation class RemoveShoppingBasketServlet
 */
@WebServlet("/removeServlet")
public class RemoveShoppingBasketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		OrderServiceImpl service = OrderServiceImpl.getInstance();
		
		Member member = (Member)session.getAttribute("loginMember");
		String memberId = member.getMemberId();
		//checkbox값이 여러개 이다.
		String[] orderId = request.getParameterValues("check"); //주문번호를 받아옴
		
		//삭제 작업
		for(int i = 0 ; i < orderId.length ; i++) {
			System.out.println(orderId[i]);
			service.removeOrder(orderId[i]);
		}
		
		//삭제 후 findOrder를 다시 회원의 정보를 조회
		member = service.findOrder(memberId);
		
		List<Order> listOrder;
		//null.getOrderList(); -> NullpointExcoption 발생
		if(member != null) {
			//상품이 있으면 requestScope에 저장
			listOrder = member.getOrderList();
			session.setAttribute("listOrder", listOrder);
		} else {
			//상품이 없으면 null을 리턴
			session.setAttribute("listOrder", null);
		}
		//request.getRequestDispatcher("/order/ShopingBasketView.jsp").forward(request, response);
		response.sendRedirect("/socksShopping/order/ShopingBasketView.jsp");
	}
}