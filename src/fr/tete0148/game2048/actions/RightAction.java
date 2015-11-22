package fr.tete0148.game2048.actions;

import fr.tete0148.game2048.Game;
import fr.tete0148.game2048.IntMatrice;

public final class RightAction {
	
	public static void process(Game game) 
	{
		IntMatrice cells = game.getCells();
		
		for(int r = 0; r<cells.getX(); r++){
			int[] row = cells.getRow(r);
			for(int i=row.length-2;i>=0;i--){
				
				if(row[i+1] == row[i]) {
					row[i+1] *= 2;
					row[i] = 0;
				} else if(i>0&&row[i-1]==row[i]){
					row[i-1]*=2;
					row[i]=0;
				}
				
				int val = row[i];
				int farthestX = 0;
				for(int ii=0;ii<cells.getY();ii++){
					if(row[ii]==0){
						farthestX = ii;
					}
				}
				if(row[farthestX]==0) {
					row[i] = 0;
					row[farthestX] = val;
				}
			}
			
			cells.setRow(r,row);
		}
		
		game.setCells(cells);
	}
}
