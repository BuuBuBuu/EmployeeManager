import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

/**
 * JAX-RS App entry point for the Employee Service.
 * Base URI starts with "/service"/..
 */
@ApplicationPath("/service")
public class EmployeeApp extends Application {
    // leaving constructor empty - JAX-RS will do autoscan and load everything with @Path and @Provider
//    @Override
//    public Set<Class<?>> getClasses() {
//        Set<Class<?>> s = new HashSet<>();
//        s.add(EmployeeController.class);
//        s.add(DepartmentController.class);
//        s.add(JacksonConfigUtil.class); // need to add this!
//        return s;
//    }
}
