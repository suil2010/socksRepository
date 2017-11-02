package item;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.socks.item.service.impl.itemServiceImpl;
import com.socks.item.vo.Item;

/**
 * Servlet implementation class DetailServlet
 */
@WebServlet("/addItem")
public class AddItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public Item item;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String upDir;
		
		itemServiceImpl service = itemServiceImpl.getInstance();
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		try {
			List<FileItem> list = upload.parseRequest(request);
			
			Item item = new Item();
			for(FileItem file : list) {
				
				String requestName = file.getFieldName();
				
				if(file.isFormField()) {	//true면 요청파라미터가 String, false면 파라미터가 file
					String requestValue = file.getString("UTF-8");
					if(requestName.equals("itemId")) {
						item.setItemId(requestValue);
					}else if(requestName.equals("itemPrice")) {
						item.setItemPrice(Integer.parseInt(requestValue));
					}else if(requestName.equals("itemQuantity")) {
						item.setItemQuantity(Integer.parseInt(requestValue));
					} else if(requestName.equals("itemName")) {
						item.setItemName(requestValue);
					} 
				}else {//파일
					//파일 정보조회 - 업로드된파일명, 파일 크기
					//String fileName = item.getName(); 실제 파일명, 근데 사진이 달라도 이름이 같으면 최신 것만 남는 문제가 있다. 이 문제 해결방법은 바로 아래줄
					//String fileName = System.currentTimeMillis()+".jpg";//1번째 방법 - 현재 시간을 파일 이름으로..
					
					if(file.getFieldName().equals("mainImage")) {
						
						String fileName = UUID.randomUUID().toString();
						upDir = getServletContext().getRealPath("/mainImage");
						long fileSize = file.getSize();
						if(fileSize != 0) {
							//파일 처리 - 카페, 삭제
							file.write(new File(upDir, fileName));
							file.delete();
							item.setMainCut(fileName);
						}
					}
					else if(file.getFieldName().equals("detailImage")) {
						upDir = getServletContext().getRealPath("/detailImage");
						String fileName = UUID.randomUUID().toString();			//2번째 방법
						long fileSize = file.getSize();
						if(fileSize != 0) {
							//파일 처리 - 카페, 삭제
							file.write(new File(upDir, fileName));
							file.delete();
							item.setDetailCut(fileName);
						}
					}
				}
			}
			request.setAttribute("item", item);
			service.addItem(item);
			request.getRequestDispatcher("/item/additemResult.jsp").forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}

}
