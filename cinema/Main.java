package cinema;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner ( System.in );
        Cinema cinema = new Cinema ( );
        System.out.println ( "Enter the number of rows: " );
        cinema.setNumberOfRows ( scanner.nextInt ( ));
        System.out.println ( "Enter the number of seats in each row: " );
        cinema.setNumberOfSeats ( scanner.nextInt ( ) );
        cinema.setTotalSeats ( cinema.getNumberOfRows ( ), cinema.getNumberOfSeats () );
        String[][] cinemaRoom = new String[cinema.getNumberOfRows ( )+1][cinema.getNumberOfSeats ()+1];
        int countTicket = 0;
        int profit = 0;
        int income = 0;
        cinema.setProfit ( profit, cinema.getNumberOfRows (), cinema.getNumberOfSeats ( ), cinema.getTotalSeats ( ) );



        cinemaRoom[0][0] = " ";
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j <= cinema.getNumberOfSeats (); j++) {
                cinemaRoom[i][j] = Integer.toString ( j );
            }
        }
        for (int i = 0; i <= cinema.getNumberOfRows ( ); i++) {
            for (int j = 0; j < 1; j++) {
                cinemaRoom[i][j] = Integer.toString ( i );
            }
        }
        for (int i = 1; i <= cinema.getNumberOfRows ( ); i++) {
            for (int j = 1; j <= cinema.getNumberOfSeats ( ); j++) {
                cinemaRoom[i][j] = "S";
            }
        }

        cinema.showMenu();

        int choice = scanner.nextInt ( );

        while (choice != 0) {
            switch (choice) {
                case 1:
                    cinema.showSeats (cinemaRoom);
                    System.out.println ( "\n1. Show the seats\n" +
                            "2. Buy a ticket\n" +
                            "3. Statistics\n" +
                            "0. Exit" );
                    choice = scanner.nextInt ( );
                    break;
                case 2:
                    System.out.println ( "\nEnter a row number: " );
                    cinema.setRowNumber ( scanner.nextInt ( ) );
                    System.out.println ( "\nEnter a seat number in that row: " );
                    cinema.setSeatNumber ( scanner.nextInt ( ) );
                    if (cinema.checkTicket ( cinema.getRowNumber ( ), cinema.getSeatNumber ( ), cinema.getNumberOfRows ( ), cinema.getNumberOfSeats ( ) ) == false){
                        System.out.println ( "\nWrong input!\n" );
                        choice = 2;
                        break;
                    }
                    if (cinema.checkRoom ( cinema.getRowNumber ( ), cinema.getSeatNumber ( ), cinemaRoom) == false){
                        System.out.println ( "\nThat ticket has already been purchased!" );
                        choice = 2;
                        break;
                    }
                    cinema.setCountTickets (countTicket += 1);
                    cinema.setIncome ( income += Cinema.buyTicket ( cinema.getRowNumber ( ), cinema.getSeatNumber ( ), cinema.getTotalSeats ( ), cinema.getNumberOfRows ( ),cinemaRoom));
                    cinema.showMenu();

                    choice = scanner.nextInt ( );
                    break;
                case 3:
                    Cinema.statistics ( cinema.getTotalSeats ( ), cinema.getCountTickets (), cinema.getIncome(), cinema.getProfit ()  );
                    cinema.showMenu();
                    choice = scanner.nextInt ( );
                    break;
                default:
                    cinema.showMenu();
                    choice = scanner.nextInt ( );
                    break;

            }
        }
    }
}
