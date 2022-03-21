package service;

import entity.Bank;
import entity.Borrower;
import exception.TheLedgerCoException;
import run.LedgerCo;

public class Loan {

    /*
            Description: This class is used to serve all the loan related queries.
    */

    /* used to calculate total amount which the borrower has to pay */
    public static int totalAmountToBePaid(double principal,double loanPeriod,double rateOfInterest){

        double interest=principal*loanPeriod*rateOfInterest;
        double totalAmount=principal+interest;

        return (int) Math.ceil(totalAmount);
    }

    /* used to intialize a new bank */
    public static void initializeBank(String bank){
        LedgerCo.bankHashMap.put(bank,new Bank(bank));
    }

    /* used to add a new borrower for a bank */
    public static void initializeBorrower(String input) throws TheLedgerCoException { // used to

        String [] inputs=input.split(" ");

        /* validating loan query */
        if(!Validation.validateLoanQuery(input)){
            throw new TheLedgerCoException("Please give the input for LOAN query as described in the problem statment");
        }

        String bank=inputs[1];
        String name=inputs[2];
        double principal=Integer.valueOf(inputs[3]);
        double loanPeriod=Integer.valueOf(inputs[4]);
        double rateOfInterest=Integer.valueOf(inputs[5]);

        if(!LedgerCo.bankHashMap.containsKey(bank)){
            initializeBank(bank);
        }

        if(LedgerCo.bankHashMap.get(bank).getBorrowerHashMap().containsKey(name)){
            throw new TheLedgerCoException("borrower already exists for this bank");
        }

        Borrower borrower=new Borrower(name,bank,principal,loanPeriod,rateOfInterest);
        LedgerCo.bankHashMap.get(bank).getBorrowerHashMap().put(name,borrower);
    }

    /* calculating emi amount */
    public static int calculateOneEmiAmount(double totalAmount, double months) {
        return (int) Math.ceil(totalAmount/months);
    }
}
