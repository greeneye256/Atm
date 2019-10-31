package Atm.bankNoteHolder;

public class BankNoteHolderOf100 extends BankNoteHolder {

    private BankNoteType bankNoteType;

    public BankNoteHolderOf100(BankNoteHolder bankNoteHolder) {
        super(bankNoteHolder);
        bankNoteType = BankNoteType.ONEHUNDRED;
    }

    @Override
    public BankNoteType getBankNoteType() {
        return bankNoteType;
    }
}
