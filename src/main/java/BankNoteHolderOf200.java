class BankNoteHolderOf200 extends BankNoteHolder {

    BankNoteHolderOf200(BankNoteHolder bankNoteHolder) {
        super(bankNoteHolder);
        this.bankNoteType = BankNoteType.TWOHUNDRED;
    }
}
