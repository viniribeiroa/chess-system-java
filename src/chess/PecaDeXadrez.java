package chess;

import boardgame.Board;
import boardgame.Peca;
import boardgame.Position;

public abstract class PecaDeXadrez extends Peca {
	
	private Color color;
	private int moveCount;

	public PecaDeXadrez(Board board, Color color) {
		super(board);
		this.color = color;
	}

	public Color getColor() {
		return color;
	}
	
	public int getMoveCount() {
		return moveCount;
	}
	
	public void increaseMoveCount() {
		moveCount++;
	}
	public void decreaseMoveCount() {
		moveCount--;
	}
	
	public ChessPosition getChessPosition() {
		return ChessPosition.fromPosition(position);
	}
	
	protected boolean isThereOpponentPeca(Position position) {
		PecaDeXadrez p = (PecaDeXadrez) getBoard().peca(position);
		return p != null && p.getColor() != color;
	}
	
	

}
