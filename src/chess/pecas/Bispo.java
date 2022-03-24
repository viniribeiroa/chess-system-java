package chess.pecas;

import boardgame.Board;
import chess.Color;
import chess.PecaDeXadrez;

public class Bispo extends PecaDeXadrez{

	public Bispo(Board board, Color color) {
		super(board, color);
		
		
		}
	@Override
	public String toString() {
		return "B";
	}	
	@Override
	public boolean[][] possibleMoves() {
		boolean[][] matriz = new boolean[getBoard().getLinhas()][getBoard().getColunas()];
		return matriz;
	}

}
