import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Atm {

    private List<BankNoteHolder> listOfBankNoteHolders = new ArrayList<>();

    Atm() {
        //chain of responsability
        BankNoteHolder bankNoteHolderOf5;
        listOfBankNoteHolders.add(bankNoteHolderOf5 = new BankNoteHolderOf5(null));
        BankNoteHolder bankNoteHolderOf10;
        listOfBankNoteHolders.add(bankNoteHolderOf10 = new BankNoteHolderOf10(bankNoteHolderOf5));
        BankNoteHolder bankNoteHolderOf50;
        listOfBankNoteHolders.add(bankNoteHolderOf50 = new BankNoteHolderOf50(bankNoteHolderOf10));
        BankNoteHolder bankNoteHolderOf100;
        listOfBankNoteHolders.add(bankNoteHolderOf100 = new BankNoteHolderOf100(bankNoteHolderOf50));
        BankNoteHolder bankNoteHolderOf200;
        listOfBankNoteHolders.add(bankNoteHolderOf200 = new BankNoteHolderOf200(bankNoteHolderOf100));
        listOfBankNoteHolders.sort(Comparator.comparing((BankNoteHolder b) -> b.bankNoteType.value));
    }

    List<BankNoteHolder> getListOfBankNoteHolders() {
        return listOfBankNoteHolders;
    }

    void fillEachHolder(){
        listOfBankNoteHolders.forEach(BankNoteHolder::fillBankNoteHolder);
    }

    int getTotalCashOfAtm(){
        int total = 0;
        for (BankNoteHolder bankNoteHolder:listOfBankNoteHolders
             ) {
            total += bankNoteHolder.numberOfBankNotes * bankNoteHolder.bankNoteType.value;
        }
        return total;
    }

    BankNoteHolder getHolder(BankNoteType bankNoteType){
        for (BankNoteHolder bankNoteHolder:listOfBankNoteHolders
        ) {
            if (bankNoteHolder.bankNoteType.value == bankNoteType.value){
                return bankNoteHolder;
            }
        }
        return null;
    }

    private boolean isValidAndAreEnoughMoney(int money){

        return listOfBankNoteHolders.get(listOfBankNoteHolders.size()-1).areEnoughMoney(money);
    }

    boolean withdrawCash(int money){
        if (money % listOfBankNoteHolders.get(0).bankNoteType.value != 0 || money == 0){
            System.out.println("The amount must be at least " + listOfBankNoteHolders.get(0).bankNoteType.value + " and multiple of it!");
            return false;
        }
        if (isValidAndAreEnoughMoney(money)){
            listOfBankNoteHolders.get(listOfBankNoteHolders.size()-1).withdrawCash(money);
            return true;
        }
        else {
            System.out.println("Out of money. We are sorry for the inconvenience. We will fix this as soon as possible.");
            return false;
        }

    }
}
