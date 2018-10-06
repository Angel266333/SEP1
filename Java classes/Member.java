import java.io.Serializable;

@SuppressWarnings("serial")
public class Member implements Serializable
{
   private String name;
   private long phoneNumber;
   private String email;
   private int paymentYear;
   private MyDate dateOfMembership;

   public Member(String name, long phoneNumber, String email, int paymentYear,
         MyDate dateOfMembership)
   {
      this.name = name;
      this.phoneNumber = phoneNumber;
      this.email = email;
      this.paymentYear = paymentYear;
      this.dateOfMembership = dateOfMembership;
   }

   public String getName()
   {
	   return name;
   }
   
   public void setName(String name)
   {
	   this.name = name;
   }

   public long getPhoneNumber()
   {
	   return phoneNumber;
   }
   
   public void setPhoneNumber(long phoneNumber)
   {
	   this.phoneNumber = phoneNumber;
   }
   
   public String getEmail()
   {
	   return email;
   }
   
   public void setEmail(String email)
   {
      this.email = email;
   }

   public int getPaymentYear()
   {
      return paymentYear;
   }

   public void setPaymentYear(int paymentYear)
   {
      this.paymentYear = paymentYear;
   }

   public MyDate getDateOfMembership()
   {
      return dateOfMembership;
   }

   public void setDateOfMembership(MyDate dateOfMembership)
   {
      this.dateOfMembership = dateOfMembership;
   }



   public String toString()
   {
      return "Name: " + name + ", Phone Number: " + phoneNumber + ", Email: "
            + email + ", PaymentYear: " + paymentYear + ", Date Of Membership: "
            + dateOfMembership;
   }

}
