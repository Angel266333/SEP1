import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Event implements Serializable
{

   private String eventFeedback;
   private String category;
   private String type;
   private String title;
   private String description;
   private ArrayList<Lecturer> lecturer;
   private MyDate startDate;
   private MyDate endDate;
   private ArrayList<Member> participant;

   private boolean isFinalized;
   private int totalSeats;
   private int participantNumber;
   private int availableSeats;
   private int price;

   public Event(String category, String type, String title, String description,
         ArrayList<Lecturer> lecturer, MyDate startDate, MyDate endDate,
         boolean isFinalized, int totalSeats, int price, String feedback,ArrayList<Member> participant)
   {

      this.category = category;
      this.type = type;
      this.title = title;
      this.description = description;
      this.lecturer = lecturer;
      this.startDate = startDate;
      this.endDate = endDate;
      this.isFinalized = isFinalized;
      this.totalSeats = totalSeats;
      this.participantNumber = 0;
      this.availableSeats = totalSeats - participantNumber;
      this.price = price;
      this.eventFeedback = feedback;
      this.participant = participant;
   }

   public String getFeedback()
   {
      return eventFeedback;
   }
   

   public String getCategory()
   {

      return category;
   }

   public String getType()
   {
      return type;
   }

   public String getTitle()
   {
      return title;
   }

   public String getDescription()
   {
      return description;
   }

   public ArrayList<Lecturer> getLecturer()
   {
      return lecturer;
   }


   public MyDate getStartDate()
   {
      return startDate;
   }

   public MyDate getEndDate()
   {
      return endDate;
   }

   public ArrayList<Member> getParticipant()
   {
      return participant;
   }
   
   public int getAvailableSeats()
   {
	   return availableSeats;
   }

   public boolean isFinalized()
   {
      return this.isFinalized;
   }

   public int getTotalSeats()
   {
      return totalSeats;
   }

   public int getParticipantNumber()
   {
      return participantNumber;
   }

   public int getPrice()
   {
	   return price;
   }
      
   public void setFeedback(String feedback)
   {
	   this.eventFeedback = feedback;
   }
   
   public void setCategory(String category)
   {
	   this.category = category;
   }
   
   public void setType(String type)
   {
	   this.type = type;
   }
   
   public void setTitle(String title)
   {
	   this.title = title;
   }
   
   public void setDescription(String description)
   {
	   this.description = description;
   }
   
   public void setLecturer(ArrayList<Lecturer> lecturer)
   {
	   this.lecturer = lecturer;
   }
   
   public void setStartDate(MyDate startDate)
   {
	   this.startDate = startDate;
   }
   
   public void setEndDate(MyDate endDate)
   {
	   this.endDate = endDate;
   }
   
   public void setParticipant(ArrayList<Member> participant)
   {
	   this.participant = participant;
	   participantNumber = participant.size();
	   availableSeats = totalSeats - participantNumber;
   }
   
   
   public void setTotalSeats(int totalSeats)
   {
	   this.totalSeats = totalSeats;
   }
   
   public void setAvailableSeats(int availableSeats)
   {
	   this.availableSeats = availableSeats;
   }
   
   public void setPrice(int price)
   {
	   this.price = price;
   }
   
   public void setIsFinalized(boolean bool)
   {
	   isFinalized = bool;
   }

   ///////////////////////////////

   public boolean isEqual(Object obj)
   {
      if (!(obj instanceof Event))
      {
         return false;
      }
      else
      {
         Event other = (Event) obj;

         return getCategory() == other.getCategory()
               && getType() == other.getCategory()
               && this.title == other.getTitle()
               && this.description == other.getDescription()
               && this.lecturer == other.getLecturer()
               && this.startDate == other.getStartDate()
               && this.endDate == other.getEndDate()
               && this.participant == other.getParticipant()
               && this.totalSeats == other.getTotalSeats()
               && this.participantNumber == other.getParticipantNumber()
               && this.availableSeats == other.getAvailableSeats()
               && this.price == other.getPrice();

      }
   }


   public String toString()
   {
      return "Title: " + title + ", Category: " + category + ", Type " + type
            + ", Description: " + description + ", Start Date: " + startDate
            + ", End Date: " + endDate + ", Is Event Finalized?: "
            + isFinalized + ", Total Seats: "
            + totalSeats + ", Participant Number: " + participantNumber
            + ", Available Seats: " + availableSeats + ", Price: " + price
            + ".";
   }

}