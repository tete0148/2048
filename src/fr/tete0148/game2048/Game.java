package fr.tete0148.game2048;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Game {
	
	private Scanner scanner = new Scanner(System.in);
	private Random random   = new Random();
	
	private IntMatrice cells = null;
	private ActionHandler actionHandler = null;
	private boolean running = false;
	
	public void start() throws IOException
	{
		this.cells = new IntMatrice(3,3);
		
		this.actionHandler = new ActionHandler(this);
		
		this.cells.set((random.nextInt(cells.getSize())), 2);
		this.cells.set((random.nextInt(cells.getSize())), 2);
		p("Welcome to 2048 !");
		this.loop();
	}
	
	public IntMatrice getCells()
	{
		return this.cells;
	}
	
	public Game setCells(IntMatrice cells)
	{
		this.cells = cells;
		return Game.this;
	}
	
	private void loop() throws IOException
	{
		this.running = true;
		while(running) {
			this.drawMatrice();
			int action = scanner.nextInt();
			switch(action) {
			case 8:
				actionHandler.handle(Action.UP);
				break;
			case 2:
				actionHandler.handle(Action.DOWN);
				break;
			case 4:
				actionHandler.handle(Action.LEFT);
				break;
			case 5:
				p("Goodbye !");
				this.running = false;
				break;
			case 6:
				actionHandler.handle(Action.RIGHT);
				break;
			}
			
			this.addCell();
		}
		
	}
	
	private void addCell()
	{
		int[] emptyIndexes = cells.getEmptyIndexes();
		if(emptyIndexes.length>0) {
			int index = emptyIndexes[random.nextInt(emptyIndexes.length)];
			if(Math.random()<0.9){
				cells.set(index, 2);
			} else {
				cells.set(index, 4);
			}	
		}
		
	}
	
	
	private void drawMatrice() throws IOException
	{
		this.clear();
		for(int i = 0; i<cells.getY(); i++){
			String line = "";
			for(int ii = 0; ii<cells.getX(); ii++){
				line += "[" + cells.get(ii,i) + "]";
			}
			p(line);
		}
	}
	
	private void clear()
	{
		try {
			  if(System.getProperty("os.name" ).startsWith("Windows" ))
			    Runtime.getRuntime().exec("cls" );
			  else
			    Runtime.getRuntime().exec("clear" );
			} catch(Exception excpt) {
			  for(int i=0;i<100;i++)
			    System.out.println();
			}
	}
	
	private void p(Object str)
	{
		System.out.println(str);
	}
}
