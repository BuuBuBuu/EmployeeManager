package model.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * JPA Utility class for managing EntityManagerFactory and EntityManager instances.
 */
public class JPAUtil {

  // Adapt from digipen sample
  // singleton we need to have private static final field to hold the instance
  // Need to have private construct
  // Need to have public static method that other class can call that returns the instance

  // declare private static final EntityManagerFactory
  /**
   * Singleton EntityManagerFactory instance
   */
  private static EntityManagerFactory emf;

  /**
   * Private constructor to prevent instantiation for singleton
   */
  private JPAUtil() {}

  // THIS IS THE PUBLIC ACCESS METHOD FOR GETTING EMF
  /**
   * Get the singleton EntityManagerFactory instance
   * @return EntityManagerFactory instance
   */
  public static synchronized EntityManagerFactory getEntityManagerFactory() {
    if (emf == null) {
      try {
        emf = Persistence.createEntityManagerFactory("EmployeeManagerPU");
      } catch (Throwable ex) {
        System.err.println("EMF initialization failed." + ex);
        // stop application if db connection/config not working or bad
        throw new ExceptionInInitializerError(ex);
      }
    }
    return emf;
  }

  // THIS IS THE PUBLIC ACCESS METHOD FOR GETTING EM
  /**
   * Create and return a new EntityManager instance
   * @return EntityManager instance
   */
  public static EntityManager getEntityManager() {
    EntityManagerFactory factory = getEntityManagerFactory();
    return factory.createEntityManager();
  }

  // Shutdown method
  /**
   * Shutdown the EntityManagerFactory
   */
  public static void shutdown() {
    if (emf != null) {
      emf.close();
    }
  }
}