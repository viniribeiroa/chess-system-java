package application;

import java.util.Scanner;

import chess.ChessPosition;
import chess.PartidaDeXadrez;
import chess.PecaDeXadrez;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		PartidaDeXadrez partidadexadrez = new PartidaDeXadrez();

		while (true) {
			UI.PrintBoard(partidadexadrez.getPecas());
			System.out.println();
			System.out.print("Source: ");
			ChessPosition source = UI.readChessPosition(sc);
			
			System.out.println();
			System.out.print("target: ");
			ChessPosition target = UI.readChessPosition(sc);
			
			PecaDeXadrez capturadaPeca = partidadexadrez.performChessMove(source, target);

		}

	}

}
