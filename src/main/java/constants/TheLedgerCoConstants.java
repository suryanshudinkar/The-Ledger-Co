package constants;

import java.util.Arrays;
import java.util.List;

public class TheLedgerCoConstants {

    /*
        Description: This class is used to store all the constants used in the program.
     */

    public static final List<String> QUERIES= Arrays.asList(new String[]{"LOAN", "PAYMENT", "BALANCE"});
    public static final int fieldsInLoanQuery=6;
    public static final int fieldsInPaymentQuery=5;
    public static final int fieldsInBalanceQuery=4;
}
