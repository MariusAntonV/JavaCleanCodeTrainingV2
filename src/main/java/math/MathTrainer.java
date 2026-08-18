/************************************************************************
 ** COPYRIGHT: FREQUENTIS AG. All rights reserved.
 **            Registered with Commercial Court Vienna,
 **            reg.no. FN 72.115b.
 ************************************************************************/
package math;

import training.ITrainer;

public class MathTrainer implements ITrainer
{
   @Override
   public String getName()
   {
      return "George Matematician";
   }


   @Override
   public int deliverExperience( int difficulty )
   {
      return 100;
   }
}
