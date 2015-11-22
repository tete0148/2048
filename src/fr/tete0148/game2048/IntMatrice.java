package fr.tete0148.game2048;

import java.util.ArrayList;

public class IntMatrice {
	
	private int x = 0;
	private int y = 0;
	private int[] values = null;
	
	/**
	 * Constructeur qui crée un tableau de taille dépendant des arguments
	 * 
	 * @param int x
	 * @param int y
	 */
	public IntMatrice(int x, int y)
	{
		this.x = x;
		this.y = y;
		this.values = new int[x*y];
	}
	
	/**
	 * Retourne la valeur de la matrice correspondant aux coordonnées entrées
	 * 
	 * @param x
	 * @param y
	 * @return Integer
	 */
	public int get(int x, int y)
	{
		int index = x + (y*this.x);
		return this.values[index];
	}
	
	public int get(int index)
	{
		return this.values[index];
	}
	
	public IntMatrice set(int x, int y, int value)
	{
		this.values[x+(y*this.x)] = value;
		
		return IntMatrice.this;
	}
	
	public IntMatrice set(int index, int value)
	{
		this.values[index] = value;
		
		return IntMatrice.this;
	}
	
	public int[] getRow(int y)
	{
		int[] row = new int[this.getX()];
		for(int i=0;i<this.getX();i++) {
			row[i] = this.values[i+y*this.getX()];
		}
		
		return row;
	}
	
	public IntMatrice setRow(int y, int[] row)
	{
		for(int i = 0; i<this.getX();i++){
			this.values[i+y*this.getX()] = row[i];
		}
		
		return IntMatrice.this;
	}
	
	public int[] getCol(int x)
	{
		int[] col = new int[getY()];
		for(int i=0;i<getY();i++){
			col[i] = this.values[x+this.getX()*i];
		}
		
		return col;
	}
	
	public IntMatrice setCol(int x, int[] col)
	{
		for(int i=0;i<this.getY();i++){
			this.values[x+this.getX()*i] = col[i];
		}
		
		return IntMatrice.this;
	}
	
	public int[] getEmptyIndexes()
	{
		ArrayList<Integer> indexes= new ArrayList<>();
		for(int i = 0;i<values.length;i++) {
			if(values[i] == 0) {
				indexes.add(i);
			}
		}
		int[] ind = new int[indexes.size()];
		for(int i=0;i<ind.length;i++){
			ind[i]=indexes.get(i);
		}
		
		return ind;
	}
	
	public int getSize()
	{
		return this.values.length;
	}
	
	public int[] getValues()
	{
		return this.values;
	}
	
	public int getX()
	{
		return this.x;
	}
	
	public int getY()
	{
		return this.y;
	}
}
