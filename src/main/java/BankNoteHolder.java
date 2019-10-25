public abstract class BankNoteHolder {

    private BankNoteHolder nextBankNoteHolder;

    private int numberOfBankNotes;

    private static final int MAXOFBANKNOTES = 200;

    BankNoteHolder(BankNoteHolder bankNoteHolder) {
        this.nextBankNoteHolder = bankNoteHolder;
    }

    public int getValue() {

        return numberOfBankNotes * getBankNoteType().value + (nextBankNoteHolder == null ? 0 : nextBankNoteHolder.getValue());
    }

    public abstract BankNoteType getBankNoteType();

    private void printReturnedBankNotes(int numberOfReturnedBankNotes) {
        System.out.println(numberOfReturnedBankNotes + " * " + getBankNoteType());
    }

    boolean withdrawCash(int money) {
        int bankNoteValue = getBankNoteType().value;
        int requiredBankNotes = money / bankNoteValue;
        int preparedBankNotes = (requiredBankNotes > this.numberOfBankNotes) ? this.numberOfBankNotes : requiredBankNotes;
        int moneyInHolder = this.numberOfBankNotes * bankNoteValue;

        if (moneyInHolder == 0 || requiredBankNotes == 0) {
            return (nextBankNoteHolder != null) && nextBankNoteHolder.withdrawCash(money);
        }

        if (money % bankNoteValue == 0 && moneyInHolder - money >= 0) {
            this.numberOfBankNotes -= requiredBankNotes;
            printReturnedBankNotes(requiredBankNotes);
            return true;
        }

        if (nextBankNoteHolder == null) {return false;}

        if (nextBankNoteHolder.withdrawCash(money - preparedBankNotes * bankNoteValue)) {
            this.numberOfBankNotes -= preparedBankNotes;
            printReturnedBankNotes(preparedBankNotes);
            return true;
        }
        return false;
    }

    public void fillBankNoteHolder() {

        this.numberOfBankNotes = MAXOFBANKNOTES;
        if (nextBankNoteHolder != null) {
            nextBankNoteHolder.fillBankNoteHolder();
        }
    }

    public BankNoteHolder getBankNoteHolder(BankNoteType bankNoteType) {
        if (this.getBankNoteType() == bankNoteType) {
            return this;
        } else {
            return nextBankNoteHolder.getBankNoteHolder(bankNoteType);
        }
    }
}
