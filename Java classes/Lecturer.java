import java.io.Serializable;

@SuppressWarnings("serial")
public class Lecturer implements Serializable
{

   private String name;
   private String category;
   private boolean freeAdvertisement;
   private String email;

   public Lecturer(String name, String category, String email,
         boolean freeAdvertisement)
   {
      setName(name);
      setCategory(category);
      setFreeAdvertisement(freeAdvertisement);
      setEmail(email);
   }

   public String getName()
   {
      return name;
   }

   public void setName(String name)
   {
      this.name = name;
   }

   public String getCategory()
   {
      return category;
   }

   public void setCategory(String category)
   {
      this.category = category;
   }

   public boolean isFreeAdvertisement()
   {
      return freeAdvertisement;
   }

   public void setFreeAdvertisement(boolean freeAdvertisement)
   {
      this.freeAdvertisement = freeAdvertisement;
   }

   public String getEmail()
   {
      return email;
   }

   public void setEmail(String email)
   {
      this.email = email;
   }
   
   public boolean getDiscount()
   {
      return freeAdvertisement;
   }

   public boolean isEqual(Object obj)
   {
      if (!(obj instanceof Lecturer))
      {
         return false;
      }
      else
      {
         Lecturer other = (Lecturer) obj;
         return this.name == other.name && other.category == this.category
               && this.freeAdvertisement == other.freeAdvertisement
               && this.email == other.email;
      }
   }

   public String toString()
   {
      return "Name: " + name + ", Email: " + email + ", Category: " + category
            + ", Advertisement free? : " + freeAdvertisement;
   }
}
