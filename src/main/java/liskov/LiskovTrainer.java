/************************************************************************
 ** COPYRIGHT: FREQUENTIS AG. All rights reserved.
 **            Registered with Commercial Court Vienna,
 **            reg.no. FN 72.115b.
 ************************************************************************/
package liskov;

import training.ITrainer;

public class LiskovTrainer implements ITrainer
{
   @Override
   public String getName()
   {
      return "";
   }


   @Override
   public int deliverExperience( int difficulty )
   {
      throw new RuntimeException("No way I'll do that !!!!");
   }
}
