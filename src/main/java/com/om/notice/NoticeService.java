package com.om.notice;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.om.board.BoardDTO;
import com.om.board.BoardService;
import com.om.util.Pager;

@Service
public class NoticeService implements BoardService{
	
	@Inject
	private NoticeDAO noticeDAO;
	
	@Override
	public ModelAndView list(Pager pager) throws Exception {
		
		pager.makeRow();
		int totalCount = noticeDAO.totalCount(pager);
		pager.makePage(totalCount);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", noticeDAO.list(pager));
		mv.addObject("pager", pager);
		mv.addObject("board", "notice");
		mv.setViewName("board/boardList");
		
		return mv;
	}

	@Override
	public ModelAndView select(int num, Pager pager) throws Exception {
		ModelAndView mv = new ModelAndView();
		BoardDTO boardDTO = noticeDAO.select(num);
		
		pager.makeRow();
		int totalCount = noticeDAO.totalCount(pager);
		pager.makePage(totalCount);
		
		if(boardDTO !=null) {
			mv.addObject("Ndto", boardDTO);
			mv.addObject("list", noticeDAO.list(pager));
			mv.addObject("pager", pager);
			mv.setViewName("board/boardSelect");
		}else {
			mv.addObject("msg", "해당 글을 찾을 수 없습니다");
			mv.setViewName("redirect:./noticeList");
		}
		mv.addObject("board", "notice");
		return mv;
	}

	@Override
	public ModelAndView insert(BoardDTO boardDTO) throws Exception {
		
		int num = noticeDAO.getNum(); //1. 시퀀스에서 넘버 가져오기 메서드 호출
		
		//2. notice table에 insert
		boardDTO.setNum(num);
		int result = noticeDAO.insert(boardDTO);
		ModelAndView mv = new ModelAndView();
		String massage="작성 실패";
		if(result>0) {
			massage = "작성 성공";
		}
		
		mv.addObject("msg", massage);
		mv.setViewName("redirect:./noticeList");
		
		return mv;
	}

	@Override
	public ModelAndView update(BoardDTO boardDTO) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		int result = noticeDAO.update(boardDTO);
		
		String massage="수정 실패";
		if(result>0) {
			massage = "수정 성공";
		}
		
		mv.addObject("msg", massage);
		mv.setViewName("redirect:./noticeSelect?num="+boardDTO.getNum());
		
		return mv;
	}

	@Override
	public ModelAndView delete(int num) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		int result = noticeDAO.delete(num);
		String massage="삭제 실패";
		if(result>0) {
			massage = "삭제 성공";
		}
		
		mv.addObject("msg", massage);
		mv.setViewName("redirect:./noticeList");
		
		return mv;
	}
	
	
	

}
