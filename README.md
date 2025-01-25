# Travel Agency Backend System

A robust backend system designed for a travel agency, enabling users to book hotel rooms and event tickets, manage their bookings, and receive personalized notifications. 
The system is built using *Java* programming language and the *Spring Boot* framework, with a focus on clean architecture using MVC architecture style, design patterns, and SOLID principles.

---

## Features

### 1. *Hotel Booking*
   - Users can view, search, and book hotel rooms 
   - Real-time integration with hotel providers via APIs.

### 2. *Event Booking*
   - Users can view, search, and book tickets for local events.
   - Integration with an external events API to fetch event details.

### 3. *User Dashboard*
   - Users have a personalized dashboard to view, manage, and print their bookings.
   - Upcoming and archived bookings are displayed separately.

### 4. *Notification Module*
   - *Templates Management*: Supports multiple languages (English, Arabic, French, German) and placeholders for dynamic content.
   - *Queuing System*: Notifications are queued for asynchronous processing to avoid blocking the main thread.
   - *Sending Mechanism*: Notifications are sent via email or SMS, with retry logic for failed attempts.
   - *Statistics*: Tracks successful and failed notifications, most notified users, and most used templates.

### 5. *User Management*
   - *Registration*: Users can register with their personal information and preferences.
   - *Authentication*: Email verification and password reset functionality.
   - *Login*: Secure login with session management for both normal users and admins.

### 6. *Recommendations*
   - If a user books a hotel, the system recommends events in the destination location during their stay.

### 7. *Real-Time Backend Actions*
   - The system shows real-time backend actions (e.g., database reads, API calls) when users interact with the application.

---

## Technologies Used

- *Programming Language*: Java
- *Framework*: Spring Boot
- *Testing*: Postman (API testing)
- *Design Patterns*: Singleton, Factory, Observer, Builder, and more.
- *SOLID Principles*: Applied throughout the codebase for maintainability and scalability.
- *Mock Database*: A mock database was used for testing and development.

---

## Design Patterns and SOLID Principles

### Design Patterns
- *Singleton*: Used for classes like EventBooker, QueueManager, and SessionManager to ensure a single instance.
- *Factory*: Used in the notification module to create different types of notifications.
- *Observer*: Used for real-time updates and notifications.
- *Builder*: Used to construct complex objects like notifications with dynamic content.

### SOLID Principles
- *Single Responsibility*: Each class has a single responsibility (e.g., EventBooker handles event bookings, NotificationManager handles notifications).
- *Open/Closed*: The system is open for extension but closed for modification (e.g., adding new notification templates).
- *Liskov Substitution*: Subclasses like NormalUserLogin and AdminUserLogin can replace their parent class UserLogin without breaking the system.
- *Interface Segregation*: Interfaces like IUserLogin are specific to their use cases.
- *Dependency Inversion*: High-level modules depend on abstractions (e.g., IUserProvider), not concrete implementations.

---

## Notification Module

The notification module is a core component of the system, responsible for sending notifications via email or SMS. It includes:

1. *Template Management*: Supports multiple languages and dynamic placeholders.
   - Example: "Dear {x}, your booking of {y} is confirmed."
2. *Queuing System*: Notifications are queued and processed asynchronously.
3. *Sending Mechanism*: Handles sending notifications and retries for failed attempts.
4. *Statistics*: Provides insights into notification success rates, most used templates, and more.

---

## API Endpoints

### Hotel Booking
- **GET /hotels**: Retrieve all hotels.
- **GET /hotels/{hotelID}**: Retrieve a specific hotel by ID.
- **GET /hotels/search**: Search for hotel rooms based on filters (e.g., room type, price range).
- **POST /hotels/book/{hotelID}**: Book a hotel room.
- **DELETE /hotels/cancel/{hotelID}**: Cancel a hotel booking.

### Event Booking
- **GET /events**: Retrieve all events.
- **GET /events/{eventID}**: Retrieve a specific event by ID.
- **GET /events/search**: Search for events based on filters (e.g., date, price range).
- **POST /events/book/{eventID}**: Book an event ticket.
- **DELETE /events/cancel/{eventTicketID}**: Cancel an event booking.

### User Dashboard
- **GET /dashboard/booking/events/all**: Retrieve all event bookings for a user.
- **GET /dashboard/booking/events/upcoming**: Retrieve upcoming event bookings for a user.
- **GET /dashboard/booking/events/old**: Retrieve archived event bookings for a user.
- **GET /dashboard/booking/hotels/all**: Retrieve all hotel bookings for a user.
- **GET /dashboard/booking/hotels/upcoming**: Retrieve upcoming hotel bookings for a user.
- **GET /dashboard/booking/hotels/old**: Retrieve archived hotel bookings for a user.

### Notifications
- **GET /dashboard/notifications/all**: Retrieve all notifications for a user.
- **PUT /dashboard/notifications/{notificationID}**: Mark a notification as read/unread.
- **DELETE /dashboard/notifications/{notificationID}/delete**: Delete a notification.

### Statistics
- **GET /notifications/statistics/total**: Get the total number of notifications.
- **GET /notifications/statistics/successful**: Get the number of successful notifications.
- **GET /notifications/statistics/failed**: Get the number of failed notifications.
- **GET /notifications/statistics/most-used-template**: Get the most used notification template.

---

## Installation and Setup

Clone the repository: https://github.com/Afnan-Sayed/Travel-Agency

Testing
Postman: Used for API testing.


## Contributors
[Abdullah Hamad]
[Adham Abbas] 
[Afnan Sayed]
[Ahmed Zaineldin]
[Yahya Montasser]
