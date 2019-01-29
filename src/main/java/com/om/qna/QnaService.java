package com.om.qna;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.om.board.BoardDTO;
import com.om.board.BoardService;
import com.om.util.Pager;

@Service
public class QnaService implements BoardService{
	
	@Inject
	private QnaDAO qnaDAO;
	
	@Override
	public ModelAndView list(Pager pager) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		
		int totalCount = qnaDAO.totalCount(pager);
		pager.makeRow();
		pager.makePage(totalCount);
		
		mv.addObject("board", "qna");
		mv.addObject("list", qnaDAO.list(pager));
		mv.addObject("pager", pager);
		mv.setViewName("board/boardList");
		return mv;
	}

	@Override
	public ModelAndView select(int num, Pager pager) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		
		BoardDTO boardDTO = qnaDAO.select(num);
		
		mv.setViewName("board/boardSelect");
		mv.addObject("board", "qna");
		mv.addObject("dto", boardDTO);
		
		return mv;
	}

	@Override
	public ModelAndView insert(BoardDTO boardDTO) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		
		int result = qnaDAO.insert(boardDTO);
		
		String massage="작성 실패";
		if(result>0) {
			massage = "작성 성공";
		}
		
		mv.addObject("msg", massage);
		mv.setViewName("redirect:./qnaList");
		
		return mv;
	}

	@Override
	public ModelAndView update(BoardDTO boardDTO) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		
		int result = qnaDAO.update(boardDTO);
		
		String massage="수정 실패";
		if(result>0) {
			massage = "수정 성공";
		}
		
		mv.addObject("msg", massage);
		mv.setViewName("redirect:./qnaSelect?num="+boardDTO.getNum());
		return mv;
	}

	@Override
	public ModelAndView delete(int num) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		
		int result = qnaDAO.delete(num);
		
		String massage="삭제 실패";
		if(result>0) {
			massage = "삭제 성공";
		}
		
		mv.addObject("msg", massage);
		mv.setViewName("redirect:./qnaList");
		
		return mv;
	}
	
	public ModelAndView reply(QnaDTO qnaDTO) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		
		BoardDTO boardDTO = qnaDAO.select(qnaDTO.getNum());
		QnaDTO pQnaDTO = (QnaDTO)boardDTO;
		
		qnaDAO.replyUpdate(pQnaDTO);
		
		qnaDTO.setRef(pQnaDTO.getRef());
		qnaDTO.setStep(pQnaDTO.getStep()+1);
		qnaDTO.setDepth(pQnaDTO.getDepth()+1);
		
		int result = qnaDAO.reply(qnaDTO);
		
		String massage="작성 실패";
		if(result>0) {
			massage = "작성 성공";
		}
		
		mv.addObject("msg", massage);
		mv.setViewName("redirect:./qnaList");
		
		return mv;
		
	}

	
}
