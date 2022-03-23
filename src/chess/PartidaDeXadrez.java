package chess;

import boardgame.Board;

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
	
	private void placeNewPiece(char coluna, int linha, PecaDeXadrez peca) {
		board.placePeca(peca, new ChessPosition(coluna, linha).toPosition());
	}
	
	private void initialSetup() {
		placeNewPiece('a', 1, new Torre(board, Color.WHITE));
		placeNewPiece('h', 1, new Torre(board, Color.WHITE));
		placeNewPiece('h', 8, new Torre(board, Color.BLACK)); 
		placeNewPiece('a', 8, new Torre(board, Color.BLACK)); 
		placeNewPiece('e', 8, new  Rei(board, Color.BLACK));
		placeNewPiece('e', 1, new  Rei(board, Color.WHITE));
		placeNewPiece('d', 1, new  Rainha(board, Color.WHITE)); 
		placeNewPiece('d', 8, new  Rainha(board, Color.BLACK)); 
		placeNewPiece('c', 1, new  Bispo(board, Color.WHITE)); 
		placeNewPiece('c', 8, new  Bispo(board, Color.BLACK));
		placeNewPiece('f', 1, new  Bispo(board, Color.WHITE)); 
		placeNewPiece('f', 8, new  Bispo(board, Color.BLACK));
		placeNewPiece('b', 1, new  Cavalo(board, Color.WHITE));
		placeNewPiece('g', 1, new  Cavalo(board, Color.WHITE)); 
		placeNewPiece('b', 8, new  Cavalo(board, Color.WHITE));
		placeNewPiece('g', 8, new  Cavalo(board, Color.WHITE)); 

	}	
}
