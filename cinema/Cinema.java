package cinema;

public class Cinema {

    int numberOfRows = getRowNumber ( );
    int numberOfSeats = getNumberOfSeats ( );


    int totalSeats = 0;
    int rowNumber = 0;
    int seatNumber = 0;
    int income = 0;
    int profit = 0;
    int countTickets = 0;

    public int getCountTickets() {
        return countTickets;
    }

    public void setCountTickets(int countTickets) {
        this.countTickets = countTickets;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {

        this.income = income;
    }

    public int getProfit() {
        return profit;
    }

    public void setProfit(int profit, int numberOfRows,int numberOfSeats, int totalSeats) {
        if (totalSeats <= 60 && numberOfRows <= 9) {
            profit = totalSeats * 10;
        } else if (totalSeats % 2 == 0 && numberOfRows <= 9) {
            int halfRows = numberOfRows/2;
            profit = (halfRows*10*numberOfSeats) + (halfRows*8* numberOfSeats);
         } else if (totalSeats % 2 != 0 && numberOfRows <= 9) {
            int frontRows = (numberOfRows / 2);
            int backRows =  numberOfRows - frontRows;
                profit = (frontRows*numberOfSeats*10) + (backRows*8*numberOfSeats);
            } else if (numberOfRows > 9) {
            System.out.println ( );
        }
        this.profit = profit;

    }

    public int getNumberOfRows() {
        return numberOfRows;
    }

    public void setNumberOfRows(int numberOfRows) {
        this.numberOfRows = numberOfRows;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public void setTotalSeats(int numberOfRows, int numberOfSeats) {
        this.totalSeats = numberOfRows * numberOfSeats;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public static int buyTicket(int rowNumber, int seatNumber, int totalSeats, int numberOfRows, String[][] cinemaRoom) {

        cinemaRoom[rowNumber][seatNumber] = "B";
        if (totalSeats <= 60 && numberOfRows <= 9) {
            System.out.println ( "Ticket price: $10\n" );
            return 10;

        } else if (totalSeats % 2 == 0 && numberOfRows <= 9) {
            if (rowNumber <= numberOfRows / 2) {
                System.out.println ( "Ticket price: $10\n" );
                return 10;
            } else {
                System.out.println ( "Ticket price: $8\n" );
                return 8;
            }
        } else if (totalSeats % 2 != 0 && numberOfRows <= 9) {
            int frontRows = (numberOfRows / 2);
            if (rowNumber <= frontRows) {
                System.out.println ( "Ticket price: $10\n" );
                return 10;
            } else {
                System.out.println ( "Ticket price: $8\n" );
                return 8;
            }
        } else if (numberOfRows > 9) {
            System.out.println ( );
            return 0;
        }
        return 0;
    }

    public static boolean checkTicket(int rowNumber,int seatNumber, int numberOfRows, int numberOfSeats) {
        if (rowNumber > numberOfRows || seatNumber > numberOfSeats) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean checkRoom(int rowNumber,int seatNumber, String[][] cinemaRoom) {
        if (cinemaRoom[rowNumber][seatNumber] == "B") {
            return false;
        } else {
            return true;
        }
    }

    public void showSeats(String[][] cinemaRoom) {
        cinemaRoom[0][0] = " ";
        System.out.println ( "Cinema: " );

        for (int i = 0; i <= numberOfRows; i++) {
            for (int j = 0; j <= numberOfSeats; j++) {
                System.out.print ( " " + cinemaRoom[i][j] );

            }
            System.out.println ( );

        }
    }

    public static void statistics(int totalSeat, int countTickets, int income, int profit) {
        double percentage = ((double) countTickets / (double) totalSeat) * 100;

        System.out.println ( "Number of purchased tickets:" + countTickets );
        System.out.printf ( "Percentage: %.2f", percentage );
        System.out.println ( "%\nCurrent income: $" + income + "\n" +
                "Total income: $" + profit );

    }

}
