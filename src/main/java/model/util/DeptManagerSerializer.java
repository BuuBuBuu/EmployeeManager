// https://www.baeldung.com/jackson-custom-serialization
package model.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import model.entity.DeptManager;

import java.io.IOException;

/**
 * Custom serializer for DeptManager entity
 */
public class DeptManagerSerializer extends StdSerializer<DeptManager> {
  /**
   * Default constructor
   */
  public DeptManagerSerializer() {
    this(null);
  }

  /**
   * Parameterized constructor
   * @param t Class type
   */
  public DeptManagerSerializer(Class<DeptManager> t) {
    super(t);
  }

  /**
   * Serialize DeptManager object to JSON
   * @param deptManager DeptManager object
   * @param jsonGenerator JSON generator
   * @param serializerProvider Serializer provider
   * @throws IOException if an I/O error occurs
   * @throws JsonProcessingException if a JSON processing error occurs
   */
  @Override
  public void serialize(DeptManager deptManager, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
    jsonGenerator.writeStartObject();
    jsonGenerator.writeStringField("deptNo", deptManager.getDeptNo());
    jsonGenerator.writeStringField("deptName", deptManager.getDepartment().getDeptName());
    jsonGenerator.writeObjectField("fromDate", deptManager.getFromDate());
    jsonGenerator.writeObjectField("toDate", deptManager.getToDate());
    jsonGenerator.writeEndObject();
  }
}