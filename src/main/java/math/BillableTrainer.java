package math;

import training.IBillable;
import training.ITrainer;

public class BillableTrainer implements ITrainer, IBillable
{
   @Override
   public String getName()
   {
      return "";
   }


   @Override
   public int deliverExperience( int difficulty )
   {
      return 300;
   }

   @Override
   public void charge( int credit )
   {
      //charge given redit
   }
}
