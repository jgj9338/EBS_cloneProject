package com.green.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.green.mapper.BoardMapper;
import com.green.service.BoardService;
import com.green.vo.BoardVO;


@Controller
@RequestMapping("/board/*")
public class BoardController {

	@Inject
	BoardService service;
	
	@RequestMapping(value="/board/list", method=RequestMethod.GET)
	public String list(Model model, BoardVO vo, String keyword) throws Exception{
		model.addAttribute("listCategory", service.FaqlistCategory());
		if(vo.getCno() != 1000) {
		model.addAttribute("readTitle", service.FaqreadTitle(vo.getCno(), keyword));
		model.addAttribute("totalBnoCount", service.FaqtotalBnoCount(vo.getCno(), keyword));
		} else {
		model.addAttribute("none", "1000");
		model.addAttribute("readTitle", service.Faqfavorite());
		model.addAttribute("totalBnoCount", service.FaqFavoriteTotalBnoCount(vo.getCno(), keyword));
		}
		
		
		
		return "/board/listView";
	}
	
	@RequestMapping(value="/board/list", method=RequestMethod.POST)
	public String lists(Model model, BoardVO vo, String keyword) throws Exception{
		model.addAttribute("listCategory", service.FaqlistCategory());
		if(vo.getCno() != 1000) {
		model.addAttribute("readTitle", service.FaqreadTitle(vo.getCno(), keyword));
		model.addAttribute("totalBnoCount", service.FaqtotalBnoCount(vo.getCno(), keyword));
		} else {
		model.addAttribute("none", "1000");
		model.addAttribute("readTitle", service.Faqfavorite());
		model.addAttribute("totalBnoCount", service.FaqFavoriteTotalBnoCount(vo.getCno(), keyword));
		}
		
		return "/board/listView";
	}
	
	
	
	@RequestMapping(value="/download", method=RequestMethod.GET)
	public void download(HttpServletResponse response) throws Exception{
		try {
        	String path = "D:\\09_10 Java-WebProject_JGJ\\test.txt"; 
        	
        	File file = new File(path);
        	response.setHeader("Content-Disposition", "attachment;filename=" + file.getName()); // 다운로드 되거나 로컬에 저장되는 용도로 쓰이는지를 알려주는 헤더
        	
        	FileInputStream fileInputStream = new FileInputStream(path); // 파일 읽어오기 
        	OutputStream out = response.getOutputStream();
        	
        	int read = 0;
                byte[] buffer = new byte[1024];
                while ((read = fileInputStream.read(buffer)) != -1) { // 1024바이트씩 계속 읽으면서 outputStream에 저장, -1이 나오면 더이상 읽을 파일이 없음
                    out.write(buffer, 0, read);
                }
                
        } catch (Exception e) {
            throw new Exception("download error");
        }	
	}
	
	@RequestMapping(value="/board/newqu", method=RequestMethod.GET)
	public String newquView() throws Exception {
		return "/board/newQuPage";
	}
	
	@RequestMapping(value="/board/newqu", method=RequestMethod.POST)
	public String newqu(BoardVO vo) throws Exception{
		service.FaqnewQuestion(vo.getCategory(), vo.getCno(), vo.getQuestion(), vo.getAnswer());
		int recno = vo.getCno();
		return "redirect:/board/list?cno=" + recno;
	}
	
	@RequestMapping(value="/board/delete", method=RequestMethod.POST)
	public String delete(BoardVO vo) throws Exception{
		service.Faqdelete(vo.getCno(), vo.getBno());
		int recno = vo.getCno();
		return "redirect:/board/list?cno=" + recno;
	}
	
	@RequestMapping(value="/board/update", method=RequestMethod.POST)
	public String updateView(BoardVO vo, Model model) throws Exception{
		model.addAttribute("update", service.FaqupdateView(vo.getCno(), vo.getBno()));
		return "/board/updateView";
	}
	
	@RequestMapping(value="/board/updateQu", method=RequestMethod.POST)
	public String update(BoardVO vo) throws Exception{
		service.Faqupdate(vo.getCno(), vo.getCategory(), vo.getQuestion(), vo.getAnswer(), vo.getBno());
		int recno = vo.getCno();
		return "redirect:/board/list?cno=" + recno;
	}
	
	@ResponseBody
	@RequestMapping(value="/board/readcount", method=RequestMethod.GET)
	public void readcounts(@RequestParam(value="cno") int cno, @RequestParam(value="bno") int bno) throws Exception{
		service.Faqreadcount(cno, bno);
	}
	
}
