package chess.pecas;

import boardgame.Board;
import chess.Color;
import chess.PecaDeXadrez;

public class Torre extends PecaDeXadrez{

	public Torre(Board board, Color color) {
		super(board, color);
		
	}
	
	@Override
	public String toString() {
		return "T";
		
	}
	@Override
	public boolean[][] possibleMoves() {
		boolean[][] matriz = new boolean[getBoard().getLinhas()][getBoard().getColunas()];
		return matriz;
	}

}
