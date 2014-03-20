import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

class HospitalFrame extends JFrame implements ActionListener {
	static String sometext = "Use your email id as your user name.";

	final int PATIENTTYPE = 1;

	final int DOCTORTYPE = 2;

	final int NURSETYPE = 3;

	HospitalInit hInit = new HospitalInit();

	JTextArea detailText = new JTextArea(sometext);

	Patient currentPatient = null;

	Doctor currentDoctor = null;

	AttendingDoctor aDoc = null;

	Nurse currentNurse = null;

	AttendingNurse aNurs = null;

	Surgery currentSurgery = null;

	Appointment pAppt = null;

	LabTest pLab = null;

	MedicalHistory medHist = null;

	Prescription pPres = null;

	final Color SKYBLUE = new Color(135, 206, 235);

	final Font BIGFONT = new Font("TimesRoman", Font.BOLD, 16);

	// declare button components for left side
	JButton loginButton = new JButton("Login");

	JButton nurseButton = new JButton("Show nurses");

	JButton personButton = new JButton("Personal Info");

	JButton surgButton = new JButton("Surgery Info");

	JButton apptButton = new JButton("Appointment Info");

	JButton labButton = new JButton("Lab Results");

	JButton histButton = new JButton("Medical History");

	JButton prescButton = new JButton("Prescription");

	JComboBox patientDropdown = new JComboBox();

	JButton patientInfoButton = new JButton("Patient Info");

	JButton exitButton = new JButton("Exit");

	JPanel buttons;

	int userType;

	public HospitalFrame() {
		super("Hospital Interface");
		setSize(450, 500);

		buttons = new JPanel(new GridLayout(10, 1, 2, 2));

		buttons.add(loginButton);
		buttons.add(personButton);
		personButton.setEnabled(false);
		buttons.add(surgButton);
		surgButton.setEnabled(false);
		buttons.add(apptButton);
		apptButton.setEnabled(false);
		buttons.add(labButton);
		labButton.setEnabled(false);
		buttons.add(histButton);
		histButton.setEnabled(false);
		buttons.add(prescButton);
		prescButton.setEnabled(false);
		buttons.add(patientDropdown);
		patientDropdown.setEnabled(false);
		buttons.add(patientInfoButton);
		patientInfoButton.setEnabled(false);
		buttons.add(exitButton);
		exitButton.addActionListener(new ExitHandler());
		buttons.setBackground(SKYBLUE);
		buttons.setBorder(new TitledBorder("Hospital Toolbox"));

		detailText.setLineWrap(true);
		detailText.setEditable(false);
		detailText.setMinimumSize(new Dimension(250, 500));
		JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, buttons,
				detailText);
		nurseButton.addActionListener(this);
		loginButton.addActionListener(this);
		personButton.addActionListener(this);
		surgButton.addActionListener(this);
		apptButton.addActionListener(this);
		labButton.addActionListener(this);
		histButton.addActionListener(this);
		prescButton.addActionListener(this);
		patientDropdown.addActionListener(this);
		patientInfoButton.addActionListener(this);

		/*
		 * HashMap patientList = Patient.patientList;
		 * 
		 * Set set = patientList.keySet(); Iterator iter = set.iterator(); if
		 * (iter.hasNext()) { currentPatient = (Patient)
		 * patientList.get(iter.next()); }
		 * 
		 * Vector pAppts = currentPatient.appointments; Iterator apptIter =
		 * pAppts.iterator();
		 * 
		 * if (apptIter.hasNext()) { pAppt = (Appointment) apptIter.next(); }
		 * Vector plabTest = currentPatient.labTests; Iterator labIter =
		 * plabTest.iterator();
		 * 
		 * if (labIter.hasNext()) { pLab = (LabTest) labIter.next(); }
		 * 
		 * Vector pMedHistory = currentPatient.history; Iterator histIter =
		 * pMedHistory.iterator(); if (histIter.hasNext()) { medHist =
		 * (MedicalHistory) histIter.next(); }
		 * 
		 * Vector pPrescription = currentPatient.prescriptions; Iterator
		 * presIter = pPrescription.iterator(); if (presIter.hasNext()) { pPres =
		 * (Prescription) presIter.next(); }
		 */

