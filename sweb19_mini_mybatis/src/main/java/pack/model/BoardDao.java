package pack.model;

	import java.util.ArrayList;
	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Repository;

	import pack.controller.BoardBean;

	@Repository
	public class BoardDao implements BoardInter{
		
		@Autowired
		private BoardAnnoInter boardAnnoInter;
		
		public List<BoardDto> list() {
			ArrayList<BoardDto> list = (ArrayList<BoardDto>)boardAnnoInter.selectAllData();
			return list;
		}
		
		public List<BoardDto> search(String name, String value) {
			ArrayList<BoardDto> list = (ArrayList<BoardDto>)annoInter.search(name,value);
			return list;
		}
		
		public boolean writeData(BoardBean bean) {
			boolean b = annoInter.writeData(bean);
			return b;
		}
		
		public BoardDto detail(String num) {
			BoardDto dto = annoInter.detail(num);
			return dto;
		}
		
		public boolean update(BoardBean bean) {
			boolean b = annoInter.update(bean);
			return b;
		}
		
		public boolean delete(String num) {
			boolean b = annoInter.delete(num);
			return b;
		}
		
		public void count(String num) {
			annoInter.count(num);
		}

	}

	
	
	
	
	
}





