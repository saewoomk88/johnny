package com.om.qna;

import org.springframework.web.servlet.ModelAndView;

import com.om.board.BoardDTO;
import com.om.board.BoardService;
import com.om.util.Pager;

public class QnaService implements BoardService{
	
	
	
	@Override
	public ModelAndView list(Pager pager) throws Exception {
		return null;
	}

	@Override
	public ModelAndView select(int num, Pager pager) throws Exception {
		return null;
	}

	@Override
	public ModelAndView insert(BoardDTO boardDTO) throws Exception {
		return null;
	}

	@Override
	public ModelAndView update(BoardDTO boardDTO) throws Exception {
		return null;
	}

	@Override
	public ModelAndView delete(int num) throws Exception {
		return null;
	}

	
}
