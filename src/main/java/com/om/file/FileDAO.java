package com.om.file;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class FileDAO {
	
	@Inject
	private SqlSession sqlSession;
	private static final String NAMESPACE = "fileMapper.";
	
	public int insert(FileDTO fileDTO) throws Exception{
		
		return sqlSession.insert(NAMESPACE+"insert", fileDTO);
	}
	
	public List<FileDTO> list(FileDTO fileDTO) throws Exception{
		
		return sqlSession.selectList(NAMESPACE+"list", fileDTO);
	}
	
	public FileDTO select(int i_num) throws Exception{
		
		return sqlSession.selectOne(NAMESPACE+"select", i_num);
	}
	
	public int delete(int i_num) throws Exception{
		
		return sqlSession.delete(NAMESPACE+"delete", i_num);
	}
	
	public int deleteAll(String p_code) throws Exception{
		
		return sqlSession.delete(NAMESPACE+"deleteAll", p_code);
	}

}
