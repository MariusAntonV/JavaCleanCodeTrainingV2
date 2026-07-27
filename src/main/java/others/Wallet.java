package others;

public class Wallet
{
   public enum Code
   {
      OK, INSUFFICIENT_FUNDS
   }

   private int credits = 0;

   private int bonusCredits = 0;

   public void addCredits( final int credits, final boolean isBonus )
   {
      if ( credits > 0 )
      {
         if ( isBonus )
         {
            this.bonusCredits += credits;
         }
         else
         {
            this.credits += credits;
         }
      }
      else
      {
         return;
      }

   }


   public Code consumeCredits( final int noOfCreditsToConsume )
   {
      if ( this.credits >= noOfCreditsToConsume )
      {
         this.credits -= noOfCreditsToConsume;
         return Code.OK;
      }
      else
      {
         return Code.INSUFFICIENT_FUNDS;
      }
   }


   public boolean hasBonusCredits()
   {
      final boolean hasBonusCredits = this.bonusCredits > 0;
      this.bonusCredits--;
      return hasBonusCredits;
   }

}
