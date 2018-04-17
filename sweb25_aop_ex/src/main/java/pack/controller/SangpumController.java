package pack.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pack.model.DataDto;
import pack.model.DataInter;

@Controller
public class SangpumController {
	
	@Autowired
	private DataInter inter;
	
	@RequestMapping("sangpum")
	@ResponseBody
	public Map<String, Object> abc(){
		List<Map<String, String>> dataList = new ArrayList<Map<String,String>>();
		Map<String, String> data = null;
		
		List<DataDto> sangList = inter.sangpumList();
		
		for(DataDto d:sangList) {
			data = new HashMap<String, String>();
			data.put("code", d.getCode());
			data.put("sang", d.getSang());
			data.put("su", d.getSu());
			data.put("dan", d.getDan());
			dataList.add(data);
		}
		
		Map<String, Object> sangpumDatas = new HashMap<String, Object>();
		sangpumDatas.put("datas", dataList);
		
		return sangpumDatas;
	}
	
}










