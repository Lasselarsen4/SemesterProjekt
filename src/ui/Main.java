package ui;

public class Main {
	private static MainMenu mainmenu;
	private static TryMe tryme;
	
    public static void main(String[] args) {
    	tryme = new TryMe();
    	mainmenu = new MainMenu();
        tryme.tryMeData();
        mainmenu.start();
    }
}
