package test;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.socks.item.dao.impl.itemDaoImpl;
import com.socks.item.exception.ItemNotFoundException;
import com.socks.item.service.impl.itemServiceImpl;
import com.socks.item.vo.Item;
import com.socks.member.vo.Member;
import com.socks.order.dao.impl.OrderDaoImpl;
import com.socks.order.service.impl.OrderServiceImpl;
import com.socks.order.vo.Order;
import com.socks.util.SqlSessionFactoryManager;

public class test {
	public static void main(String[] args) throws IOException, ItemNotFoundException {
		//factory와 dao객체를 생성
				SqlSessionFactory factory = SqlSessionFactoryManager.getInstance().getSqlSessionFactory();
				itemServiceImpl service = itemServiceImpl.getInstance();
				OrderServiceImpl service1 = OrderServiceImpl.getInstance();
				
				itemDaoImpl dao = itemDaoImpl.getInstance();
				OrderDaoImpl dao1 = OrderDaoImpl.getInstance();
				
				SqlSession session = null;
				//List<Item> list = null;
				List<Member> list = null;
				Item item = null;
				int cnt = 0;
				try {
					session = factory.openSession();
					
					/*System.out.println("------selectbyid------");
					item = service.findItemById("g234");
					System.out.println(item);
					
					System.out.println("-----findbyName-------");
					list = service.findItemByName("긴 양말");
					for(Item i : list) {
						System.out.println(i);
					}
					
					
					//cnt = dao.updateItemById(session, new Item("g234",12000,12,"빨간 양말","sdlfjldjfs","sdfsdfdf"));
					//System.out.println(cnt);
					System.out.println("------selectALl------");
					list = dao.selectAllItem(session);
					for(Item i : list) {
						System.out.println(i);
					}
					
					System.out.println("-----update--------");
					//service.updateItemById(new Item("",112300,1222,"빨간 양말","sdlfjldjfs","sdfsdfdf"));
					 
*/					
					
					/*System.out.println("-------insert-------");
					//String orderId, int orderQuantity, String memberId, String itemId, Date orderDate
					Date date = new Date();
					System.out.println(date);
					String str = String.format("%tY-%<tm-%<td %<tA %<tH:%<tM:%<tS %<tp%n", date);
					System.out.println(str);
					cnt = dao1.insertOrder(session, new Order("orderId-12",12,"userId-1","itemId-2",new Date()));
					System.out.println(cnt);*/
					
					/*System.out.println("--------delete------");
					cnt = dao1.deleteOrderById(session, "orderId-1");
					System.out.println(cnt);*/
					
					/*System.out.println("------select--------");
					list = dao1.selectAllOrder(session);
					for(Member m : list) {
						System.out.println(m);
					}
					
					System.out.println("-------selectByJoin-------");
					Member member = dao1.selectAllOrderByJoin(session,"userId-1");
					
						System.out.println(member.getName());
						System.out.println("--------------------");
						List<Order> list1 = member.getOrderList();
						for(Order o : list1) {
							System.out.println(o);
							System.out.println("-------------------");
							item = o.getItem();
							System.out.println(item);
						}*/
						
					/*System.out.println("------add------");
					service1.addOrder(new Order("orderId-14",12,"userId-1","itemId-2",new Date()));
					
					System.out.println("------delete-------");
					service1.removeOrder("orderId-6");
					*/
					
					System.out.println("----selelct------");
					list = service1.findAllOrder();
					for(Member m : list) {
						System.out.println(m);
					}
					
					System.out.println("--------------------");
					Member member = service1.findOrder("userId-1");
					for(Order order : member.getOrderList()) {
						System.out.println(order);
					}
					
					System.out.println("---- selectOrder------");
					Order order = dao1.selectOrderByJoin(session,"orderId-3");
					System.out.println(order);
					session.commit();
				} finally {
					session.close();
				}
	}
}
