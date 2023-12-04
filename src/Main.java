import com.crmsystem.fileio.CustomFileReader;
import com.crmsystem.fileio.CustomFileWriter;
import com.crmsystem.models.ClientManager;
import com.crmsystem.models.ClientService;
import com.crmsystem.models.Manager;
import com.crmsystem.models.Service;
import com.crmsystem.ui.Ui;

import java.io.FileReader;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
// Implement file operations for XML/SQLite
        Ui ui = new Ui();
        CustomFileWriter fileWriter = new CustomFileWriter();
        CustomFileReader fileReader = new CustomFileReader();
        Service service = new ClientService(fileReader, fileWriter);
        Manager manager = new ClientManager(service);
        System.out.println("Welcome to the Client Management System");
        ui.displayOptions();
        boolean active = true;
        Scanner scanner = new Scanner(System.in);
        while (active) {
            System.out.println("Enter command: ");
            String command = scanner.nextLine();
            manager.performAction(command);
// Add Client
// 1, Oceanic Enterprises, Finance, Sarah Smith, 500000.00
// Update Client
// 1, Oceanic Enterprises, Tech, Sarah Smith, 750000.00
// View Clients
// Search Industry Tech
// Search ID 1
// Remove Client 1
// Search Name Oceanic
// Save & Exit
        }
    }
}