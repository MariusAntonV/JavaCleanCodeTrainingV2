package training;

import java.util.ArrayList;
import java.util.List;

public class Student
{
   private final String name;

   private final Contact contact;

   private int credits;

   private final List<Training> trainings = new ArrayList<>();



   public Student( final String name, final Contact contact )
   {
      this.name = name;
      this.contact = contact;
   }


   public String getName()
   {
      return this.name;
   }


   public Contact getContact()
   {
      return this.contact;
   }


   public String getAddressAsText()
   {
      return this.contact.getAddress().asText();
   }


   public String getContactAsText()
   {
      return this.contact.asText();
   }


   public void participate( final Training training )
   {
      this.trainings.add( training );
   }


   protected Integer calculateTotalTrainingsCost()
   {
      int cost = 0;
      for ( final Training aTraining : this.trainings )
      {
         cost += aTraining.getCost();
      }

      return cost;
   }


   public List<Training> getTrainings()
   {
      return this.trainings;
   }


   public void addCredit( final int credit )
   {
      this.credits += credit;
   }


   public int getCredits()
   {
      return this.credits;
   }


   public int calculateGainedExperience()
   {
      int experience = 0;
      for ( final Training training : this.trainings )
      {
         final int difficulty = training.getTopic().getDifficulty();
         final ITrainer trainer = training.getTrainer();

         experience += trainer.deliverExperience( difficulty );

      }

      return experience;
   }
}
