package com.ou.util;

public class Pager {
	
	//https://okky.kr/article/282819 보충자료
	//페이지넘버 1,2,3,4,5
	private int curPage;
	
	//perPage(한 페이지에 보여지는 개시글 수) countList
	private int perPage;
	
	//perBlock가 5라면 curBlock이 1-5..6-10 이렇게 보이게 해줌
	private int perBlock;
	
	//DAO 에 rownum으로 사용하기 위함
	private int startRow;
	private int lastRow;
	

}
