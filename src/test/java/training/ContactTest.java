package training;

import org.junit.Assert;
import org.junit.Test;

public class ContactTest
{

   @Test
   public void asText_appendsPhoneToAddress()
   {
      final Contact contact = new Contact( new Address( "Romania", "Cluj-Napoca", "Taietura" ), "1234567" );
      Assert.assertEquals( "Romania, Cluj-Napoca, Taietura, 1234567", contact.asText() );
   }


   @Test
   public void gettersExposeAddressAndPhone()
   {
      final Address address = new Address( "Romania", "Cluj-Napoca", "Taietura" );
      final Contact contact = new Contact( address, "1234567" );
      Assert.assertSame( address, contact.getAddress() );
      Assert.assertEquals( "1234567", contact.getPhoneNo() );
   }
}

