package others;

import org.junit.Assert;
import org.junit.Test;

/**
 * Characterizes the CORRECT behavior of Wallet before the "Cleanup Wallet"
 * refactor (guard clauses, command/query separation). All green today.
 *
 * The side-effect bug in hasBonusCredits() is intentionally NOT asserted here;
 * it is handled as a separate bugfix step (see training.BugfixStepsTest).
 *
 */
public class WalletTest
{

   @Test
   public void consumeCredits_withEnoughBalance_succeedsAndDeducts()
   {
      final Wallet wallet = new Wallet();
      wallet.addCredits( 100 );

      Assert.assertEquals( Wallet.Code.OK, wallet.consumeCredits( 40 ) );
      Assert.assertEquals( Wallet.Code.OK, wallet.consumeCredits( 60 ) );
      Assert.assertEquals( Wallet.Code.INSUFFICIENT_FUNDS, wallet.consumeCredits( 1 ) );
   }


   @Test
   public void consumeCredits_withInsufficientBalance_isRejected()
   {
      final Wallet wallet = new Wallet();
      wallet.addCredits( 30);

      Assert.assertEquals( Wallet.Code.INSUFFICIENT_FUNDS, wallet.consumeCredits( 31 ) );
   }


   @Test
   public void addCredits_ignoresNonPositiveAmounts()
   {
      final Wallet wallet = new Wallet();
      wallet.addCredits( 0 );
      wallet.addCredits( -50 );

      Assert.assertEquals( Wallet.Code.INSUFFICIENT_FUNDS, wallet.consumeCredits( 1 ) );
   }


   @Test
   public void bonusCredits_areNotSpendableAsRegularCredits()
   {
      final Wallet wallet = new Wallet();
      wallet.addBonusCredits( 50); // bonus only, no regular credits

      Assert.assertEquals( Wallet.Code.INSUFFICIENT_FUNDS, wallet.consumeCredits( 1 ) );
      Assert.assertTrue( wallet.hasBonusCredits() );
   }
}
