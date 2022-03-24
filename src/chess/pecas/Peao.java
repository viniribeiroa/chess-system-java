package chess.pecas;

import boardgame.Board;
import chess.Color;
import chess.PecaDeXadrez;

public class Peao extends PecaDeXadrez{

	public Peao(Board board, Color color) {
		super(board, color);
		
	}
	@Override
	public String toString() {
		return "P";
	}
	@Override
	public boolean[][] possibleMoves() {
		boolean[][] matriz = new boolean[getBoard().getLinhas()][getBoard().getColunas()];
		return matriz;
	}

}
