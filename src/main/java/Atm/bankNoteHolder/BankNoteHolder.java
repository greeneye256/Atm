package Atm.bankNoteHolder;

public abstract class BankNoteHolder {

    private BankNoteHolder nextBankNoteHolder;

    private int numberOfBankNotes;

    private static final int MAXOFBANKNOTES = 200;

    public BankNoteHolder(BankNoteHolder bankNoteHolder) {
        this.nextBankNoteHolder = bankNoteHolder;
    }

    public int getValue() {

        return numberOfBankNotes * getBankNoteType().value + (nextBankNoteHolder == null ? 0 : nextBankNoteHolder.getValue());
    }

    public abstract BankNoteType getBankNoteType();

    private void printReturnedBankNotes(int numberOfReturnedBankNotes) {
        if (numberOfReturnedBankNotes == 0) {
            return;
        }
        System.out.println(numberOfReturnedBankNotes + " * " + getBankNoteType());
    }

    public boolean withdrawCash(int money) {
        int bankNoteValue = getBankNoteType().value;
        int requiredBankNotes = money / bankNoteValue;
        int preparedBankNotes = (requiredBankNotes > this.numberOfBankNotes) ? this.numberOfBankNotes : requiredBankNotes;
        int moneyPassedToNextBankNoteHolder = money - preparedBankNotes * bankNoteValue;

        if (money == 0) {
            return true;
        }

        if (nextBankNoteHolder != null) {
            if (nextBankNoteHolder.withdrawCash(moneyPassedToNextBankNoteHolder)) {
                this.numberOfBankNotes -= preparedBankNotes;
                printReturnedBankNotes(preparedBankNotes);
                return true;
            } else {
                return false;
            }
        } else {
            if (moneyPassedToNextBankNoteHolder == 0) {
                this.numberOfBankNotes -= preparedBankNotes;
                printReturnedBankNotes(preparedBankNotes);
                return true;
            } else {
                return false;
            }
        }
    }

    public void fillBankNoteHolder() {

        this.numberOfBankNotes = MAXOFBANKNOTES;
        if (nextBankNoteHolder != null) {
            nextBankNoteHolder.fillBankNoteHolder();
        }
    }

    public void setNumberOfBankNotes(BankNoteType bankNoteType, int numberOfBankNotes) {
        if (this.getBankNoteType() == bankNoteType) {
            this.numberOfBankNotes = numberOfBankNotes;
        } else {
            nextBankNoteHolder.setNumberOfBankNotes(bankNoteType, numberOfBankNotes);
        }
    }

    public int getNumberOfBankNotes(BankNoteType bankNoteType) {
        if (this.getBankNoteType() == bankNoteType) {
            return this.numberOfBankNotes;
        } else {
            return nextBankNoteHolder.getNumberOfBankNotes(bankNoteType);
        }
    }
}
