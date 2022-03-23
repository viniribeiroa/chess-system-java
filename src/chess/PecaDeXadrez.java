package chess;

import boardgame.Board;
import boardgame.Peca;

public class PecaDeXadrez extends Peca {
	
	private Color color;

	public PecaDeXadrez(Board board, Color color) {
		super(board);
		this.color = color;
	}

	public Color getColor() {
		return color;
	}
	
	

}
