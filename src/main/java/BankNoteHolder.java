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

    public int getNumberOfBankNotes() {
        return numberOfBankNotes;
    }

    public abstract BankNoteType getBankNoteType();

    boolean withdrawCash(int money) {
        int moneyInHolder = this.numberOfBankNotes * getBankNoteType().value;
        int preparedBankNotes = 0;
        if (moneyInHolder == 0) {
            if (nextBankNoteHolder == null) {
                return false;
            } else {
                nextBankNoteHolder.withdrawCash(money);
            }

        } else {
            if (money % getBankNoteType().value == 0){
                if (moneyInHolder - money >= 0){
                    System.out.println(money/getBankNoteType().value + " * " + getBankNoteType().value);
                    this.numberOfBankNotes -= money / getBankNoteType().value;
                    return true;
                }
                else {
                    preparedBankNotes = numberOfBankNotes;
                    if (nextBankNoteHolder == null){return false;}
                    if (nextBankNoteHolder.withdrawCash(money - (preparedBankNotes * getBankNoteType().value))){
                        if (preparedBankNotes != 0){
                            System.out.println(preparedBankNotes + " * " + getBankNoteType().value);
                        }
                        this.numberOfBankNotes = 0;
                        return true;
                    }

                }
            }
            else {
                if (this.numberOfBankNotes < money / getBankNoteType().value){
                    preparedBankNotes = this.numberOfBankNotes;
                    if (nextBankNoteHolder.withdrawCash(money - (preparedBankNotes * getBankNoteType().value))){
                        if (preparedBankNotes != 0){
                            System.out.println(preparedBankNotes + " * " + getBankNoteType().value);
                        }
                        this.numberOfBankNotes = 0;
                        return true;
                    }
                }
                else {
                    preparedBankNotes = money / getBankNoteType().value;
                    if (nextBankNoteHolder.withdrawCash(money % getBankNoteType().value)){
                        if (preparedBankNotes != 0){
                            System.out.println(preparedBankNotes + " * " + getBankNoteType().value);
                        }
                        this.numberOfBankNotes -= preparedBankNotes;
                        return true;
                    }
                }
            }
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
