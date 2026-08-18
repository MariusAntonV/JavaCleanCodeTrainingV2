package training;

public class Training
{
   private final Topic topic;

   private final ITrainer trainer;

   private final int cost;

   public Training( final Topic topic, final ITrainer trainer, final int cost )
   {
      this.topic = topic;
      this.trainer = trainer;
      this.cost = cost;
   }


   public Topic getTopic()
   {
      return this.topic;
   }


   public ITrainer getTrainer()
   {
      return this.trainer;
   }


   public int getCost()
   {
      return this.cost;
   }
}
