package chess;

import boardgame.Board;
import boardgame.Position;
import chess.pecas.Bispo;
import chess.pecas.Cavalo;
import chess.pecas.Rainha;
import chess.pecas.Rei;
import chess.pecas.Torre;

public class PartidaDeXadrez {
	
	private Board board;
	
	public PartidaDeXadrez() {
		board = new Board(8,8);
		initialSetup();
	}
	
	public PecaDeXadrez[][] getPecas(){
		PecaDeXadrez[][] matriz = new PecaDeXadrez[board.getLinhas()][board.getColunas()];
		
		for (int i=0; i<board.getLinhas(); i++) {
			for(int j=0; j<board.getColunas(); j++) {
				matriz[i][j] = (PecaDeXadrez) board.peca(i, j);
			}
		}
		return matriz;
	}
	
	private void initialSetup() {
		board.placePeca(new Torre(board, Color.WHITE), new Position(7,0));
		board.placePeca(new Torre(board, Color.WHITE), new Position(7,7));
		board.placePeca(new Torre(board, Color.WHITE), new Position(0,0));
		board.placePeca(new Torre(board, Color.WHITE), new Position(0,7));
		board.placePeca(new  Rei(board, Color.BLACK), new Position(0,4));
		board.placePeca(new  Rei(board, Color.WHITE), new Position(7,4));
		board.placePeca(new  Rainha(board, Color.WHITE), new Position(7,3));
		board.placePeca(new  Rainha(board, Color.BLACK), new Position(0,3));
		board.placePeca(new  Bispo(board, Color.WHITE), new Position(7,2));
		board.placePeca(new  Bispo(board, Color.BLACK), new Position(0,2));
		board.placePeca(new  Bispo(board, Color.WHITE), new Position(7,5));
		board.placePeca(new  Bispo(board, Color.BLACK), new Position(0,5));
		board.placePeca(new  Cavalo(board, Color.WHITE), new Position(7,1));
		board.placePeca(new  Cavalo(board, Color.WHITE), new Position(7,6));
		board.placePeca(new  Cavalo(board, Color.BLACK), new Position(0,1));
		board.placePeca(new  Cavalo(board, Color.BLACK), new Position(0,6));
	}

}
