package trainers;

/**
 * A junior trainer delivers full experience for easy topics, half for medium
 * ones and nothing for hard topics.
 */
public class JuniorTrainer extends Trainer
{
   private static final int EASY_THRESHOLD = 30;

   private static final int HARD_THRESHOLD = 60;


   public JuniorTrainer( final String name )
   {
      super( name );
   }


   @Override
   public int deliverExperience( final int difficulty )
   {
      if ( difficulty < EASY_THRESHOLD )
      {
         return difficulty;
      }
      if ( difficulty < HARD_THRESHOLD )
      {
         return difficulty / 2;
      }
      return 0; // too difficult
   }
}

