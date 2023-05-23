import java.util.Scanner;
public class MedicalCenter {

        static String[][] doctors = {
                        { "Ali Ahmed", "MBBS,MS", "1500", "9am to 11am\n7pm to 11pm" },
                        { "Muhammed Ali", "BDS,Ophthalmologist", "500", "4pm to 11pm" },
                        { "Arayan Ahmed", "BUMS,MS in Neurologist", "3500", "5pm to 7pm" },
                        { "Ismail Ali", "BYNS", "1000", "9am to 1pm" },
                        { "Riwan Ali", "MBBS,FCPS", "2500", "2pm to 5pm" },
                        { "Iqbal Ahmed", "MBBS,ANT", "1500", "8am to 12am\n3pm to 11pm" },
                        { "Javed Ali", "BHMS", "1300", "close only 12am to 3pm" },
                        { "Arif ALi", "BPT,Cardiologist", "2000","8am to 12am\n5pm to 8pm"},
                        { "Muhammad Hussain","MBBS,Dermatologist","1500","2pm to 6pm"},
                        { "Mazhar Ali","MBBS,Gastroenterologist","1000","11am to 3pm"},

        };
        static int[][] daysAvailable = { {0,1,2,3,4,5},{0,1,9,3,5},{0,1,5,4,3},{2,7,6,4},{7,9,4,3,5},{0,7,8,2,5},{6,4,8,9,2,1} };
        static Scanner sc = new Scanner(System.in);

        public static void main(String[] args) {

                int option = -1;
                while(option != 3){
                       
                System.out.println("Select\n 1.To Search Doctor's Name \n 2.To Search by Day(Monday etc) \n 3.Exit ");
                System.out.print("\nEnter your  option : ");
                option = sc.nextInt();
                sc.nextLine();

                switch (option) {
                        case 1:
                                searchByName();
                                break;

                        case 2:
                                searchByDay();
                                break;

                        case 3:
                                System.exit(0);
                                break;

                        default:
                                System.out.println("Wrong option");
                                break;
                }
        }
        }

        static void searchByName() {

                System.out.println("Enter a doctors name to get info: ");
                String name = sc.nextLine();
                int index = -1;
                for (int i = 0; i < doctors.length; i++) {
                        if (doctors[i][0].equalsIgnoreCase(name)) {
                                index = i;
                                break;
                        }
                }

                if (index >= 0) {
                        System.out.println("Dr. " + doctors[index][0] + " " + doctors[index][1]);
                        System.out.println("Fees: " + doctors[index][2]);
                        System.out.println("Timing:  \n" + doctors[index][3]);

                } else {
                        System.out.println("Wrong name record doesn't exist in database");
                }
        }

        static void searchByDay() {
                System.out.print("\nEnter The Day (Monday , Tuesday ....) : ");
                String day = sc.nextLine();
                day = day.toLowerCase();
                int indexOfDay = -1;
                switch (day) {
                        case "monday":
                                indexOfDay = 0;
                                break;

                        case "tuesday":
                                indexOfDay = 1;
                                break;

                        case "wednesday":
                                indexOfDay = 2;
                                break;

                        case "thursday":
                                indexOfDay = 3;
                                break;

                        case "friday":
                                indexOfDay = 4;
                                break;

                        case "saturday":
                                indexOfDay = 5;
                                break;

                        case "sunday":
                                indexOfDay = 6;
                                break;

                        default:
                                System.out.println("Wrong Name Entered");
                                break;
                }
                if (indexOfDay >= 0) {

                        for (int i = 0; i < daysAvailable[indexOfDay].length; i++) {
                                System.out.println("\n\n" + (i + 1));
                                System.out.println("Dr. " + doctors[daysAvailable[indexOfDay][i]][0] + " "
                                                + doctors[daysAvailable[indexOfDay][i]][1]);
                                System.out.println("Fees: " + doctors[daysAvailable[indexOfDay][i]][2]);

                                System.out.println("Timing:  \n" + doctors[daysAvailable[indexOfDay][i]][3]);

                        }
                }

        }
}