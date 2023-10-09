import java.util.Scanner;

public class Phonebook {
        
    LinkedList<Contact> Contactlist= new LinkedList<>();
    LinkedList<Event> Eventlist= new LinkedList<>();

    

    public void addContact(Contact contact){
        if (!UniqueContact(contact)) {
            System.out.println("a contact with the same name or phone number already exists, Contact can not be added");
            return;
        }   
        
        Contactlist.insert(contact);
        System.out.println("Contact added successfully!"); 
    }
    

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


    public LinkedList<Contact> searchContactsByCriteria(String criteria) {
    LinkedList<Contact> Contacts= new LinkedList<>();

        Contactlist.findfirst();
        Contact contact = Contactlist.retrieve();

        while(contact!=null){

             if (contact.getEmail().equalsIgnoreCase(criteria) ||
                contact.getAddress().equalsIgnoreCase(criteria) ||
                contact.getBirthday().equalsIgnoreCase(criteria)) {
                Contacts.insert(contact); }

            Contactlist.findnext();
            contact=Contactlist.retrieve();
        }
        return Contacts;
    }


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

     
    public boolean removeContact(Contact contact){
        if(Contactlist.find(contact)){
            Contactlist.remove();
            return true;

        };
        return false;
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


    // a method to schedule an event while making sure it has no conflict
    public void scheduleEvent(Event event){
        if(hasEventConflict(event)){
            System.out.println("Sorry there was a conflict!");
            return;
        }
        Eventlist.insert(event);
        System.out.println("Event scheduled successfully!");
    }

    public void shareFirstName(String firstName){
    	Contact currentContact = null;
    	Contactlist.findfirst();
    	boolean discovered = false;
    	   
    	   while(!Contactlist.empty()) {
    		   currentContact = Contactlist.retrieve();
    		   
    		   if(currentContact.getName().equalsIgnoreCase(firstName)) {
    			   System.out.println("the contacts that share the same name: " + currentContact); 
    			   discovered = true;
    		   }
    		   
    		   Contactlist.findnext();
    	
    	   }
    	  if(!discovered) { 
    		  System.out.println("No contacts found with the same name as : " + firstName );
    	  }
    	  
    }

    public void shareEvents(){}

    public void shareFirstName(){}

    public void ContactExists(){}

    public boolean searchContactByName(String name){
    return true;
    }

    public boolean hasEventConflict(Event newEvent) {
    	   Eventlist.findfirst(); // Start at the beginning of the list

    	   while (!Eventlist.empty()) {
    	       Event existingEvent = Eventlist.retrieve();
               
               if (existingEvent.getDate().equals(newEvent.getDate())) {
    	           return true; 
    	        }
    	       
    	       Eventlist.findnext();
    	    }

    	   return false; 

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

                        Contact contact = new Contact(name, phone, email, address, birthday,notes);
                        phonebook.addContact(contact);

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

                            if(phonebook.searchContactByName(name1)){
                                System.out.println("Contact found!");
                            }
                             
                            break;
                        case 2:
                            System.out.print("Enter the contact's phone number: ");

                            break;
                        case 3:
                            System.out.print("Enter the contact's email address:");

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
                        Event event = new Event(eventtitle, eContact, date, location);
                        phonebook.scheduleEvent(event); 

                        break;
                    case 5:
                    
                        break;
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
    
        scanner.close();

             

    }
}