public class Contact {
    private String name;
    private String phoneNumber;
    private String email;
    private String address;
    private String birthday;
    private String notes;

    public Contact(String name, String phoneNumber, String email, String address, String birthday, String notes) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address=address;
        this.birthday=birthday;
        this.notes=notes;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthday() {
        return this.birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
    

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", phoneNumber='" + getPhoneNumber() + "'" +
            ", email='" + getEmail() + "'" +
            ", address='" + getAddress() + "'" +
            ", birthday='" + getBirthday() + "'" +
            ", notes='" + getNotes() + "'" +
            "}";
    }
    
   
    
}
