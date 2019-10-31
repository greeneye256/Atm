package Atm.bankNoteHolder;

public class BankNoteHolderOf200 extends BankNoteHolder {

    private BankNoteType bankNoteType;

    public BankNoteHolderOf200(BankNoteHolder bankNoteHolder) {
        super(bankNoteHolder);
        bankNoteType = BankNoteType.TWOHUNDRED;
    }

    @Override
    public BankNoteType getBankNoteType() {
        return bankNoteType;
    }
}
