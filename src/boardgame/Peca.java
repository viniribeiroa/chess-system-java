package boardgame;

public abstract class Peca {
	
	protected Position position;
	private Board board;
	public Peca(Board board) {
		
		this.board = board;
	}
	protected Board getBoard() {
		return board;
	}
	
	public abstract boolean[][] possibleMoves();
	
	public boolean possibleMove(Position position) {
		return possibleMoves()[position.getLinha()][position.getColuna()];
	}
	
	public boolean isThereAnyPossibleMove() {
		
		boolean[][] matriz = possibleMoves();
		
		for(int i = 0; i < matriz.length; i++) {
			
			for(int j = 0; j < matriz.length; j++) {
				
				if(matriz[i][j]) {
					return true;
				}
			}
		}
		return false;
	}

}
