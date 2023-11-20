package ui;

import model.Doctor;

import java.util.ArrayList;
import java.util.Scanner;

public class UIDoctorMenu {

    public static ArrayList<Doctor> doctorsAvailableAppointments = new ArrayList<>();

    public static void showDoctorMenu() {
        int response = 0;
        do {
            System.out.println("\n\n");
            System.out.println("Doctor");
            System.out.println("Welcome " + UiMenu.doctorLogged.getName());
            System.out.println("1. Add available Appointment");
            System.out.println("2. My Scheduled Appointment");
            System.out.println("0. Logout");

            Scanner sc = new Scanner(System.in);
            response = Integer.parseInt(sc.nextLine());

            switch (response) {
                case 1:
                    showAddAvailableApponitmentsMenu();
                    break;
                case 2:
                    break;
                case 0:
                    UiMenu.showMenu();
                    break;
            }

        } while (response != 0);
    }

    private static void showAddAvailableApponitmentsMenu() {
        int response = 0;
        do {
            System.out.println("\n\n");
            System.out.println(":: Add Available Appointment");
            System.out.println(":: Select a Month");
            for (int i = 0; i < 3; i++) {
                int j = i + 1;
                System.out.println(j + "- " + UiMenu.MONTHS[i]);
            }
            System.out.println("0. Return");

            Scanner sc = new Scanner(System.in);
            response = Integer.parseInt(sc.nextLine());

            if (response > 0 && response < 4) {
                int monthSelected = response;
                System.out.println(monthSelected + " . " + UiMenu.MONTHS[monthSelected-1]);
                System.out.println("Inser the date available: [dd/mm/yyyy]");
                String date = sc.nextLine();

                System.out.println("Your date is: " + date + "\n1. Correct \n2. Change Date");

                int responseDate = Integer.parseInt(sc.nextLine());
                if (responseDate == 2) continue;

                int responseTime = 0;
                String time = "";
                do {
                    System.out.println("Insert the time available for Date: " + date + "[16:00]");
                    time = sc.nextLine();
                    System.out.println("Your time is: " + time + "\n1. Correct \n2. Change Time");
                    responseTime = Integer.parseInt(sc.nextLine());

                    UiMenu.doctorLogged.addAvailableAppointment(date, time);
                    checkDoctorAvailableAppointments(UiMenu.doctorLogged);
                } while (responseTime == 2);
            } else if (response == 0) {
                showDoctorMenu();
            } else {
                System.out.println("Debe seleccionar una opción válida.");
            }
        } while (response != 0);
    }

    private static void checkDoctorAvailableAppointments(Doctor doctor) {
        if (!doctor.getAvailableAppointments().isEmpty() && !doctorsAvailableAppointments.contains(doctor)) {
            doctorsAvailableAppointments.add(doctor);
        }
    }
}
