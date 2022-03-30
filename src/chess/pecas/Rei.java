package chess.pecas;

import boardgame.Board;
import boardgame.Position;
import chess.Color;
import chess.PartidaDeXadrez;
import chess.PecaDeXadrez;

public class Rei extends PecaDeXadrez {
	private PartidaDeXadrez partidaDeXadrez;

	public Rei(Board board, Color color, PartidaDeXadrez partidaDeXadrez2) {
		super(board, color);
		this.partidaDeXadrez = partidaDeXadrez;

	}

	@Override
	public String toString() {
		return "R";
	}

	private boolean canMove(Position position) {

		PecaDeXadrez p = (PecaDeXadrez) getBoard().peca(position);
		return p == null || p.getColor() != getColor();
	}
	
	private boolean testTorre(Position position) {
		
		PecaDeXadrez p = (PecaDeXadrez)getBoard().peca(position);
		return p != null && p instanceof Torre && p.getColor() == getColor() &&p.getMoveCount() == 0;
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] matriz = new boolean[getBoard().getLinhas()][getBoard().getColunas()];

		Position p = new Position(0, 0);

		// ACIMA
		p.setValues(position.getLinha() - 1, position.getColuna());
		if (getBoard().positionExists(p) && canMove(p)) {
			matriz[p.getLinha()][p.getColuna()] = true;
		}
		// ABAIXO
		p.setValues(position.getLinha() + 1, position.getColuna());
		if (getBoard().positionExists(p) && canMove(p)) {
			matriz[p.getLinha()][p.getColuna()] = true;
		}
		// ESQUERDA
		p.setValues(position.getLinha(), position.getColuna() - 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			matriz[p.getLinha()][p.getColuna()] = true;
		}
		// DIREITA
		p.setValues(position.getLinha(), position.getColuna() + 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			matriz[p.getLinha()][p.getColuna()] = true;
		}
		// DIAGONAL ESQUERDA SUPERIOR
		p.setValues(position.getLinha() - 1, position.getColuna() - 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			matriz[p.getLinha()][p.getColuna()] = true;
		}
		// DIAGONAL ESQUERDA INFERIOR
		p.setValues(position.getLinha() + 1, position.getColuna() - 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			matriz[p.getLinha()][p.getColuna()] = true;
		}
		// DIAGONAL DIREITA SUPERIOR
		p.setValues(position.getLinha() + 1, position.getColuna() + 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			matriz[p.getLinha()][p.getColuna()] = true;
		}
		// DIAGONAL DIREITA INFERIOR
		p.setValues(position.getLinha() + 1, position.getColuna() - 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			matriz[p.getLinha()][p.getColuna()] = true;
		}
		
		// movimentação especial torre
		
		if(getMoveCount() == 0 && !partidaDeXadrez.getCheck()) {
			
			//especial 1
			Position posT1 =new Position(position.getLinha(), position.getColuna() +3);
			if(testTorre(posT1)) {
				Position p1 = new Position(position.getLinha(), position.getColuna() + 1);
				Position p2 = new Position(position.getLinha(), position.getColuna() + 2);
				
				if(getBoard().peca(p1) == null && getBoard().peca(p2) == null) {
					
					matriz[position.getLinha()][position.getColuna() + 2] = true;
				}
			}
			
		}
		// movimentação especial torre lado da rainha
		
				if(getMoveCount() == 0 && !partidaDeXadrez.getCheck()) {
					
					//especial 1
					Position posT1 =new Position(position.getLinha(), position.getColuna() - 4);
					if(testTorre(posT1)) {
						Position p1 = new Position(position.getLinha(), position.getColuna() - 1);
						Position p2 = new Position(position.getLinha(), position.getColuna()  - 2);
						Position p3 = new Position(position.getLinha(), position.getColuna()  - 3);
						
						if(getBoard().peca(p1) == null && getBoard().peca(p2) == null && getBoard().peca(p3) == null) {
							
							matriz[position.getLinha()][position.getColuna() + 2] = true;
						}
					}
					
				}
		
		return matriz;
	}

}
