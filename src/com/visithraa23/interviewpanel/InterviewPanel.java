package com.visithraa23.interviewpanel;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

import javax.management.Query;


public class InterviewPanel {
	public static void main(String[] args) {
		InterviewPanel interview=new InterviewPanel();
		interview.start();
	}

	private void start() {
		Queue<String> queue=new LinkedList<String>();
		Map<String, Integer> map=new HashMap<>();
		Scanner sc=new Scanner(System.in);
		do {
			System.out.println("\nEnter the input");
			System.out.println(
					"1.Add no of Interviewers \n2.Add Interviewing Candidates \n0.exit");
			int input = sc.nextInt();

			switch (input) {
			case 1:
				System.out.println("\nEnter the Interviewers");
				int n=sc.nextInt();
				break;
			case 2:
				System.out.println("Enter the no of interviewing candidates ");
				int candidate=sc.nextInt();
				for(int i=0;i<candidate;i++) {
					queue.add(sc.next());
				}
				for(int i=0;i<candidate;i++) {
					startinterview1(queue.poll());
					//startinterview2(queue.poll());
				}
				break;
			case 3:
				
				break;
			case 0:
				return;
			default:
				System.out.println("Invalid input");
				break;
			}
		} while (true);
	
	
	}

	private void startinterview1(String string) {
		int score=0;
		String str= "JVM";

		Scanner sc=new Scanner(System.in);
		System.out.println("Why main method is static in java?");
		
		//startInterview2();
	}

	private void startInterview2(Object poll) {
		// TODO Auto-generated method stub
		
	}
}
