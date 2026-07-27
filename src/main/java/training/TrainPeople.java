package training;

import trainers.Trainer;

public class TrainPeople
{
   private final Topic topic;

   private final Trainer tutor;

   private int cost;

   public TrainPeople( final Topic topic, final Trainer tutor, final int cost )
   {
      this.topic = topic;
      this.tutor = tutor;
      this.cost = cost;
   }


   public Topic getTopic()
   {
      return this.topic;
   }


   public Trainer getTutor()
   {
      return this.tutor;
   }


   public void cost( int cost )
   {
      cost += this.cost;
   }
}
