package service;

import entity.Borrower;
import exception.TheLedgerCoException;
import run.LedgerCo;

import java.util.List;

public class Balance {
    public static void showBalance(String input) throws TheLedgerCoException {

        /*
            Description: This class is used to serve all the balance related queries.
         */

        String [] inputs=input.split(" ");

        if(!Validation.validateBalanceQuery(input)){                //validating balance query
            throw new TheLedgerCoException("Please give the input for BALANCE query as described in the problem statment");
        }

        String bank=inputs[1];
        String name=inputs[2];
        int emiNo=Integer.valueOf(inputs[3]);

        if(!Validation.checkIfUserExists(bank,name)){              //checking if user exists or not
            throw new TheLedgerCoException("Wrong query, No user exists for the given bank");
        }

        Borrower borrower= LedgerCo.bankHashMap.get(bank).getBorrowerHashMap().get(name); //getting the borrower's info by providing bank and borrower's name.
        Payment.updatePaymentHistory(borrower,emiNo,0);                          //updating the payment history of current borrower, so that correct balance could be shown.
        showBalance(borrower,emiNo);            //used to display balance for current borrower.
    }

    private static void showBalance(Borrower borrower,int emiNo) throws TheLedgerCoException {
        List<Integer> paymentHistory=borrower.getPaymentHistory();

        if(emiNo>=paymentHistory.size()){
            throw new TheLedgerCoException("Total amount has already been paid by "+borrower.getName()+" before this EMI");
        }
        double totalAmountToBePaid=borrower.getTotalAmount();
        double totalAmountPaidSoFar=paymentHistory.get(emiNo);
        double oneEmi=borrower.getOneEmiAmount();
        int emisLeft= (int) Math.ceil((totalAmountToBePaid-totalAmountPaidSoFar)/oneEmi);  //calculating  no of Emis left.



        System.out.println(borrower.getBank()+" "+borrower.getName()+" "+String.valueOf((int) totalAmountPaidSoFar)+" "+String.valueOf(emisLeft));
    }
}
