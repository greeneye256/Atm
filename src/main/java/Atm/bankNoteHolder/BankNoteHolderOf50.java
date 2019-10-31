package Atm.bankNoteHolder;

public class BankNoteHolderOf50 extends BankNoteHolder {

    private BankNoteType bankNoteType;

    public BankNoteHolderOf50(BankNoteHolder bankNoteHolder) {
        super(bankNoteHolder);
        bankNoteType = BankNoteType.FIFTY;
    }

    @Override
    public BankNoteType getBankNoteType() {
        return bankNoteType;
    }
}
