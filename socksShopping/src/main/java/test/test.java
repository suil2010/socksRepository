package test;
import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.socks.item.dao.impl.itemDaoImpl;
import com.socks.item.exception.ItemNotFoundException;
import com.socks.item.service.impl.itemServiceImpl;
import com.socks.item.vo.Item;
import com.socks.util.SqlSessionFactoryManager;

public class test {
	public static void main(String[] args) throws IOException, ItemNotFoundException {
		//factory와 dao객체를 생성
				SqlSessionFactory factory = SqlSessionFactoryManager.getInstance().getSqlSessionFactory();
				itemServiceImpl service = itemServiceImpl.getInstance();
				itemDaoImpl dao = itemDaoImpl.getInstance();
				
				SqlSession session = null;
				List<Item> list = null;
				Item item = null;
				int cnt = 0;
				try {
					session = factory.openSession();
					
					System.out.println("------selectbyid------");
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
					session.commit();
				} finally {
					session.close();
				}
	}
}
