class BankNoteHolderOf10 extends BankNoteHolder {

    BankNoteHolderOf10(BankNoteHolder bankNoteHolder) {
        super(bankNoteHolder);
        this.bankNoteType = BankNoteType.TEN;
    }
}
