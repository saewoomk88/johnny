package com.om.johnny;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.om.board.BoardDTO;
import com.om.notice.NoticeService;
import com.om.util.Pager;

@Controller
@RequestMapping(value="/notice/**")
public class NoticeController {
	
	@Inject
	private NoticeService noticeService;
	
	@RequestMapping(value="noticeList")
	public ModelAndView list(Pager pager) throws Exception{
		
		return noticeService.list(pager);
		
	}
	
	@RequestMapping(value="noticeSelect")
	public ModelAndView select(int num, Pager pager) throws Exception{
		
		return noticeService.select(num, pager);
	}
	
	@RequestMapping(value="noticeWrite", method=RequestMethod.GET)
	public String write(Model model) {
		model.addAttribute("board", "notice");
		return "board/boardWrite";
	}
	
	@RequestMapping(value="noticeWrite", method=RequestMethod.POST)
	public ModelAndView insert(BoardDTO boardDTO) throws Exception{
		return noticeService.insert(boardDTO);
	}
	
	@RequestMapping(value="noticeUpdate", method=RequestMethod.GET)
	public ModelAndView update(int num, Pager pager) throws Exception {
		ModelAndView mv = noticeService.select(num, pager);
		mv.setViewName("board/boardUpdate");
		return mv;
	}
	
	@RequestMapping(value="noticeUpdate", method=RequestMethod.POST)
	public ModelAndView update(BoardDTO boardDTO) throws Exception{
		
		return noticeService.update(boardDTO);
	}
	
	@RequestMapping(value="noticeDelete", method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView delete(int num) throws Exception{
		
		return noticeService.delete(num);
	}
	
	

}
