package ui;

import model.*;
import controller.OrderController;
import java.util.*;

public class OrderUI
{
	private OrderController oc;
	private Scanner scanner;
	
	public OrderUI()
	{
		oc = new OrderController();
		scanner = new Scanner(System.in);
	}
	
	/**
	 * Menuen som bruges til at komme ind til ordremenuen
	 */
	public void menu()
	{
		printMenu();
		boolean moveOn = true;
		while (moveOn) {
			String input = scanner.nextLine();
			switch (input)
			{
			case "1":
				newOrder();
				break;
			case "2":
				System.out.println("Fejl! - Ikke implementeret");
				break;
			case "3":
				moveOn = false;
				break;
			default:
				System.out.println("Du skal trykke 1");

			}
		}
	}
	public void orderMenu()
	{
		boolean moveOn = true;
		while (moveOn) {
			printOrderMenu();
			String input = scanner.nextLine();
			switch (input) {
			case "1":
				addProduct();
				break;
			case "2":
				addMember();
				break;
			case "3":
				printLines();
				break;
			case "4":
				moveOn = false;
				System.out.println("Ordrer færdig!");
				printLines();
				oc.finishOrder();
				printMenu();
				break;
			default:
				System.out.println("Mulighed findes ikke!");
				
			}
		}
	}
	
	/**
	 * Printer hovedmenuen til OrderUI
	 */
	public void printMenu()
	{
		System.out.println(" Ordre Menu ");
		System.out.println("1: Ny Ordre");
		System.out.println("2: Se Ordrer");
		System.out.println("3. Gå tibage");
	}
	
	/**
	 * Printer Ordremenuen
	 */
	public void printOrderMenu()
	{
		System.out.println(" Ordre Menu ");
		System.out.println("1. Tilføj et produkt");
		System.out.println("2. Tilføj en kunde");
		System.out.println("3. Se produkter");
		System.out.println("4. Bekræft ordre");
	}
	/**
	 * Sender brugeren videre til ordre-menuen
	 */
	public void newOrder()
	{
		oc.createOrder();
		orderMenu();
	}
	public void addMember()
	{
		boolean moveOn = true;
		while (moveOn) {
			System.out.println("Kundens email?");
			String email = scanner.nextLine();
			Member m = oc.addMember(email);
			if (m != null) {
				moveOn = false;
			} else {
				System.out.println("Ingen kunde fundet med denne email.");
			}
		}
	}
	/**
	 * Tilføj et produkt til ordren
	 */
	public void addProduct() {
	    while (true) {
	        System.out.println("Indtast stregkode:");
	        String barcode = scanner.nextLine();
	        System.out.println("Indtast antal:");
	        String quantity = scanner.nextLine();

	        try {
	            int barcodeInt = Integer.parseInt(barcode);
	            int quantityInt = Integer.parseInt(quantity);
	            OrderLine oL = oc.addProduct(barcodeInt, quantityInt);
	            if (oL != null) {
	                System.out.println("Produktet er tilføjet!");
	            } else {
	                System.out.println("Produkt ikke fundet!");
	            }
	            break;
	        } catch (NumberFormatException e) {
	            System.out.println("Fejl!!");
	        }
	    }
	}
	public void printLines()
	{
		for (OrderLine ol : oc.getOrderLines()) {
			System.out.println("Navn på produkt: " + ol.getProduct().getName() + " Mængde: " + ol.getQuantity() + " Pris: " + ol.getPrice());		
		}
		System.out.println("Total pris: " + oc.getTotalCost());
	}
}
