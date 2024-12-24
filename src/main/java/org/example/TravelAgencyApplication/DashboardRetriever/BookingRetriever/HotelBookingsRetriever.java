package org.example.TravelAgencyApplication.DashboardRetriever.BookingRetriever;

import org.example.TravelAgencyPersistence.BookingStore.BookingProvider.HotelPortal;
import org.example.TravelAgencyPersistence.BookingStore.ExternalHotelProvider.Hotel;
import org.example.TravelAgencyPersistence.BookingStore.UserHotelProvider.BookedHotelRoom;

import java.util.ArrayList;
import java.util.Date;

public class HotelBookingsRetriever {
    private HotelPortal portal;

    public HotelBookingsRetriever() {
        portal = new HotelPortal();
    }

    //retriever Logic
    public ArrayList<BookedHotelRoom> retrieveAllHotelRooms(int userID) {
        return portal.getFilteredBookedHotelRooms(null, userID, null,null,null,null);
    }

    public ArrayList<BookedHotelRoom> retrieveArchivedOrUpcomingHotelRooms(int userID,boolean archived) {
        ArrayList<BookedHotelRoom> hotelBookings = retrieveAllHotelRooms(userID);

        Date now = new Date();

        for (int i=0; i<hotelBookings.size(); i++) {
            if (hotelBookings.get(i).date.before(now) && !archived){
                hotelBookings.remove(i--);
            }
            else if ((hotelBookings.get(i).date.equals(now) || hotelBookings.get(i).date.after(now)) && archived){
                hotelBookings.remove(i--);
            }
        }
        return hotelBookings;
    }//archived: true means past room bookings, false means upcoming room bookings



    public ArrayList<HotelBooking> retrieveHotelBookings(ArrayList<BookedHotelRoom> hotelRooms){
        ArrayList<HotelBooking> bookings = new ArrayList<>();
        while (!hotelRooms.isEmpty()) {
            Hotel hotel = hotelRooms.getFirst().hotel;
            int bookingID = hotelRooms.getFirst().bookingID;
            ArrayList<HotelRoomInfo> rooms = new ArrayList<>();
            for (int j=0; j<hotelRooms.size(); j++) { //remove and put bookings with same ID in one booking
                if (hotelRooms.get(j).bookingID == bookingID){
                    BookedHotelRoom room = hotelRooms.remove(j--);
                    rooms.add(new HotelRoomInfo(room.roomID, room.roomNum, room.date, room.nights));
                }
            }
            bookings.add(new HotelBooking(hotel,rooms));
        }
        return bookings;
    }


}
