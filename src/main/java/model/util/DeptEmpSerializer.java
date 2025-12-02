// https://www.baeldung.com/jackson-custom-serialization
package model.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import model.entity.DeptEmp;

import java.io.IOException;

/**
 * Custom serializer for DeptEmp entity
 */
public class DeptEmpSerializer extends StdSerializer<DeptEmp> {

  /**
   * Default constructor
   */
  public DeptEmpSerializer() {
    this(null);
  }

  /**
   * Parameterized constructor
   * @param t Class type
   */
  public DeptEmpSerializer(Class<DeptEmp> t) {
    super(t);
  }

  /**
   * Serialize DeptEmp object to JSON
   * @param deptEmp DeptEmp object
   * @param jsonGenerator JSON generator
   * @param serializerProvider Serializer provider
   * @throws IOException if an I/O error occurs
   * @throws JsonProcessingException if a JSON processing error occurs
   */
  @Override
  public void serialize(DeptEmp deptEmp, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
    jsonGenerator.writeStartObject();
    jsonGenerator.writeStringField("deptNo", deptEmp.getDeptNo());
    jsonGenerator.writeStringField("deptName", deptEmp.getDepartment().getDeptName());
    jsonGenerator.writeObjectField("fromDate", deptEmp.getFromDate());
    jsonGenerator.writeObjectField("toDate", deptEmp.getToDate());
    jsonGenerator.writeEndObject();
  }
}