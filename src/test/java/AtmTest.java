import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AtmTest {
    private Atm atm;
    private final int MAXIMUM_AMOUNT_IN_ATM = 5*200 + 10*200 + 50 * 200 + 100 * 200 + 200 * 200;
    @Before
    public void setAtm(){
        atm = new Atm();
    }

    @Test
    public void atmCreation(){
        Assert.assertEquals(0,atm.getTotalCashOfAtm());
        Assert.assertEquals(5,atm.getListOfBankNoteHolders().size());
        Assert.assertEquals(5,atm.getListOfBankNoteHolders().get(0).bankNoteType.value);
        Assert.assertEquals(10,atm.getListOfBankNoteHolders().get(1).bankNoteType.value);
        Assert.assertEquals(50,atm.getListOfBankNoteHolders().get(2).bankNoteType.value);
        Assert.assertEquals(100,atm.getListOfBankNoteHolders().get(3).bankNoteType.value);
        Assert.assertEquals(200,atm.getListOfBankNoteHolders().get(4).bankNoteType.value);
    }

    @Test
    public void fillAtm(){

        //when
        atm.fillEachHolder();
        //then
        Assert.assertEquals(MAXIMUM_AMOUNT_IN_ATM,atm.getTotalCashOfAtm());
    }
    @Test
    public void areMoneyWithdrawn(){
        //given
        atm.fillEachHolder();
        //when
        atm.withdrawCash(250);
        //then
        Assert.assertEquals(MAXIMUM_AMOUNT_IN_ATM-250,atm.getTotalCashOfAtm());
    }

    @Test
    public void impossibleWithdraw(){
        //when
        atm.fillEachHolder();
        atm.withdrawCash(MAXIMUM_AMOUNT_IN_ATM -500);
        //then
        Assert.assertFalse(atm.withdrawCash(600));
        Assert.assertFalse(atm.withdrawCash(0));
        Assert.assertFalse(atm.withdrawCash(2));
        Assert.assertTrue(atm.withdrawCash(5));
        Assert.assertEquals(495,atm.getTotalCashOfAtm());

        //when
        atm.fillEachHolder();
        for (int i = 0; i < 200; i++) {
            atm.withdrawCash(5);
        }
        //then
        Assert.assertFalse(atm.withdrawCash(55));

        //when
        for (int i = 0; i < 200; i++) {
            atm.withdrawCash(10);
        }
        //then
        Assert.assertFalse(atm.withdrawCash(20));
    }

    @Test
    public void getsRightHolder(){
        //when
        BankNoteHolder testHolder = atm.getHolder(BankNoteType.FIFTY);
        //then
        Assert.assertEquals(BankNoteType.FIFTY, testHolder.bankNoteType);
    }

}
