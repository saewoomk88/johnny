package com.om.johnny;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.om.board.BoardDTO;
import com.om.qna.QnaDTO;
import com.om.qna.QnaService;
import com.om.util.Pager;

@Controller
@RequestMapping(value="/qna/**")
public class QnaController {
	
	@Inject
	private QnaService qnaService;
	
	@RequestMapping(value="qnaReply", method=RequestMethod.GET)
	public String reply(Model model, int num) {
		model.addAttribute("board", "qna");
		model.addAttribute("num", num);
		return "board/boardReply";
	}
	
	@RequestMapping(value="qnaReply", method=RequestMethod.POST)
	public ModelAndView reply(QnaDTO qnaDTO) throws Exception{
		
		return qnaService.reply(qnaDTO);
	}
	
	@RequestMapping(value="qnaList")
	public ModelAndView list(Pager pager) throws Exception{
		
		return qnaService.list(pager);
		
	}
	
	@RequestMapping(value="qnaSelect")
	public ModelAndView select(int num, Pager pager) throws Exception{
		
		return qnaService.select(num, pager);
	}
	
	@RequestMapping(value="qnaWrite", method=RequestMethod.GET)
	public String write(Model model) {
		model.addAttribute("board", "qna");
		return "board/boardWrite";
	}
	
	@RequestMapping(value="qnaWrite", method=RequestMethod.POST)
	public ModelAndView insert(BoardDTO boardDTO) throws Exception{
		return qnaService.insert(boardDTO);
	}
	
	@RequestMapping(value="qnaUpdate", method=RequestMethod.GET)
	public ModelAndView update(int num, Pager pager) throws Exception {
		ModelAndView mv = qnaService.select(num, pager);
		mv.setViewName("board/boardUpdate");
		return mv;
	}
	
	@RequestMapping(value="noticeUpdate", method=RequestMethod.POST)
	public ModelAndView update(BoardDTO boardDTO) throws Exception{
		
		return qnaService.update(boardDTO);
	}
	
	@RequestMapping(value="noticeDelete", method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView delete(int num) throws Exception{
		
		return qnaService.delete(num);
	}

}
