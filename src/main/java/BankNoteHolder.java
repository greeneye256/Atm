abstract class BankNoteHolder {
    private BankNoteHolder bankNoteHolder;
    BankNoteType bankNoteType;
    int numberOfBankNotes;
    private static final int MAXOFBANKNOTES = 200;

    BankNoteHolder(BankNoteHolder bankNoteHolder) {
        this.bankNoteHolder = bankNoteHolder;
    }

    void fillBankNoteHolder() {
        this.numberOfBankNotes = MAXOFBANKNOTES;
    }

    void withdrawCash(int money) {
        if (this.numberOfBankNotes == 0) {
            this.bankNoteHolder.withdrawCash(money);
            return;
        }
        if (money % bankNoteType.value != 0) {
            if (money / bankNoteType.value == 0) {
                this.bankNoteHolder.withdrawCash(money);
                return;
            }
            System.out.println(money / bankNoteType.value + " * " + bankNoteType.value);
            this.numberOfBankNotes -= money / bankNoteType.value;
            this.bankNoteHolder.withdrawCash(money % bankNoteType.value);
            return;
        }
        System.out.println(money / bankNoteType.value + " * " + bankNoteType.value);
        this.numberOfBankNotes -= money / bankNoteType.value;
    }

    boolean areEnoughMoney(int money) {
        if (money % bankNoteType.value == 0 && numberOfBankNotes * bankNoteType.value >= money) {
            return true;
        }
        if (bankNoteHolder == null) {
            return false;
        }
        if (numberOfBankNotes * bankNoteType.value > money){
            return bankNoteHolder.areEnoughMoney(money % bankNoteType.value);
        }
        else return bankNoteHolder.areEnoughMoney(money - (numberOfBankNotes * bankNoteType.value));
    }
}
