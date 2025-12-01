// https://www.baeldung.com/jackson-custom-serialization
package model.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import model.entity.DeptEmp;

import java.io.IOException;

public class DeptEmpSerializer extends StdSerializer<DeptEmp> {

  public DeptEmpSerializer() {
    this(null);
  }

  public DeptEmpSerializer(Class<DeptEmp> t) {
    super(t);
  }

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