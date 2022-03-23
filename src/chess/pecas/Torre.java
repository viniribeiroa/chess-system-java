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

}
