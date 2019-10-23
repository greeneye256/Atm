public class AtmClient {

    public static void main(String[] args) {
        Atm myAtm = new Atm();
        myAtm.fillEachHolder();
        System.out.println(myAtm.getTotalCashOfAtm());
        myAtm.withdrawCash(-5000);
        System.out.println(myAtm.getTotalCashOfAtm());
        myAtm.withdrawCash(75);
    }

}
