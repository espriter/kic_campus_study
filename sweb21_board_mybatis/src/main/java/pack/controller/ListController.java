package pack.controller;



import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.BoardDaoInter;
import pack.model.BoardDto;

@Controller
public class ListController {
	
	@Autowired
	private BoardDaoInter inter;
	
	private int tot; // 전체 레코드수
	private int plist = 5; // 페이지 당 레코드 수
	private int pageSu; //전체 페이지 수
	
	//한 화면에 보여줄 목록
	public ArrayList<BoardDto> getList(
			ArrayList<BoardDto> list, int page){
		ArrayList<BoardDto> result = new ArrayList<>();
		int start = (page -1) * plist; //0,5,10...
		int size = plist <= list.size() - start?plist:list.size() - start;
		
		for(int i = 0; i < size; i++) {
			result.add(i, list.get(start + i));
		}
		return result;
	}
	
	public int getPageSu() { // 총 페이지 수
		pageSu = tot / plist;
		if(tot % plist > 0) pageSu += 1;
		return pageSu;
		
	}

	
	@RequestMapping("list")
	public Model process(Model model, @RequestParam("page")int page) {
		tot = inter.totalCnt(); // 전체 레코드 수
		
		ArrayList<BoardDto> list = inter.getList();
		ArrayList<BoardDto> result = getList(list, page);		
		//System.out.println("result " + result.size());
		
		//model.addAttribute("data", list); paging x
		
		//paging 0
		model.addAttribute("data", result);
		model.addAttribute("pagesu", getPageSu());
		model.addAttribute("page", page);
		
		return model;
	}
}
