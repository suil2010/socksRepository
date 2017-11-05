package order;

import java.io.IOException;
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
 * Servlet implementation class RefreshShoppingBasketServlet
 */
@WebServlet("/RefreshShoppingBasket")
public class RefreshShoppingBasketServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		OrderServiceImpl service = OrderServiceImpl.getInstance();
		
		Member member = (Member)session.getAttribute("loginMember");
		String memberId = member.getMemberId();
		
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
		response.sendRedirect("/socksShopping/order/ShopingBasketView.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
