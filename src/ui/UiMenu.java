package ui;

import model.Doctor;
import model.Patient;

import java.util.ArrayList;
import java.util.Scanner;

public class UiMenu {

    public static final String[] MONTHS = {
            "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
            "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
    };
    public static Doctor doctorLogged;
    public static Patient patientLogged;
    public static void showMenu() {
        System.out.println("Welcome to My Appointments");
        System.out.println("Selecciona la opción deseada");

        int response = 0;
        do {
            System.out.println("1. Doctor");
            System.out.println("2. Patient");
            System.out.println("0. Salir");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response) {
                case 1:
                    response = 0;
                    authUser(1);
                case 2:
                    response = 0;
                    authUser(2);
                case 0:
                    System.out.println("Thank you for you visit");
                    break;
                default:
                    response = 0;
                    System.out.println("Error format response");
            }
        } while (response != 0);
    }

    private static void authUser(int userType) {

        boolean emailCorrect = false;
        String emailResp = "";

        ArrayList<Doctor> Doct = new ArrayList<>();
        Doct.add(new Doctor("Juan", "juan@juan.com"));
        Doct.add(new Doctor("Alan", "alan@alan.com"));
        Doct.add(new Doctor("Agus", "agus@agus.com"));

        ArrayList<Patient> Pat = new ArrayList<>();
        Pat.add(new Patient("ventilador", "ventilador@ventilador.com"));
        Pat.add(new Patient("cama", "cama@cama.com"));
        Pat.add(new Patient("sueño", "sueño@sueño.com"));

        do {
            System.out.println("Insert your email: [a***@a****.com]");
            Scanner sc = new Scanner(System.in);
            emailResp = sc.nextLine();
            if (userType == 1) {
                for (Doctor d : Doct) {
                    if (emailResp.equals(d.getEmail())){
                        emailCorrect = true;
                        doctorLogged = d;
                        UIDoctorMenu.showDoctorMenu();
                        return;
                    }
                }
                System.out.println("Autenticación sin éxito, vuelve a ingresar un email válido: ");
            } else if (userType == 2) {
                for (Patient p : Pat) {
                    if (emailResp.equals(p.getEmail())){
                        patientLogged = p;
                        emailCorrect = true;
                        UIPatientMenu.showPatientMenu();
                        return;
                    }
                }
                System.out.println("Autenticación sin éxito, vuelve a ingresar un email válido: ");
            }
        } while (!emailCorrect);
    }
}
