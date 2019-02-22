package com.om.product;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.om.util.Pager;

@Repository
public class ProductDAO {

	@Inject
	private SqlSession sqlSession;
	private static final String NAMESPACE="productMapper.";
	
	public List<ProductDTO> list(Pager pager) throws Exception{
		
		return sqlSession.selectList(NAMESPACE+"list", pager);
	}
	
	public ProductDTO select(String p_code) throws Exception{
		
		return sqlSession.selectOne(NAMESPACE+"select", p_code);
	}
	
	public int insert(ProductDTO productDTO) throws Exception{
		
		return sqlSession.insert(NAMESPACE+"insert", productDTO);
	}
	
	public int update(ProductDTO productDTO) throws Exception{
		
		return sqlSession.update(NAMESPACE+"update", productDTO);
	}
	
	public int delete(String p_code) throws Exception{
		
		return sqlSession.delete(NAMESPACE+"delete", p_code);
	}
	
	public int totalCount(Pager pager) throws Exception{
		
		return sqlSession.selectOne(NAMESPACE+"totalCount", pager);
	}
	
	public String getNum() throws Exception{
		
		return sqlSession.selectOne(NAMESPACE+"getNum");
	}
}
