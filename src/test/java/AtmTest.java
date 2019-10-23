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
    }

    @Test
    public void fillAtm(){

        //when
        atm.fillEachHolder();
        //then
        Assert.assertEquals(MAXIMUM_AMOUNT_IN_ATM,atm.getTotalCashOfAtm());
    }
    @Test
    public void areMoneyWithdraw(){
        //given
        atm.fillEachHolder();
        //when
        atm.withdrawCash(250);
        //then
        Assert.assertEquals(MAXIMUM_AMOUNT_IN_ATM-250,atm.getTotalCashOfAtm());
    }

    @Test
    public void impossibleWithdraws(){
        //when
        atm.fillEachHolder();
        atm.withdrawCash(MAXIMUM_AMOUNT_IN_ATM -500);
        //then
        Assert.assertFalse(atm.withdrawCash(600));
        Assert.assertFalse(atm.withdrawCash(0));
        Assert.assertFalse(atm.withdrawCash(2));

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
}
