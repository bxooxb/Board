package com.ict.model;

public class Paging {
	// 페이지 기법 : 전체 정보 중에서 일부 원하는 정보를 가져오기 
	// 해당 페이지의 시작번호, 끝번호 구하기 
	// 시작 블록과 끝블록 구하기 
	
	private int nowPage = 1 ;       // 현재 페이지 
	private int nowBlock = 1 ;      // 현재 블록
	private int totalRecored = 0 ;  // 전체 게시물의 수
	private int totalPage = 0 ;     // 전체 페이지의 수
	private int totalBlock = 0 ;    // 전체 블록의 수
	private int numPerpage = 10 ;   // 한 페이지에 존재하는 게시물의 수
	private int pagePerBlock = 2 ;  // 한 블록에 존재하는 페이지의 수  
	
	private int begin = 0 ;         // 시작 번호 
	private int end = 0 ;           // 끝 번호
	private int beginBlock = 0 ;    // 시작 블록
	private int endBlock = 0 ;      //  끝 블록
	
	public int getNowPage() {
		return nowPage;
	}
	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}
	public int getNowBlock() {
		return nowBlock;
	}
	public void setNowBlock(int nowBlock) {
		this.nowBlock = nowBlock;
	}
	public int getTotalRecored() {
		return totalRecored;
	}
	public void setTotalRecored(int totalRecored) {
		this.totalRecored = totalRecored;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getTotalBlock() {
		return totalBlock;
	}
	public void setTotalBlock(int totalBlock) {
		this.totalBlock = totalBlock;
	}
	public int getNumPerpage() {
		return numPerpage;
	}
	public void setNumPerpage(int numPerpage) {
		this.numPerpage = numPerpage;
	}
	public int getPagePerBlock() {
		return pagePerBlock;
	}
	public void setPagePerBlock(int pagePerBlock) {
		this.pagePerBlock = pagePerBlock;
	}
	public int getBegin() {
		return begin;
	}
	public void setBegin(int begin) {
		this.begin = begin;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public int getBeginBlock() {
		return beginBlock;
	}
	public void setBeginBlock(int beginBlock) {
		this.beginBlock = beginBlock;
	}
	public int getEndBlock() {
		return endBlock;
	}
	public void setEndBlock(int endBlock) {
		this.endBlock = endBlock;
	}
	
	
}
