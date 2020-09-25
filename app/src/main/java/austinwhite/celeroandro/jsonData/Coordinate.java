package austinwhite.celeroandro.jsonData;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.builder.ToStringBuilder;


public class Coordinate {

    private Double latitude;
    private Double longitude;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("latitude", latitude).append("longitude", longitude).append("additionalProperties", additionalProperties).toString();
    }

}
