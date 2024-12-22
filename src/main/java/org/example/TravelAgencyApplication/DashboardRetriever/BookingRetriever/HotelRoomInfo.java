package org.example.TravelAgencyApplication.DashboardRetriever.BookingRetriever;

import java.util.Date;

public class HotelRoomInfo {
    public int bookedRoomID;
    public int roomNum;
    public Date startDate;
    public int nights;

    public HotelRoomInfo(int bookedRoomID, int roomNum, Date startDate, int nights) {
        this.bookedRoomID = bookedRoomID;
        this.roomNum = roomNum;
        this.startDate = startDate;
        this.nights = nights;
    }
}
