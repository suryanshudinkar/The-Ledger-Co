package entity;

import service.Loan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Borrower {

    /*
        Description: This class is used to store all the necessary information of a borrower.
     */
    private String name;
    private String bank;
    private double principal;
    private double loanPeriod;
    private double rateOfInterest;
    private int totalAmount;
    private int oneEmiAmount;
    private List<Integer> paymentHistory;

    public Borrower(){}

    public Borrower(String name, String bank, double principal, double loanPeriod, double interest) {
        this.name = name;
        this.bank = bank;
        this.principal = principal;
        this.loanPeriod = loanPeriod;
        this.rateOfInterest = interest/100.0;
        paymentHistory=new ArrayList<>(Arrays.asList(0));
        totalAmount= Loan.totalAmountToBePaid(this.principal,this.loanPeriod,this.rateOfInterest);
        oneEmiAmount=Loan.calculateOneEmiAmount((double) this.totalAmount,this.loanPeriod*12);
    }

    public String getName() {
        return name;
    }

    public String getBank() {
        return bank;
    }

    public double getPrincipal() {
        return principal;
    }

    public double getLoanPeriod() {
        return loanPeriod;
    }

    public double getRateOfInterest() {
        return rateOfInterest;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public int getOneEmiAmount() {
        return oneEmiAmount;
    }

    public List<Integer> getPaymentHistory() {
        return paymentHistory;
    }

    public void setPaymentHistory(List<Integer> paymentHistory) {
        this.paymentHistory = paymentHistory;
    }
}
