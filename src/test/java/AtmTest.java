import Atm.Atm;
import Atm.bankNoteHolder.BankNoteType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AtmTest {
    private Atm atm;
    private final int MAXIMUM_AMOUNT_IN_ATM = 5 * 200 + 10 * 200 + 50 * 200 + 100 * 200 + 200 * 200;

    @Before
    public void setAtm() {
        atm = new Atm();
    }

    @Test
    public void atmCreation() {
        Assert.assertEquals(0, atm.getTotalCashOfAtm());
    }

    @Test
    public void withdrawWhenAtmIsEmpty() {
        Assert.assertFalse(atm.withdrawCash(200));
    }

    @Test
    public void fillAtm() {

        //when
        atm.fillEachHolder();
        //then
        Assert.assertEquals(MAXIMUM_AMOUNT_IN_ATM, atm.getTotalCashOfAtm());
    }

    @Test
    public void setsNumberOfBankNotesInHolder() {
        atm.setNumberOfBankNotesInAtm(BankNoteType.FIVE, 1);
        Assert.assertEquals(5, atm.getTotalCashOfAtm());
    }

    @Test
    public void withdraw0Money() {
        Assert.assertFalse(atm.withdrawCash(0));
    }

    @Test
    public void withdrawMinusAmount() {
        Assert.assertFalse(atm.withdrawCash(-5));
    }

    @Test
    public void areMoneyWithdraw() {
        //given
        atm.fillEachHolder();
        //when
        atm.withdrawCash(250);
        //then
        Assert.assertEquals(MAXIMUM_AMOUNT_IN_ATM - 250, atm.getTotalCashOfAtm());
    }

    @Test
    public void impossibleWithdraw1() {
        //when
        atm.fillEachHolder();
        atm.withdrawCash(MAXIMUM_AMOUNT_IN_ATM - 500);
        //then
        Assert.assertFalse(atm.withdrawCash(600));

    }

    @Test
    public void impossibleWithdraw2() {
        //when
        atm.setNumberOfBankNotesInAtm(BankNoteType.FIVE, 0);
        //then
        Assert.assertFalse(atm.withdrawCash(5));

    }

    @Test
    public void impossibleWithdraw3() {
        //when
        atm.fillEachHolder();
        Assert.assertFalse(atm.withdrawCash(2));
    }

    @Test
    public void impossibleWithdraw4() {
        //when
        atm.fillEachHolder();
        atm.setNumberOfBankNotesInAtm(BankNoteType.FIVE, 0);
        atm.setNumberOfBankNotesInAtm(BankNoteType.TEN, 0);
        Assert.assertFalse(atm.withdrawCash(40));
    }

    @Test
    public void withdrawFrom5() {
        //when
        atm.fillEachHolder();
        atm.setNumberOfBankNotesInAtm(BankNoteType.TWOHUNDRED, 0);
        atm.setNumberOfBankNotesInAtm(BankNoteType.ONEHUNDRED, 0);
        atm.setNumberOfBankNotesInAtm(BankNoteType.FIFTY, 0);
        atm.setNumberOfBankNotesInAtm(BankNoteType.TEN, 0);
        Assert.assertTrue(atm.withdrawCash(900));
    }

    @Test
    public void withdrawOverLimit() {
        //when
        atm.fillEachHolder();
        atm.setNumberOfBankNotesInAtm(BankNoteType.TWOHUNDRED, 0);
        atm.setNumberOfBankNotesInAtm(BankNoteType.ONEHUNDRED, 0);
        atm.setNumberOfBankNotesInAtm(BankNoteType.FIFTY, 0);
        atm.setNumberOfBankNotesInAtm(BankNoteType.TEN, 0);
        Assert.assertFalse(atm.withdrawCash(2000));
    }

    @Test
    public void withdrawCombinedAmount(){
        atm.fillEachHolder();
        atm.withdrawCash(365);
        Assert.assertEquals(199,atm.getNumbersOfBankNotesInAtm(BankNoteType.TWOHUNDRED));
        Assert.assertEquals(199,atm.getNumbersOfBankNotesInAtm(BankNoteType.ONEHUNDRED));
        Assert.assertEquals(199,atm.getNumbersOfBankNotesInAtm(BankNoteType.FIFTY));
        Assert.assertEquals(199,atm.getNumbersOfBankNotesInAtm(BankNoteType.TEN));
        Assert.assertEquals(199,atm.getNumbersOfBankNotesInAtm(BankNoteType.FIVE));
    }
}
