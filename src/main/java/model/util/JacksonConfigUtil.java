package model.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.ws.rs.ext.ContextResolver;
import jakarta.ws.rs.ext.Provider;

/**
 * Utility class to serial LocalDate
 */
@Provider
public class JacksonConfigUtil implements ContextResolver<ObjectMapper> {
  /**
   * ObjectMapper instance
   */
  private final ObjectMapper mapper;

  /**
   * Constructor for JacksonConfigUtil
   */
  public JacksonConfigUtil() {
    mapper = new ObjectMapper();
    // register the module to handle LocalDate
    mapper.registerModule(new JavaTimeModule());

    // make dates look like "1986-06-26" instead of an array like [1986, 06, 26]
    mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
  }

  /**
   * Objectmapper getContext overriding
   * @param type Class type
   * @return ObjectMapper instance
   */
  @Override
  public ObjectMapper getContext(Class<?> type) {
    return mapper;
  }
}