package chess;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import boardgame.Board;
import boardgame.Peca;
import boardgame.Position;
import chess.pecas.Bispo;
import chess.pecas.Cavalo;
import chess.pecas.Peao;
import chess.pecas.Rainha;
import chess.pecas.Rei;
import chess.pecas.Torre;

public class PartidaDeXadrez {

	private int turn;
	private Color currentPlayer;
	private Board board;
	private boolean check;
	private boolean checkMate;
	private PecaDeXadrez enPassantVunerable;

	private List<Peca> pecasNoTabuleiro = new ArrayList<>();
	private List<Peca> pecasCapturadas = new ArrayList<>();

	public PartidaDeXadrez() {
		board = new Board(8, 8);
		turn = 1;
		currentPlayer = Color.WHITE;

		initialSetup();
	}

	public int getTurn() {
		return turn;
	}

	public Color getCurrentPlayer() {
		return currentPlayer;
	}

	public boolean getCheck() {
		return check;
	}

	public boolean getCheckMate() {
		return checkMate;
	}
	public PecaDeXadrez enPassntVunerable() {
		return enPassantVunerable;
	}

	public PecaDeXadrez[][] getPecas() {
		PecaDeXadrez[][] matriz = new PecaDeXadrez[board.getLinhas()][board.getColunas()];

		for (int i = 0; i < board.getLinhas(); i++) {
			for (int j = 0; j < board.getColunas(); j++) {
				matriz[i][j] = (PecaDeXadrez) board.peca(i, j);
			}
		}
		return matriz;
	}

	public boolean[][] possibleMoves(ChessPosition sourcePosition) {
		Position position = sourcePosition.toPosition();
		ValidationSourcePosition(position);
		return board.peca(position).possibleMoves();
	}

	public PecaDeXadrez performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
		Position source = sourcePosition.toPosition();
		Position target = targetPosition.toPosition();

		ValidationSourcePosition(source);
		validationTargetPosition(source, target);
		Peca capturedPeca = makeMove(source, target);

		if (testCheck(currentPlayer)) {
			undoMove(source, target, capturedPeca);

			throw new ChessException("Você não pode se colocar em check");
		}
		
		PecaDeXadrez MovePeca = (PecaDeXadrez)board.peca(target);

		check = (testCheck(opponent(currentPlayer))) ? true : false;

		if (testCheckMate(opponent(currentPlayer))) {
			checkMate = true;
		} else {
			nextTurn();
		}
		
		// especial movimento empassant
		
