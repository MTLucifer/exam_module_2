import File.FileManagement;
import Model.PhoneBook;
import Model.PhoneManagement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
        PhoneManagement phoneManagement = new PhoneManagement();
        Scanner scanner = new Scanner(System.in);
        FileManagement fileManagement = new FileManagement();
        List<PhoneBook> list = null;
        System.out.println("Input new contact:");
        String contact = scanner.nextLine();
        phoneManagement.add("contacts.csv", contact);
        list = fileManagement.readCSV("contacts.csv");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("Input Phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.println(phoneManagement.findBYPhone("contacts.csv", phoneNumber));
        phoneManagement.delete("contacts.csv", phoneNumber);
    }
}
