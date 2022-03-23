package chess.pecas;

import boardgame.Board;
import chess.Color;
import chess.PecaDeXadrez;

public class Rei extends PecaDeXadrez{

	public Rei(Board board, Color color) {
		super(board, color);
		
	}
	
	@Override
	public String toString() {
		return "R";
	}

}
