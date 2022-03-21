package service;

import constants.TheLedgerCoConstants;
import run.LedgerCo;

import java.util.List;

public class Validation {

     /*
        Description: This class is used to serve all validation related queries.
     */


    /* validate given input i.e input should start with either of these commands i.e LOAN, PAYMENT, BALANCE */
    public static boolean validateInput(String input){

        String [] in=input.split(" ");
        String typeOfQuery=in[0];

        List<String> queries= TheLedgerCoConstants.QUERIES;

        if(queries.contains(typeOfQuery))
            return true;
        else
            return false;

    }

    /* validating Loan query by checking no of words in it*/
    public static boolean validateLoanQuery(String input) {
        String [] in=input.split(" ");

        if(in.length!=TheLedgerCoConstants.fieldsInLoanQuery)
            return false;
        else
            return true;
    }

    /* validating Payment query by checking no of words in it*/
    public static boolean validatePaymentQuery(String input) {
        String [] in=input.split(" ");

        if(in.length!=TheLedgerCoConstants.fieldsInPaymentQuery)
            return false;
        else
            return true;
    }

    /* validating Balance query by checking no of words in it*/
    public static boolean validateBalanceQuery(String input) {
        String [] in=input.split(" ");

        if(in.length!=TheLedgerCoConstants.fieldsInBalanceQuery)
            return false;
        else
            return true;
    }

    public static boolean checkIfBankExists(String bank) {

        if(LedgerCo.bankHashMap.containsKey(bank))
         return true;
        else
            return false;
    }

    public static boolean checkIfUserExists(String bank,String name) {

        if((checkIfBankExists(bank))&&(LedgerCo.bankHashMap.get(bank).getBorrowerHashMap().containsKey(name)))
            return true;
        else
            return false;

    }
}
