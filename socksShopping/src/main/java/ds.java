import java.io.IOException;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.socks.item.impl.itemDaoImpl;
import com.socks.item.vo.Item;
import com.socks.member.dao.impl.MemberDaoImpl;
import com.socks.util.SqlSessionFactoryManager;

public class ds {
	public static void main(String[] args) throws IOException {
		SqlSessionFactory factory = SqlSessionFactoryManager.getInstance().getSqlSessionFactory();
		MemberDaoImpl dao = MemberDaoImpl.getInstance();
		itemDaoImpl daoItem = itemDaoImpl.getInstance();
		
		SqlSession session = null;
		try {
			int cnt = 0;
			session = factory.openSession();
			/*System.out.println("------insert-------");
			Member member = new Member("userID-7","장산범","12355","경기 화성","suil12@sss.com",520);
			cnt = dao.insertMember(session, member);
			System.out.println(cnt);
			
			System.out.println("----update-----");
			cnt = dao.updateMemberById(session, new Member("userID-7","곽한구","12315","경기 화성","suil12@sss.com",332));
			System.out.println(cnt);
			
			System.out.println("-----delete-----");
			cnt = dao.deleteMemberById(session, "userID-7");
			System.out.println(cnt);
			
			System.out.println("-----select-----");
			List<Member> list = dao.selectAll(session);
			for(Member l : list) {
				System.out.println(l);
			}
			
			System.out.println("-----selectAllByJoin-----");
			list = dao.selectAllByJoin(session);
			
			for(Member l : list) {
				System.out.println(l.getName());
				List<Order> order = l.getOrderList();
				System.out.println("----------");
				for(Order o : order) {
					System.out.println("주문 수 : " + o.getOrderQuantity()+"개");
					Item item = o.getItem();
					System.out.println(item);
				}
			}*/
			
			System.out.println("----selectitem--------");
			cnt = daoItem.insertItem(session, 
					new Item("itemId-90",12400,1200,"sdkkslf","C:\\","D:\\"));
			System.out.println(cnt);
			
			System.out.println("----update-----");
			cnt = daoItem.updateItemById(session,new Item("itemId-3",112400,1400,"sdfdc","C:\\","D:\\"));
			System.out.println(cnt);
			
			System.out.println("-----delete-----");
			cnt = daoItem.deleteItemById(session, "itemId-5");
			System.out.println(cnt);
			
			session.commit();
		} finally {
			session.close();
		}
	}
}
