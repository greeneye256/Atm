class BankNoteHolderOf5 extends BankNoteHolder {

    BankNoteHolderOf5(BankNoteHolder bankNoteHolder) {
        super(bankNoteHolder);
        this.bankNoteType = BankNoteType.FIVE;
    }
}
