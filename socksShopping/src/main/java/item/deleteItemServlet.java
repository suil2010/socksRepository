package item;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.socks.item.exception.ItemNotFoundException;
import com.socks.item.service.impl.itemServiceImpl;

/**
 * Servlet implementation class deleteItemServlet
 */
@WebServlet("/deleteItem")
public class deleteItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		itemServiceImpl service = itemServiceImpl.getInstance(); 
		
		String itemId = request.getParameter("itemId");
		try {
			service.removeItemById(itemId);
		} catch (ItemNotFoundException e) {
			throw new ServletException(e);
		}
		request.getRequestDispatcher("/item/deleteItemResult.jsp").forward(request, response);
	}

}
