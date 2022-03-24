package chess;

import boardgame.Board;
import boardgame.Peca;
import boardgame.Position;

public abstract class PecaDeXadrez extends Peca {
	
	private Color color;

	public PecaDeXadrez(Board board, Color color) {
		super(board);
		this.color = color;
	}

	public Color getColor() {
		return color;
	}
	
	protected boolean isThereOpponentPeca(Position position) {
		PecaDeXadrez p = (PecaDeXadrez) getBoard().peca(position);
		return p != null && p.getColor() != color;
	}
	
	

}
