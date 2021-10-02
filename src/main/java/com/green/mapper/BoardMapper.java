package com.green.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.green.vo.BoardVO;


public interface BoardMapper {

	public List<BoardVO> Faqlist() throws Exception;
	
	public List<BoardVO> FaqlistCategory() throws Exception;

	public List<BoardVO> FaqreadTitle(@Param("cno") int cno, @Param("keyword") String keyword) throws Exception;
	
	public int FaqtotalBnoCount(@Param("cno") int cno, @Param("keyword") String keyword) throws Exception;
	
	public int FaqFavoriteTotalBnoCount(@Param("cno") int cno, @Param("keyword") String keyword) throws Exception;
	
	public void FaqnewQuestion(@Param("category") String category, @Param("cno") int cno,
			@Param("question") String question, @Param("answer") String answer) throws Exception;
	
	public void Faqdelete(@Param("cno") int cno, @Param("bno") int bno) throws Exception;
	
	public BoardVO FaqupdateView(@Param("cno") int cno, @Param("bno") int bno) throws Exception;

	public void Faqupdate(@Param("cno") int cno, @Param("name") String name,
			@Param("question") String question, @Param("answer") String answer, @Param("bno") int bno) throws Exception;
	
	public void Faqreadcount(@Param("cno") int cno, @Param("bno") int bno) throws Exception;
	
	public void FaqautoInsert(@Param("name") String name, @Param("question") String question, @Param("answer") String answer) throws Exception;
	
	public List<BoardVO> Faqfavorite() throws Exception;
}
