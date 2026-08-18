package trainers;

import training.ITrainer;

public class Trainer implements ITrainer
{

   private final String name;

   private final String type;


   public Trainer( final String name, final String type )
   {
      this.name = name;
      this.type = type;
   }


   public String getName()
   {
      return this.name;
   }


   @Override
   public int deliverExperience( int difficulty )
   {
      int experience = 0;
      switch ( type )
      {
         case ITrainer.JUNIOR:
            if ( difficulty < 30 )
            {
               experience += difficulty;
            }
            else if ( difficulty < 60 )
            {
               experience += difficulty / 2;
            }
            else
            {
               experience += 0;//too difficult
            }
            break;
         case ITrainer.MIDDLE:
            if ( difficulty < 50 )
            {
               experience += difficulty;
            }
            else
            {
               experience += difficulty * 0.6;
            }
            break;
         case ITrainer.SENIOR:
            experience += difficulty;//delivered experience is 100%
            break;
      }
      return experience;
   }
}
