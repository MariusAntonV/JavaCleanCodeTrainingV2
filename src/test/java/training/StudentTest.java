package training;

import org.junit.Assert;
import org.junit.Test;

import liskov.LiskovTrainer;
import math.MathTrainer;
import trainers.JuniorTrainer;
import trainers.MiddleTrainer;
import trainers.SeniorTrainer;

public class StudentTest
{

   private static Contact standardContact()
   {
      return new Contact( new Address( "Romania", "Cluj-Napoca", "Taietura" ), "1234567" );
   }


   @Test
   public void deliveredExperience()
   {
      final Student student = new Student( "Marius", standardContact() );
      student.addCredit( 30 );

      final ITrainer trainer1 = new JuniorTrainer( "Mihai" );
      final ITrainer trainer2 = new MiddleTrainer( "Ionut" );
      final ITrainer trainer3 = new SeniorTrainer( "Andreea" );

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
      final Student student = new Student( "Marius", standardContact() );
      student.addCredit( 30 );
      Assert.assertEquals( 30, student.getCredits() );
   }


   @Test
   public void addCredits_accumulatesAcrossCalls()
   {
      final Student student = new Student( "Marius", standardContact() );
      student.addCredit( 30 );
      student.addCredit( 20 );
      Assert.assertEquals( 50, student.getCredits() );
   }


   // --- Address / contact formatting -----------------------------------------
   // Locks in the current output BEFORE it is extracted into Address/Contact classes.

   @Test
   public void printAddress_joinsCountryCityStreet()
   {
      final Student student = new Student( "Marius", standardContact() );
      Assert.assertEquals( "Romania, Cluj-Napoca, Taietura", student.getAddressAsText() );
   }


   @Test
   public void printContact_appendsPhoneToAddress()
   {
      final Student student = new Student( "Marius", standardContact() );
      Assert.assertEquals( "Romania, Cluj-Napoca, Taietura, 1234567", student.getContactAsText() );
   }


   @Test
   public void studentCanBeBuiltFromAContact()
   {
      final Contact contact = new Contact( new Address( "Romania", "Cluj-Napoca", "Taietura" ), "1234567" );
      final Student student = new Student( "Marius", contact );

      Assert.assertSame( contact, student.getContact() );
      Assert.assertEquals( "Romania, Cluj-Napoca, Taietura", student.getAddressAsText() );
      Assert.assertEquals( "Romania, Cluj-Napoca, Taietura, 1234567", student.getContactAsText() );
   }


   @Test
   public void junior_belowEasyThreshold_awardsFullDifficulty()
   {
      Assert.assertEquals( 29, experienceForSingleTraining( new JuniorTrainer( "Trainer" ), 29 ) );
   }


   @Test
   public void junior_atEasyThreshold_awardsHalfDifficulty()
   {
      Assert.assertEquals( 15, experienceForSingleTraining( new JuniorTrainer( "Trainer" ), 30 ) );
   }


   @Test
   public void junior_justBelowHardThreshold_awardsHalfDifficulty()
   {
      Assert.assertEquals( 29, experienceForSingleTraining( new JuniorTrainer( "Trainer" ), 59 ) );
   }


   @Test
   public void junior_atHardThreshold_awardsNoExperience()
   {
      Assert.assertEquals( 0, experienceForSingleTraining( new JuniorTrainer( "Trainer" ), 60 ) );
   }


   @Test
   public void middle_belowThreshold_awardsFullDifficulty()
   {
      Assert.assertEquals( 49, experienceForSingleTraining( new MiddleTrainer( "Trainer" ), 49 ) );
   }


   @Test
   public void middle_atThreshold_awardsReducedDifficulty()
   {
      Assert.assertEquals( 30, experienceForSingleTraining( new MiddleTrainer( "Trainer" ), 50 ) );
   }


   @Test
   public void senior_awardsFullDifficultyRegardlessOfLevel()
   {
      Assert.assertEquals( 80, experienceForSingleTraining( new SeniorTrainer( "Trainer" ), 80 ) );
   }


   @Test
   public void testMathTrainer()
   {
      final Student student = new Student( "Marius", standardContact() );
      student.addCredit( 30 );

      final ITrainer trainer = new MathTrainer();

      final Topic html = new Topic( "HTML for beginners", 20 );

      final Training training1 = new Training( html, trainer, 10 );

      student.participate( training1 );

      Assert.assertEquals( 100, student.calculateGainedExperience() );
   }


   @Test
   public void testLiskovTrainer()
   {
      final Student student = new Student( "Marius", standardContact() );
      student.addCredit( 30 );

      final ITrainer trainer = new MathTrainer();
      final ITrainer liskovTrainer = new LiskovTrainer();

      final Topic html = new Topic( "HTML for beginners", 20 );

      final Training training1 = new Training( html, trainer, 10 );
      final Training training2 = new Training( html, liskovTrainer, 10 );

      student.participate( training1 );
      student.participate( training2 );

      Assert.assertEquals( 100, student.calculateGainedExperience() );
   }


   private int experienceForSingleTraining( final ITrainer trainer, final int difficulty )
   {
      final Student student = new Student( "Marius", standardContact() );
      final Topic topic = new Topic( "Topic", difficulty );
      student.participate( new Training( topic, trainer, 0 ) );
      return student.calculateGainedExperience();
   }
}
