package com.om.product;

import java.io.File;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.om.file.FileDAO;
import com.om.file.FileDTO;
import com.om.util.FileSaver;
import com.om.util.Pager;

@Service
public class ProductService {

	@Inject
	private ProductDAO productDAO;
	@Inject
	private FileDAO fileDAO;

	public ModelAndView list(Pager pager) throws Exception{

		pager.makeRow();
		int totalCount= productDAO.totalCount(pager);
		pager.makePage(totalCount);

		ModelAndView mv = new ModelAndView();
		mv.addObject("list", productDAO.list(pager));
		mv.addObject("pager", pager);
		mv.setViewName("product/productList");
		return mv;
	}

	public ModelAndView select(String p_code) throws Exception{

		ModelAndView mv = new ModelAndView();
		ProductDTO productDTO = productDAO.select(p_code);
		if(productDTO!=null) {
			mv.addObject("product", productDTO);
			mv.setViewName("product/productSelect");
		}else {
			mv.addObject("msg", "해당 글을 찾을 수 없습니다.");
			mv.setViewName("redirect:./productList");
		}

		return mv;
	}

	public ModelAndView insert(ProductDTO productDTO, List<MultipartFile> multi, HttpSession session) throws Exception{

		ModelAndView mv = new ModelAndView();

		String p_code = productDAO.getNum();
		productDTO.setP_code(p_code);
		int result = productDAO.insert(productDTO);
		String msg = "insert Fail";
		if(result>0) {
			msg="insert Success";


			// HDD에 File Save
			FileSaver fs = new FileSaver();
			String realPath = session.getServletContext().getRealPath("resources/product");

			for(MultipartFile mFile : multi) {
				if(mFile.isEmpty()) {
					continue;
				}

				FileDTO fileDTO = new FileDTO();
				fileDTO.setOname(mFile.getOriginalFilename());
				fileDTO.setFname(fs.saveFile3(realPath, mFile));
				fileDTO.setP_code(p_code);

				result= fileDAO.insert(fileDTO);
				if(result<1) {
					msg="Fail";
				}
			}

		}
		mv.addObject("msg",msg);
		mv.setViewName("redirect:./productList");

		return mv;
	}

	public ModelAndView update(ProductDTO productDTO, List<MultipartFile>multi, HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();

		int result = productDAO.update(productDTO);
		String msg = "Update Fail";

		if(result>0) {
			msg="Update Success";
			
		FileSaver fs = new FileSaver();
		String realPath = session.getServletContext().getRealPath("resources/product");
		for(MultipartFile mFile:multi) {
			FileDTO fileDTO = new FileDTO();
			fileDTO.setP_code(productDTO.getP_code());
			fileDTO.setOname(mFile.getOriginalFilename());
			fileDTO.setFname(fs.saveFile3(realPath, mFile));
			result = fileDAO.insert(fileDTO);
			if(result<1) {
				msg="Fail";
			}
		}
		}
		mv.setViewName("redirect:./productSelect?p_code="+productDTO.getP_code());
		mv.addObject("msg", msg);
		return mv;
	}

	public ModelAndView delete(String p_code, HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();

		int result = productDAO.delete(p_code);
		if(result <1) {
			throw new SQLException();
		}

		FileDTO fileDTO = new FileDTO();

		fileDTO.setP_code(p_code);
		List<FileDTO> ar = fileDAO.list(fileDTO);

		result = fileDAO.deleteAll(p_code);

		String realPath= session.getServletContext().getRealPath("resources/product");
		for(FileDTO fileDTO2 : ar) {
			File file = new File(realPath, fileDTO2.getFname());
			file.delete();
		}
		mv.setViewName("redirect:./productList");

		return mv;


	}


}
