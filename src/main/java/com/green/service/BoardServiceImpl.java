package com.green.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.green.mapper.BoardMapper;
import com.green.vo.BoardVO;


@Service
public class BoardServiceImpl implements BoardService{
	
	@Inject
	private BoardMapper boardMapper;

	@Override
	public List<BoardVO> Faqlist() throws Exception {
		return boardMapper.Faqlist();
	}

	@Override
	public List<BoardVO> FaqlistCategory() throws Exception {
		return boardMapper.FaqlistCategory();
	}

	@Override
	public List<BoardVO> FaqreadTitle(int cno, String keyword) throws Exception {
		return boardMapper.FaqreadTitle(cno, keyword);
	}

	@Override
	public int FaqtotalBnoCount(int cno, String keyword) throws Exception {
		return boardMapper.FaqtotalBnoCount(cno, keyword);
	}

	
	@Override
	public void FaqnewQuestion(String category, int cno, String question, String answer)
			throws Exception {
		boardMapper.FaqnewQuestion(category, cno, question, answer);
		
	}

	@Override
	public void Faqdelete(int cno, int bno) throws Exception {
		boardMapper.Faqdelete(cno, bno);
	}

	@Override
	public BoardVO FaqupdateView(int cno, int bno) throws Exception {
		return boardMapper.FaqupdateView(cno, bno);
	}

	@Override
	public void Faqupdate(int cno, String category, String question, String answer, int bno) throws Exception {
		boardMapper.Faqupdate(cno, category, question, answer, bno);
		
	}

	@Override
	public void Faqreadcount(int cno, int bno) throws Exception {
		boardMapper.Faqreadcount(cno, bno);
	}

	@Override
	public void FaqautoInsert(String category, String question, String answer) throws Exception {
		boardMapper.FaqautoInsert(category, question, answer);
	}

	@Override
	public List<BoardVO> Faqfavorite() throws Exception {
		return boardMapper.Faqfavorite();
	}

	@Override
	public int FaqFavoriteTotalBnoCount(int cno, String keyword) throws Exception {
			return boardMapper.FaqFavoriteTotalBnoCount(cno, keyword); 
	}





}
