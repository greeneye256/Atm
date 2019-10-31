package Atm.bankNoteHolder;

public class BankNoteHolderOf5 extends BankNoteHolder {

    private BankNoteType bankNoteType;

    public BankNoteHolderOf5(BankNoteHolder bankNoteHolder) {
        super(bankNoteHolder);
        bankNoteType = BankNoteType.FIVE;
    }

    @Override
    public BankNoteType getBankNoteType() {
        return bankNoteType;
    }
}
