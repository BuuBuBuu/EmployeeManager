package model.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {

  // Adapt from digipen sample
  // singleton we need to have private static final field to hold the instance
  // Need to have private construct
  // Need to have public static method that other class can call that returns the instance

  // declare private static final EntityManagerFactory
  private static final EntityManagerFactory emf;

  // static initialize stuff
  static {
    try {
      emf = Persistence.createEntityManagerFactory("EmployeeManagerPU");
    } catch (Throwable ex) {
      System.err.println("EMF initialization failed." + ex);

      // stop application if db connection/config not working or bad
      throw new ExceptionInInitializerError(ex);
    }
  }

  // private construtor to prefent instantiation for singleton
  private JPAUtil() {}

  // THIS IS THE PUBLIC ACCESS METHOD FOR GETTING EMF
  public static EntityManagerFactory getEntityManagerFactory() {
    return emf;
  }

  // THIS IS THE PUBLIC ACCESS METHOD FOR GETTING EM
  public static EntityManager getEntityManager() {
    return emf.createEntityManager();
  }

  // Shutdown method
  public static void shutdown() {
    if (emf != null) {
      emf.close();
    }
  }
}
