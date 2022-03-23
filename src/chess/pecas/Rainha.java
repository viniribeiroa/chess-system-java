package chess.pecas;

import boardgame.Board;
import chess.Color;
import chess.PecaDeXadrez;

public class Rainha extends PecaDeXadrez{

	public Rainha(Board board, Color color) {
		super(board, color);
		
	}
	
	@Override
	public String toString() {
		return "Q";
	}

}
