import java.util.Scanner;

public class Phonebook {
        
    static LinkedList<Contact> Contactlist= new LinkedList<Contact>();
    static LinkedList<Event> Eventlist= new LinkedList<>();
  


    
    // a method to add contact and sorts the contacts alphabetically
    public void addContact(Contact contact){
        if (!UniqueContact(contact)) {
            System.out.println("a contact with the same name or phone number already exists, Contact can not be added\n");
            return;
        }   
        
        Contactlist.insert(contact);
        Contactlist.Sort();
        System.out.println("Contact added successfully!\n"); 
    }
    

    // a method that checks if the contact is unique
    public boolean UniqueContact(Contact newContact) {

        if (Contactlist.empty()){
            return true;
        }

        Contactlist.findfirst();
        Contact existing = Contactlist.retrieve();

        while(existing!=null){
            if (existing.getName().equalsIgnoreCase(newContact.getName())||existing.getPhoneNumber().equals(newContact.getPhoneNumber())) {
                return false;
            }

            Contactlist.findnext();
            existing=Contactlist.retrieve();

        } 
        return true; 
    }


    // a method that search for a contact by name
    public void searchContactByName(String name) {

        Contactlist.findfirst();
        Contact contact = Contactlist.retrieve();
 
        while(contact!=null){

             if (contact.getName().equalsIgnoreCase(name)) {
                  System.out.println("Contact found!\n");
                  System.out.println(contact+"\n");
                  return;
        }
            Contactlist.findnext();
            contact=Contactlist.retrieve();}
            
            System.out.println("Contact not found!\n");

    }


    // a method that search for a contact by phone number
    public void searchContactsByPhonenumber(String Phonenumber) {

        Contactlist.findfirst();
        Contact contact = Contactlist.retrieve();
 
        while(contact!=null){

             if (contact.getPhoneNumber().equals(Phonenumber)) {
                  System.out.println("Contact found!\n");
                  System.out.println(contact+"\n");
                  return;
        }
            Contactlist.findnext();
            contact=Contactlist.retrieve();}
            System.out.println("Contact not found!\n");

    }

    

    // a method that list and print events Alphabetically
    public void listEventsAlphabetically(LinkedList<Event> events) {

        LinkedList<Event>[] Letter = new LinkedList[26];
        for (int i = 0; i < 26; i++) {
            Letter[i] = new LinkedList<>();
        }
    
        events.findfirst();
        Event event = events.retrieve();
    
        while (event != null) {
            char firstL = event.getTitle().toLowerCase().charAt(0);
            int index = firstL - 'a';
            Letter[index].insert(event);
    
            events.findnext();
            event = events.retrieve();
        }
    
        LinkedList<Event> sortedEvents = new LinkedList<>();
    
        for (int i = 0; i < 26; i++) {
            LinkedList<Event> Letters = Letter[i];
            Letters.findfirst();
            Event sortedEvent = Letters.retrieve();
    
            while (sortedEvent != null) {
                sortedEvents.insert(sortedEvent);
                Letters.findnext();
                sortedEvent = Letters.retrieve();
            }
        } printList(sortedEvents);
    
        
    }
    
    
    // a method that search for a contact by email address or birthday or address
    public void searchContactsByCriteria(String criteria) {
    LinkedList<Contact> Contacts= new LinkedList<>();
        int i=0;

        Contactlist.findfirst();
        Contact contact = Contactlist.retrieve();

        while(contact!=null){

            if (contact.getEmail().equalsIgnoreCase(criteria) || contact.getAddress().equalsIgnoreCase(criteria) || contact.getBirthday().equalsIgnoreCase(criteria)) {
                Contacts.insert(contact); 
                i++;
            }

            Contactlist.findnext();
            contact=Contactlist.retrieve();

        } if (Contacts.empty()) {
            System.out.println("Contact not found!\n");
            
        }else{

        System.out.println("Contact found!\n");

        Contacts.findfirst();
        Contact c = Contacts.retrieve();

        for (int index = 0; index < i; index++) {
                
            System.out.println(c+"\n");

            Contacts.findnext();
            c=Contacts.retrieve();
        }}
    }


    // a method to remove a contact with its assosiated events
    public boolean removeContact(Contact contact){
        if(Contactlist.contains(contact)){

           Eventlist.findfirst();
           Event event=Eventlist.retrieve();
           
           while(event!=null){
                if((event).getContactName().equals(contact)){
                  Eventlist.remove(event);
                }
               Eventlist.findnext();
               event=Eventlist.retrieve();
           }
           
           Contactlist.findfirst();
           Contact contactToBeDelted=Contactlist.retrieve();
           
           while(contactToBeDelted!=null){
            
            if(contactToBeDelted.equals(contact)){
            Contactlist.remove(contactToBeDelted);
            return true;
        }
            Contactlist.findnext();
            contactToBeDelted=Contactlist.retrieve();
           }
        }
       return false;
    }


