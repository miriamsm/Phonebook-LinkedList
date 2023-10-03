public class Event {
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
        return "{" +
            " title='" + getTitle() + "'" +
            ", contactName='" + getContactName() + "'" +
            ", date='" + getDate() + "'" +
            ", location='" + getLocation() + "'" +
            "}";
    }
    
    
}
