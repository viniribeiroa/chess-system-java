package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessPosition;
import chess.PartidaDeXadrez;
import chess.PecaDeXadrez;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		PartidaDeXadrez partidadexadrez = new PartidaDeXadrez();

		while (true) {
			try {
				UI.clearScreen();
				UI.PrintBoard(partidadexadrez.getPecas());
				System.out.println();
				System.out.print("Source: ");
				ChessPosition source = UI.readChessPosition(sc);
				
				System.out.println();
				System.out.print("target: ");
				ChessPosition target = UI.readChessPosition(sc);
				
				PecaDeXadrez capturadaPeca = partidadexadrez.performChessMove(source, target);
			}
			catch(ChessException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
			catch(InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			
			}

		}

	}

}
