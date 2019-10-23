class BankNoteHolderOf10 extends BankNoteHolder {

    private BankNoteType bankNoteType;

    BankNoteHolderOf10(BankNoteHolder bankNoteHolder) {
        super(bankNoteHolder);
        bankNoteType = BankNoteType.TEN;
    }

    @Override
    public BankNoteType getBankNoteType() {
        return bankNoteType;
    }
}
