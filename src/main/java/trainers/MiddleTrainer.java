package trainers;

/**
 * A middle trainer delivers full experience below a threshold and a reduced
 * amount (60%) for harder topics.
 */
public class MiddleTrainer extends Trainer
{
   private static final int THRESHOLD = 50;

   private static final double REDUCED_FACTOR = 0.6;


   public MiddleTrainer( final String name )
   {
      super( name );
   }


   @Override
   public int deliverExperience( final int difficulty )
   {
      if ( difficulty < THRESHOLD )
      {
         return difficulty;
      }
      return (int) ( difficulty * REDUCED_FACTOR );
   }
}