    // a method to schedule an event while making sure it has no conflict
    public void scheduleEvent(Event event){
        if(!Contactlist.contains(event.getContactName())){
            System.out.println("Sorry contact does not exist\n");
            return;
        }
        if(eventHasConflict(event)){
            System.out.println("Sorry there is a conflict!\n");
            return;
        }
        Eventlist.insert(event); 
        System.out.println("Event scheduled successfully!\n");
    }
    


    // a method that checks if an event has a conflict
    public boolean eventHasConflict(Event newEvent) {
    	   Eventlist.findfirst(); 
           Event event = Eventlist.retrieve();

        while(event!=null){

             if (event.getDate().equals(newEvent.getDate()) && (event.getContactName().equals(newEvent.getContactName()))||(event.getTitle().equalsIgnoreCase(newEvent.getTitle()))) {
                    return true;  
             }

            Eventlist.findnext();
            event=Eventlist.retrieve();
        } return false;

    }


    // a method to print event details    
    public void PrintEventByName(String eventTitle){

        Eventlist.findfirst(); 
        Event event = Eventlist.retrieve();
 
        while(event!=null){
               if (event.getTitle().equalsIgnoreCase(eventTitle)) {
                System.out.println("Event found!\n"); 
                   System.out.println(event+"\n"); 
                   return;
                }
            
            Eventlist.findnext();
            event=Eventlist.retrieve();
        }
        System.out.println("Event not found!\n"); 

    }


    // a method to print event details    
    public void PrintEventByContact(String name){

        Eventlist.findfirst(); 
        Event event = Eventlist.retrieve();
 
        while(event!=null){
               if ((event.getContactName().getName()).equals(name)) {
                   System.out.println("Event found!\n"); 
                   System.out.println(event+"\n"); 
                   return;
                }
            
            Eventlist.findnext();
            event=Eventlist.retrieve();
        }
        System.out.println("Event not found!\n"); 

    }


    // a method to print all events that share the first name
    public void shareFirstName(String firstName){
        LinkedList<Contact> shareFirstName= new LinkedList<>();

        Contactlist.findfirst();
        Contact contact = Contactlist.retrieve();

        while(contact!=null){

            if (contact.getName().toLowerCase().startsWith(firstName.toLowerCase())) {
                shareFirstName.insert(contact);
            }

            Contactlist.findnext();
            contact=Contactlist.retrieve();
        }if (shareFirstName.empty()) {
    	    System.out.println("No contacts found with the first name: " + firstName+"\n");
    	}else{
            
            System.out.println("Contacts that share the first name:\n");
            printList(shareFirstName);
        }
    }


    // Method to print all contacts sharing an event
    public void ContactsSharingEvent(String eventTitle) {
        LinkedList<Contact> contactsSharingEvent= new LinkedList<>();

        Eventlist.findfirst(); 
        Event event = Eventlist.retrieve();
 
            while(event!=null){

                if (event.getTitle().equalsIgnoreCase(eventTitle)) {
                    contactsSharingEvent.insert(event.getContactName());
                }
            
                Eventlist.findnext();
                event=Eventlist.retrieve();
            }
    
            if (contactsSharingEvent.empty()) {
                  System.out.println("No contacts are sharing the event: " + eventTitle+"\n");
            } 
            else {
                System.out.println("The contacts sharing event: " + eventTitle+"\n");
                printList(contactsSharingEvent);
            }
    }


    // a method that prints all events alphabetically
    public <T> void printList(LinkedList<T> sortedlist){
        if(sortedlist.empty()){
            System.out.println("Sorry list is empty\n");
            return;
        }
        sortedlist.findfirst();
        T list = sortedlist.retrieve();

        while(list!= null){

            System.out.println(list+"\n");

            sortedlist.findnext();
            list=sortedlist.retrieve();
        }
    }


    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
            Phonebook phonebook = new Phonebook();
            
            String eventT;
            String nameC;
            int choice;

