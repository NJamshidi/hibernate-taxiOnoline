package tamrintaxi;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        TaxiManager taxiManager = new TaxiManager();
        int select;

        select:
        do {
            System.out.print(
                    "1.Add a group of drivers  \n" +
                            "2.Add a group of passengers  \n" +
                            "3.Driver signup or login  \n" +
                            "4.Passenger signup or login  \n" +
                            "5.Show ongoing travels  \n" +
                            "6.Show a list of drivers \n" +
                            "7.Show a list of passengers\n" +
                            "8.exit");
            select = scanner.nextInt();

            switch (select) {
                case 1:
                    taxiManager.createDriver(1);
                    break;

                case 2:
                    taxiManager.createPassenger(2);
                    break;

                case 3:
                    taxiManager.signupOrLogin(3);
                    break;

                case 4:
                    taxiManager.signupOrLogin(4);
                    break;

                case 5:
                    taxiManager.showAllOngoingTravels();
                    break;

                case 6:
                    taxiManager.showAllDrivers();
                    break;

                case 7:
                    taxiManager.showAllPassengers();
                    break;

                case 8:
                    break select;

                default:
                    System.out.println("invalid value");
            }

        } while (true);
    }

}

