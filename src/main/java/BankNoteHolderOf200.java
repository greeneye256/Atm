class BankNoteHolderOf200 extends BankNoteHolder {

    private BankNoteType bankNoteType;

    BankNoteHolderOf200(BankNoteHolder bankNoteHolder) {
        super(bankNoteHolder);
        bankNoteType = BankNoteType.TWOHUNDRED;
    }

    @Override
    public BankNoteType getBankNoteType() {
        return bankNoteType;
    }
}
