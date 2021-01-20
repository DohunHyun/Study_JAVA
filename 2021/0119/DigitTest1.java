package com.ssafy.algo;

import java.util.Scanner;

public class DigitTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] inputArray;
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		String [] inputSentence = input.split(" ");
		inputArray = new int[inputSentence.length-1];
		int[] checkArray = new int[10];
		
		for(int k=0; k<inputArray.length; k++) {
			inputArray[k] = Integer.parseInt(inputSentence[k]);
		}
		
		for(int j=0; j<inputArray.length; j++) {
			checkArray[inputArray[j]/10]++;
		}
		
		for(int i=0; i<checkArray.length; i++) {
			if(checkArray[i] > 0) {
				System.out.println(i + " : " + checkArray[i] + "개");
			}
		}
		
	}

}
