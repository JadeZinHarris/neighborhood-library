package com.pluarsight;

import java.util.Scanner;


public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Books[] libraryBooks = new Books[20];
    static int currentAvailableBooks = 10;

    static String homeScreen = "Welcome to the Library :  (A) - Shows available books  (C) - Shows checked out books " +
            "  (X) - Quit the program  ";
    static String availableBooks = "Choose a book to check out:  (O) - Check out book   if checking out type: O <book-name> OR <book-isbn> OR <book-id>" +
            " (X) - Return back to main menu ";
    static String enterName = "Please enter your name: ";
    static String checkedOutMenu = "Choose to check in a book:  (C) - To check in a book: C <book-id>" +
            " (X) - Return back to main menu ";


    public static void main(String[] args) {
        libraryBooks[0] = new Books(6, "1421501082", "Nana. Vol. 1 ");
        libraryBooks[1] = new Books(20, "1421503786", "Nana. Vol. 2 ");
        libraryBooks[2] = new Books(1365, "1591824990", "Peach girl. Change of heart. 10");
        libraryBooks[3] = new Books(286, "1421012154", "Hell girl. Volume three, Cherry");
        libraryBooks[4] = new Books(1, "9781678202224", "The history of anime and manga");
        libraryBooks[5] = new Books(26, "9781591169192", "InuYasha the movie 3 : swords of an honorable ruler");
        libraryBooks[6] = new Books(8, "9781506713595", "Danganronpa 2: goodbye despair");
        libraryBooks[7] = new Books(2, "1632369575", "Beyond the clouds : the girl who fell from the sky. Volume 01");
        libraryBooks[8] = new Books(3, "1642750530", "Mythical beast investigator. Volume 1");
        libraryBooks[9] = new Books(80, "9780545581608", "Dog Man");




        System.out.println("Welcome to the Bronx Library!");


        boolean nope = false;

        while (!nope) {
            char command = getCharInput(scanner, homeScreen);
            switch(command) {
                case 'A':
                    availableBooksMenu();
                    break;
                case 'C':
                    showCheckedOutBooks();
                    break;
                case 'X':
                    System.out.println("Quitting the program");
                    nope = true;
                    break;
                default:
                    System.out.println("Sorry, that is not a valid command - type: A, O, or X");
            }

        }
    }

    public static void availableBooksMenu() {
        System.out.println("Here is a list of all the available books:");
        for(int i = 0; i < currentAvailableBooks; i++) {
            if(!libraryBooks[i].isCheckedOut()) {
                System.out.println(libraryBooks[i]);
            }
        }


        while(true) {
            String command = getStringInput(scanner, availableBooks);
            switch(command.toUpperCase().charAt(0)) {
                case 'O':
                    checkOutBook(command);
                    break;
                case 'X':
                    System.out.println("Returning to main menu...");
                    return;
                default:
                    System.out.println("Sorry, that is not a valid command - type: S or X");
            }
        }
    }

    public static void showCheckedOutBooks() {
        System.out.println("Here is a list of all the books that are checked out:");
        for(int i = 0 ; i < currentAvailableBooks; i++) {
            if(libraryBooks[i].isCheckedOut()) {
                System.out.println(libraryBooks[i] + " - Checked out to: " + libraryBooks[i].getCheckedOutTo());
            }
        }

        while(true) {
            String command = getStringInput(scanner, checkedOutMenu);
            switch (command.toUpperCase().charAt(0)) {
                case 'C':
                    checkInBooks(command);
                    return;
                case 'X':
                    System.out.println("Returning to main menu...");
                    return;
                default:
                    System.out.println("Sorry, that is not a valid command - type: C or X");
            }
        }
    }

    public static void checkOutBook(String bookInfo) {

        String[] tokens = bookInfo.split(" ", 2);


        for(int i = 0; i < currentAvailableBooks; i++) {
            Books book = libraryBooks[i];
            if (
                    book.getTitle().equalsIgnoreCase(tokens[1]) ||
                            String.valueOf(book.getId()).equalsIgnoreCase(tokens[1]) ||
                            book.getIsbn().equalsIgnoreCase(tokens[1])
            ) {
                String name = getStringInput(scanner, enterName);
                libraryBooks[i].checkOut(name);
            }
        }
    }

    public static void checkInBooks(String bookInfo) {
        String[] tokens = bookInfo.split(" ");
        for(int i = 0; i < currentAvailableBooks; i++) {
            Books book = libraryBooks[i];
            if(String.valueOf(book.getId()).equalsIgnoreCase(tokens[1])) {
                libraryBooks[i].checkIn();
            }
        }
    }

    public static String getStringInput(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public static char getCharInput(Scanner scanner, String prompt) {
        System.out.print(prompt);
        char input = scanner.next().toUpperCase().charAt(0);
        scanner.nextLine();
        return input;
    }
}
