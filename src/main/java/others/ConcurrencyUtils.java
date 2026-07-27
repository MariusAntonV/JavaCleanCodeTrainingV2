package others;

import java.util.Random;

public class ConcurrencyUtils
{
   /**
    * Simulates running a task on a busy thread.
    * @param task
    */
   public static void runOnBusyThread( Runnable task )
   {
      final Thread thread = new Thread( () ->
      {
         try
         {
            final Random rand = new Random();
            Thread.sleep( rand.nextInt( 10_000 ) );

            task.run();
         }
         catch ( final InterruptedException e )
         {
            e.printStackTrace();
         }
      } );
      thread.start();
   }
}
