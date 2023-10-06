import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
       LinkedList<Contact> Contactlist= new LinkedList<>();
       LinkedList<Event> Eventlist= new LinkedList<>();

       public boolean isContactUnique(Contact contact){}

       public void addContact(Contact contact){}

       public void removeContact(Contact contact){
        if (isContactUnique(Contact contact)){
            Contactlist.contact.remove();
        }
       }

       public String search(){}

       public void shareEvents(){}

       public void shareFirstName(){}



       System.out.println("Welcome to the Linked Tree Phonebook!\r\n" + //
               "Please choose an option:\r\n" + //
               "1. Add a contact\r\n" + //
               "2. Search for a contact\r\n" + //
               "3. Delete a contact\r\n" + //
               "4. Schedule an event\r\n" + //
               "5. Print event details\r\n" + //
               "6. Print contacts by first name\r\n" + //
               "7. Print all events alphabetically\r\n" + //
               "8. Exit\r");
               System.out.println("\nEnter your choice:");
             int userChoice = Integer.parseInt(scanner.nextLine());

             

    }
}
