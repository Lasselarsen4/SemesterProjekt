package ui;

import model.*;
import java.util.Scanner;

public class MainMenu {
	private Scanner scanner;
	private OrderUI orderui;
	@SuppressWarnings("unused")
	private TryMe tryme;
	@SuppressWarnings("unused")
	private User user;
	
	public MainMenu()
	{
		scanner = new Scanner(System.in);
		orderui = new OrderUI();
		tryme = new TryMe();
	}
	
	public void start()
	{
		boolean moveOn = true;
		while (moveOn) {
			mainMenu();
			String input = scanner.nextLine();
			switch (input) {
			case "1":
				orderui.menu();
				break;
			}
		}
	}
	
	private void mainMenu()
	{
		System.out.println("Hovedmenu");
		System.out.println("1. Ordre menu");
	}

}
