package Jam;

import java.io.IOException;
import Jam.ChatList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ChattingServlet/*")
public class ChattingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String Name = request.getParameter("name");
		String Msg = request.getParameter("msg");
		String Index = request.getParameter("index");
		String vin = new String("");
		if(Index.equals("update")) {
			response.getWriter().write(select());
		}
		else if(Index.equals("submit")) {
			if(Name == null || Name.trim().equals(vin) || Msg == null || Msg.trim().equals(vin)) {
				response.getWriter().write("0");
			} else {
				Chat chat = new Chat();
				chat.setName(Name);
				chat.setMsg(Msg);
				ChatList.chatList.add(chat);
				response.getWriter().write(select());
			}
		}
	}
	
	protected String select() {
		StringBuffer data = new StringBuffer("");
		for(int i=0; i<ChatList.chatList.size(); i++) {
			data.append("<div><p style='font-size:25px;'>");
			data.append(ChatList.chatList.get(i).getName());
			data.append("</p></div><div><p style='font-size:20px;'>");
			data.append(ChatList.chatList.get(i).getMsg());
			data.append("</p></div><hr width='99%' align='left'/>");
		}
		return data.toString();
	}

}
