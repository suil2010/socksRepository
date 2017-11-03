package order;

import java.io.IOException;
import java.util.ArrayList;
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
import com.socks.member.vo.Member;
import com.socks.order.service.impl.OrderServiceImpl;
import com.socks.order.vo.Order;

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
		
		Member member = (Member)session.getAttribute("loginMember");
		String memberId = member.getMemberId();
		//checkbox값이 여러개 이다.
		String[] orderId = request.getParameterValues("check");
		for(String i : orderId) {
			System.out.println(i);
		}
		List<Order> list = new ArrayList<Order>(100);
		
		Order order = null;
		//삭제 후 findOrder를 회원의 정보를 조회
		member = service.findOrder(memberId);
		
		//주문 작업 check한 주문상품의 수를 재고(DB)에서 뺀다.
			for(int i = 0 ; i < orderId.length ; i++) {
				System.out.println(orderId[i]);
				//orderId로 orderId의 주문개수를 조회 (item의 전체제품수도 조회)
				order = service.findOrderById(orderId[i]);
				//list.add() : 더하기
				//list.set() : 변경
				list.add(i, order);
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
			session.setAttribute("checkListOrder", list);
			//회원이 장바구니에 넣은 상품중에서 orderId를 체크한 정보
			
			/*//회원이 장바구니에 넣은 상품
			List<Order> listOrder = null;
			//회원이 장바구니에 넣은 상품중에서 orderId를 체크한 정보
			ArrayList<Order> checkListOrder = new ArrayList<Order>();
				//null.getOrderList(); -> NullpointExcoption 발생
				if(member != null) {
					//상품이 있으면 requestScope에 저장
					listOrder = member.getOrderList();
					//체크한 orderId의 배열
					for(int i = 0 ; i < orderId.length ; i++) {
						//회원이 장바구니에 넣은 상품
						for(int j = 0; j < listOrder.size() ; j++) {
							if(listOrder.get(j).getOrderId() == orderId[i]) {
								checkListOrder.set(i,service.findOrderById(orderId[i]));
								System.out.println(checkListOrder.get(i));
							}
						}
					}
					session.setAttribute("checkListOrder", checkListOrder);
					}	
				 else {
					//상품이 없으면 null을 리턴
					session.setAttribute("checkListOrder", null);
				}*/
		//request.getRequestDispatcher("/order/OrderView.jsp").forward(request, response);
		response.sendRedirect("/socksShopping/order/OrderView.jsp");
	}

}
