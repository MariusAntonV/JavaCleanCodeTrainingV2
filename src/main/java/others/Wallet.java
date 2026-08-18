package others;

public class Wallet
{
   public enum Code
   {
      OK, INSUFFICIENT_FUNDS
   }

   private int credits = 0;

   private int bonusCredits = 0;


   public void addBonusCredits( int credits )
   {
      if ( credits > 0 )
      {
         this.bonusCredits += credits;
      }
   }


   public void addCredits( final int credits )
   {
      if ( credits > 0 )
      {
         this.credits += credits;
      }
   }


   public Code consumeCredits( final int noOfCreditsToConsume )
   {
      if ( !hasCredits( noOfCreditsToConsume ) )
      {
         return Code.INSUFFICIENT_FUNDS;
      }

      this.credits -= noOfCreditsToConsume;
      return Code.OK;
   }


   private boolean hasCredits( int noOfCreditsToConsume )
   {
      return this.credits >= noOfCreditsToConsume;
   }


   public boolean hasBonusCredits()
   {
      final boolean hasBonusCredits = this.bonusCredits > 0;
      this.bonusCredits--;
      return hasBonusCredits;
   }

}
