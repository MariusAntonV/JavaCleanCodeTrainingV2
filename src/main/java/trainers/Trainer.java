package trainers;

import training.ITrainer;

/**
 * Base class for all trainers. Holds the common state (the name) and leaves the
 * amount of experience delivered to the concrete subclasses:
 * {@link JuniorTrainer}, {@link MiddleTrainer} and {@link SeniorTrainer}.
 *
 * Replacing the old {@code type}-string + {@code switch} with polymorphism means
 * a new trainer level can be added without touching existing code (Open/Closed
 * Principle).
 */
public abstract class Trainer implements ITrainer
{
   private final String name;


   protected Trainer( final String name )
   {
      this.name = name;
   }


   @Override
   public String getName()
   {
      return this.name;
   }
}
