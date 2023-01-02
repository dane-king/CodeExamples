package converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SimpleTest {
    @Test
    void shouldJavaSerializeToXmlStr() throws JsonProcessingException {
        XmlMapper mapper = new XmlMapper();
        String name = "test";
        int x = 2;
        int y = 3;
        String xml = mapper.writeValueAsString(new Simple(x, y, name));
        assertEquals(getXMLString(x, y, name), xml);

    }

    @Test
    void shouldDeserializeFromStringToJava() throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
//        String xml = IOUtils.toString(
//                Objects.requireNonNull(this.getClass().getResourceAsStream("test.xml")),
//                StandardCharsets.UTF_8
//        );

        Simple value
                = xmlMapper.readValue("<root><x>6</x><y>7</y><name>another</name></root>", Simple.class);
        assertEquals(getObjectString(6,7,"another"), value.toString());
    }

    public String getXMLString(int x, int y, String name){
        return "<root><x>" + x + "</x><y>" + y + "</y><name>" + name + "</name></root>";
    }

    public String getObjectString(int x, int y, String name){
        return "Simple{x=" + x +", y=" + y + ", name='"+ name + "'}";
    }
}