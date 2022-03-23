package boardgame;

public class Board {
	
	private int linhas;
	private int colunas;
	private Peca[][] pecas; //MATRIZ DE PE�AS...
	
	
	public Board(int linhas, int colunas) {
		
		if(linhas < 1 || colunas < 1 ) {
			throw new BoardException("ERRO ao criar tabuleiro � necessario que seja criado pelo menos uma linha e uma coluna");
		}
		this.linhas = linhas;
		this.colunas = colunas;
		pecas = new Peca[linhas][colunas];
	}


	public int getLinhas() {
		return linhas;
	}

	
	public int getColunas() {
		return colunas;
	}

		
	public Peca peca(int linha, int coluna) {
		
		if(!positionExists(linha, coluna)) {
			throw new BoardException("Esta posi��o n�o existe no tabuleiro");
		}
		return pecas[linha][coluna];
	}
	public Peca peca(Position position) {
		
		if(!positionExists(position)) {
			throw new BoardException("est� posi��o n�o extiste no tabuleiro");
		}
		return pecas[position.getLinha()][position.getColuna()];
	}
	
	public void placePeca(Peca peca, Position position) {
		
		if(thereIsAPiece(position)) {
			throw new BoardException("Existe uma pe�a nesta posi��o");
		}
		pecas[position.getLinha()][position.getColuna()] = peca;
		peca.position = position;
	}
	
	private boolean positionExists(int linha, int coluna) {
		return linha >= 0 && linha < linhas && coluna >= 0 && coluna < colunas;
	}
	
	public boolean positionExists(Position position) {
		return positionExists(position.getLinha(), position.getColuna()); // testando se a posi��o existe
		
	}
	
	public boolean thereIsAPiece(Position position) {
		
		if(!positionExists(position)) {
			throw new BoardException("est� posi��o n�o extiste no tabuleiro");
		}
		return peca(position) != null;
	}

}
