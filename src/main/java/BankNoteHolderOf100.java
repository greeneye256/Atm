class BankNoteHolderOf100 extends BankNoteHolder {

    BankNoteHolderOf100(BankNoteHolder bankNoteHolder) {
        super(bankNoteHolder);
        this.bankNoteType = BankNoteType.ONEHUNDRED;
    }
}
