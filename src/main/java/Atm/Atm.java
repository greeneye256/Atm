package Atm;

import Atm.bankNoteHolder.*;

public class Atm {

    private BankNoteHolder minBankNoteHolder;
    private BankNoteHolder maxBankNoteHolder;

    public Atm() {
        //chain of responsability
        BankNoteHolder bankNoteHolder = new BankNoteHolderOf5(null);
        minBankNoteHolder = bankNoteHolder;
        bankNoteHolder = new BankNoteHolderOf10(bankNoteHolder);
        bankNoteHolder = new BankNoteHolderOf50(bankNoteHolder);
        bankNoteHolder = new BankNoteHolderOf100(bankNoteHolder);
        bankNoteHolder = new BankNoteHolderOf200(bankNoteHolder);
        maxBankNoteHolder = bankNoteHolder;
    }

    public void fillEachHolder() {
        maxBankNoteHolder.fillBankNoteHolder();
    }

    public int getTotalCashOfAtm() {
        return maxBankNoteHolder.getValue();
    }

    public boolean withdrawCash(int money) {
        if (money % minBankNoteHolder.getBankNoteType().value != 0 || money <= 0) {
            System.out.println("The amount must be at least " + minBankNoteHolder.getBankNoteType().value + " and multiple of it!");
            return false;
        }
        if (maxBankNoteHolder.withdrawCash(money)) {
            return true;
        } else {
            System.out.println("Out of money. We are sorry for the inconvenience. We will fix this as soon as possible.");
            return false;
        }
    }

    public void setNumberOfBankNotesInAtm(BankNoteType bankNoteType, int numberOfBankNotes){
        maxBankNoteHolder.setNumberOfBankNotes(bankNoteType,numberOfBankNotes);
    }

    public int getNumbersOfBankNotesInAtm(BankNoteType bankNoteType){
        return maxBankNoteHolder.getNumberOfBankNotes(bankNoteType);
    }
}
