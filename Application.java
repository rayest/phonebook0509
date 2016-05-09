package cn.PhoneBook;

import java.util.List;
import java.util.Scanner;

/**
 * Created by xubt on 4/23/16.
 */
public class Application {
    private static PhoneBook phoneBook = new PhoneBook();

    public static void main(String[] args) throws Exception {
        backToHome();
    }

    public static void backToHome() throws Exception {
        System.out.println("\nWelcome to the phonebook!");
        System.out.println("Select operation:");
        System.out.println("1    Add contact");
        System.out.println("2   Find contact");
        System.out.println("3 Delete contact");
        System.out.println("4   Edit contact");
        System.out.println("5   View contact\n");
        Scanner input = new Scanner(System.in);
        int selectedOption = input.nextInt();
        switch (selectedOption) {
            case 1:
                Person newPerson = new Person();
                input = new Scanner(System.in);
                System.out.println("Enter contact's name:");
                String addName = input.next();
                newPerson.setName(addName);
                System.out.println("Enter contact's phoneNumber:");
                String addPhoneNumber = input.next();
                newPerson.setPhoneNumber(addPhoneNumber);
                if (newPerson == null) {
                    throw new Exception("Information can not be NULL");
                } else {
                    phoneBook.addPerson(newPerson);
                    System.out.println(newPerson.getName() + " successfully added!");
                }
                break;
            case 2:
                input = new Scanner(System.in);
                System.out.println("Enter contact's name");
                String contactName = input.next();
                Person foundPerson = phoneBook.findPersonByName(contactName);
                if (foundPerson == null) {
                    System.out.println("Contact can not be found");
                } else {
                    System.out.println(foundPerson.getName() + ":" + foundPerson.getPhoneNumber());
                }
                break;
            case 3:
                input = new Scanner(System.in);
                System.out.println("Enter contact's name");
                String deleteName = input.next();
                phoneBook.deletePerson(deleteName);
                System.out.println(deleteName + "successfully deleted!");
                break;
            case 4:
                input = new Scanner(System.in);
                System.out.println("Enter contact's name");
                String oldName = input.next();
                foundPerson = phoneBook.findPersonByName(oldName);
                if (foundPerson == null) {
                    System.out.println("Contact can not be found");
                } else {
                    System.out.println("Enter contact's new name");
                    String newName = input.next();
                    foundPerson.setName(newName);
                    System.out.println("Enter contact's new phone number:");
                    addPhoneNumber = input.nextLine();
                    foundPerson.setPhoneNumber(addPhoneNumber);
                    phoneBook.editPerson(oldName, foundPerson);
                    System.out.println(foundPerson.getName() + "successfully edited!");
                }
                break;
            case 5:
                List<Person> persons = phoneBook.loadPersons();
                for (Person person : persons) {
                    System.out.println("Name:" + person.getName());
                    System.out.println("PhoneNumber:" + person.getPhoneNumber());
                    System.out.println("----------------------------------");
                }
        }
        backToHome();
    }
}
