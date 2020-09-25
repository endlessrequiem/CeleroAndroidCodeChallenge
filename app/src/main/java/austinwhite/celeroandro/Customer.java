package austinwhite.celeroandro;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.builder.ToStringBuilder;

import austinwhite.celeroandro.jsonData.Location;
import austinwhite.celeroandro.jsonData.ProfilePicture;


class Customer {
    private int identifier;
    int visitOrder;
    private String name;
    private String phoneNumber;
    private ProfilePicture profilePicture;
    private Location location;
    private String serviceReason;
    private List<String> problemPictures;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public int getIdentifier() {
        return identifier;
    }

    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    public int getVisitOrder() {
        return visitOrder;
    }

    public void setVisitOrder(int visitOrder) {
        this.visitOrder = visitOrder;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public ProfilePicture getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(ProfilePicture profilePicture) {
        this.profilePicture = profilePicture;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getServiceReason() {
        return serviceReason;
    }

    public void setServiceReason(String serviceReason) {
        this.serviceReason = serviceReason;
    }

    public List<String> getProblemPictures() {
        return problemPictures;
    }

    public void setProblemPictures(List<String> problemPictures) {
        this.problemPictures = problemPictures;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public String toString() {
        return new ToStringBuilder(this).append("identifier", identifier).append("visitOrder", visitOrder).append("name", name).append("phoneNumber", phoneNumber).append("profilePicture", profilePicture).append("location", location).append("serviceReason", serviceReason).append("problemPictures", problemPictures).append("additionalProperties", additionalProperties).toString();
    }


}