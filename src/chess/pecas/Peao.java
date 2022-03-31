package chess.pecas;

import boardgame.Board;
import boardgame.Position;
import chess.Color;
import chess.PartidaDeXadrez;
import chess.PecaDeXadrez;

public class Peao extends PecaDeXadrez {

	private PartidaDeXadrez partidaDeXadrez;

	public Peao(Board board, Color color, PartidaDeXadrez partidaDeXadrez) {
		super(board, color);
		this.partidaDeXadrez = partidaDeXadrez;

	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] matriz = new boolean[getBoard().getLinhas()][getBoard().getColunas()];

		Position p = new Position(0, 0);
		if (getColor() == Color.WHITE) {

			p.setValues(position.getLinha() - 1, position.getColuna());

			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
				matriz[p.getLinha()][p.getColuna()] = true;
			}
			p.setValues(position.getLinha() - 2, position.getColuna());
			Position p2 = new Position(position.getLinha() - 1, position.getColuna());

			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getBoard().positionExists(p2)
					&& !getBoard().thereIsAPiece(p2) && getMoveCount() == 0) {
				matriz[p.getLinha()][p.getColuna()] = true;
			}
			p.setValues(position.getLinha() - 1, position.getColuna() - 1);

			if (getBoard().positionExists(p) && !isThereOpponentPeca(p)) {
				matriz[p.getLinha()][p.getColuna()] = true;
			}
			p.setValues(position.getLinha() - 1, position.getColuna() + 1);

			if (getBoard().positionExists(p) && !isThereOpponentPeca(p)) {
				matriz[p.getLinha()][p.getColuna()] = true;
			}

			// Especial movimento para pecas brancas
			if (position.getLinha() == 3) {
				Position esquerda = new Position(position.getLinha(), position.getColuna() - 1);

				if (getBoard().positionExists(esquerda) && isThereOpponentPeca(esquerda)
						&& getBoard().peca(esquerda) == partidaDeXadrez.enPassntVunerable())
					;

				matriz[esquerda.getLinha()][esquerda.getColuna()] = true;
			}
			// Especial movimento para pecas brancas
			if (position.getLinha() == 3) {
				Position direita = new Position(position.getLinha(), position.getColuna() + 1);

				if (getBoard().positionExists(direita) && isThereOpponentPeca(direita)
						&& getBoard().peca(direita) == partidaDeXadrez.enPassntVunerable())
					;

				matriz[direita.getLinha()][direita.getColuna()] = true;
			}
		} else {
			p.setValues(position.getLinha() + 1, position.getColuna());

			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
				matriz[p.getLinha()][p.getColuna()] = true;
			}
			p.setValues(position.getLinha() + 2, position.getColuna());
			Position p2 = new Position(position.getLinha() + 1, position.getColuna());

			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getBoard().positionExists(p2)
					&& !getBoard().thereIsAPiece(p2) && getMoveCount() == 0) {
				matriz[p.getLinha()][p.getColuna()] = true;
			}
			p.setValues(position.getLinha() + 1, position.getColuna() - 1);

			if (getBoard().positionExists(p) && !isThereOpponentPeca(p)) {
				matriz[p.getLinha()][p.getColuna()] = true;
			}
			p.setValues(position.getLinha() + 1, position.getColuna() + 1);

			if (getBoard().positionExists(p) && !isThereOpponentPeca(p)) {
				matriz[p.getLinha()][p.getColuna()] = true;
			}
			// Especial movimento para pecas pretas
			if (position.getLinha() == 3) {
				Position esquerda = new Position(position.getLinha(), position.getColuna() - 1);

				if (getBoard().positionExists(esquerda) && isThereOpponentPeca(esquerda)
						&& getBoard().peca(esquerda) == partidaDeXadrez.enPassntVunerable());
					

				matriz[esquerda.getLinha() + 1][esquerda.getColuna()] = true;
			}
			// Especial movimento para pecas pretas
			if (position.getLinha() == 4) {
				Position direita = new Position(position.getLinha(), position.getColuna() + 1);

				if (getBoard().positionExists(direita) && isThereOpponentPeca(direita)
						&& getBoard().peca(direita) == partidaDeXadrez.enPassntVunerable());
					

				matriz[direita.getLinha() + 1][direita.getColuna()] = true;
			}
		}
		return matriz;
	}

	@Override
	public String toString() {
		return "P";
	}

}
