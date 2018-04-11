package pack.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pack.model.DataInter;
import pack.model.GogekDto;
import pack.model.SawonDto;

@Controller
public class SangpumController {
	@Autowired
	private DataInter inter;

	@RequestMapping("sawon")
	@ResponseBody
	public Map<String, Object> sawonList(@RequestParam("buser_name")String buser_name){
		List<Map<String,String>> dataList = new ArrayList<Map<String,String>>();
		Map<String, String> data = null;
		
		List<SawonDto> sawonList = inter.sawonList(buser_name);
		if(sawonList.size()==0) {
			return null;
		}
		for(SawonDto d:sawonList) {
			data = new HashMap<String,String>();
			data.put("sawon_no", d.getSawon_no());
			data.put("sawon_name", d.getSawon_name());
			data.put("buser_tel", d.getBuser_tel());
			data.put("sawon_jik", d.getSawon_jik());
			data.put("gogek_ct", d.getGogek_ct());
			dataList.add(data);
		}
		Map<String, Object> sawonDatas = new HashMap<String,Object>();
		sawonDatas.put("datas", dataList);
		
		return sawonDatas;
	}
	
	@RequestMapping("gogek")
	@ResponseBody
	public Map<String, Object> gogekList(@RequestParam("sawon_no")String sawon_no){
		List<Map<String,String>> dataList = new ArrayList<Map<String,String>>();
		Map<String, String> data = null;
		
		List<GogekDto> gogekList = inter.gogekList(sawon_no);
		if(gogekList.size()==0) {
			return null;
		}
		for(GogekDto d:gogekList) {
			data = new HashMap<String,String>();
			data.put("gogek_no", d.getGogek_no());
			data.put("gogek_name", d.getGogek_name());
			data.put("gogek_tel", d.getGogek_tel());
			data.put("gogek_jumin", d.getGogek_jumin());
			dataList.add(data);
		}
		Map<String, Object> gogekDatas = new HashMap<String,Object>();
		gogekDatas.put("datas", dataList);
	
		return gogekDatas;
	}
}
