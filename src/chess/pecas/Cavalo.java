package chess.pecas;

import boardgame.Board;
import chess.Color;
import chess.PecaDeXadrez;

public class Cavalo extends PecaDeXadrez{

	public Cavalo(Board board, Color color) {
		super(board, color);
		
	}
	
	@Override
	public String toString() {
		return "C";
	}
	@Override
	public boolean[][] possibleMoves() {
		boolean[][] matriz = new boolean[getBoard().getLinhas()][getBoard().getColunas()];
		return matriz;
	}

}
