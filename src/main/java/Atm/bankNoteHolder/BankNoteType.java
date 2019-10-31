package Atm.bankNoteHolder;

import Atm.Atm;

public enum BankNoteType {
    TWOHUNDRED(200), ONEHUNDRED(100), FIFTY(50), TEN(10), FIVE(5);
    public int value;

    BankNoteType(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "" + value;
    }
}

