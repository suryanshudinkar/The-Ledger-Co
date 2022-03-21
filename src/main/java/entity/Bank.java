package entity;

import java.util.HashMap;

public class Bank {

    /*
        Description: This class stores the borrowers for a particular bank

        name: stores the name of the bank.
        borrowerHashMap: stores the borrowers for the above bank in the form of key-value par. Hashmap is used to quickly
                         get the borrower by just giving the borrower's name. As it was quite intuitive from the problem statement that
                         there won't be borrowers with same name in a bank, that's why I preferred Hashmap over List.
     */

    private String name;
    private HashMap<String,Borrower> borrowerHashMap;

    public Bank(String name) {
        this.name = name;
        this.borrowerHashMap = new HashMap<>();
    }

    public void addBorrower(Borrower borrower){
        borrowerHashMap.put(borrower.getName(),borrower);
    }

    public String getName() {
        return name;
    }

    public HashMap<String, Borrower> getBorrowerHashMap() {
        return borrowerHashMap;
    }
}
