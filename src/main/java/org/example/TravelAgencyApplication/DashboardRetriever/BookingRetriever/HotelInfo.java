package org.example.TravelAgencyApplication.DashboardRetriever.BookingRetriever;

public class HotelInfo {
    public int hotelID;
    public String hotelName;
    public double latitude;
    public double longitude;

    HotelInfo(int hotelID, String hotelName, double latitude, double longitude) {
        this.hotelID = hotelID;
        this.hotelName = hotelName;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
