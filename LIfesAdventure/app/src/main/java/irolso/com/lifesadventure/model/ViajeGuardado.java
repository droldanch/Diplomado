package irolso.com.lifesadventure.model;

/**
 * Created by Roldan on 13/02/17.
 */

public class ViajeGuardado {


    String name;
    String observations;
    String price;
    String placeTime;
    String placeToVisit;
    String startDate;
    String endDate;
    String picture;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPlaceTime() {
        return placeTime;
    }

    public void setPlaceTime(String placeTime) {
        this.placeTime = placeTime;
    }

    public String getplaceToVisit() {
        return placeToVisit;
    }

    public void setplaceToVisit(String vplaceToVisit) {
        this.placeToVisit = vplaceToVisit;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    String detalles;
}
