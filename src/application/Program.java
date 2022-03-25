package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessPosition;
import chess.PartidaDeXadrez;
import chess.PecaDeXadrez;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		PartidaDeXadrez partidadexadrez = new PartidaDeXadrez();
		List<PecaDeXadrez> captured = new ArrayList<>();

		while (true) {
			try {
				UI.clearScreen();
				UI.printMatch(partidadexadrez, captured);
				System.out.println();
				System.out.print("Source: ");
				ChessPosition source = UI.readChessPosition(sc);
				
				boolean [][] possibleMoves = partidadexadrez.possibleMoves(source);
				UI.clearScreen();
				UI.PrintBoard(partidadexadrez.getPecas(), possibleMoves);
				
				System.out.println();
				System.out.print("target: ");
				ChessPosition target = UI.readChessPosition(sc);
				
				PecaDeXadrez capturadaPeca = partidadexadrez.performChessMove(source, target);
				
				if(capturadaPeca != null) {
					captured.add(capturadaPeca);
				}
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
