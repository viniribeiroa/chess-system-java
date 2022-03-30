package chess.pecas;

import boardgame.Board;
import boardgame.Position;
import chess.Color;
import chess.PecaDeXadrez;

public class Rainha extends PecaDeXadrez{

	public Rainha(Board board, Color color) {
		super(board, color);
		
	}
	
	@Override
	public String toString() {
		return "Q";
	}
	@Override
	public boolean[][] possibleMoves() {
		boolean[][] matriz = new boolean[getBoard().getLinhas()][getBoard().getColunas()];
		
Position p = new Position(0,0);
		
		/* MOVIMENTAÇÃO DA PEÇA ACIMA
		 * 
		 */
		p.setValues(position.getLinha() -1, position.getColuna());
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
			
			matriz[p.getLinha()][p.getColuna()] = true;
			p.setLinha(p.getLinha() -1);
		}
		if(getBoard().positionExists(p) && isThereOpponentPeca(p)) {
			matriz[p.getLinha()][p.getColuna()] = true;
		}
		/* MOVIMENTAÇÃO DA PEÇA ESQUERDA
		 * 
		 */
		p.setValues(position.getLinha() , position.getColuna() -1);
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
			
			matriz[p.getLinha()][p.getColuna()] = true;
			p.setColuna(p.getColuna() -1);
		}
		if(getBoard().positionExists(p) && isThereOpponentPeca(p)) {
			matriz[p.getLinha()][p.getColuna()] = true;
		}
		/* MOVIMENTAÇÃO DA PEÇA DIREITA
		 * 
		 */
		p.setValues(position.getLinha() , position.getColuna() +1);
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
			
			matriz[p.getLinha()][p.getColuna()] = true;
			p.setColuna(p.getColuna() +1);
		}
		if(getBoard().positionExists(p) && isThereOpponentPeca(p)) {
			matriz[p.getLinha()][p.getColuna()] = true;
		}
		/* MOVIMENTAÇÃO DA PEÇA BAIXO
		 * 
		 */
		p.setValues(position.getLinha() +1, position.getColuna());
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
			
			matriz[p.getLinha()][p.getColuna()] = true;
			p.setLinha(p.getLinha() +1);
		}
		if(getBoard().positionExists(p) && isThereOpponentPeca(p)) {
			matriz[p.getLinha()][p.getColuna()] = true;
		}
		/* MOVIMENTAÇÃO DA PEÇA ACIMA
		 * 
		 */
		p.setValues(position.getLinha() -1, position.getColuna() -1);
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
			
			matriz[p.getLinha()][p.getColuna()] = true;
			p.setValues(p.getLinha() -1, p.getColuna() -1);
		}
		if(getBoard().positionExists(p) && isThereOpponentPeca(p)) {
			matriz[p.getLinha()][p.getColuna()] = true;
		}
		/* MOVIMENTAÇÃO DA PEÇA ESQUERDA
		 * 
		 */
		p.setValues(position.getLinha() +1 , position.getColuna() -1);
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
			
			matriz[p.getLinha()][p.getColuna()] = true;
			p.setValues(p.getLinha() +1, p.getColuna() -1);
		}
		if(getBoard().positionExists(p) && isThereOpponentPeca(p)) {
			matriz[p.getLinha()][p.getColuna()] = true;
		}
		/* MOVIMENTAÇÃO DA PEÇA DIREITA
		 * 
		 */
		p.setValues(position.getLinha() -1, position.getColuna() +1);
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
			
			matriz[p.getLinha()][p.getColuna()] = true;
			p.setValues(p.getLinha() -1, p.getColuna() +1);
		}
		if(getBoard().positionExists(p) && isThereOpponentPeca(p)) {
			matriz[p.getLinha()][p.getColuna()] = true;
		}
		/* MOVIMENTAÇÃO DA PEÇA BAIXO
		 * 
		 */
		p.setValues(position.getLinha() +1, position.getColuna() +1);
		while(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
			
			matriz[p.getLinha()][p.getColuna()] = true;
			p.setValues(p.getLinha() +1, p.getColuna() +1);
		}
		if(getBoard().positionExists(p) && isThereOpponentPeca(p)) {
			matriz[p.getLinha()][p.getColuna()] = true;
		}
		return matriz;
	}

}
