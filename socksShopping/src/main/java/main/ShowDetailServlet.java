package main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.socks.item.service.itemService;
import com.socks.item.service.impl.itemServiceImpl;
import com.socks.item.vo.Item;

/**
 * Servlet implementation class ShowDetailServlet
 */
@WebServlet("/main/showDetail")
public class ShowDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		itemService service = itemServiceImpl.getInstance();
		String itemId=null;
		Item item = null;
		
		try {
			itemId = request.getParameter("itemId");
			item = service.findItemById(itemId);
		}catch(Exception e){
			e.getMessage();
			throw new ServletException(e);
		}
		request.setAttribute("item", item);
		request.getRequestDispatcher("/item/itemDetailView.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
