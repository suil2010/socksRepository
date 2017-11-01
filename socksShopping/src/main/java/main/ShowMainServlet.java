package main;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.socks.item.service.itemService;
import com.socks.item.service.impl.itemServiceImpl;
import com.socks.item.vo.Item;

@WebServlet("/main/showMain")
public class ShowMainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		itemService service = itemServiceImpl.getInstance();
		List<Item> list = service.selectAllItem();
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("/main/mainPage.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	} 
}
