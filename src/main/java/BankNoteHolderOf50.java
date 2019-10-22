class BankNoteHolderOf50 extends BankNoteHolder {

    BankNoteHolderOf50(BankNoteHolder bankNoteHolder) {
        super(bankNoteHolder);
        this.bankNoteType = BankNoteType.FIFTY;
    }
}
