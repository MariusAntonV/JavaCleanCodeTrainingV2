package training;

import org.junit.Assert;
import org.junit.Test;

public class AddressTest
{

   @Test
   public void asText_joinsCountryCityStreet()
   {
      final Address address = new Address( "Romania", "Cluj-Napoca", "Taietura" );
      Assert.assertEquals( "Romania, Cluj-Napoca, Taietura", address.asText() );
   }


   @Test
   public void gettersExposeTheParts()
   {
      final Address address = new Address( "Romania", "Cluj-Napoca", "Taietura" );
      Assert.assertEquals( "Romania", address.getCountry() );
      Assert.assertEquals( "Cluj-Napoca", address.getCity() );
      Assert.assertEquals( "Taietura", address.getStreet() );
   }
}

