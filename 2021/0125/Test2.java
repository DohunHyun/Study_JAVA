import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int teamNum = sc.nextInt();
		
		for(int teamCycle=0; teamCycle<teamNum; teamCycle++) {
			int member = sc.nextInt();
			int[] score = new int[member];
			int total = 0;
			for(int i=0; i<member; i++) {
				score[i] = sc.nextInt();
				total += score[i];
			}
			double average = total/member;
			
			int count=0; //평균 넘는 학생수 
			for(int i=0; i<member; i++) {
				if(score[i] > average) {
					count++;
				}
			}
			double percent = ((double)count/(double)member)*100;
			System.out.printf("#%d %.3f", (teamCycle+1), percent);
			System.out.println("%");
		
		}
	}
	
}