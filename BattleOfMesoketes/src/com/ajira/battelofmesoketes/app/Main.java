package com.ajira.battelofmesoketes.app;

import java.io.InputStream;
import java.util.Scanner;

import com.ajira.battelofmesoketes.battle.Battle;

public class Main {
	public static void main(String[] args) {
		System.out.println("Enter the battel data");
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();

		Battle battle = new Battle();
		battle.start(input);
	}
}
