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

}
