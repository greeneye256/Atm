package Atm.bankNoteHolder;

public class BankNoteHolderOf10 extends BankNoteHolder {

    private BankNoteType bankNoteType;

    public BankNoteHolderOf10(BankNoteHolder bankNoteHolder) {
        super(bankNoteHolder);
        bankNoteType = BankNoteType.TEN;
    }

    @Override
    public BankNoteType getBankNoteType() {
        return bankNoteType;
    }
}
