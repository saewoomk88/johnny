package com.om.johnny;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.om.board.BoardDTO;
import com.om.member.MemberDTO;
import com.om.member.MemberService;
import com.om.qna.QnaDTO;
import com.om.qna.QnaService;
import com.om.util.Pager;

@Controller
@RequestMapping(value="/member/**")
public class MemberController {
	
	@Inject
	private MemberService memberService;
	

	
	@RequestMapping(value="memberList")
	public ModelAndView list(Pager pager) throws Exception{
		
		return memberService.list(pager);
	}
	
	@RequestMapping(value="insert", method=RequestMethod.GET)
	public void insert()throws Exception{}
	
	@RequestMapping(value="insert", method=RequestMethod.POST)
	public ModelAndView insert(MemberDTO memberDTO) throws Exception{
		
		return memberService.insert(memberDTO); 
	}
	
	@RequestMapping(value="login", method=RequestMethod.GET)
	public void login()throws Exception{}
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public ModelAndView login(MemberDTO memberDTO, HttpSession session) throws Exception {
		
		return memberService.login(memberDTO, session);
	}
	
	@RequestMapping(value="updatePW", method=RequestMethod.GET)
	public void updatePW()throws Exception{}
	
	@RequestMapping(value="updatePW", method=RequestMethod.POST)
	public ModelAndView updatePW(MemberDTO memberDTO, HttpSession session) throws Exception {
		
		return memberService.updatePW(memberDTO, session);
	}
	
	@RequestMapping(value="update", method=RequestMethod.GET)
	public void update()throws Exception{}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	public ModelAndView update(MemberDTO memberDTO, HttpSession session) throws Exception {
		
		return memberService.update(memberDTO, session);
	}
	
	@RequestMapping(value="delete")
	public ModelAndView delete(HttpSession session) throws Exception {
		
		return memberService.delete(session);
	}
	
	@RequestMapping(value="myPage")
	public void myPage()throws Exception{}
	
	
	@RequestMapping(value="logOut")
	public String logOut(HttpSession session)throws Exception{
		session.invalidate();
		return "redirect:../";
	}
	
	
	

}
