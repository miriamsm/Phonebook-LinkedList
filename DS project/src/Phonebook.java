import java.util.Scanner;

public class Phonebook {
        
    LinkedList<Contact> Contactlist= new LinkedList<>();
    LinkedList<Event> Eventlist= new LinkedList<>();

    
    // a method to add contact and sorts the contacts alphabetically
    public void addContact(Contact contact){
        if (!UniqueContact(contact)) {
            System.out.println("a contact with the same name or phone number already exists, Contact can not be added");
            return;
        }   
        
        Contactlist.insert(contact);
        System.out.println("Contact added successfully!"); 
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
                  System.out.println("Contact found!");
                  System.out.println(contact);
                  return;
        }
            Contactlist.findnext();
            contact=Contactlist.retrieve();}
            
            System.out.println("Contact not found!");

    }


    // a method that search for a contact by phone number
    public void searchContactsByPhonenumber(String Phonenumber) {

        Contactlist.findfirst();
        Contact contact = Contactlist.retrieve();
 
        while(contact!=null){

             if (contact.getPhoneNumber().equals(Phonenumber)) {
                  System.out.println("Contact found!");
                  System.out.println(contact);
                  return;
        }
            Contactlist.findnext();
            contact=Contactlist.retrieve();}
            System.out.println("Contact not found!");

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
        }
        
        Contacts.findfirst();
        Contact c = Contacts.retrieve();

        for (int index = 0; index < i; index++) {
                
            System.out.println(c);

            Contacts.findnext();
            c=Contacts.retrieve();
        }
    }


    // a method to remove a contact with its assosiated events
    public boolean removeContact(Contact contact){
        if(Contactlist.find(contact)){

           Eventlist.findfirst();
           Event event=Eventlist.retrieve();
           while(event!=null){
                if((event).getContactName().equals(contact)){
                  Eventlist.remove();
                }
               Eventlist.findnext();
               event=Eventlist.retrieve();
           }

            Contactlist.remove();
            return true;
        }
       return false;
    }


    // a method to schedule an event while making sure it has no conflict
    public void scheduleEvent(Event event){
        if(!Contactlist.contains(event.getContactName())){
            System.out.println("Sorry contact does not exist");
            return;
        }
        if(eventHasConflict(event)){
            System.out.println("Sorry there is a conflict!");
            return;
        }
        Eventlist.insert(event); 
        System.out.println("Event scheduled successfully!");
    }
    


    // a method that checks if an event has a conflict
    public boolean eventHasConflict(Event newEvent) {
    	   Eventlist.findfirst(); 
           Event event = Eventlist.retrieve();

        while(event!=null){

             if (event.getDate().equals(newEvent.getDate())) { 
                if (event.getContactName().equals(newEvent.getContactName())) {
                    return true;
                }
             }

            Eventlist.findnext();
            event=Eventlist.retrieve();
        } return false;

    }



    // Method to print all contacts sharing an event
    public void contactsSharingEvent(String eventTitle) {
        LinkedList<Contact> contactsSharingEvent= new LinkedList<>();
        int i=0;

        Eventlist.findfirst(); 
        Event event = Eventlist.retrieve();
 
            while(event!=null){

                if (event.getTitle().equalsIgnoreCase(eventTitle)) {
                    contactsSharingEvent.insert(event.getContactName());
                    i++;
                }
            
                Eventlist.findnext();
                event=Eventlist.retrieve();}
    
                if (contactsSharingEvent.empty()) {
                  System.out.println("No contacts are sharing the event: " + eventTitle);
                } 
                else {
                    System.out.println("The contacts sharing event: " + eventTitle);
                    contactsSharingEvent.findfirst();
                    Contact contact = contactsSharingEvent.retrieve();

                     for (int index = 0; index < i; index++) {
                     System.out.println(contact);

                     contactsSharingEvent.findnext();
                     contact=contactsSharingEvent.retrieve();
                    }
            }
    }
        

    // a method to print event details    
    public void PrintEventByName(String eventTitle){

        Eventlist.findfirst(); 
        Event event = Eventlist.retrieve();
 
        while(event!=null){
               if (event.getTitle().equalsIgnoreCase(eventTitle)) {
                System.out.println("Event found!"); 
                   System.out.println(event); 
                   return;
                }
            
            Eventlist.findnext();
            event=Eventlist.retrieve();
        }
        System.out.println("Event is not found"); 

    }


    // a method to print event details    
    public void PrintEventByContact(String phone){

        Eventlist.findfirst(); 
        Event event = Eventlist.retrieve();
 
        while(event!=null){
               if ((event.getContactName().getPhoneNumber()).equals(phone)) {
                System.out.println("Event found!"); 
                   System.out.println(event); 
                   return;
                }
            
            Eventlist.findnext();
            event=Eventlist.retrieve();
        }
        System.out.println("Event is not found"); 

    }



    // a method to print all events that share the first name
    public void shareFirstName(String firstName){
        LinkedList<Contact> shareFirstName= new LinkedList<>();
        int i=0;

        Contactlist.findfirst();
        Contact contact = Contactlist.retrieve();

        while(contact!=null){

            if (contact.getName().toLowerCase().startsWith(firstName.toLowerCase())) {
                shareFirstName.insert(contact);
                i++;
            }

            Contactlist.findnext();
            contact=Contactlist.retrieve();
        }
            
        shareFirstName.findfirst();
        Contact c = shareFirstName.retrieve();
        for (int index = 0; index < i; index++) {
            System.out.println(c);
            shareFirstName.findnext();
            c=shareFirstName.retrieve();
        }
    	
    	if (shareFirstName.empty()) {
    	    System.out.println("No contacts found with the first name: " + firstName);
    	}
    }



    // a method that returns an object Contact from a Stirng
    public Contact searchContact(String name){
        if (name == null || name=="")
        return null;

        if (Contactlist.empty())
        return null;

        Contactlist.findfirst();
        Contact temp = Contactlist.retrieve();

        while(!((temp).getName().equalsIgnoreCase((name)))){
            Contactlist.findnext();
            temp=Contactlist.retrieve();
        }
        return temp;
    }



    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
            Phonebook phonebook = new Phonebook();

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
                System.out.println("8. Exit\n");
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

                        phonebook.addContact(new Contact(name, phone, email, address, birthday,notes));

                        break;
                    case 2:
                        System.out.println("Enter search criteria:\r\n"+"1. Name\r\n"+"2. Phone Number\r\n"+"3. Email Address\r\n"+"4. Address\r\n"+"5. Birthday\r");
                        System.out.println("Enter your choice: ");
                        int criteria = scanner.nextInt();
                        scanner.nextLine(); 

                    switch(criteria){

                        case 1:
                           System.out.print("Enter the contact's name: ");
                           String name1= scanner.nextLine();
                           phonebook.searchContactByName(name1);

                             
                            break;
                        case 2:
                            System.out.print("Enter the contact's phone number: ");
                            String phonenum=scanner.nextLine();
                            phonebook.searchContactsByPhonenumber(phonenum);

                            break;
                        case 3:
                            System.out.print("Enter the contact's email address:");
                            String email1 =scanner.nextLine();
                            phonebook.searchContactsByCriteria(email1);
                            break;
                        case 4:
                            System.out.print("Enter the contact's address:");
                            String addr =scanner.nextLine();
                            phonebook.searchContactsByCriteria(addr);
                            break;
                        case 5:
                            System.out.print("Enter the contact's birthday:");
                            String birthd =scanner.nextLine();
                            phonebook.searchContactsByCriteria(birthd);
                            break;
                    }

                        break;
                    case 3:
                        System.out.println("Enter the  contact's name:");
                        String name2 =scanner.next();
                    
                        if(phonebook.removeContact(phonebook.searchContact(name2))){
                            System.out.println("Contact was succesfully deleted!");
                        }
                        else{
                           System.out.println("Sorry couldn't find this contact!");
                        }
                        break;
                    case 4:
                        System.out.println("Enter event title:");
                        String eventtitle=  scanner.nextLine();
                        System.out.println("Enter contact name:");
                        String contactname= scanner.nextLine();
                        System.out.println("Enter event date and time (MM/DD/YYYY HH:MM):");
                        String date= scanner.nextLine();
                        System.out.println("Enter event location:");      
                        String location= scanner.nextLine();

                        Contact eContact=phonebook.searchContact(contactname);
                        phonebook.scheduleEvent(new Event(eventtitle, eContact, date, location)); 

                        break;
                    case 5:
                        System.out.println("Enter search criteria:\r\n" +  "1. contact name\r\n" + "2. Event tittle\r");
                        System.out.print("Enter your choice: ");
                        int search=  scanner.nextInt();
                        switch (search) {
                            case 1:
                            System.out.print("Enter contact name: ");
                            String Cname=  scanner.nextLine();
                            phonebook.PrintEventDetails(Cname);

                                break;
                            case 2:
                            System.out.print("Enter event tittle: ");

                             String eventT=  scanner.nextLine();
                             phonebook.PrintEventDetails(eventT);
                                
                                break;
                        
                            default:
                            System.out.print("invalid choice ");
                                break;
                        }
                    
                        break;
                    case 6:
                        System.out.print("Enter the first name: ");
                         String Fname=  scanner.nextLine();
                         phonebook.shareFirstName(Fname);
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
    
        scanner.close();

             

    }
}