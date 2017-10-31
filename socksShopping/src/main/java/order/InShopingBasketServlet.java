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

import com.socks.order.service.OrderService;
import com.socks.order.service.impl.OrderServiceImpl;
import com.socks.order.vo.Order;

/**
 * Servlet implementation class InShopingBasketServlet
 */
@WebServlet("/inShoppingBasket")
public class InShopingBasketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
request.setCharacterEncoding("utf-8");
		
		
		HttpSession session = request.getSession();
		Order order = new Order();
		OrderService service = OrderServiceImpl.getInstance();
		/*
		 * 수량 선택 -> 장바구니 클릭 -> 상품담김 -> itemId, itemStock 값을 받음
		 * 
		 * 
		 * 
		 */
		String itemId = request.getParameter("아이템 이름");
		int orderQuantity = Integer.parseInt(request.getParameter("itemNumber아이템수량"));
		Date orderDate = new Date(System.currentTimeMillis());
		String orderId = UUID.randomUUID().toString();;	//일단 가상으로
		String memberId = "socks";//임시 파일
		
		
		service.insertOrder(new Order(orderId, orderQuantity, memberId, itemId, orderDate));
		
		
		//회원 아이디를 통해 회원이랑 연결, 
		
		request.getRequestDispatcher("/order/ShopingBasketView.jsp").forward(request, response);
		
	}

}