            System.out.println("Welcome to the Linked Tree Phonebook!");
            do {
                System.out.println("Please choose an option:");
                System.out.println("1. Add a Contact");
                System.out.println("2. Search for a Contacts");
                System.out.println("3. Delete a Contact");
                System.out.println("4. Schedule  an Event");
                System.out.println("5. Print event details");
                System.out.println("6. Print contacts by first name");
                System.out.println("7. Print all events alphabetically");
                System.out.println("8. Print contacts that share an event\n");
                System.out.println("9. Exit\n");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine(); 
                
                switch (choice) {
                    case 1:
                        System.out.println("Enter the contact's name: ");
                        String name = scanner.nextLine();
                        System.out.println("Enter the contact's phone number:");
                        String phone = scanner.nextLine();
                        System.out.println("Enter the contact's email address:");
                        String email = scanner.nextLine();
                        System.out.println("Enter the contact's address:");
                        String address = scanner.nextLine();
                        System.out.println("Enter the contact's birthday:");
                        String birthday = scanner.nextLine();
                        System.out.println("Enter any notes for the contact:");
                        String notes = scanner.nextLine();

                        System.out.println("\n");
                        phonebook.addContact(new Contact(name, phone, email, address, birthday,notes));
                        phonebook.printList(Contactlist);

                        break;
                    case 2:
                        System.out.println("\n");
                        System.out.println("Enter search criteria:\r\n"+"1. Name\r\n"+"2. Phone Number\r\n"+"3. Email Address\r\n"+"4. Address\r\n"+"5. Birthday\r");
                        System.out.println("Enter your choice: ");
                        int criteria = scanner.nextInt();
                        scanner.nextLine(); 

                    switch(criteria){

                        case 1:
                           System.out.println("\n");
                           System.out.print("Enter the contact's name: ");
                           String name1= scanner.nextLine();
                           System.out.println("\n");
                           phonebook.searchContactByName(name1);

                             
                            break;
                        case 2:
                            System.out.println("\n");
                            System.out.print("Enter the contact's phone number: ");
                            String phonenum=scanner.nextLine();

                            System.out.println("\n");
                            phonebook.searchContactsByPhonenumber(phonenum);

                            break;
                        case 3:
                            System.out.println("\n");
                            System.out.print("Enter the contact's email address:");
                            String email1 =scanner.nextLine();

                            System.out.println("\n");
                            phonebook.searchContactsByCriteria(email1);
                            break;
                        case 4:
                            System.out.println("\n");
                            System.out.print("Enter the contact's address:");
                            String addr =scanner.nextLine();

                            System.out.println("\n");
                            phonebook.searchContactsByCriteria(addr);
                            break;
                        case 5:
                            System.out.println("\n");
                            System.out.print("Enter the contact's birthday:");
                            String birthd =scanner.nextLine();

                            System.out.println("\n");
                            phonebook.searchContactsByCriteria(birthd);
                            break;
                    }

                        break;
                    case 3:
                        System.out.println("\n");
                        System.out.println("Enter the  contact's name:");
                        String name2 =scanner.next();

                        System.out.println("\n");
                        if(phonebook.removeContact(Contactlist.searchContact(name2))){
                            System.out.println("Contact was succesfully deleted!\n");
                        }
                        else{
                           System.out.println("Sorry couldn't find this contact!\n");
                        }
                        break;
                    case 4:
                        System.out.println("\n");
                        System.out.println("Enter event title:");
                        String eventtitle=  scanner.nextLine();
                        System.out.println("Enter contact name:");
                        String contactname= scanner.nextLine();
                        System.out.println("Enter event date and time (MM/DD/YYYY HH:MM):");
                        String date= scanner.nextLine();
                        System.out.println("Enter event location:");     
                        String location= scanner.nextLine();

                        System.out.println("\n");
                        Contact eContact=Contactlist.searchContact(contactname);
                        if (eContact==null) {
                            System.out.println("Can not schedule event, contact does not exist\n");
                        }else{
                        phonebook.scheduleEvent(new Event(eventtitle, eContact, date, location));} 

                        break;
                    case 5:
                        System.out.println("\n");
                        System.out.println("Enter search criteria:\r\n" +  "1. contact name\r\n" + "2. Event tittle\r");
                        System.out.println("Enter your choice: ");
                        int search=  scanner.nextInt();
                        System.out.println();
                        
                        switch (search) {
                            case 1:
                            System.out.println("Enter contact name: ");

                            nameC= scanner.next();
                            phonebook.PrintEventByContact(nameC);

                                break;
                            case 2:
                            System.out.println("Enter event tittle: ");

                            eventT= scanner.next();
                            phonebook.PrintEventByName(eventT);
                                
                                break;
                        
                            default:
                            System.out.println("\n");
                            System.out.println("invalid choice\n");
                                break;
                        }
                    
                        break;
                    case 6:
                        System.out.println("\n");
                        System.out.println("Enter the first name: ");
                        String Fname=  scanner.nextLine();

                        System.out.println("\n");
                        phonebook.shareFirstName(Fname);
                        break;
                    case 7:
                        System.out.println("\n");
                        System.out.println("The events listed alphabetically: \n");
                        phonebook.listEventsAlphabetically(Eventlist);
                        break;
                    case 8:
                        System.out.println("Enter event tittle: ");
                         String eventTitle= scanner.next();
                         phonebook.ContactsSharingEvent(eventTitle);  
                        
                    case 9:
                        System.out.println("Goodbye!");   

                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.\n");
                        break;
                }
            } while (choice != 8);
    
        scanner.close();

             

    }
}