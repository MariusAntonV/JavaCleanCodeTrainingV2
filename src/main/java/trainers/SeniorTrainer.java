package trainers;

/**
 * A senior trainer always delivers the full experience regardless of the
 * topic's difficulty.
 */
public class SeniorTrainer extends Trainer
{
   public SeniorTrainer( final String name )
   {
      super( name );
   }


   @Override
   public int deliverExperience( final int difficulty )
   {
      return difficulty; // delivered experience is 100%
   }
}