		if(MovePeca instanceof Peao && (target.getLinha() == source.getLinha() - 2 || target.getLinha() == source.getLinha() + 2)) {
			enPassantVunerable = MovePeca;
		}else {
			enPassantVunerable = null;
		}
		return (PecaDeXadrez) capturedPeca;

	}

	private Peca makeMove(Position source, Position target) {
		PecaDeXadrez p = (PecaDeXadrez) board.removePeca(source);
		p.increaseMoveCount();
		Peca capturadaPeca = board.removePeca(target);
		board.placePeca(p, target);

		if (capturadaPeca != null) {
			pecasNoTabuleiro.remove(capturadaPeca);
			pecasCapturadas.add(capturadaPeca);
		}

		// jogada especial torre

		if (p instanceof Rei && target.getColuna() == source.getColuna() + 2) {
			Position sourceT = new Position(source.getLinha(), source.getColuna() + 3);
			Position targetT = new Position(source.getLinha(), source.getColuna() + 1);

			PecaDeXadrez torre = (PecaDeXadrez) board.removePeca(sourceT);
			board.placePeca(torre, targetT);
			torre.increaseMoveCount();
		}
		// jogada especial torre grande

		if (p instanceof Rei && target.getColuna() == source.getColuna() - 2) {
			Position sourceT = new Position(source.getLinha(), source.getColuna() - 4);
			Position targetT = new Position(source.getLinha(), source.getColuna() - 1);

			PecaDeXadrez torre = (PecaDeXadrez) board.removePeca(sourceT);
			board.placePeca(torre, targetT);
			torre.increaseMoveCount();
		}
		// especial movimento enpassant
		if(p instanceof Peao) {
			if(source.getColuna() != target.getColuna() && capturadaPeca == null) {
				Position peaoPosition;
				if(p.getColor() == Color.WHITE) {
					peaoPosition = new Position(target.getLinha() +1, target.getColuna());
				}else {
					peaoPosition = new Position(target.getLinha() -1, target.getColuna());
				}
				
				capturadaPeca = board.removePeca(peaoPosition);
				pecasCapturadas.add(capturadaPeca);
				pecasNoTabuleiro.remove(capturadaPeca);
				
			}
		}
		return capturadaPeca;
	}

	private void undoMove(Position source, Position target, Peca capturadaPeca) {

		PecaDeXadrez p = (PecaDeXadrez) board.removePeca(target);
		p.decreaseMoveCount();
		board.placePeca(p, source);

		if (capturadaPeca != null) {
			board.placePeca(capturadaPeca, target);
			pecasCapturadas.remove(capturadaPeca);
			pecasNoTabuleiro.add(capturadaPeca);

		}

		// jogada especial torre

		if (p instanceof Rei && target.getColuna() == source.getColuna() + 2) {
			Position sourceT = new Position(source.getLinha(), source.getColuna() + 3);
			Position targetT = new Position(source.getLinha(), source.getColuna() + 1);

			PecaDeXadrez torre = (PecaDeXadrez) board.removePeca(targetT);
			board.placePeca(torre, sourceT);
			torre.decreaseMoveCount();
		}
		// jogada especial torre grande

		if (p instanceof Rei && target.getColuna() == source.getColuna() - 2) {
			Position sourceT = new Position(source.getLinha(), source.getColuna() - 4);
			Position targetT = new Position(source.getLinha(), source.getColuna() - 1);

			PecaDeXadrez torre = (PecaDeXadrez) board.removePeca(targetT);
			board.placePeca(torre, sourceT);
			torre.decreaseMoveCount();
		}
		
		// especial movimento enpassant
				if(p instanceof Peao) {
					if(source.getColuna() != target.getColuna() && capturadaPeca == enPassantVunerable) {
						
						PecaDeXadrez peao = (PecaDeXadrez)board.removePeca(target);
						Position peaoPosition;
						if(p.getColor() == Color.WHITE) {
							peaoPosition = new Position(3, target.getColuna());
						}else {
							peaoPosition = new Position(4, target.getColuna());
						}
						
						board.placePeca(peao, peaoPosition);
						
						capturadaPeca = board.removePeca(peaoPosition);
						pecasCapturadas.add(capturadaPeca);
						pecasNoTabuleiro.remove(capturadaPeca);
						
					}
				}
	}

	private void ValidationSourcePosition(Position position) {
		if (!board.thereIsAPiece(position)) {
			throw new ChessException("Posição não existe");
		}
		if (currentPlayer != ((PecaDeXadrez) board.peca(position)).getColor()) {
			throw new ChessException("é a vez de seu oponente");
		}
		if (board.peca(position).isThereAnyPossibleMove()) {
			throw new ChessException("não exite movimento possiveis para a peça escolhida");
		}
	}

	private void validationTargetPosition(Position source, Position target) {

		if (!board.peca(source).possibleMove(target)) {
			throw new ChessException("A peça não pode se mexer para a possição escohida");
		}
	}

	private void nextTurn() {

		turn++;
		currentPlayer = (currentPlayer == Color.WHITE) ? Color.BLACK : Color.WHITE;
	}

	private Color opponent(Color color) {
		return (color == Color.WHITE) ? Color.BLACK : Color.WHITE;
	}

	private PecaDeXadrez Rei(Color color) {
		List<Peca> list = pecasNoTabuleiro.stream().filter(x -> ((PecaDeXadrez) x).getColor() == color)
				.collect(Collectors.toList());

		for (Peca p : list) {
			if (p instanceof Rei) {
				return (PecaDeXadrez) p;
			}
		}
		throw new IllegalStateException("não existe o rei" + color + "no tabuleiro");
	}

	private boolean testCheck(Color color) {

		Position reiPosition = Rei(color).getChessPosition().toPosition();
		List<Peca> opponentPecas = pecasNoTabuleiro.stream()
				.filter(x -> ((PecaDeXadrez) x).getColor() == opponent(color)).collect(Collectors.toList());
		for (Peca p : opponentPecas) {

			boolean[][] matriz = p.possibleMoves();
			if (matriz[reiPosition.getLinha()][reiPosition.getColuna()]) {
				return true;
			}
		}
		return false;
	}

	private boolean testCheckMate(Color color) {
		if (!testCheck(color)) {
			return false;
		}
		List<Peca> list = pecasNoTabuleiro.stream().filter(x -> ((PecaDeXadrez) x).getColor() == color)
				.collect(Collectors.toList());
		for (Peca p : list) {
			boolean[][] matriz = p.possibleMoves();
			for (int i = 0; i < board.getLinhas(); i++) {
				for (int j = 0; j < board.getColunas(); j++) {
					if (matriz[i][j]) {
						Position source = ((PecaDeXadrez) p).getChessPosition().toPosition();
						Position target = new Position(i, j);
						Peca pecaCapturada = makeMove(source, target);
						boolean testCheck = testCheck(color);
						undoMove(source, target, pecaCapturada);
						if (!testCheck) {
							return false;
						}
					}
				}
			}
		}
		return true;

	}

	private void placeNewPiece(char coluna, int linha, PecaDeXadrez peca) {
		board.placePeca(peca, new ChessPosition(coluna, linha).toPosition());
		pecasNoTabuleiro.add(peca);
	}

	private void initialSetup() {
		placeNewPiece('a', 1, new Torre(board, Color.WHITE));
		placeNewPiece('h', 1, new Torre(board, Color.WHITE));
		placeNewPiece('h', 8, new Torre(board, Color.BLACK));
		placeNewPiece('a', 8, new Torre(board, Color.BLACK));
		placeNewPiece('e', 8, new Rei(board, Color.BLACK, this));
		placeNewPiece('e', 1, new Rei(board, Color.WHITE, this));
		placeNewPiece('d', 1, new Rainha(board, Color.WHITE));
		placeNewPiece('d', 8, new Rainha(board, Color.BLACK));
		placeNewPiece('c', 1, new Bispo(board, Color.WHITE));
		placeNewPiece('c', 8, new Bispo(board, Color.BLACK));
		placeNewPiece('f', 1, new Bispo(board, Color.WHITE));
		placeNewPiece('f', 8, new Bispo(board, Color.BLACK));
		placeNewPiece('b', 1, new Cavalo(board, Color.WHITE));
		placeNewPiece('g', 1, new Cavalo(board, Color.WHITE));
		placeNewPiece('b', 8, new Cavalo(board, Color.BLACK));
		placeNewPiece('g', 8, new Cavalo(board, Color.BLACK));
		placeNewPiece('a', 7, new Peao(board, Color.BLACK, this));
		placeNewPiece('b', 7, new Peao(board, Color.BLACK, this));
		placeNewPiece('c', 7, new Peao(board, Color.BLACK, this));
		placeNewPiece('d', 7, new Peao(board, Color.BLACK, this));
		placeNewPiece('e', 7, new Peao(board, Color.BLACK, this));
		placeNewPiece('f', 7, new Peao(board, Color.BLACK, this));
		placeNewPiece('g', 7, new Peao(board, Color.BLACK, this));
		placeNewPiece('a', 2, new Peao(board, Color.WHITE, this));
		placeNewPiece('b', 2, new Peao(board, Color.WHITE, this));
		placeNewPiece('c', 2, new Peao(board, Color.WHITE, this));
		placeNewPiece('d', 2, new Peao(board, Color.WHITE, this));
		placeNewPiece('e', 2, new Peao(board, Color.WHITE, this));
		placeNewPiece('f', 2, new Peao(board, Color.WHITE, this));
		placeNewPiece('g', 2, new Peao(board, Color.WHITE, this));

	}
}
