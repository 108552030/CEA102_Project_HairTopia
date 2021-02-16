package com.chat.model;

import java.util.List;

public class ChatService {
	private ChatDAO_interface dao;
	
	public ChatService() {
		dao = new ChatDAO();
	}
	
	public ChatVO addChat(Integer chatSender, Integer chatReceiver, String chatText) {
		ChatVO chatVO = new ChatVO();
		
		chatVO.setChatSender(chatSender);
		chatVO.setChatReceiver(chatReceiver);
		chatVO.setChatText(chatText);
		
		dao.insert(chatVO);
		
		return chatVO;
	}
	
	public ChatVO updateMember(Integer chatNo, Integer chatSender, Integer chatReceiver, String chatText) {
		
		ChatVO chatVO = new ChatVO();
		chatVO.setChatNo(chatNo);
		chatVO.setChatSender(chatSender);
		chatVO.setChatReceiver(chatReceiver);
		chatVO.setChatText(chatText);
		
		dao.update(chatVO);
		
		return chatVO;
	}
	
	public void deleteMember(Integer chatNo) {
		dao.delete(chatNo);
	}
	
	public ChatVO getOneMem(Integer chatNo) {
		return dao.findByPrimaryKey(chatNo);
	}
	
	public List<ChatVO> getAll() {
		return dao.getAll();
	}
		
}
