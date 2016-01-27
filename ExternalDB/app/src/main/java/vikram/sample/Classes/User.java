package vikram.sample.Classes;

/**
 * Created by bosco on 8/31/2015.
 */
public class User {
    private String userID;
    private String userName;
    private String passWord;
    private byte[] userImage;
    private String FirstName;
    private String LastName;
    private String Gender;
    private String phoneNumber;
    private String email;
    private String address;
    private String bday;

    public User(String userID, String userName, String passWord, byte[] userImage, String firstName, String lastName, String gender, String phoneNumber, String email, String address, String bday) {
        this.userID = userID;
        this.userName = userName;
        this.passWord = passWord;
        this.userImage = userImage;
        FirstName = firstName;
        LastName = lastName;
        Gender = gender;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.bday = bday;
    }


    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public byte[] getUserImage() {
        return userImage;
    }

    public void setUserImage(byte[] userImage) {
        this.userImage = userImage;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBday() {
        return bday;
    }

    public void setBday(String bday) {
        this.bday = bday;
    }
}
