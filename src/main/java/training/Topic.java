package training;

public class Topic
{
   private final String name;

   private final int difficulty;


   public Topic( final String name, final int difficulty )
   {
      this.name = name;
      this.difficulty = difficulty;
   }


   public String getName()
   {
      return this.name;
   }


   public int getDifficulty()
   {
      return this.difficulty;
   }
}
