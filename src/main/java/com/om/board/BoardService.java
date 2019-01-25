package com.om.board;

import org.springframework.web.servlet.ModelAndView;

import com.om.util.Pager;

public interface BoardService {
	
	public ModelAndView list(Pager pager) throws Exception;
	
	public ModelAndView select(int num, Pager pager) throws Exception;
	
	public ModelAndView insert(BoardDTO boardDTO) throws Exception;
	
	public ModelAndView update(BoardDTO boardDTO) throws Exception;
	
	public ModelAndView delete(int num) throws Exception;

}
