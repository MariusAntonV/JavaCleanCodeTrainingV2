package training;

import java.util.ArrayList;
import java.util.List;

import trainers.Trainer;

public class Student
{
   private final String name;

   private final String country;

   private final String city;

   private final String street;

   private final String phoneNo;

   private int avCrds;

   private final List<TrainPeople> trainings = new ArrayList<>();

   public Student( final String name, final String country, final String city, final String street,
         final String phoneNo )
   {
      this.name = name;
      this.country = country;
      this.city = city;
      this.street = street;
      this.phoneNo = phoneNo;
   }


   public String printAddress()
   {
      final StringBuilder sb = new StringBuilder( "" );
      sb.append( this.country ).append( ", " ).append( this.city ).append( ", " ).append( this.street );
      return sb.toString();
   }


   public String printContact()
   {
      final StringBuilder sb = new StringBuilder( "" );
      sb.append( this.country ).append( ", " ).append( this.city ).append( ", " ).append( this.street ).append( ", " )
            .append( this.phoneNo );
      return sb.toString();
   }


   public Integer participate( final TrainPeople training )
   {
      this.trainings.add( training );

      final int cst = 0;
      for ( final TrainPeople t : this.trainings )
      {
         t.cost( cst );
      }

      return cst;
   }


   public List<TrainPeople> getTrainings()
   {
      return this.trainings;
   }


   public void crds( final int c )
   {
      this.avCrds += c;
   }

   public int creds(){
      return this.avCrds;
   }


   public int exp()
   {
      int e = 0;
      for ( final TrainPeople tr : this.trainings )
      {
         final int d = tr.getTopic().getDifficulty();
         final Trainer t = tr.getTutor();

         switch ( t.getType() )
         {
            case Trainer.J:
               if ( d < 30 )
               {
                  e += d;
               }
               else if ( d < 60 )
               {
                  e += d / 2;
               }
               else
               {
                  e += 0;//too difficult
               }
               break;
            case Trainer.M:
               if ( d < 50 )
               {
                  e += d;
               }
               else
               {
                  e += d * 0.6;
               }
               break;
            case Trainer.S:
               e += d;//efficiency is 100%
               break;
         }

      }

      return e;
   }
}
