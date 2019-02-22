package com.om.member;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.om.util.Pager;

@Service
public class MemberService {
	
	@Inject
	private MemberDAO memberDAO;
	
	public ModelAndView list(Pager pager) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("list", memberDAO.list(pager));
		mv.addObject("pager", pager);
		mv.setViewName("member/memberList");
		return mv;
	}
	
	public ModelAndView check(String id) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		MemberDTO memberDTO = memberDAO.check(id);
		//int result가 0이면 사용불가	 , 1이면 사용가능으로 설정하기
		int result =0;
		if(memberDTO ==null) {
			result=1;
		}
		
		mv.addObject("result", result);
		mv.setViewName("common/result");
		
		return mv;
	}
	
	public ModelAndView insert(MemberDTO memberDTO) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		
		int result = memberDAO.insert(memberDTO);
		String msg = "가입성공";
		String path = "redirect:../";
		if(result<1) {
			msg="가입 실패";
			path ="redirect:./insert";
		}
		
		mv.addObject("msg", msg);
		mv.setViewName(path);
		
		return mv;
	}
	
	public ModelAndView login(MemberDTO memberDTO, HttpSession session) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		
		memberDTO = memberDAO.login(memberDTO);
		String path="";
		if(memberDTO !=null) {
			session.setAttribute("member", memberDTO);
			System.out.println(memberDTO.getPw());
			path="redirect:../";
		}else {
			path="redirect:./login";
			mv.addObject("msg", "로그인 실패");
		}
		
		mv.setViewName(path);
		
		return mv;
	}
	
	public ModelAndView updatePW(MemberDTO memberDTO, HttpSession session) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		
		MemberDTO loginDTO = (MemberDTO)session.getAttribute("member");
		memberDTO.setId(loginDTO.getId());
		int result = memberDAO.updatePW(memberDTO);
		
		if(result>0) {
			session.setAttribute("member", memberDTO);
		}else {
			mv.addObject("msg", "비밀번호 수정 실패");
		}
		mv.setViewName("redirect:./myPage");
		
		return mv;
	}
	
	public ModelAndView update(MemberDTO memberDTO, HttpSession session) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		
		MemberDTO loginDTO = (MemberDTO)session.getAttribute("member");
		memberDTO.setId(loginDTO.getId());
		int result = memberDAO.update(memberDTO);
		
		if(result>0) {
			session.setAttribute("member", memberDTO);
		}else {
			mv.addObject("msg", "비밀번호 수정 실패");
		}
		mv.setViewName("redirect:./myPage");
		
		return mv;
	}
	
	public ModelAndView delete(HttpSession session) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		
		MemberDTO loginDTO = (MemberDTO)session.getAttribute("member");
		System.out.println(loginDTO.getPw());
		int result = memberDAO.delete(loginDTO);
		
		String msg = "탈퇴 실패";
		if(result>0) {
			msg = "탈퇴 성공";
			session.invalidate();
		}
		mv.addObject("msg", msg);
		mv.setViewName("redirect:../");
		
		return mv;
	}
	
	
	
	
	
	
}
