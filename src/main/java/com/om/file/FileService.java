package com.om.file;

import java.net.URLEncoder;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;





@Service
public class FileService {

	@Inject
	private FileDAO fileDAO;
	
	public ModelAndView delete(int i_num) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		int result = fileDAO.delete(i_num);
		mv.setViewName("common/result");
		mv.addObject("result", result);
		
		return mv;
		
	}
	

	
	
}
