public class Event implements Comparable<Event> {
    private String title;
    private Contact contactName;
    private String date;
    private String location;


    public Event(String title, Contact contactName, String date, String location) {
        this.title = title;
        this.contactName = contactName;
        this.date = date;
        this.location = location;
    }

    public Event(Event event){
        this.title=event.title;
        this.contactName=event.contactName;
        this.date=event.date;
        this.location=event.location;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Contact getContactName() {
        return this.contactName;
    }

    public void setContactName(Contact contactName) {
        this.contactName = contactName;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return 
            " Title='" + getTitle() + "\n" +
            " ContactName='" + getContactName() + "\n" +
            " Date='" + getDate() + "\n" +
            " Location='" + getLocation() + "\n" ;
    }

    @Override
    public int compareTo(Event o) {
     return this.title.compareToIgnoreCase(o.getTitle());
    }
    
}
