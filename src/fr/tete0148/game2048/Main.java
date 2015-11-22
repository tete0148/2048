package fr.tete0148.game2048;

import java.io.IOException;

public class Main {
	
	public static void main(String[] args)
	{
		Game game = new Game();
		try {
			game.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
