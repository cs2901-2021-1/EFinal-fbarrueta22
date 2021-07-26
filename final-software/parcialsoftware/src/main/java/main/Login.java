package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class Login {

    private static Login instance = null;

    List<User> users = new ArrayList<>();
    static final Logger logger = Logger.getLogger (Login.class.getName());

    //Singleton
    public static synchronized Login getInstance() {
        if(instance == null)
            return new Login();
        return instance;
    }

    public void toUser() {
        try (Scanner scanner = new Scanner(System.in)) {
            logger.info(" Enter username: ");
            String userName = scanner.nextLine();

            logger.info(" Enter password: ");
            String password = scanner.nextLine();

            User user = new User(userName,password);
            users.add(user);

            while (true) {
                logger.info("Añadir Centro de Vacunación (0): ");
                logger.info("Avance de la Vacunación (1): ");
                logger.info("Cobertura de la Vacunación (2): ");
                logger.info("Dar de baja o alta (3): ");
                logger.info("Numero de Centros de Vacunación (4): ");
                logger.info("Número de personas vacunadas parcialmente (5): ");
                logger.info("Número de personas vacunadas completamente (6): ");
                logger.info("Ver porcentaje de vacunados (7): ");
                logger.info("Cerrar sesión (8): ");
                String option = scanner.nextLine();
                if (option.equals("0")) {
                    logger.info("Ingrese distrito: ");
                    String distrit = scanner.nextLine();
                    logger.info("Ingrese vacunas parciales: ");
                    int vacunasParciales = scanner.nextInt();
                    logger.info("Ingrese vacunas completos: ");
                    int vacunasCompletas = scanner.nextInt();
                    CentroVacunacionController.getInstance().addNuevoCentro(distrit,vacunasParciales, vacunasCompletas);
                }
                else if (option.equals("1")) {
                    logger.info(Float.toString(CentroVacunacionController.getInstance().getAvance()));
                }
                else if (option.equals("2")) {
                    logger.info(Float.toString(CentroVacunacionController.getInstance().getCobertura()));
                }
                else if (option.equals("3")) {
                    logger.info("Ingrese id de centro de vacunación: ");
                    int id = scanner.nextInt();
                    logger.info("Dar de baja (1): ");
                    logger.info("Dar de alta (2): ");
                    String option2 = scanner.nextLine();
                    if (option2.equals("1")) {
                        CentroVacunacionController.getInstance().getCentroById(id).darBaja();
                    }
                    else if (option2.equals("2")) {
                        CentroVacunacionController.getInstance().getCentroById(id).darAlta();
                    }
                }
                else if (option.equals("4")) {
                    logger.info(Integer.toString(CentroVacunacionController.getInstance().getTotalCentros()));
                }
                else if (option.equals("5")) {
                    logger.info(Integer.toString(CentroVacunacionController.getInstance().getVacunasParciales()));
                }
                else if (option.equals("6")) {

                    logger.info(Integer.toString(CentroVacunacionController.getInstance().getVacunasCompletas()));
                }
                else if (option.equals("7")) {
                    logger.info("Ingrese rango de edad: ");
                    String rangoDeEdad = scanner.nextLine();
                    logger.info(Float.toString(DataVacunacion.getInstance().getPorcentaje(rangoDeEdad)));
                }
                else if (option.equals("8")) {
                    logout(user);
                    break;
                }
                else{
                    logger.info("Opcion incorrecta, ingrese otra");
                }
            }
        }
    }


    public boolean logout(User user) {
        return users.remove(user);
    }


}
