package com.visithraa23.queueExample;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class HospitalQueue {
	static List<Patient> listComplete = new ArrayList<>();
	static Queue<Patient> patientQueue = new LinkedList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input;

		HospitalQueue hospitalQueue = new HospitalQueue();
		hospitalQueue.patientList();

		do {
			System.out.println("\nEnter the input");
			System.out.println(
					"1.Add Patient Details \n2.print waiting patients \n3.Medical Examination completed peoples\n0.exit");
			input = sc.nextInt();

			switch (input) {
			case 1:
				System.out.println("\nEnter the Patient name");
				String name = sc.next();
				System.out.println("Enter the Patient age");
				int age = sc.nextInt();
				// sc.nextLine();
				Patient patient = new Patient(name, age);
				patientQueue.add(patient);
				break;
			case 2:
				if (patientQueue.isEmpty())
					System.out.println("No patients are waiting...");
				else
					System.out.println("Patient waiting list:\n" + patientQueue);
				break;
			case 3:
				medicalCompleted();
				break;
			case 0:
				return;
			default:
				System.out.println("Invalid input");
				break;
			}
		} while (input != 0);
		System.out.println();
		sc.close();
	}

	private static void medicalCompleted() {
		System.out.println("\nMedical Examination completed for:");
		for (Patient li : listComplete) {
			System.out.println(li);
		}
	}

	private void patientList() {
		ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

		scheduler.scheduleAtFixedRate(() -> {
			if (!patientQueue.isEmpty()) {
				Patient patient = patientQueue.poll();
				listComplete.add(patient);
				}
		}, 0, 15, TimeUnit.SECONDS);
	}
}

class Patient {
	private String name;
	private int age;

	Patient(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String toString() {
		return "name = " + name + " : age = " + age ;
	}
}