		getContentPane().add(sp, BorderLayout.CENTER);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent event) {
		Object source = event.getSource();
		StringBuffer jtTextBuffer = new StringBuffer();
		Set set;
		Iterator iter, iter2;
		Patient tempPatient = null;
		if (source == personButton) {
			if (userType == PATIENTTYPE) {
				jtTextBuffer.append("Patient Name: " + currentPatient.lastName
						+ ", " + currentPatient.firstName + "\n");
				jtTextBuffer
						.append("Address: " + currentPatient.address + "\n");
				jtTextBuffer.append("Email: " + currentPatient.email + "\n");
				jtTextBuffer.append("Phone: " + currentPatient.phoneNumber
						+ "\n");
			} else if (userType == DOCTORTYPE) {
				jtTextBuffer.append("Doctor Name: " + currentDoctor.lastName
						+ ", " + currentDoctor.firstName + "\n");
				jtTextBuffer.append("Department: " + currentDoctor.department
						+ "\n");
				jtTextBuffer.append("Address: " + currentDoctor.address + "\n");
				jtTextBuffer.append("Email: " + currentDoctor.email + "\n");
				jtTextBuffer.append("Phone: " + currentDoctor.phoneNumber
						+ "\n");
			} else if (userType == NURSETYPE) {
				jtTextBuffer.append("Nurse Name: " + currentNurse.lastName
						+ ", " + currentNurse.firstName + "\n");
				jtTextBuffer.append("Address: " + currentNurse.address + "\n");
				jtTextBuffer.append("Email: " + currentNurse.email + "\n");
				jtTextBuffer
						.append("Phone: " + currentNurse.phoneNumber + "\n");
			}
			detailText.setText(jtTextBuffer.toString());
		} else if (source == surgButton) {

			if (userType == PATIENTTYPE) {
				HashMap surgeries = Surgery.surgeries;
				set = surgeries.keySet();
				iter = set.iterator();
				while (iter.hasNext()) {
				Surgery	pSurgery = (Surgery) surgeries.get(iter.next());

					if (pSurgery.patient.patient_no == currentPatient.patient_no) {
						jtTextBuffer.append("Surgery: "
								+ pSurgery.comments + "\n");
						jtTextBuffer.append("Room # " + pSurgery.roomNo
								+ "\n");
						jtTextBuffer.append("Date: " + pSurgery.date
								+ "\n");
						jtTextBuffer.append("Time " + pSurgery.time
								+ "\n\n");
						detailText.setText(jtTextBuffer.toString());
					}
				}
			} else if (userType == NURSETYPE) {
				Vector attndNurse = Surgery.attendingNurses;
				Iterator atNursIter = attndNurse.iterator();
				while (atNursIter.hasNext()) {

					aNurs = (AttendingNurse) atNursIter.next();
					if (aNurs.nurse.equals(currentNurse)) {
						jtTextBuffer.append("Patient: "
								+ aNurs.surgery.patient.lastName + ","
								+ aNurs.surgery.patient.firstName + "\n");
						jtTextBuffer.append("Surgery: "
								+ aNurs.surgery.comments + "\n");
						jtTextBuffer.append("Room # " + aNurs.surgery.roomNo
								+ "\n");
						jtTextBuffer.append("Date: " + aNurs.surgery.date
								+ "\n");
						jtTextBuffer.append("Time " + aNurs.surgery.time
								+ "\n\n");
					}
					detailText.setText(jtTextBuffer.toString());
				}
			} else if (userType == DOCTORTYPE) {
				Vector attnDoc = Surgery.attendingDoctors;
				Iterator atDocIter = attnDoc.iterator();
				while (atDocIter.hasNext()) {
					aDoc = (AttendingDoctor) atDocIter.next();
					if (aDoc.doctor.equals(currentDoctor)) {
						jtTextBuffer.append("Patient: "
								+ aDoc.surgery.patient.lastName + ","
								+ aDoc.surgery.patient.firstName + "\n");
						jtTextBuffer.append("Surgery: " + aDoc.surgery.comments
								+ "\n");
						jtTextBuffer.append("Room # " + aDoc.surgery.roomNo
								+ "\n");
						jtTextBuffer
								.append("Date: " + aDoc.surgery.date + "\n");
						jtTextBuffer.append("Time: " + aDoc.surgery.time
								+ "\n\n");
					}
					detailText.setText(jtTextBuffer.toString());
				}
			}
		}

		else if (source == apptButton) {
			if (userType == PATIENTTYPE) {
				Vector pAppts = currentPatient.appointments;
				Iterator apptIter = pAppts.iterator();

				while (apptIter.hasNext()) {
					pAppt = (Appointment) apptIter.next();
					jtTextBuffer.append("With Doctor: " + pAppt.doctor.lastName
							+ "," + pAppt.doctor.firstName + "\n");
					jtTextBuffer.append("Purpose: " + pAppt.purposeOfVisit
							+ "\n");
					jtTextBuffer
							.append("Date: " + pAppt.appointmentDate + "\n");
					jtTextBuffer.append("Time: " + pAppt.time + "\n");
					detailText.setText(jtTextBuffer.toString());
				}
			}
			if (userType == DOCTORTYPE) {
				Vector dAppts = currentDoctor.appointments;
				Iterator dapptIter = dAppts.iterator();

				while (dapptIter.hasNext()) {
					pAppt = (Appointment) dapptIter.next();
					jtTextBuffer.append("Patient: " + pAppt.patient.firstName
							+ " " + pAppt.patient.lastName + "\n");

					jtTextBuffer
							.append("Date: " + pAppt.appointmentDate + "\n");
					jtTextBuffer.append("Time: " + pAppt.time + "\n");
					jtTextBuffer.append("Purpose: " + pAppt.purposeOfVisit
							+ "\n\n");
					detailText.setText(jtTextBuffer.toString());
				}
			}

		} else if (source == labButton) {

			Vector plabTest = currentPatient.labTests;
			Iterator labIter = plabTest.iterator();

			while (labIter.hasNext()) {
				pLab = (LabTest) labIter.next();
				jtTextBuffer.append("Ordered By Doctor: "
						+ pLab.doctor.lastName + "," + pLab.doctor.firstName
						+ "\n");
				jtTextBuffer.append("Result: " + pLab.type + "\n");
				jtTextBuffer.append("Date: " + pLab.date + "\n\n");
			}

			detailText.setText(jtTextBuffer.toString());
		} else if (source == histButton) {

			Vector pMedHistory = currentPatient.history;
			Iterator histIter = pMedHistory.iterator();
			while (histIter.hasNext()) {
				medHist = (MedicalHistory) histIter.next();
				jtTextBuffer.append("Description: " + medHist.description
						+ "\n");
				jtTextBuffer.append("Date: " + medHist.date + "\n");
			}

			detailText.setText(jtTextBuffer.toString());
		} else if (source == prescButton) {

			Vector pPrescription = currentPatient.prescriptions;
			Iterator presIter = pPrescription.iterator();
			if (presIter.hasNext()) {
				pPres = (Prescription) presIter.next();
				jtTextBuffer.append("Ordered By Doctor: "
						+ pPres.doctor.lastName + "," + pPres.doctor.firstName
						+ "\n");
				jtTextBuffer.append("Medicine: " + pPres.medicineName + "\n");
				jtTextBuffer.append("Dosage: " + pPres.dosage + "\n");
				jtTextBuffer.append("Pharmacy: "
						+ pPres.pharmacy.pharmacyLocation + "\n\n");
			}

			detailText.setText(jtTextBuffer.toString());
		}

		else if (source == loginButton) {

			if (loginButton.getText().equals("Logout")) {
				switch (userType) {
				case PATIENTTYPE:
					currentPatient = null;
					break;
				case DOCTORTYPE:
					currentDoctor = null;
					patientDropdown.removeAllItems();
					break;
				case NURSETYPE:
					currentNurse = null;
					break;
				}
				loginButton.setText("Login");
				detailText.setText("Thanks for visiting our website.");
				personButton.setEnabled(false);
				surgButton.setEnabled(false);
				apptButton.setEnabled(false);
				labButton.setEnabled(false);
				histButton.setEnabled(false);
				prescButton.setEnabled(false);
				patientDropdown.setEnabled(false);
				patientInfoButton.setEnabled(false);
				return;
			}

			final PasswordChooser dialog = new PasswordChooser();
			if (dialog.showDialog(this, "Login")) {
				User u = dialog.getUser();
				String userNameInput = u.getName();
				String passwdInput = new String(u.getPassword());

				userType = isValiduser(userNameInput, passwdInput);

				if (userType == PATIENTTYPE) {
					loginButton.setText("Logout");
					personButton.setEnabled(true);
					surgButton.setEnabled(true);
					apptButton.setEnabled(true);
					labButton.setEnabled(true);
					histButton.setEnabled(true);
					prescButton.setEnabled(true);
					detailText.setText("Welcome Patient: "
							+ currentPatient.firstName + "!");
				} else if (userType == DOCTORTYPE) {
					loginButton.setText("Logout");
					personButton.setEnabled(true);
					surgButton.setEnabled(true);
					apptButton.setEnabled(true);
					patientInfoButton.setEnabled(true);

					detailText.setText("Welcome Doctor: "
							+ currentDoctor.firstName + "!");
					patientDropdown.setEnabled(true);
					HashMap patientList = Patient.patientList;

					set = patientList.keySet();
					iter = set.iterator();
					while (iter.hasNext()) {
						 tempPatient = (Patient) patientList.get(iter
								.next());
						patientDropdown.addItem(tempPatient.lastName + ", "
								+ tempPatient.firstName);
					}

				} else if (userType == NURSETYPE) {
					loginButton.setText("Logout");
					personButton.setEnabled(true);
					surgButton.setEnabled(true);
					patientInfoButton.setEnabled(true);
					detailText.setText("Welcome Nurse: "
							+ currentNurse.firstName + "!");
					patientDropdown.setEnabled(true);
					HashMap patientList = Patient.patientList;

					set = patientList.keySet();
					iter = set.iterator();
					while (iter.hasNext()) {
						 tempPatient = (Patient) patientList.get(iter
								.next());
						patientDropdown.addItem(tempPatient.lastName + ", "
								+ tempPatient.firstName);
					}
				} else
					detailText.setText("Invalid userid or password.");
			}
		}

		// Patient Info Button

		else if (source == patientInfoButton) {

			String selectedPatientName = patientDropdown.getSelectedItem()
					.toString();
			// detailText.setText("You selected: " + patientName);
			HashMap patientList = Patient.patientList;
			set = patientList.keySet();
			iter = set.iterator();
			while (iter.hasNext()) {
				 tempPatient = (Patient) patientList.get(iter.next());

				if (selectedPatientName.equals(tempPatient.lastName + ", "
						+ tempPatient.firstName)) {
					jtTextBuffer.append("Name :" + tempPatient.lastName + ", "
							+ tempPatient.firstName + "\nAddress: "
							+ tempPatient.address + "\nPhone#"
							+ tempPatient.phoneNumber + "\nEmail: "
							+ tempPatient.email + "\nPatient # "
							+ tempPatient.patient_no + "\n\n");
					
					Vector pAppt = tempPatient.appointments;
					Iterator iter1 = pAppt.iterator();

					while (iter1.hasNext()) {
						Appointment apt = (Appointment) iter1.next();
			
						jtTextBuffer.append("Appoint With Doctor: " + apt.doctor.lastName
								+ "," + apt.doctor.firstName + "\n");
						jtTextBuffer.append("Purpose: " + apt.purposeOfVisit
								+ "\n");
						jtTextBuffer
								.append("Date: " + apt.appointmentDate + "\n");
						jtTextBuffer.append("Time: " + apt.time + "\n\n");
						detailText.setText(jtTextBuffer.toString());
					}
					
					Vector labTest = tempPatient.labTests;
					iter2 = labTest.iterator();

					while (iter2.hasNext()) {
						LabTest Lab = (LabTest) iter2.next();
						jtTextBuffer.append("LabTest Ordered By Doctor: "
								+ Lab.doctor.lastName + "," + Lab.doctor.firstName
								+ "\n");
						jtTextBuffer.append("Result: " + Lab.type + "\n");
						jtTextBuffer.append("Date: " + Lab.date + "\n\n");
						detailText.setText(jtTextBuffer.toString());
					}
					
					Vector MedHistory = tempPatient.history;
					Iterator iter3 = MedHistory.iterator();
					
					while (iter3.hasNext()) {
						MedicalHistory	mHist = (MedicalHistory) iter3.next();
					
						jtTextBuffer.append("Medical History: " + mHist.description
								+ "\n");
						jtTextBuffer.append("Date: " + mHist.date + "\n\n");
					}

					detailText.setText(jtTextBuffer.toString());
				

					Vector pres= tempPatient.prescriptions;
					Iterator iter4 = pres.iterator();
					while (iter4.hasNext()) {
						Prescription prsc = (Prescription) iter4.next();
						if (selectedPatientName.equals(tempPatient.lastName
								+ ", " + tempPatient.firstName)){
						jtTextBuffer.append(" Prescription Ordered By Doctor: "
								+ prsc.doctor.lastName + "," + prsc.doctor.firstName
								+ "\n");
						jtTextBuffer.append("Medicine: " + prsc.medicineName + "\n");
						jtTextBuffer.append("Dosage: " + prsc.dosage + "\n");
						jtTextBuffer.append("Pharmacy: "
								+ prsc.pharmacy.pharmacyLocation + "\n\n");
					}

					detailText.setText(jtTextBuffer.toString());
					
				}
			}
			}


			HashMap surgeries = Surgery.surgeries;
			set = surgeries.keySet();
			iter = set.iterator();
			while (iter.hasNext()) {
				Surgery tempSurgery = (Surgery) surgeries.get(iter.next());

				if (selectedPatientName.equals(tempSurgery.patient.lastName
						+ ", " + tempSurgery.patient.firstName)) {
					jtTextBuffer.append("Surgery: " + tempSurgery.comments
							+ "\n");
					jtTextBuffer.append("Room # " + tempSurgery.roomNo + "\n");
					jtTextBuffer.append("Date: " + tempSurgery.date + "\n");
					jtTextBuffer.append("Time: " + tempSurgery.time + "\n\n");
					detailText.setText(jtTextBuffer.toString());
				}
			}
			
		
		}
	}
			

		// else {
		// detailText
		// .setText("You pressed the button: " + event.paramString());
		// }
	

	public static void main(String args[]) {
		new HospitalFrame();
	}

	public int isValiduser(String u, String p) {
		Set set;
		Iterator iter;
		HashMap patientList = Patient.patientList;

		set = patientList.keySet();
		iter = set.iterator();
		while (iter.hasNext()) {
			currentPatient = (Patient) patientList.get(iter.next());
			if (currentPatient.email.equalsIgnoreCase(u)
					&& currentPatient.passwd.equals(p))
				return PATIENTTYPE;
		}

		HashMap doctors = Doctor.doctors;
		set = doctors.keySet();
		iter = set.iterator();
		while (iter.hasNext()) {
			currentDoctor = (Doctor) doctors.get(iter.next());
			if (currentDoctor.email.equalsIgnoreCase(u)
					&& currentDoctor.passwd.equals(p))
				return DOCTORTYPE;
		}

		HashMap nurses = Nurse.nurses;
		set = nurses.keySet();
		iter = set.iterator();
		while (iter.hasNext()) {
			currentNurse = (Nurse) nurses.get(iter.next());
			if (currentNurse.email.equalsIgnoreCase(u)
					&& currentNurse.passwd.equals(p))
				return NURSETYPE;
		}

		return 0;
	}
}

class ExitHandler implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}
}
