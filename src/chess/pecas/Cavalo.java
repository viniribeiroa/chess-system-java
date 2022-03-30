package chess.pecas;

import boardgame.Board;
import boardgame.Position;
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
	
	private boolean canMove(Position position) {

		PecaDeXadrez p = (PecaDeXadrez) getBoard().peca(position);
		return p == null || p.getColor() != getColor();
	}
	
	@Override
	public boolean[][] possibleMoves() {
		boolean[][] matriz = new boolean[getBoard().getLinhas()][getBoard().getColunas()];
		Position p = new Position(0, 0);

		
		p.setValues(position.getLinha() - 1, position.getColuna() -2);
		if (getBoard().positionExists(p) && canMove(p)) {
			matriz[p.getLinha()][p.getColuna()] = true;
		}
		
		p.setValues(position.getLinha() + 1, position.getColuna() +2);
		if (getBoard().positionExists(p) && canMove(p)) {
			matriz[p.getLinha()][p.getColuna()] = true;
		}
		
		p.setValues(position.getLinha() -2, position.getColuna() - 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			matriz[p.getLinha()][p.getColuna()] = true;
		}
		
		p.setValues(position.getLinha() +2, position.getColuna() + 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			matriz[p.getLinha()][p.getColuna()] = true;
		}
		
		p.setValues(position.getLinha() - 1, position.getColuna() + 2);
		if (getBoard().positionExists(p) && canMove(p)) {
			matriz[p.getLinha()][p.getColuna()] = true;
		}
		
		p.setValues(position.getLinha() + 1, position.getColuna() -2);
		if (getBoard().positionExists(p) && canMove(p)) {
			matriz[p.getLinha()][p.getColuna()] = true;
		}
		
		p.setValues(position.getLinha() + 2, position.getColuna() - 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			matriz[p.getLinha()][p.getColuna()] = true;
		}
		
		p.setValues(position.getLinha() - 2, position.getColuna() + 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			matriz[p.getLinha()][p.getColuna()] = true;
		}
		return matriz;
	}

}
