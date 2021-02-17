package com.ict.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class DAO {
	private static SqlSession ss;
	private synchronized static SqlSession getSession() {
		if(ss == null) {
			ss = DBService.getFactory().openSession(false);
		}
		return ss;
	}
	
	// 전체 게시물의 수
	public static int getCount() {
		int result = 0 ;
		result = getSession().selectOne("count");
		return result;
	}
	// 리스트
	public static List<VO> getList(int begin, int end){
		List<VO> list = new ArrayList<VO>();
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("begin", begin);
		map.put("end", end);
		list = getSession().selectList("list", map);
		return list;
	}
	// 원글 삽입
	public static int getInsert(VO vo) {
		int result = 0 ;
		result = getSession().insert("insert", vo);
		ss.commit();
		return result;
	}
	
	// 조회수 업데이트 
	public static int getHit(String idx) {
		int result = 0 ;
		result = getSession().update("hit_up", idx);
		ss.commit();
		return result;
	}
	
	// 상세보기
	public static VO getOneList(String idx) {
		VO vo = new VO();
		vo = getSession().selectOne("onelist", idx);
		return vo;
	}
	
	// 원글 업데이트
	public static int getUpdate(VO vo) {
		int result = 0 ;
		result = getSession().update("update", vo);
		ss.commit();
		return result;
	}
	
	 // 원글 삭제 
	public static int getDelete(String idx) {
		int result = 0;
		result = getSession().delete("delete", idx);
		ss.commit();
		return result;
	}
	
	// 댓글 전 lev 업데이트
	public static int getUp_lev(Map<String, Integer> map) {
		int result = 0 ;
		result = getSession().update("lev_up", map);
		ss.commit();
		return result;
	}
	
	// 댓글 삽입
	public static int getAnsInsert(VO vo) {
		int result = 0 ;
		result = getSession().update("ans_insert", vo);
		ss.commit();
		return result;
	}
	
	// 원글을 삭제하면 전체 댓글 삭제하자
	public static int getDeleteAll(String groups) {
		int result = 0 ;
		result = getSession().delete("delete_all", groups);
		ss.commit();
		return result;
	}
}








