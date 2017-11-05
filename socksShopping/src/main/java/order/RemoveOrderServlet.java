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
import com.socks.orderdetail.OrderDetailServiceImpl;
import com.socks.orderdetail.vo.OrderDetail;
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
				itemServiceImpl serviceItem = itemServiceImpl.getInstance();
				OrderMemberServiceImpl serviceOrder = OrderMemberServiceImpl.getInstance();
				MemberServiceImpl serviceMember = MemberServiceImpl.getInstance();
				
				Member member = (Member)session.getAttribute("loginMember");
				String memberId = member.getMemberId();
				member = serviceMember.findOrderMemberById(memberId);
				String[] orderDetailIdList = request.getParameterValues("checkOrderDetailId");
				
				//주문 수에서 재고를 다사 더하는 메소드
				serviceItem.cancelManagerOrderList(orderDetailIdList);
				//주문 취소하는 메소드
				serviceOrder.cancelOrderProcessing(orderDetailIdList);
				
				//다시 회원 정보를 조회
				member = serviceMember.findOrderMemberById(memberId);
				System.out.println("member : "+member);
				
				List<OrderMember> listOrderMember;
				//null.getOrderList(); -> NullpointExcoption 발생
				if(member != null) {
					//상품이 있으면 requestScope에 저장
					listOrderMember = member.getOrderMemberList();
					session.setAttribute("checkListOrder", listOrderMember);
				} else {
					//상품이 없으면 null을 리턴
					session.setAttribute("checkListOrder", null);
				}
				//request.getRequestDispatcher("/order/ShopingBasketView.jsp").forward(request, response);
				response.sendRedirect("/socksShopping/order/OrderView.jsp");
	}

}
