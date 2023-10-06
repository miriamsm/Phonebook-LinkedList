import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
       LinkedList<Contact> Contactlist= new LinkedList<>();
       LinkedList<Event> Eventlist= new LinkedList<>();

       public void addContact(Contact contact) {
        if (!UniqueContact(contact)) {
            System.out.println("a contact with the same name or phone number already exists, Contact can not be added");
            return;
        }   Contactlist.insert(contact);
          System.out.println("Contact added successfully!"); }
    

     private boolean UniqueContact(Contact new) {
        for (Contact existing : Contactlist) {
           if (existing.getName().equalsIgnoreCase(new.getName())||existing.getPhoneNumber().equals(new.getPhoneNumber())) {
            return false; }
    }
        return true;  }


       public void removeContact(Contact contact){
        if (UniqueContact(Contact contact)){
            Contactlist.contact.remove();}  }
    

       public String searchContact(){}

       public void shareEvents(){}

       public void shareFirstName(){}

       public void ContactExists(){}

       public boolean searchContactByName(String name){}



 int choice;
            System.out.println("Welcome to the Linked Tree Phonebook!" );
            do {
                System.out.println("Please choose an option:");
                System.out.println("1. Add a Contact");
                System.out.println("2. Search for a Contacts");
                System.out.println("3. Delete a Contact");
                System.out.println("4. Schedule  an Event");
                System.out.println("5. Print event details");
                System.out.println("6. Print contacts by first name");
                System.out.println("7. Print all events alphabetically");
                System.out.println("8. Exit\n");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine(); 
                
                switch (choice) {
                    case 1:
                System.out.println("Enter the contact's name: ");
                System.out.println("Enter the contact's phone number:");
                System.out.println("Enter the contact's email address:");
                System.out.println("Enter the contact's address:");
                System.out.println("Enter the contact's birthday:");
                System.out.println("Enter any notes for the contact:");
                        break;
                    case 2:
                System.out.println("Enter search criteria:\r\n"+"1. Name\r\n"+"2. Phone Number\r\n"+"3. Email Address\r\n"+"4. Address\r\n"+"5. Birthday\r");
                System.out.println("Enter your choice: ");
                     int criteria = scanner.nextInt();
                     scanner.nextLine(); 
                     switch(criteria){

                        case 1:
                        System.out.print("Enter the contact's name: ");
                             String name= scanner.nextline();

                            if(searchContactByName(name)){
                            System.out.println("Contact found!");
                            System.out.println(contact.toString());
                           }
                             
                        break;
                        case 2:
                        System.out.print("Enter the contact's phone number: ");
                        break;
                        case 3:
                        System.out.print("Enter the contact's email address":);
                        break;
                        case 4:
                        System.out.print("Enter the contact's address:");
                        break;
                        case 5:
                        System.out.print("Enter the contact's birthday:");
                        break;
                     }
                        break;
                    case 3:
                        // Logic to delete a contact
                        break;
                    case 4:
                System.out.println("Enter event title:");
                System.out.println("Enter contact name:");
                System.out.println("Enter event date and time (MM/DD/YYYY HH:MM):");
                System.out.println("Enter event location:");               
                         break;
                    case 5:
                System.out.println("Enter search criteria:\r\n"+"1. contact name\r\n"+"2. Event tittle");  
                  criteria = scanner.nextInt();
                     scanner.nextLine(); 
                     switch(criteria){
                        case 1:
                        System.out.print("Enter the contact's name: ");
                        break;
                        case 2:
                        System.out.print("Enter the event title:");
                        break;            
                     } break;
                    case 6:
                        System.out.print("Enter the first name: ");
                        break;
                    case 7:
                        // Logic to schedule an event
                        break;
                    case 8:
                        System.out.println("Goodbye!");                  
                              break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            } while (choice != 8);
            

             

    }
}
