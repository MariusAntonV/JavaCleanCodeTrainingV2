package training;

/**
 * Value object holding the postal address of a person.
 *
 * Extracted out of {@link Student} so that the student is no longer responsible
 * for knowing how an address is structured or formatted (Single Responsibility
 * Principle).
 */
public class Address
{
   private final String country;

   private final String city;

   private final String street;


   public Address( final String country, final String city, final String street )
   {
      this.country = country;
      this.city = city;
      this.street = street;
   }


   public String getCountry()
   {
      return this.country;
   }


   public String getCity()
   {
      return this.city;
   }


   public String getStreet()
   {
      return this.street;
   }


   public String asText()
   {
      return this.country + ", " + this.city + ", " + this.street;
   }
}

