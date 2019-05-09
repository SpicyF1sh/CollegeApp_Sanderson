package com.hsandies.collegeapp_sanderson;

import java.util.ArrayList;

public class Family {
    private final String TAG = Family.class.getName();
    private static ArrayList<FamilyMember> family;
    private static Family sFamily;

    private Family(){
        family = new ArrayList<>();
        family.add(new Guardian("John","Doe", "Accountant"));
        family.add(new Guardian("Jane", "Doe", "Walmart Cashier"));
        family.add(new Sibling("Joe", "Shmoe"));
    }

    public static Family getFamily(){
        if(sFamily == null){
            sFamily = new Family();
        }
        return sFamily;
    }

    public static ArrayList<FamilyMember> getFamilyList(){
        return family;
    }

    public void setFamily(ArrayList<FamilyMember> family) {
        this.family = family;
    }

    public void addFamilyMember(FamilyMember familyMember){
        family.add(familyMember);
    }

    public void deleteFamilyMember(FamilyMember familyMember){
        family.remove(familyMember);
    }
}