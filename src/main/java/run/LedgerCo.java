package run;

import entity.Bank;
import entity.Borrower;
import exception.TheLedgerCoException;
import service.Balance;
import service.Loan;
import service.Payment;
import service.Validation;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class LedgerCo {

    /*
        Description: This is our main class.

        bankHashMap: used to store the information of a bank. Hashmap is used to quickly
                     get the bank information by just giving the bank's name and from there,
                     we are fetching the borrower's information.
     */

    public static HashMap<String, Bank> bankHashMap =new HashMap<>();

    public static void main(String[] args){

        try {
            if(args.length!=1){
                throw new TheLedgerCoException("Please, provide the input file correctly");
            }

            File file=new File(args[0]);
            Scanner scanner=new Scanner(file);

            while(scanner.hasNextLine()){

                String input=scanner.nextLine();

                try {
                    if(!Validation.validateInput(input)){
                        throw new TheLedgerCoException("Wrong Input Format for the input: "+input);
                    }
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }


                String []temp=input.split(" ");
                String typeOfQuery=temp[0];

                try {

                    switch (typeOfQuery){
                        case "LOAN":
                            Loan.initializeBorrower(input);
                            break;
                        case "BALANCE":
                            Balance.showBalance(input);
                            break;
                        case "PAYMENT":
                            Payment.pay(input);
                            break;
                    }

                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
