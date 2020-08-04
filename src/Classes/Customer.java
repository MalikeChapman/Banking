package Classes;

import java.time.LocalDate;
import java.util.UUID;

public class Customer {
    private String firstName;
    private String lastName;
    private String fullName;
    private int year;
    private int month;
    private int day;
    private LocalDate dateOfBirth;
    private int age;
    private String address;
    private String email;
    private String phoneNumber;
    private String username;
    private String pin;
    private UUID uniqueID;

    public Customer(){

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = Verification.usernameVerification(username);
    }

    public String getPin() {
        return pin;
    }

    public void setPin() {
        this.pin = Verification.userPinVerification();
    }
    public void setPin(String pin){
        this.pin = pin;
    }

    public Customer(String firstName, String lastName, int year, int month, int day, String address, String email, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = firstName + " " + lastName;
        this.dateOfBirth = LocalDate.of(year, month, day);
        this.year = year;
        this.month = month;
        this.day = day;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        uniqueID = UUID.randomUUID();

    }
    public int calculateAge(LocalDate dateOfBirth){
        int calculatedAge;
        if ((dateOfBirth.getMonth() != LocalDate.now().getMonth()) && (dateOfBirth.getDayOfMonth() != LocalDate.now().getDayOfMonth())){
            return calculatedAge = (LocalDate.now().getYear() - dateOfBirth.getYear()) - 1;
        }
        else {
            return calculatedAge = LocalDate.now().getYear() - dateOfBirth.getYear();

        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String firstName, String lastName) {
        this.fullName = firstName + ", " + lastName;
    }
    public void setFullName(String name){
        this.fullName = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    @Override
    public String toString() {
        return fullName + ", " + year + ", " + month + ", " + day + ", " + age + ", " + address + ", " + email + ", " + phoneNumber + ", " + username + ", " + pin;
    }
}
