class BankNoteHolderOf5 extends BankNoteHolder {

    private BankNoteType bankNoteType;

    BankNoteHolderOf5(BankNoteHolder bankNoteHolder) {
        super(bankNoteHolder);
        bankNoteType = BankNoteType.FIVE;
    }

    @Override
    public BankNoteType getBankNoteType() {
        return bankNoteType;
    }
}
