package fr.tete0148.game2048.actions;

import fr.tete0148.game2048.Game;
import fr.tete0148.game2048.IntMatrice;

public final class DownAction {
	
	public static void process(Game game) 
	{
		IntMatrice cells = game.getCells();
		
		for(int c = 0; c<cells.getY(); c++){
			int[] col = cells.getCol(c);
			for(int i=col.length-2;i>=0;i--){
				
				if(col[i+1] == col[i]) {
					col[i+1] *= 2;
					col[i] = 0;
				} else if(i>0&&col[i-1]==col[i]){
					col[i-1]*=2;
					col[i]=0;
				}
				
				int val = col[i];
				int farthestY = 0;
				for(int ii=0;ii<cells.getY();ii++){
					if(col[ii]==0){
						farthestY = ii;
					}
				}
				if(col[farthestY]==0) {
					col[i] = 0;
					col[farthestY] = val;
				}
			}
			
			cells.setCol(c,col);
		}
		
		game.setCells(cells);
	}

}
