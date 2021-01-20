package com.ssafy.ws01.step3;

public class DigitTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int num = 1;
		for(int i=5; i>0; i--) {
			for(int k=5-i; k>0; k--) {
				System.out.printf("   ");
			}
			for(int j=i; j>0; j--) {
				System.out.printf("%3d", num++);				
			}
			System.out.println();
			
		}
	}

}
