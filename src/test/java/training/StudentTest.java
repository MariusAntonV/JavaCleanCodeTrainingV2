package training;

import org.junit.Assert;
import org.junit.Test;

import trainers.Trainer;

public class StudentTest
{

   @Test
   public void deliveredExperience()
   {
      final Student student = new Student( "Marius", "Romania", "Cluj-Napoca", "Taietura", "1234567" );
      student.crds( 30 );

      final Trainer trainer1 = new Trainer( "Mihai", Trainer.JUNIOR );
      final Trainer trainer2 = new Trainer( "Ionut", Trainer.MIDDLE );
      final Trainer trainer3 = new Trainer( "Andreea", Trainer.SENIOR );

      final Topic html = new Topic( "HTML for beginners", 20 );
      final Topic java = new Topic( "Java in action", 50 );
      final Topic apis = new Topic( "Secure APIS", 80 );

      final Training training1 = new Training( html, trainer1, 10 );
      final Training training2 = new Training( java, trainer2, 20 );
      final Training training3 = new Training( apis, trainer3, 30 );

      student.participate( training1 );
      student.participate( training2 );
      student.participate( training3 );

      Assert.assertEquals( 130, student.calculateGainedExperience() );

   }


   @Test
   public void addCredits()
   {
      final Student student = new Student( "Marius", "Romania", "Cluj-Napoca", "Taietura", "1234567" );
      student.crds( 30 );
      Assert.assertEquals( 30, student.creds() );
   }


   @Test
   public void addCredits_accumulatesAcrossCalls()
   {
      final Student student = new Student( "Marius", "Romania", "Cluj-Napoca", "Taietura", "1234567" );
      student.crds( 30 );
      student.crds( 20 );
      Assert.assertEquals( 50, student.creds() );
   }


   // --- Address / contact formatting -----------------------------------------
   // Locks in the current output BEFORE it is extracted into Address/Contact classes.

   @Test
   public void printAddress_joinsCountryCityStreet()
   {
      final Student student = new Student( "Marius", "Romania", "Cluj-Napoca", "Taietura", "1234567" );
      Assert.assertEquals( "Romania, Cluj-Napoca, Taietura", student.printAddress() );
   }


   @Test
   public void printContact_appendsPhoneToAddress()
   {
      final Student student = new Student( "Marius", "Romania", "Cluj-Napoca", "Taietura", "1234567" );
      Assert.assertEquals( "Romania, Cluj-Napoca, Taietura, 1234567", student.printContact() );
   }


   // --- Experience by trainer type: threshold characterization ---------------
   // Behavior is asserted THROUGH Student.exp() (the aggregate), never through the
   // Trainer switch internals, so these survive the Open/Closed refactor to
   // JuniorTrainer / MiddleTrainer / SeniorTrainer.

   @Test
   public void junior_belowEasyThreshold_awardsFullDifficulty()
   {
      Assert.assertEquals( 29, experienceForSingleTraining( Trainer.JUNIOR, 29 ) );
   }


   @Test
   public void junior_atEasyThreshold_awardsHalfDifficulty()
   {
      Assert.assertEquals( 15, experienceForSingleTraining( Trainer.JUNIOR, 30 ) );
   }


   @Test
   public void junior_justBelowHardThreshold_awardsHalfDifficulty()
   {
      Assert.assertEquals( 29, experienceForSingleTraining( Trainer.JUNIOR, 59 ) );
   }


   @Test
   public void junior_atHardThreshold_awardsNoExperience()
   {
      Assert.assertEquals( 0, experienceForSingleTraining( Trainer.JUNIOR, 60 ) );
   }


   @Test
   public void middle_belowThreshold_awardsFullDifficulty()
   {
      Assert.assertEquals( 49, experienceForSingleTraining( Trainer.MIDDLE, 49 ) );
   }


   @Test
   public void middle_atThreshold_awardsReducedDifficulty()
   {
      Assert.assertEquals( 30, experienceForSingleTraining( Trainer.MIDDLE, 50 ) );
   }


   @Test
   public void senior_awardsFullDifficultyRegardlessOfLevel()
   {
      Assert.assertEquals( 80, experienceForSingleTraining( Trainer.SENIOR, 80 ) );
   }


   private int experienceForSingleTraining( final String trainerType, final int difficulty )
   {
      final Student student = new Student( "Marius", "Romania", "Cluj-Napoca", "Taietura", "1234567" );
      final Trainer trainer = new Trainer( "Trainer", trainerType );
      final Topic topic = new Topic( "Topic", difficulty );
      student.participate( new Training( topic, trainer, 0 ) );
      return student.calculateGainedExperience();
   }
}
