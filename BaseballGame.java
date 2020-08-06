package baseball;
import java.util.*;
public class BaseballGame {
	public static int point;
	public static void main(String[] args) {
		ArrayList number = new ArrayList();
		while(true) {
			int a = (int)(Math.random()*10);
			if(!number.contains(a)) {
				number.add(a);
			}
			if(number.size()==3) {
				break;
			}
		}//while
		
		System.out.println("-------------룰 설명-------------");
		System.out.println("0~9까지 서로 다른 3개의 숫자가 생성됩니다.");
		System.out.println("숫자와 자리가 모두 같으면 S");
		System.out.println("숫자는 같고 자리는 다르면 B");
		System.out.println("숫자와 자리 모두 틀리면 O이 표시됩니다.");
		System.out.println("-------------------------------");
		System.out.println("숫자가 생성되었습니다.");
		Scanner s = new Scanner(System.in);
		
		while(true) {
			System.out.println("정답을 입력해주세요.");
			System.out.print(">");
			int str = s.nextInt();
			ArrayList answer = new ArrayList();
			answer.add(str/100);
			answer.add((str-(str/100)*100)/10);
			answer.add(str-(str/10)*10);
			System.out.println(answer);
			BaseballGame.setPoint(answer, number);
			BaseballGame.getCount(BaseballGame.point);
//			System.out.println(BaseballGame.point);
			if(!number.equals(answer)) {
				System.out.println("틀렸습니다.");
				continue;
			}//if
			else {
				System.out.println("정답입니다.");						
					break;
			}//else
		}//while
		
	}//main

		
	public static void setPoint(ArrayList a, ArrayList b) {	
		BaseballGame.point = 0;
		for (int i = 0 ; i < b.size() ; i++) {
			if(a.get(i)==b.get(i)) {
				BaseballGame.point += 5;
			} else if(a.get(i)==b.get(0)||a.get(i)==b.get(1)||a.get(i)==b.get(2)){
				BaseballGame.point += 1;
			} else {
				BaseballGame.point += 0;
			}
		}
	}
		
	public static void getCount(int x) {
		switch(x) {
			case 15:
				System.out.println("3S");
				break;
			case 11:
				System.out.println("2S1B");
				break;
			case 10:
				System.out.println("2S1O");
				break;
			case 7:
				System.out.println("1S2B");
				break;
			case 6:
				System.out.println("1S1B1O");
				break;
			case 5:
				System.out.println("1S2O");
				break;
			case 3:
				System.out.println("3B");
				break;
			case 2:
				System.out.println("2B1O");
				break;
			case 1:
				System.out.println("1B2O");
				break;
			default:
				System.out.println("3O");
				break;
		}
	}
}
			/*
			S = 5 / B = 1 / O = 0
			3S=15 2S1B=11 2S1O=10 1S2B=7 1S1B1O=6 1S2O=5
			3B=3 2B1O=2 1B2O=1 3O=0
			*/
	