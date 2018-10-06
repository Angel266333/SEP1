import java.util.ArrayList;
import java.io.IOException;
import java.io.Serializable;


@SuppressWarnings("serial")
public class VipassanaSystem implements Serializable
{

   // Defining and preparing array lists

   private ArrayList<Member> memberList;
   private ArrayList<Event> eventList;
   private ArrayList<Lecturer> lecturerList;

   public VipassanaSystem()
   {
      memberList = new ArrayList<Member>();
      eventList = new ArrayList<Event>();
      lecturerList = new ArrayList<Lecturer>();
      readAllData();
      

   }

   // Managing member stuff

   public void addMember(Member member)
   {
      memberList.add(member);
   }

   public void removeMember(Member member)
   {
      memberList.remove(member);
   }

   public Member getMemberByName(String name)
   {
      Member memberToGet = null;
      for (Member d : memberList)
      {
         if (d.getName().equals(name))
         {
            memberToGet = d;
         }
      }
      return memberToGet;
   }
   
   public Member getMemberByEmail(String email)
   {
      Member memberToGet = null;
      for (Member d : memberList)
      {
         if (d.getEmail().equals(email))
         {
            memberToGet = d;
         }
      }
      return memberToGet;
   }
   

   public Member getMemberByNameAndEmail(String name, String email)
   {
      Member memberToGet = null;
      for (Member d : memberList)
      {
         if (d.getName().equals(name) && d.getEmail().equals(email))
         {
            memberToGet = d;
         }
      }
      return memberToGet;
   }

   public void removeMember(String name, String email)
   {
      Member memberToGet = null;
      for (Member d : memberList)
      {
         if (d.getName().equals(name) && d.getEmail().equals(email))
         {
            memberToGet = d;
         }
         memberList.remove(memberList.indexOf(memberToGet));
         break;
      }
   }
   
   public ArrayList<Member> getMemberList()
   {
      return memberList;
   }

   // Done with member

   /******************************************************************************/

   // Event list

   public void addEvent(Event event)
   {
      eventList.add(event);
   }

   public void removeEvent(Event event)
   {
      eventList.remove(event);
   }

   public void removeEventByTitle(String title)
   {
      Event eventToGet = null;
      for (Event d : eventList)
      {
         if (d.getTitle().equals(title))
         {
            eventToGet = d;
         }
         eventList.remove(eventList.indexOf(eventToGet));
         break;
      }
   }
   
   public ArrayList<Event> getEventByType(String type)
   {
      ArrayList<Event> eventsNameList = new ArrayList<Event>();
      for (Event d : eventList)
      {
         if (d.getType() != null && d.getType().contains(type))
         {
            eventsNameList.add(d);
         }
      }
      return eventsNameList;
   }

   public Event getEventByTitle(String title)
   {
      Event eventToGet = null;
      for (Event d : eventList)
      {
         if (d.getTitle().equals(title))
         {
            eventToGet = d;
            break;
         }
      }
      return eventToGet;
      
   }
   
   @SuppressWarnings("unlikely-arg-type")
   public ArrayList<Event> getEventByLecturer(Lecturer lecturer)
   {
      ArrayList<Event> eventsLecturerList = new ArrayList<Event>();
      for (Event d : eventList)
      {
         if (d.getLecturer() != null && lecturer.equals(d.getLecturer()))
         {
            eventsLecturerList.add(d);
         }
      }
      return eventsLecturerList;
   }

   public ArrayList<Event> getEventByCategory(String category)
   {
      ArrayList<Event> eventsCategoryList = new ArrayList<Event>();
      for (Event d : eventList)
      {
         if (d.getCategory() != null && d.getCategory().contains(category))
         {
            eventsCategoryList.add(d);
         }
      }
      return eventsCategoryList;
   }

   public ArrayList<Event> getUnfinalizedEvents()
   {
      ArrayList<Event> unDoneEvents = new ArrayList<Event>();
      for (Event d : eventList)
      {
         if (d.isFinalized() == false)
         {
            unDoneEvents.add(d);
         }

      }
      return unDoneEvents;
   }
   
   public ArrayList<Event> getFinalizedEvents()
   {
      ArrayList<Event> doneEvents = new ArrayList<Event>();
      for (Event d : eventList)
      {
         if (d.isFinalized() == true)
         {
            doneEvents.add(d);
         }

      }
      return doneEvents;
   }
   
   public ArrayList<Event> getEventList()
   {
      return eventList;
   }

   // End of Event section

   /********************************************************************************************/

   // Lecturer list

   public void addLecturer(Lecturer lecturer)
   {
      lecturerList.add(lecturer);
   }

   public void removeLecturer(Lecturer lecturer)
   {
      lecturerList.remove(lecturer);
   }

   public void removeLecturer(String name, String email)
   {
      Lecturer lecturerToGet = null;
      for (Lecturer d : lecturerList)
      {
         if (d.getName().equals(name) && d.getEmail().equals(email))
         {
            lecturerToGet = d;
         }
         lecturerList.remove(lecturerList.indexOf(lecturerToGet));
         break;
      }
   }

   public Lecturer getLecturerByName(String name)
   {
      Lecturer lecturerToGet = null;
      for (Lecturer d : lecturerList)
      {
         if (d.getName().equals(name))
         {
            lecturerToGet = d;
         }
      }
      return lecturerToGet;
   }
   
   
   

   public Lecturer getLecturerByNameAndCategory(String name, String category)
   {
      Lecturer lecturerToGet = null;
      for (Lecturer d : lecturerList)
      {
         if (d.getName().equals(name) && d.getCategory().equals(category))
         {
            lecturerToGet = d;
         }
      }
      return lecturerToGet;
   }

   public ArrayList<Lecturer> getLecturerByCategory(String category)
   {
      ArrayList<Lecturer> lecturersCategoryList = new ArrayList<Lecturer>();
      for (Lecturer d : lecturerList)
      {
         if (d.getCategory().contains(category))
         {
            lecturersCategoryList.add(d);
         }
      }
      return lecturersCategoryList;
   }
   
   public ArrayList<Lecturer> getLecturerList()
   {
      return lecturerList;
   }

   // File handler calls
   
   public void saveEventsData()
   {
      try {
      FileHandler.writeEventFile(eventList);
      }
      catch(IOException e)
      {
         
      }
   }
   
   public void saveMembersData()
   {
      try {
      FileHandler.writeMemberFile(memberList);
      }
      catch(IOException e)
      {
         
      }
   }
   
   public void saveLecturersData()
   {
      try {
      FileHandler.writeLecturerFile(lecturerList);
      }
      catch(IOException e)
      {
         
      }
   }
   
   
   public void readAllData()
   {
      try {
      eventList = FileHandler.readEventFile();
      lecturerList = FileHandler.readLecturerFile();
      memberList = FileHandler.readMemberFile();
      }
      catch (ClassNotFoundException e)
      {
         e.printStackTrace();
      }
      catch (IOException e)
      {
         e.printStackTrace();
      }
   }

}
