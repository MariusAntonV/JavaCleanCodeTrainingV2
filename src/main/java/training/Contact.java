package training;

/**
 * Value object grouping the contact details of a person: the postal
 * {@link Address} plus a phone number.
 *
 * Extracted out of {@link Student} so that the student is no longer responsible
 * for knowing how contact information is structured or formatted (Single
 * Responsibility Principle).
 */
public class Contact
{
   private final Address address;

   private final String phoneNo;


   public Contact( final Address address, final String phoneNo )
   {
      this.address = address;
      this.phoneNo = phoneNo;
   }


   public Address getAddress()
   {
      return this.address;
   }


   public String getPhoneNo()
   {
      return this.phoneNo;
   }


   public String asText()
   {
      return this.address.asText() + ", " + this.phoneNo;
   }
}

