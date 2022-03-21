# The-Ledger-Co

Link to the problem statement : https://codu.ai/coding-problem/the%20ledger%20co

The Ledger Co., a marketplace for banks to lend money to borrowers and receive payments for the loans. The interest for the loan is calculated by I = P*N*R where P is the principal amount, N is the number of years and R is the rate of interest. The total amount to repay will be A = P + I The amount should be paid back monthly in the form of EMIs. The borrowers can also pay a lump sum (that is, an amount more than their monthly EMI). In such a case, the lump sum will be deducted from the total amount (A) which can reduce the number of EMIs. This doesn’t affect the EMI amount unless the remaining total amount is less than the EMI. All transactions happen through The Ledger Co.

Input Commands

There are 3 input commands defined to separate out the actions. Input format will start with either of these commands i.e LOAN, PAYMENT, BALANCE

LOAN

The LOAN command receives a Bank name, Borrower name, Principal Amount, No of Years of Loan period and the Rate of Interest along with it.

Format - LOAN BANK_NAME BORROWER_NAME PRINCIPAL NO_OF_YEARS RATE_OF_INTEREST
Example- LOAN IDIDI Dale 10000 5 4 means a loan amount of 10000 is paid to Dale by IDIDI for a tenure of 5 years at 4% rate of interest.

PAYMENT

The PAYMENT command receives a Bank name, Borrower name, Lump sum amount and EMI number along with it. The EMI number indicates that the lump sum payment is done after that EMI.

Format - PAYMENT BANK_NAME BORROWER_NAME LUMP_SUM_AMOUNT EMI_NO
Example - PAYMENT MBI Dale 1000 5 means a lump sum payment of 1000 was done by Dale to MBI after 5 EMI payments.

BALANCE

The BALANCE command receives a Bank name, Borrower name and a EMI number along with it. It prints the total amount paid by the borrower, including all the Lump Sum amounts paid including that EMI number, and the no of EMIs remaining.

Input format - BALANCE BANK_NAME BORROWER_NAME EMI_NO
Example - BALANCE MBI Harry 12 means - print the amount paid including 12th EMI, and EMIs remaining for user Harry against the lender MBI.

Output format - BANK_NAME BORROWER_NAME AMOUNT_PAID NO_OF_EMIS_LEFT
Example - MBI Harry 1250 43

Assumptions
1. Repayments will be paid every month as EMIs until the total amount is recovered.
2. Lump sum amounts can be paid at any point of time before the end of tenure.
3. The EMI amount will be always ceiled to the nearest integer. For example 86.676767 can be ceiled to 87 and 100.10 to 101.
4. The no of EMIs should be ceiled to the nearest whole number. For example 23.79 will be ceiled to 24 and 23.1 will also be ceiled to 24.
5. If the last EMI is more than the remaining amount to pay, then it should be adjusted to match the amount remaining to pay. E.g. if the remaining amount to pay is 150 and your EMI is 160, then the last EMI amount paid should be 150.
6. The total amount remaining at any EMI number should always include the EMIs paid and lump sum payments until that number. For example if there was a lump sum payment after EMI number 10, then the balance command for EMI number 10 should include the lump sum payment as well.

SAMPLE INPUT-OUTPUT 1

INPUT: <br />
LOAN IDIDI Dale 10000 5 4 <br />
LOAN MBI Harry 2000 2 2 <br />
BALANCE IDIDI Dale 5 <br />
BALANCE IDIDI Dale 40 <br />
BALANCE MBI Harry 12 <br />
BALANCE MBI Harry 0 <br />

OUTPUT: <br />
IDIDI Dale 1000 55 <br />
IDIDI Dale 8000 20 <br />
MBI Harry 1044 12 <br />
MBI Harry 0 24 <br />

SAMPLE INPUT-OUTPUT 2 <br />

INPUT: <br />
LOAN IDIDI Dale 5000 1 6 <br />
LOAN MBI Harry 10000 3 7 <br />
LOAN UON Shelly 15000 2 9 <br />
PAYMENT IDIDI Dale 1000 5 <br />
PAYMENT MBI Harry 5000 10 <br />
PAYMENT UON Shelly 7000 12 <br />
BALANCE IDIDI Dale 3 <br />
BALANCE IDIDI Dale 6 <br />
BALANCE UON Shelly 12 <br />
BALANCE MBI Harry 12 <br />

OUTPUT: <br />
IDIDI Dale 1326 9 <br />
IDIDI Dale 3652 4 <br />
UON Shelly 15856 3 <br />
MBI Harry 9044 10 <br />


