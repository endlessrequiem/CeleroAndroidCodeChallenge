package austinwhite.celeroandro.jsonData;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.builder.ToStringBuilder;


public class Location {

    private Address address;
    private Coordinate coordinate;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }


    public String toString() {
        return new ToStringBuilder(this).append("address", address).append("coordinate", coordinate).append("additionalProperties", additionalProperties).toString();
    }

}
