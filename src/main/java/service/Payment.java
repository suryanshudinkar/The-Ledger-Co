package service;

import entity.Borrower;
import exception.TheLedgerCoException;
import run.LedgerCo;
import java.util.List;

public class Payment {

    /*
            Description: This class is used to serve all the payment related queries.
    */

    /* used to update the payment history of the current borrower */
    public static void pay(String input) throws TheLedgerCoException {

        String [] inputs=input.split(" ");

        /* validating payment query */
        if(!Validation.validatePaymentQuery(input)){
            throw new TheLedgerCoException("Please give the input for PAYMENT query as described in the problem statment");
        }

        String bank=inputs[1];
        String name=inputs[2];

        /* checking if user exists */
        if(!Validation.checkIfUserExists(bank,name)){
            throw new TheLedgerCoException("Wrong query, No such user exists for the given bank");
        }

        Borrower borrower= LedgerCo.bankHashMap.get(bank).getBorrowerHashMap().get(name);
        int emiToBeUpdated=Integer.valueOf(inputs[4]);
        int lumpSum=Integer.valueOf(inputs[3]);
        updatePaymentHistory(borrower,emiToBeUpdated,lumpSum);

    }

    /* method that is actually updating the payment history of a borrower's */
    public static void updatePaymentHistory(Borrower borrower,int emiToBeUpdated,int lumpSum) throws TheLedgerCoException {

        List<Integer> paymentHistory=borrower.getPaymentHistory();
        int lastEmiNo=paymentHistory.size()-1;
        int oneEmi=borrower.getOneEmiAmount();
        int totalSoFar=paymentHistory.get(lastEmiNo);
        int totalAmount=borrower.getTotalAmount();

        /* adding given lumpsum amount in the given emi*/
        if(emiToBeUpdated==lastEmiNo){
            totalSoFar=Math.min(totalAmount,totalSoFar+lumpSum);
            paymentHistory.set(emiToBeUpdated,totalSoFar);
        }

        /* already total amount has been paid */
        if(totalSoFar==borrower.getTotalAmount()){
            return;
        }

        /*
            filling total amount paid at ith EMI including lumpsum, this process starts from the
            last updated EMI no.
        */
        for(int i=lastEmiNo+1;i<=emiToBeUpdated;i++){

            if(i==emiToBeUpdated){
                paymentHistory.add(totalSoFar+oneEmi+lumpSum);
            }else {
                paymentHistory.add(totalSoFar+oneEmi);
            }

            if(paymentHistory.get(i)>=totalAmount){
                paymentHistory.set(i,totalAmount);
                break;
            }

            totalSoFar=paymentHistory.get(i);

        }
        borrower.setPaymentHistory(paymentHistory);
    }
}
