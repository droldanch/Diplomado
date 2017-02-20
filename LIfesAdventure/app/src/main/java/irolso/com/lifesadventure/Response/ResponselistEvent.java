
package irolso.com.lifesadventure.Response;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponselistEvent {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("isValid")
    @Expose
    private Boolean isValid;
    @SerializedName("observations")
    @Expose
    private String observations;
    @SerializedName("placeTimeDeparture")
    @Expose
    private String placeTimeDeparture;
    @SerializedName("placeToVisit")
    @Expose
    private String placeToVisit;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("publised")
    @Expose
    private Boolean publised;
    @SerializedName("reUse")
    @Expose
    private Boolean reUse;
    @SerializedName("travelDetails")
    @Expose
    private String travelDetails;
    @SerializedName("startDate")
    @Expose
    private StartDate startDate;
    @SerializedName("endDate")
    @Expose
    private EndDate endDate;
    @SerializedName("payMethods")
    @Expose
    private List<PayMethod> payMethods = null;
    @SerializedName("pictures")
    @Expose
    private List<Picture> pictures = null;
    @SerializedName("thingsToGet")
    @Expose
    private List<Object> thingsToGet = null;
    @SerializedName("whatIncludes")
    @Expose
    private List<WhatInclude> whatIncludes = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getIsValid() {
        return isValid;
    }

    public void setIsValid(Boolean isValid) {
        this.isValid = isValid;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public String getPlaceTimeDeparture() {
        return placeTimeDeparture;
    }

    public void setPlaceTimeDeparture(String placeTimeDeparture) {
        this.placeTimeDeparture = placeTimeDeparture;
    }

    public String getPlaceToVisit() {
        return placeToVisit;
    }

    public void setPlaceToVisit(String placeToVisit) {
        this.placeToVisit = placeToVisit;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Boolean getPublised() {
        return publised;
    }

    public void setPublised(Boolean publised) {
        this.publised = publised;
    }

    public Boolean getReUse() {
        return reUse;
    }

    public void setReUse(Boolean reUse) {
        this.reUse = reUse;
    }

    public String getTravelDetails() {
        return travelDetails;
    }

    public void setTravelDetails(String travelDetails) {
        this.travelDetails = travelDetails;
    }

    public StartDate getStartDate() {
        return startDate;
    }

    public void setStartDate(StartDate startDate) {
        this.startDate = startDate;
    }

    public EndDate getEndDate() {
        return endDate;
    }

    public void setEndDate(EndDate endDate) {
        this.endDate = endDate;
    }

    public List<PayMethod> getPayMethods() {
        return payMethods;
    }

    public void setPayMethods(List<PayMethod> payMethods) {
        this.payMethods = payMethods;
    }

    public List<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(List<Picture> pictures) {
        this.pictures = pictures;
    }

    public List<Object> getThingsToGet() {
        return thingsToGet;
    }

    public void setThingsToGet(List<Object> thingsToGet) {
        this.thingsToGet = thingsToGet;
    }

    public List<WhatInclude> getWhatIncludes() {
        return whatIncludes;
    }

    public void setWhatIncludes(List<WhatInclude> whatIncludes) {
        this.whatIncludes = whatIncludes;
    }

}
