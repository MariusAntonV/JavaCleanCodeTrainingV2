package training;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import others.Wallet;
import trainers.SeniorTrainer;

/**
 * Bugfix steps.
 *
 * These tests describe the INTENDED (correct) behavior and are RED against the
 * current code on purpose. They are @Ignore'd so the baseline suite stays green
 * and the students' starting point is not polluted with failing tests.
 *
 * During the training, at the matching topic:
 *   1. remove @Ignore  -> watch the test go RED,
 *   2. fix the production code -> watch it go GREEN.
 *
 * This is the whole point of the refactor-vs-bugfix distinction:
 *   - refactoring changes the shape, not the behavior  -> green stays green;
 *   - a bugfix changes the behavior on purpose         -> a red test turns green.
 *
 */
public class BugfixStepsTest
{

   /**
    * Step B1 - the cost bug.
    *
    * TrainPeople.cost(int) does `cost += this.cost` on the PARAMETER (a no-op),
    * and Student.participate(...) always returns 0, so a student's total training
    * cost is never computed. The total cost should be the sum of the costs of the
    * trainings the student participated in.
    *
    * Design choice to make with the group: where should the total live?
    * (participate(...) return value, a Student.getTotalCost(), or the Wallet that
    * pays for the trainings). This test uses the current surface - the value
    * returned by participate(...).
    */
//   @Ignore( "Step B1: enable during the 'cost calculation' topic (currently RED)" )
   @Test
   public void participate_returnsRunningTotalCost()
   {
      final Student student = new Student( "Marius",
            new Contact( new Address( "Romania", "Cluj-Napoca", "Taietura" ), "1234567" ) );
      final ITrainer trainer = new SeniorTrainer( "Trainer" );
      final Topic topic = new Topic( "Topic", 10 );

      student.participate( new Training( topic, trainer, 10 ) );
      student.participate( new Training( topic, trainer, 20 ) );
      final int totalCost = student.calculateTotalTrainingsCost();

      Assert.assertEquals( 30, totalCost );
   }


   /**
    * Step B2 - the Wallet query with a side effect.
    *
    * Wallet.hasBonusCredits() decrements bonusCredits on every call
    * (command/query separation violation). Merely checking whether bonus credits
    * exist must NOT change them.
    */
   @Ignore( "Step B2: enable during the 'command-query separation / Wallet cleanup' topic (currently RED)" )
   @Test
   public void hasBonusCredits_isASideEffectFreeQuery()
   {
      final Wallet wallet = new Wallet();
      wallet.addCredits( 1, true ); // exactly one bonus credit

      Assert.assertTrue( wallet.hasBonusCredits() );
      Assert.assertTrue( wallet.hasBonusCredits() ); // still true - checking must not consume it
   }
}
