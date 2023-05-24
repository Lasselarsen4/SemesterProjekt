package ui;

import model.*;

public class TryMe {
	public static int currentStock = 25;
	public static int minStock = 2;
	public static int maxStock = 40;
	
	public void tryMeData()
	{
		MemberContainer mc = MemberContainer.getInstance();
		ProductContainer pc = ProductContainer.getInstance();
		mc.addMember(new Member(0.0, "Lasse", "Lasse@lasse.dk", "12345678", "Vejnavn 1"));
		BasicProduct hammer = new BasicProduct("Stor hammer", "Hamre");
		hammer.addInfo(149.99, currentStock, minStock, maxStock, "Et sted");
		pc.addProduct(hammer);
		
		BasicProduct boremaskine = new BasicProduct("Boremaskine", "Værktøj");
		boremaskine.addInfo(1299.99, currentStock, minStock, maxStock, "Et sted");
		pc.addProduct(boremaskine);
		
		BasicProduct batteri = new BasicProduct("18V batteri til boremaskine", "Batterier");
		batteri.addInfo(299.99, currentStock, minStock, maxStock, "Et sted");
		pc.addProduct(batteri);
		
		ComplexProduct bMaskinePakke = new ComplexProduct("Boremaskine m. batteri", "En boremaskine, batteri inkl.");
		bMaskinePakke.addProduct(boremaskine, 1);
		bMaskinePakke.addProduct(batteri, 1);
		pc.addProduct(bMaskinePakke);
	}

}