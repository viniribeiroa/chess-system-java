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

}
