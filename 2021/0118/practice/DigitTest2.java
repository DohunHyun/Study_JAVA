package com.ssafy.ws01.step3;

public class DigitTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 1;
		
		for(int i=0; i<5; i++) {
			int k;
			if(i > 2) {
				k = 4-i;
			} else {
				k = i;
			}
			for(int b = k; b>0; b--) {
				System.out.print("   ");
			}
			for(int j=5-2*k; j>0; j--) {
				System.out.printf("%3d", num++);
			}
			
			System.out.println();
		}
	}

}
