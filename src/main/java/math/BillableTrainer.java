package math;

import training.ITrainer;

public class BillableTrainer implements ITrainer
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


   public void charge( int credit )
   {
      //charge given redit
   }
}
