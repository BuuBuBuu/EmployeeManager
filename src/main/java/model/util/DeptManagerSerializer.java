// https://www.baeldung.com/jackson-custom-serialization
package model.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import model.entity.DeptManager;

import java.io.IOException;

public class DeptManagerSerializer extends StdSerializer<DeptManager> {

  public DeptManagerSerializer() {
    this(null);
  }

  public DeptManagerSerializer(Class<DeptManager> t) {
    super(t);
  }

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