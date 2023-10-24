package task;

import java.util.List;
import java.util.Scanner;

public class ManagePersonalUI {
    private final ManagePersonal managePersonal;

    public ManagePersonalUI(ManagePersonal managePersonal) {
        this.managePersonal = managePersonal;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Waehlen Sie eine Aktion:");
            System.out.println("1. SalesMan erstellen");
            System.out.println("2. PerformanceRecord hinzufuegen");
            System.out.println("3. SalesMan lesen");
            System.out.println("4. SalesMan suchen");
            System.out.println("5. PerformanceRecord lesen");
            System.out.println("0. Beenden");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    createSalesMan(scanner);
                    break;
                case 2:
                    addPerformanceRecord(scanner);
                    break;
                case 3:
                    readSalesMan(scanner);
                    break;
                case 4:
                    querySalesMan(scanner);
                    break;
                case 5:
                    readEvaluationRecords(scanner);
                    break;
                case 0:
                    System.out.println("Anwendung wird beendet.");
                    return;
                default:
                    System.out.println("Ungültige Eingabe. Bitte erneut eingeben.");
            }
        }
    }

    private void createSalesMan(Scanner scanner) {
        System.out.println("Geben Sie den Vorname, Nachname und die ID des SalesMan ein (getrennt durch Leerzeichen):");
        String userInput = scanner.nextLine();

        String[] inputParts = userInput.split(" ");

        if (inputParts.length != 3) {
            System.out.println("Ungültige Eingabe. Bitte Vorname, Nachname und ID getrennt durch Leerzeichen eingeben.");
            return;
        }

        String vorname = inputParts[0];
        String nachname = inputParts[1];
        int id;

        try {
            id = Integer.parseInt(inputParts[2]);
        } catch (NumberFormatException e) {
            System.out.println("Ungueltige ID. Bitte geben Sie eine ganze Zahl fuer die ID ein.");
            return;
        }

        SalesMan salesMan = new SalesMan(vorname, nachname, id);
        managePersonal.createSalesMan(salesMan);
    }

    private void addPerformanceRecord(Scanner scanner) {
        System.out.println("This functionality is not implemented yet.\n");
    }

    private void readSalesMan(Scanner scanner) {
        System.out.println("Geben Sie die SalesMan-ID ein:");
        int sid = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        SalesMan salesMan = managePersonal.readSalesMan(sid);
        if (salesMan != null) {
            System.out.println("SalesMan gefunden: " + salesMan.toString());
        } else {
            System.out.println("SalesMan nicht gefunden.");
        }
    }

    private void querySalesMan(Scanner scanner) {
        System.out.println("Geben Sie das Attribut und den Schlüsselwert für die Suche ein:");
        String attribute = scanner.nextLine();
        String key = scanner.nextLine();
        List<SalesMan> salesMen = managePersonal.querySalesMan(attribute, key);
        if (!salesMen.isEmpty()) {
            System.out.println("Gefundene SalesMen:");
            for (SalesMan salesMan : salesMen) {
                System.out.println(salesMan.toString());
            }
        } else {
            System.out.println("Keine SalesMen gefunden.");
        }
    }

    private void readEvaluationRecords(Scanner scanner) {
        System.out.println("This functionality is not implemented yet.\n");
    }
}
