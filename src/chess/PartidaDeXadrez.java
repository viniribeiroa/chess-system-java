package chess;

import boardgame.Board;

public class PartidaDeXadrez {
	
	private Board board;
	
	public PartidaDeXadrez() {
		board = new Board(8,8);
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

}
