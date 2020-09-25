package austinwhite.celeroandro;

import com.google.gson.annotations.SerializedName;

import java.util.List;

class Customer {

    //Customer info
    @SerializedName("identifier")
    private String identifier;

    @SerializedName("visitOrder")
    private int visitOrder;

    @SerializedName("name")
    private String name;

    @SerializedName("phoneNumber")
    private String phoneNumber;

    //Customer Image
    @SerializedName("profilePicture/large")
    private String largeImage;

    @SerializedName("profilePicture/medium")
    private String mediumImage;

    @SerializedName("profilePicture/thumbnail")
    private String thumbnailImage;

    //Customer Location Info
    @SerializedName("location/address/street")
    private String streetAddress;

    @SerializedName("location/address/city")
    private String city;

    @SerializedName("location/address/state")
    private String state;

    @SerializedName("location/address/postalCode")
    private String postalCode;

    @SerializedName("location/address/country")
    private String country;

    //Coordinates
    @SerializedName("location/coordinate/latitude")
    private String latitude;

    @SerializedName("location/coordinate/longitude")
    private String longitude;

    //Service Reason and Problem pictures
    @SerializedName("serviceReason")
    private String serviceReason;

    @SerializedName("problemPictures")
    private List<String> problemPictures;

    public Customer(String identifier,
                    int visitOrder,
                    String name,
                    String phoneNumber,
                    String largeImage,
                    String mediumImage,
                    String thumbnailImage,
                    String streetAddress,
                    String city,
                    String state,
                    String postalCode,
                    String country,
                    String latitude,
                    String longitude,
                    String serviceReason,
                    List<String> problemPictures)
     {
         this.identifier = identifier;
         this.visitOrder = visitOrder;
         this.name = name;
         this.phoneNumber = phoneNumber;
         this.largeImage = largeImage;
         this.mediumImage = mediumImage;
         this.thumbnailImage = thumbnailImage;
         this.streetAddress = streetAddress;
         this.city = city;
         this.state = state;
         this.postalCode = postalCode;
         this.country = country;
         this.latitude = latitude;
         this.longitude = longitude;
         this.serviceReason = serviceReason;
         this.problemPictures = problemPictures;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
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

    public String getMediumImage() {
        return mediumImage;
    }

    public void setMediumImage (String mediumImage) {
        this.mediumImage = mediumImage;
    }

    public String getThumbnailImage() {
        return thumbnailImage;
    }

    public void setThumbnailImage (String thumbnailImage) {
        this.thumbnailImage = thumbnailImage;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress (String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity (String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState (String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode (String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry (String country) {
        this.country = country;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude (String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude (String longitude) {
        this.longitude = longitude;
    }

    public String getServiceReason () {
        return serviceReason;
    }

    public void setServiceReason (String serviceReason) {
        this.serviceReason = serviceReason;
    }

    public List<String> getProblemPictures() {
        return problemPictures;
    }

    public void setProblemPictures (List<String> problemPictures) {
        this.problemPictures = problemPictures;
    }



}
