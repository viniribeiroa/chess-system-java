package chess.pecas;

import boardgame.Board;
import boardgame.Position;
import chess.Color;
import chess.PecaDeXadrez;

public class Rei extends PecaDeXadrez {

	public Rei(Board board, Color color) {
		super(board, color);

	}

	@Override
	public String toString() {
		return "R";
	}

	private boolean canMove(Position position) {

		PecaDeXadrez p = (PecaDeXadrez) getBoard().peca(position);
		return p == null || p.getColor() != getColor();
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
		return matriz;
	}

}
