package order;

import java.io.IOException;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.socks.item.vo.Item;
import com.socks.member.dao.impl.MemberDaoImpl;
import com.socks.member.vo.Member;
import com.socks.order.service.OrderService;
import com.socks.order.service.impl.OrderServiceImpl;
import com.socks.order.vo.Order;

/**
 * Servlet implementation class InShopingBasketServlet
 */
@WebServlet("/InShoppingBasket")
public class InShopingBasketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
request.setCharacterEncoding("utf-8");
		
		
		HttpSession session = request.getSession();
		Order order = new Order();
		OrderService service = OrderServiceImpl.getInstance();
		MemberDaoImpl dao = MemberDaoImpl.getInstance(); 
		/*
		 * 수량 선택 -> 장바구니 클릭 -> 상품담김 -> itemId, itemStock 값을 받음
		 * 
		 * 
		 * 
		 */
		Member member = (Member)session.getAttribute("loginMember");
		String memberId = member.getMemberId();
		Item item = (Item)request.getAttribute("item");
		String itemId = item.getItemId();
		int orderQuantity = Integer.parseInt(request.getParameter("stuck"));
		Date orderDate = new Date(System.currentTimeMillis());
		String orderId = String.valueOf("order"+System.currentTimeMillis());
		
		service.addOrder(new Order(orderId, orderQuantity,memberId, itemId, orderDate));
		
		//회원 아이디를 통해 회원이랑 연결,
		
		request.getRequestDispatcher("/order/ShopingBasketView.jsp").forward(request, response);
		
	}

}
