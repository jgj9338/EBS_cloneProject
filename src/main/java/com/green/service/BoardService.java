package com.green.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.green.vo.BoardVO;

public interface BoardService {
	
	public List<BoardVO> Faqlist() throws Exception;
	
	public List<BoardVO> FaqlistCategory() throws Exception;

	public List<BoardVO> FaqreadTitle(int cno, String keyword) throws Exception;
	
	public int FaqtotalBnoCount(int cno, String keyword) throws Exception;

	public void FaqnewQuestion(String category, int cno, String question, String answer) throws Exception;
	
	public void Faqdelete(int cno, int bno) throws Exception;
	
	public BoardVO FaqupdateView(int cno, int bno) throws Exception;
	
	public void Faqupdate(int cno, String category, String question, String answer, int bno) throws Exception;
	
	public void Faqreadcount(int cno, int bno) throws Exception;
	
	public void FaqautoInsert(String category, String question, String answer) throws Exception;
	
	public List<BoardVO> Faqfavorite() throws Exception;
	
	public int FaqFavoriteTotalBnoCount(@Param("cno") int cno, @Param("keyword") String keyword) throws Exception;
}
