class BankNoteHolderOf100 extends BankNoteHolder {

    private BankNoteType bankNoteType;

    BankNoteHolderOf100(BankNoteHolder bankNoteHolder) {
        super(bankNoteHolder);
        bankNoteType = BankNoteType.ONEHUNDRED;
    }

    @Override
    public BankNoteType getBankNoteType() {
        return bankNoteType;
    }
}
