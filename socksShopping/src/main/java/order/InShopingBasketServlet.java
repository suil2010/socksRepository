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

import com.socks.item.vo.Item;
import com.socks.member.vo.Member;
import com.socks.order.service.OrderService;
import com.socks.order.service.impl.OrderServiceImpl;
import com.socks.order.vo.Order;

/**
 * Servlet implementation class InShopingBasketServlet
 * HTTP 500 : null값을 Integer로 변환해서 생김
 */
@WebServlet("/InShoppingBasket")
public class InShopingBasketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		//장바구니 담기를 누르면 동작
		HttpSession session = request.getSession();
		OrderService service = OrderServiceImpl.getInstance();
		
		//수량 선택 -> 장바구니 클릭 -> 상품담김 -> itemId, itemStock 값을 받음
		
		Member member = (Member)session.getAttribute("loginMember");
		String memberId = member.getMemberId();
		String itemId = request.getParameter("id");
		//Integer.parseInt(request.getParameter("input") == null 
		//? 0 : request.getParameter("input"));
		int orderQuantity = Integer.parseInt(request.getParameter("stuck") == null ? "0" : request.getParameter("stuck"));
		Date orderDate = new Date();
		String orderId = String.valueOf("order"+System.currentTimeMillis());
		
		//회원 아이디를 통해 회원이랑 연결,
		Order order = new Order(orderId, orderQuantity,memberId, itemId, orderDate);
		service.addOrder(order);
		
		//회원 이름으로 장바구니 조회
		member = service.findOrder(memberId);
		List<Order> listOrder = member.getOrderList();
		
		//리다이렉트방식을 사용하기 위해서
		session.setAttribute("listOrder", listOrder);
		//request.getRequestDispatcher("/order/ShopingBasketView.jsp").forward(request, response);
		
		/*DB에서 내용을 바꾸거나 server에서 내용을 바꿀때 새로고침을 되면 값이 증가하게 된다.
		리다이렉트 방식 사용*/
		response.sendRedirect("/socksShopping/order/ShopingBasketView.jsp");
	}

}