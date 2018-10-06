import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class FileHandler implements Serializable {

	public static File eventFile = new File("eventFile.bin");
	public static File lecturerFile = new File("lecturerFile.bin");
	public static File memberFile = new File("memberFile.bin");

	public static void writeEventFile(ArrayList<Event> eventList) throws IOException {

		FileOutputStream fos = new FileOutputStream(eventFile);
		ObjectOutputStream out = new ObjectOutputStream(fos);

		out.writeObject(eventList);
		out.flush();
		out.close();
		fos.close();
		
}

	public static ArrayList<Event> readEventFile() throws IOException, ClassNotFoundException {
	   
	   if(!(eventFile.exists())) { 
	      FileOutputStream fos = new FileOutputStream(eventFile);
	      ObjectOutputStream out = new ObjectOutputStream(fos);
	      ArrayList<Event> arrayEvents = new ArrayList<Event>();
	      out.writeObject(arrayEvents);
	      out.flush();
	      out.close();
	      fos.close();
	   }
	   
		ObjectInputStream read = null;
		FileInputStream fis = new FileInputStream(eventFile);

		read = new ObjectInputStream(fis);
		@SuppressWarnings("unchecked")
      ArrayList<Event> events =  (ArrayList<Event>) read.readObject();
		fis.close();
		read.close();
		return events;
	}

	public static void writeLecturerFile(ArrayList<Lecturer> lecturerList) throws IOException {

		FileOutputStream fos = new FileOutputStream(lecturerFile);
		ObjectOutputStream out = new ObjectOutputStream(fos);

		out.writeObject(lecturerList);
		out.flush();
		out.close();
		fos.close();
	}

	public static ArrayList<Lecturer> readLecturerFile() throws IOException, ClassNotFoundException {
	   
	     if(!(lecturerFile.exists())) { 
	         FileOutputStream fos = new FileOutputStream(lecturerFile);
	         ObjectOutputStream out = new ObjectOutputStream(fos);
	         ArrayList<Lecturer> arrayLecturer = new ArrayList<Lecturer>();
	         out.writeObject(arrayLecturer);
	         out.flush();
	         out.close();
	         fos.close();
	      }
	   
		ObjectInputStream read = null;
		FileInputStream fis = new FileInputStream(lecturerFile);

		read = new ObjectInputStream(fis);
		@SuppressWarnings("unchecked")
      ArrayList<Lecturer> lecturer =  (ArrayList<Lecturer>) read.readObject();
		fis.close();
		read.close();

		return lecturer;

	}

	public static void writeMemberFile(ArrayList<Member> memberList) throws IOException {

		FileOutputStream fos = new FileOutputStream(memberFile);
		ObjectOutputStream out = new ObjectOutputStream(fos);

		out.writeObject(memberList);
		out.flush();
		out.close();
		fos.close();
	}

	public static ArrayList<Member> readMemberFile() throws IOException, ClassNotFoundException {
	   
	     if(!(memberFile.exists())) { 
	         FileOutputStream fos = new FileOutputStream(memberFile);
	         ObjectOutputStream out = new ObjectOutputStream(fos);
	         ArrayList<Member> arrayMember = new ArrayList<Member>();
	         out.writeObject(arrayMember);
	         out.flush();
	         out.close();
	         fos.close();
	      }
	     
		ObjectInputStream read = null;
		FileInputStream fis = new FileInputStream(memberFile);

		read = new ObjectInputStream(fis);
		@SuppressWarnings("unchecked")
      ArrayList<Member> member =  (ArrayList<Member>) read.readObject();
		fis.close();
		read.close();

		return member;
	
	}
	
//  Used for debugging file directory
	
//	public static String debugger() {
//		
//		String curDir = System.getProperty("user.dir");
//
//		System.out.println(curDir);
//		
//		return curDir;
//	}
//	
}
