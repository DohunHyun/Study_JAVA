package com.java.first;

import java.util.Scanner;

public class CheckPoint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int height = sc.nextInt();
		int weight = sc.nextInt();
		int x = weight + 100 - height;
		System.out.println("비만수치는 " + x + "입니다. ");
		if(x > 0) {
			System.out.println("당신은 비만이군요.");			
		}else {
			System.out.println("당신은 비만이 아닙니다.");
		
		}
	}

}
