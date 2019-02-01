package com.om.member;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.om.util.Pager;

@Repository
public class MemberDAO {
	
	@Inject
	private SqlSession sqlSession;
	private static final String NAMESPACE = "memberMapper.";
	
	public List<MemberDTO> list(Pager pager) throws Exception{
		
		return sqlSession.selectList(NAMESPACE+"list", pager);
	}
	
	public MemberDTO check(String id) throws Exception{
		
		return sqlSession.selectOne(NAMESPACE+"check", id);
	}
	
	public MemberDTO login(MemberDTO memberDTO) throws Exception{
		
		return sqlSession.selectOne(NAMESPACE+"login", memberDTO);
	}
	
	public int insert(MemberDTO memberDTO) throws Exception{
		
		return sqlSession.insert(NAMESPACE+"insert", memberDTO);
	}
	
	public int update(MemberDTO memberDTO) throws Exception{
		
		return sqlSession.update(NAMESPACE+"update", memberDTO);
	}
	
	public int updatePW(MemberDTO memberDTO) throws Exception{
		
		return sqlSession.update(NAMESPACE+"updatePW", memberDTO);
	}
	
	public int delete(MemberDTO memberDTO) throws Exception{
		
		return sqlSession.delete(NAMESPACE+"delete", memberDTO);
	}
}
