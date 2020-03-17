package Jam;

import java.util.ArrayList;

class Chat {
	String Name;
	String Msg;
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	
	public String getMsg() {
		return Msg;
	}
	public void setMsg(String msg) {
		Msg = msg;
	}
}
public class ChatList {
	static ArrayList<Chat> chatList = new ArrayList<Chat>();
}
