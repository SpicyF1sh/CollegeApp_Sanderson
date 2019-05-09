package com.hsandies.collegeapp_sanderson;

public class Guardian extends FamilyMember {

    //Variable instantiation for mOccupation
    String mOccupation;

    //Getter for Guardian object LastName
    public String getLastName() {
        return mLastName;
    }

    //Setter for Guardian LastName
    public void setLastName(String lastName) {
        this.mLastName = lastName;
    }

    //Getter for Guardian FirstName
    public String getFirstName() {
        return mFirstName;
    }

    //Setter for Guardian FirstName
    public void setFirstName(String firstName) {
        this.mFirstName = firstName;
    }

    //Setter for Guardian occupation
    public void setOccupation(String occupation) {
        mOccupation = occupation;
    }

    //Getter for Guardian occupation
    public String getOccupation() {
        return mOccupation;
    }

    //Constructor for Guardian object with defaults
    public Guardian(){
        super();
        mOccupation = "Mechanic";
    }

    //Constructor for Guardian object with parameters for firstName, lastName, and occupation
    public Guardian(String firstName, String lastName){
        super(firstName, lastName);
        mOccupation = "CEO";
    }

    //Constructor for Guardian object with parameters for firstName, lastName, and occupation
    public Guardian(String firstName, String lastName, String occupation){
        super(firstName, lastName);
        mOccupation = occupation;
    }

    //Returns easy to read string format for Guardian
    @Override
    public String toString(){
        return "Guardian: "+ getFirstName() + " "+ getLastName()+ "\nOccupation: " + this.getOccupation();
    }


}
