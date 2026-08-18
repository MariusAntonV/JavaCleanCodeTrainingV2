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


   public String getType()
   {
      return this.type;
   }
}
