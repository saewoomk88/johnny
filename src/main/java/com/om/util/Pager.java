package com.om.util;

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
	
	//검색하기 위함
	private String kind;
	private String search;
	
	//페이징
	private int startNum;
	private int lastNum;
	private int curBlock;//curBlock=1, perBlock=1~5 .. curBlock=2, perBlock=6~10
	private int totalBlock;// 총 perBlock의 수
	
	public Pager() {
		this.perPage=10;
		this.perBlock=2;
	}

	
	public int getCurPage() {
		if(curPage==0) {
			curPage=1;
		}
		return curPage;
	}
	public void setCurPage(int curPage) {
		
		this.curPage = curPage;
	}
	public int getPerPage() {
		if(perPage==0) {
			perPage=10;
		}
		return perPage;
	}
	public void setPerPage(int perPage) {
		
		this.perPage = perPage;
	}
	public int getPerBlock() {
		return perBlock;
	}
	public void setPerBlock(int perBlock) {
		this.perBlock = perBlock;
	}
	public int getStartRow() {
		return startRow;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	public int getLastRow() {
		return lastRow;
	}
	public void setLastRow(int lastRow) {
		this.lastRow = lastRow;
	}
	public String getKind() {
		if(this.kind==null || this.kind.equals("")) {
			kind="title";
		}
		return kind;
	}
	public void setKind(String kind) {
		
		this.kind = kind;
	}
	public String getSearch() {
		if(search==null) {
			search="";
		}
		return search;
	}
	public void setSearch(String search) {
		
		this.search = search;
	}
	public int getStartNum() {
		return startNum;
	}
	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}
	public int getLastNum() {
		return lastNum;
	}
	public void setLastNum(int lastNum) {
		this.lastNum = lastNum;
	}
	public int getCurBlock() {
		return curBlock;
	}
	public void setCurBlock(int curBlock) {
		this.curBlock = curBlock;
	}
	public int getTotalBlock() {
		return totalBlock;
	}
	public void setTotalBlock(int totalBlock) {
		this.totalBlock = totalBlock;
	}
	
	//스타트로우,라스트로우를 계산하기 위한 메서드
	public void makeRow() {
		this.startRow = (getCurPage()-1)*getPerPage()+1; // 한페이지에 보여지는 게시물의 처음번호
		this.lastRow = getCurPage()*getPerPage(); //한페이지에 보여지는 게시물의 마지막번호
	}
	
	//페이징
	public void makePage(int totalCount) {
		//1.전체 페이지의 쪽수
		int totalPage = totalCount/perPage;
		if(totalCount%perPage !=0) {
			totalPage++;
		}
		
		//2.한 페이지에 
		this.totalBlock = totalPage/perBlock;
		if(totalPage%perBlock !=0) {
			totalBlock++;
		}
		
		//3.curPage로 curBlock 찾기
		this.curBlock = curPage/perBlock; //curPage=1 , perBlock= 5
		if(curPage%perBlock !=0) {
			curBlock++;
		}
		
		//4.curBlock 로 startNum, lastNum 찾기
		this.startNum = (curBlock-1)*perBlock+1;
		this.lastNum = curBlock*perBlock;
		
		//5. curBlock가 마지막 block 일때
		if(curBlock== totalBlock) {
			this.lastNum=totalPage;
		}
		
		
		
		
	}
	
	

}
