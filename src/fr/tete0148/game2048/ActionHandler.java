package fr.tete0148.game2048;

import fr.tete0148.game2048.actions.*;

public class ActionHandler {
	
	private Game game = null;
	
	public ActionHandler(Game game)
	{
		this.game = game;
	}
	
	public void handle(Action action)
	{
		if(action.equals(Action.UP)) {
			UpAction.process(this.game);
		} else if(action.equals(Action.DOWN)) {
			DownAction.process(game);
		} else if(action.equals(Action.LEFT)) {
			LeftAction.process(game);
		} else if(action.equals(Action.RIGHT)) {
			RightAction.process(game);
		}
	}

}
