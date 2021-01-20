package com.ssafy.ws01.step3;

import java.util.Scanner;

public class GameTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("가위바위보 게임을 시작합니다. 아래 보기 중 하나를 고르세요.");
		System.out.println("1. 5판 3승");
		System.out.println("2. 3판 2승");
		System.out.println("3. 1판 1승");
		System.out.print("번호를 입력하세요. ");

		Scanner sc = new Scanner(System.in);
		int inputNum = sc.nextInt();
		 
		 
		for(int i = inputNum; i>0; i--) {
			System.out.print("가위바위보 중 하나 입력 : ");
			String choice = sc.next();
		}
		 

	}

}
