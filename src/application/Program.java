package application;

import chess.PartidaDeXadrez;

public class Program {

	public static void main(String[] args) {
		
		PartidaDeXadrez partidadexadrez = new PartidaDeXadrez();
		UI.PrintBoard(partidadexadrez.getPecas());

	}

}
