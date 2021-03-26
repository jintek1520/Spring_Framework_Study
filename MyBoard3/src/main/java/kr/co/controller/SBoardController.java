package kr.co.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.domain.BoardVO;
import kr.co.domain.SearchPageTO;
import kr.co.service.BoardService;
import kr.co.service.SBoardService;

@Controller
@RequestMapping("/sboard")
public class SBoardController {
	
	@Inject
	private SBoardService sBoardService;
	
	@Inject
	private BoardService boardService;
	
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(BoardVO vo, SearchPageTO spt, Model model){
		boardService.update(vo);
		//new String(spt.getKeyword().getBytes("UTF-8"), "8859_1");
		//한글 나오게 하려고, 이렇게 안 하면 한글이 안 나옴
		model.addAttribute("searchType", spt.getSearchType());
		model.addAttribute("keyword", spt.getKeyword());
		model.addAttribute("curPage", spt.getCurPage());
		
		return "redirect:/sboard/read/"+vo.getBno();
	}
	
	
	@RequestMapping(value = "/update/{bno}", method = RequestMethod.GET)
	public String update(@PathVariable("bno") int bno, Model model) {
		BoardVO vo = sBoardService.updateUI(bno);
		model.addAttribute("vo", vo);
		
		return "sboard/update";
	}
	
	
	
	@RequestMapping(value = "/read/{bno}", method = RequestMethod.GET)
	public String read(@PathVariable("bno") int bno, SearchPageTO spt, Model model) {
		
		BoardVO vo = sBoardService.read(bno);
		model.addAttribute("vo", vo);
		model.addAttribute("spt", spt);
		return "sboard/read";
	}
	
	
	
	
	
	
	
	
	@RequestMapping(value = "/list/{searchType}/{keyword}/{curPage}", method=RequestMethod.GET)
	public String list(@PathVariable("searchType") String searchType,
			@PathVariable("keyword") String keyword,
			@PathVariable("curPage") int curPage,
			Model model) {
		
		SearchPageTO spt = new SearchPageTO(searchType, keyword, curPage);
		Integer amount = sBoardService.getAmount(spt);
		if(amount == null) {
			amount = 0;
		}
		spt.setAmount(amount);
		
		List<BoardVO> list = sBoardService.list(spt);
		spt.setList(list);
		
		model.addAttribute("spt", spt);
		
		
		return "sboard/list";
	}



}
