package org.example.TravelAgencyController.UserManagementInterface;

import lombok.Getter;
import lombok.Setter;

@Setter
public class Response
{
    private boolean status;
    @Getter
    private String message;

    public Response() {
    }

    public Response(boolean status, String message) {
        this.status = status;
        this.message = message;
    }

    public boolean getStatus() {
        return status;
    }
}