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

    public void addUser() {
        try (Scanner scanner = new Scanner(System.in)) {
            logger.info(" Enter username: ");
            String userName = scanner.nextLine();

            logger.info(" Enter password: ");
            String password = scanner.nextLine();

            User user = new User(userName,password);
            users.add(user);

            System.out.print("Welcome");
            Scanner sc = new Scanner(System.in))
            while (true) {
                logger.info("Avance de la Vacunación (1): ");
                logger.info("Cobertura de la Vacunación (2): ");
                logger.info("Numero de Centros de Vacunación (3): ");
                logger.info("Número de personas vacunadas parcialmente (4): ");
                logger.info("Número de personas vacunadas completamente (5): ");
                logger.info("Ver porcentaje de vacunados (6): ");
                logger.info("Cerrar sesión (7): ");
                String option = scanner.nextLine();
                if (option.equals("1")) {

                }
                else if (option.equals("2")) {
                    logger.info("Ingrese id de centro de vacunación: ");
                    int id = sc.nextInt();
                    logger.info("Dar de baja (1): ");
                    logger.info("Dar de alta (2): ");
                    String option2 = sc.nextLine();
                    if (option2.equals("1")) {
                        CentroVacunacionManager.getInstance().getCentroById(id).darDeBaja();
                    }
                    else if (option2.equals("2")) {
                        CentroVacunacionManager.getInstance().getCentroById(id).darDeAlta();
                    }
                }
                else if (option.equals("3")) {
                    logger.info(Integer.toString(CentroVacunacionManager.getInstance().getCont()));
                }
                else if (option.equals("4")) {
                    logger.info(Integer.toString(CentroVacunacionManager.getInstance().getCont()));
                    logger.info(Integer.toString(CentroVacunacionManager.getInstance().getVacunasParciales()));
                }
                else if (option.equals("5")) {
                    logger.info(Integer.toString(CentroVacunacionManager.getInstance().getCont()));
                    logger.info(Integer.toString(CentroVacunacionManager.getInstance().getVacunasCompletas()));
                }
                else if (option.equals("6")) {
                    logger.info("Ingrese rango de edad: ");
                    String rangoDeEdad = scanner.nextLine();
                    logger.info(Float.toString(user.getPorcentaje(rangoDeEdad)));
                }
                else if (option.equals("7")) {
                    logout(user);
                    break;
                }
            }


        }
    }

    public boolean logout(User user) {
        return users.remove(user);
    }


}
