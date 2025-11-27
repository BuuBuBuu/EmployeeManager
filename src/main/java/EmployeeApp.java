import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import services.EmployeeService;

import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/service")
public class EmployeeApp extends Application {

  // tell jax-rs application which are the resource classes.
  @Override
  public Set<Class<?>> getClasses() {
    Set<Class<?>> s = new HashSet<>();
    s.add(EmployeeService.class);
    return s;
  }










}
