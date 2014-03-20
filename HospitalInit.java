

import java.util.HashMap;

/*
 * HospitalInit.java
 *
 * Created on August 3, 2007, 
 *
 */

/**
 * 
 * @author Sreeveena
 */
public class HospitalInit {

	//public HashMap nurseList;
	
	/** Creates a new instance of HospitalInit */
	public HospitalInit() {

		Patient[] patients = new Patient[3];
		// populate each type of object so that each module could be accessed
		patients[0] = new Patient(123, 1252, "John", "Douglas",
				"205 old county rd, apt 323, Belmont, ca", "6502424433",
				"jdoug_1@yahoo.com", "johnd");
		patients[1] = new Patient(234, 2456, "Dennys", "Bush",
				"2445 fremont blvd,apt 547, fremont, ca", "5102445676",
				"p", "p");
		patients[2] = new Patient(345, 6897, "Sree", "Puli",
				"868 paseo blvd, San jose,ca", "4083435678",
				"sreep_1@yahoo.com", "srpu");

		// Building

		Building b1 = new Building(1, "123 Fremont Blvd, Ca");
		Building b2 = new Building(2, "124 Fremont Blvd, Ca");

		// Hospital Departments

		Department dept_1 = new Department(1, "Family Medicine", "6508854345",
				b1);
		Department dept_2 = new Department(2, "Gynecologist", "6508852343", b1);
		Department dept_3 = new Department(3, "Pediatric", "6508858979", b1);
		Department dept_4 = new Department(4, "Surgery ", "6508851234", b2);

		// Hospital Rooms

		Room ro_1 = new Room(1, "Free", b1);
		Room ro_2 = new Room(2, "Free", b1);
		Room ro_3 = new Room(3, "Free", b1);
		Room ro_4 = new Room(1, "Full", b2);
		Room ro_5 = new Room(4, "Free", b2);
		Room ro_6 = new Room(1, "Free", b2);
		Room ro_7 = new Room(10, "Full", b1);

		// Nurse
	    Nurse[] nurses = new Nurse[6];
				
		nurses[0] = new Nurse("Brown", "Susen",
				"2987 scaromento dr,fremont,ca", "family", "5103457685", "n", "p",
				1424432);
		nurses[1] = new Nurse( "Black", "James",
				"4737 ralsto ave, Palo Alto, ca", "gyno", "6505735862", "n2@b.com", "n2b", 132424);
		nurses[2] = new Nurse("Dean", "Paul",
				"3234 middle street, san mateo,ca", "family", "4086350988", "n3@b.com", "n3b",
				142112);
		nurses[3] = new Nurse("Green", "Rachel",
				"298 mathila ave, apt 326, Sunny vale,ca", "gyno",
				"4086572308", "n4@b.com", "n4b", 13242);
		nurses[4] = new Nurse("Blean", "April",
				"78434 el camino, Belmont,ca", "pediatric", "6505651232", "n5@b.com", "n5b", 12212);
		nurses[5] = new Nurse("Yellow", "May",
				"3971 Hillsdale blvd,san mateo,ca", "pediatric", "6501231354", "n6@b.com", "n6b",
				14221);
		

		// Doctor
		Doctor[] doctors = new Doctor[5];

		doctors[0] = new Doctor("Gill", "Donna", "568 Martha Ave, San Jose,  CA", "Gynecologist", "4085666777", "d", "p", 5256);
		doctors[1] = new Doctor("Plaza", "Steve", "2304 Nicolet Dr, Fremont,  CA", "Primary Care", "4089550788", "d2@b.com", "d2b", 5452);
		doctors[2] = new Doctor("Yammani", "Bharathi", "304 Paseo Padre Pkwy, Fremont, CA", "Primary Care", "5104558967", "d3@b.com", "d3b", 5345);
		doctors[3] = new Doctor("Barrey", "Stacy", "890 Country Dr,Fremont,CA", "Gynecologist", "5105678907", "d4@b.com", "d4b", 5678);

		// Surgery

		Surgery sur_1 = new Surgery(patients[0], nurses[0], doctors[0],  112, "Apendicites", "09/9/07",
				"11:00am");
		Surgery sur_2 = new Surgery(patients[1], nurses[0], doctors[0], 111, "Cesarean Section",
				"10/12/2007", "4:00pm");
		Surgery sur_3 = new Surgery(patients[2], nurses[1], doctors[1],  113, "galbladder stones ",
				"10/22/2007", "4:00pm");

		// Attending Doctor for Surgery

		/*AttendingDoctor attdoc_1 = new AttendingDoctor(sur_1, doctors[0]);
		AttendingDoctor attdoc_2 = new AttendingDoctor(sur_2, doctors[1]);
		AttendingDoctor attdoc_3 = new AttendingDoctor(sur_3, doctors[2]);
		AttendingDoctor attdoc_4 = new AttendingDoctor(sur_2, doctors[3]);*/

		// Attending Nurse for Surgery

		/*AttendingNurse attnur_1 = new AttendingNurse(nurses[0], sur_3);
		AttendingNurse attnur_2 = new AttendingNurse(nurses[1], sur_3);
		AttendingNurse attnur_3 = new AttendingNurse(nurses[0], sur_1);
		AttendingNurse attnur_4 = new AttendingNurse(nurses[2], sur_1);
		AttendingNurse attnur_5 = new AttendingNurse(nurses[0], sur_2);
		AttendingNurse attnur_6 = new AttendingNurse(nurses[2], sur_2);
		AttendingNurse attnur_7 = new AttendingNurse(nurses[3], sur_2);*/

		// Doctor Shift
		DoctorShift dos_1 = new DoctorShift("10/8/2007", "2:00", "10:00", doctors[0]);
		DoctorShift dos_2 = new DoctorShift("10/10/2007", "10:00", "5:00",
				doctors[1]);
		DoctorShift dos_3 = new DoctorShift("10/8/2007", "9:00", "6:00", doctors[1]);
		DoctorShift dos_4 = new DoctorShift("10/10/2007", "8:00", "4:00", doctors[2]);
		DoctorShift dos_5 = new DoctorShift("10/8/2007", "12:00", "6:00", doctors[3]);
		DoctorShift dos_6 = new DoctorShift("10/8/2007", "1:00", "8:00", doctors[0]);

		// Nurse Shift

		NurseShift nus_1 = new NurseShift("10/8/2007", "2:00pm", "10:00pm", nurses[0]);
		NurseShift nus_2 = new NurseShift("10/10/2007", "10:00am", "5:00pm", nurses[0]);
		NurseShift nus_3 = new NurseShift("10/8/2007", "9:00am", "6:00pm", nurses[1]);
		NurseShift nus_4 = new NurseShift("10/10/2007", "8:00pm", "4:00am", nurses[2]);
		NurseShift nus_5 = new NurseShift("10/8/2007", "12:00pm", "6:00pm", nurses[2]);
		NurseShift nus_6 = new NurseShift("10/8/2007", "1:00pm", "8:00pm", nurses[2]);

		// Appointment

		Appointment a1 = new Appointment(doctors[0], patients[0], "8/14/2007",
				"back pain", 30, "9:00am");
		Appointment a2 = new Appointment(doctors[0], patients[1], "8/14/2007",
				"leg pain", 30, "9:30am");
		Appointment a3 = new Appointment(doctors[2], patients[2], "8/16/2007",
				"check up", 30, "1:00pm");

		// Facility

		Facility f1 = new Facility("General");
		Facility f2 = new Facility("Special");
		Facility f3 = new Facility("Emergency");

		// Emergency Center

		EmergencyCenter ec1 = new EmergencyCenter("center", 1000, "John Douglas", 5, 6);

		// EmergencyCenter ec2 = new EmergencyCenter("EMR",1000,"John
		// Douglas",5, "mild");

		// Laboratory

		Laboratory l1 = new Laboratory("f1", "abcd");
		Laboratory l2 = new Laboratory("f1", "abcd");

		// LabTest

		LabTest lb1 = new LabTest(doctors[0], patients[0], l1, "blood test",
				"8/15/2007", "11:00");
		LabTest lb2 = new LabTest(doctors[1], patients[1], l2, "Urine test",
				"8/15/2007", "11:30");
		LabTest lb3 = new LabTest(doctors[2], patients[2], l1, "blood test",
				"8/15/2007", "12:00");

		// medical History

		MedicalHistory m1 = new MedicalHistory(patients[0],
				" Leg pain is ok and suggested to go to Physio therapist.",
				"8/8/2007");
		MedicalHistory m2 = new MedicalHistory(patients[1],
				" Normal and on medication Advil", "8/10/2007");
		MedicalHistory m3 = new MedicalHistory(patients[2],
				" You don't need any presciption for next 2 years.",
				"8/8/2007");

		// Pharmacy

		Pharmacy p1 = new Pharmacy("f1", "Hayward");
		Pharmacy p2 = new Pharmacy("f1", "Foster city");
		Pharmacy p3 = new Pharmacy("f1", "Fremont");

		// Prescription

		Prescription pr1 = new Prescription(p1, doctors[0], patients[0], "ibuprofen",
				"300mg", 0, "1 day");
		Prescription pr2 = new Prescription(p2, doctors[1], patients[1],
				"hydroxizine", "300mg", 0, "2 times a day");

	}
	
	/*public HashMap getNurseList() {
		return nurseList;
	}

	public void addToNurseList(Nurse n) {
		HashMap nl = getNurseList();
		nl.put(String.valueOf(nl.size()), n);
		return;
	}

	public void setNurseList(HashMap nurseList) {
		this.nurseList = nurseList;
	}
*/
	public static void main(String[] args) {
		HospitalInit hi = new HospitalInit();

		System.out.println("Hospital System");

	}
}
