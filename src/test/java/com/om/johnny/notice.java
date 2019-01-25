package com.om.johnny;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;

import com.om.board.BoardDTO;
import com.om.notice.NoticeDAO;
import com.om.notice.NoticeService;
import com.om.util.Pager;

public class notice extends AbstractTestCase{
	
	@Inject
	NoticeService noticeService;
	@Inject
	NoticeDAO noticeDAO;

	@Test
	public void test() throws Exception{
		Pager pager = new Pager();
		assertNotNull(noticeService.list(pager));
			
	}

}
