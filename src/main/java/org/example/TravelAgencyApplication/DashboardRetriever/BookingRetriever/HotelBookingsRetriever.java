package org.example.TravelAgencyApplication.DashboardRetriever.BookingRetriever;

import org.example.TravelAgencyPersistence.BookingStore.BookingProvider.HotelPortal;
import org.example.TravelAgencyPersistence.BookingStore.ExternalHotelProvider.Hotel;
import org.example.TravelAgencyPersistence.BookingStore.UserHotelProvider.BookedHotelRoom;

import java.util.ArrayList;
import java.util.Date;

public class HotelBookingsRetriever {
    private int userID;
    private HotelPortal portal;

    public HotelBookingsRetriever(int userID) {
        this.userID = userID;
        portal = new HotelPortal();
    }

    //retriever Logic
    public ArrayList<BookedHotelRoom> retrieveAllHotelRooms() {
        return portal.getHotelRoomsByUserID(userID);
    }

    public ArrayList<BookedHotelRoom> retrieveArchivedOrUpcomingHotelRooms(boolean archived) {
        ArrayList<BookedHotelRoom> hotelBookings = retrieveAllHotelRooms();

        Date now = new Date();

        for (int i=0; i<hotelBookings.size(); i++) {
            if (hotelBookings.get(i).startDate.before(now) && !archived){
                hotelBookings.remove(i--);
            }
            else if (archived){
                hotelBookings.remove(i--);
            }
        }
        return hotelBookings;
    }//archived: true means past room bookings, false means upcoming room bookings



    public ArrayList<HotelBooking> retrieveHotelBookings(ArrayList<BookedHotelRoom> hotelRooms){
        ArrayList<HotelBooking> bookings = new ArrayList<>();
        for (int i=0; i<hotelRooms.size(); i++) {
            Hotel hotel = portal.getHotelByID(hotelRooms.get(i).hotelID);
            ArrayList<HotelRoomInfo> rooms = new ArrayList<>();
            for (int j=i+1; j<hotelRooms.size(); j++) { //remove and put bookings with same ID in one booking
                if (hotelRooms.get(j).bookingID == hotelRooms.get(i).bookingID){
                    BookedHotelRoom room = hotelRooms.remove(j--);
                    rooms.add(new HotelRoomInfo(room.roomID, room.roomNum, room.startDate, room.nights));
                }
            }
            bookings.add(new HotelBooking(hotel,rooms));
        }
        return bookings;
    }


}
