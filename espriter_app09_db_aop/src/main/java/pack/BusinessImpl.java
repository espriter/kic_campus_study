package pack;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessImpl implements BusinessInter{
	
	@Autowired
	private SawonInter sawonInter;
	
	@Override
	public void dataList() {
		int cou = 0;
		Scanner scanner = new Scanner(System.in);
		System.out.println("부서번호");
		String buser = scanner.nextLine();
		
		for(SawonDto s:sawonInter.selectList()) {
			if(s.getBuser_no().equals(buser)) {
				System.out.println(s.getSawon_no() + " " +
									s.getSawon_name() + " " +
									s.getBuser_name() + " " +
									s. getSawon_jik());		
			}
			cou++;
		}
		System.out.println("인원수:" + cou + "명");
	}
	
}
