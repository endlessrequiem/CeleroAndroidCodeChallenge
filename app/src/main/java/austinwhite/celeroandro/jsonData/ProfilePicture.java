package austinwhite.celeroandro.jsonData;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.HashMap;
import java.util.Map;


public class ProfilePicture {

    private String large;
    private String medium;
    private String thumbnail;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("large", large).append("medium", medium).append("thumbnail", thumbnail).append("additionalProperties", additionalProperties).toString();
    }

}
