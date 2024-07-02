# Event Management Service


## Description
The Event Management Service project provides a robust backend server to manage events, attendees, venues, and payments through a set of well-defined and interrelated services. These services adhere to Service-Oriented Architecture (SOA) principles to ensure modularity, reusability, and maintainability.


The project encompasses five main services:


Event Service: Manages events by providing operations to create, update, delete, and retrieve event details.
Attendee Service: Handles attendee management, including registration and retrieval of attendee details.
Venue Service: Manages venue availability and bookings for events.
Payment Service: Processes payments related to events and retrieves payment statements.
Utility Service: Provides logging capabilities to support other services.








## Services


### Event Service
Handles operations related to event management.


- **createEvent**: Creates a new event.
- **updateEvent**: Updates an existing event.
- **deleteEvent**: Deletes an event.
- **getEventDetails**: Retrieves details of an event.


### Attendee Service
Handles operations related to attendee management.


- **registerAttendee**: Registers a new attendee for an event.
- **getAttendeeDetails**: Retrieves details of an attendee.


### Venue Service
Handles operations related to venue management.


- **checkAvailableVenues**: Checks available venues for an event.
- **bookVenue**: Books a venue for an event.


### Payment Service
Handles operations related to payment processing.


- **processPayment**: Processes a payment for an event.
- **getPaymentStatement**: Retrieves the payment statement for a user.


### Utility Service
Provides utility operations for other services.


- **addLog**: Adds a log entry for a specified action.


Service Contracts
Event: EventService.wsdl
Attendee: AttendeeService.wsdl
Venue: VenueService.wsdl
Payment: PaymentService.wsdl
Utility: UtilityService.wsdl




Relation between the services
The Payment Service interacts with the Event, Attendee, and Venue services to process payments. The Utility Service provides logging capabilities for the Payment Service.




Entity Services
These services are responsible for managing the entities within the application, such as events, attendees, and venues.


Event Service


createEvent: Creates a new event.
updateEvent: Updates an existing event.
deleteEvent: Deletes an event.
getEventDetails: Retrieves details of an event.




Attendee Service


registerAttendee: Registers a new attendee for an event.
getAttendeeDetails: Retrieves details of an attendee.




Venue Service


checkAvailableVenues: Checks available venues for an event.
bookVenue: Books a venue for an event.


Task Services
These services perform specific tasks that are part of the business processes within the application.


Payment Service
processPayment: Processes a payment for an event.
getPaymentStatement: Retrieves the payment statement for a user.








Utility Services
These services provide support functions that aid other services in performing their tasks.


Utility Service
addLog: Adds a log entry for a specified action.












Relation between the services
The Payment Service interacts with the Event, Attendee, and Venue services to process payments. The Utility Service provides logging capabilities for the Payment Service.






SOA Principles Related to the Services
1. Standardized Service Contract
Each service in the project has a well-defined contract (WSDL file) that specifies the interface for interaction. This ensures that clients know exactly how to interact with the services.


2. Service Reusability
Services are designed to be reusable across different parts of the application. For example, the EventService, AttendeeService, and VenueService can be used independently or together in various workflows.


3. Service Loose Coupling
Each service is loosely coupled with others, meaning changes in one service have minimal impact on others. This is achieved through well-defined interfaces and protocols (SOAP/REST).


4. Service Abstraction
Services abstract their internal logic and only expose what is necessary through their interfaces. Clients interact with the services without needing to understand their internal workings.


5. Service Composability
Services can be composed to build more complex operations. For example, the PaymentService interacts with the EventService, AttendeeService, and VenueService to complete payment processes.


6. Service Autonomy
Each service operates independently, managing its own logic and data. This autonomy allows for easier maintenance and updates.


7. Service Statelessness
Services are designed to be stateless where possible, meaning they do not retain client-specific data between requests. This improves scalability and reliability.


8. Service Discoverability
Services are documented and discoverable through their WSDL files, making it easy for developers to find and use them.




Detailed Service Descriptions


Event Service
The EventService handles all operations related to event management.


createEvent: Accepts event details and stores them in the database.
updateEvent: Accepts event ID and new details, updates the corresponding event in the database.
deleteEvent: Accepts event ID, deletes the corresponding event from the database.
getEventDetails: Accepts event ID, retrieves the corresponding event details from the database.




Attendee Service
The AttendeeService manages operations related to attendees.


registerAttendee: Accepts attendee details and associates them with an event.
getAttendeeDetails: Accepts attendee ID, retrieves the corresponding attendee details from the database.




Venue Service
The VenueService handles venue management operations.


checkAvailableVenues: Accepts event details, checks and returns available venues.
bookVenue: Accepts venue ID and event ID, books the venue for the specified event.




Payment Service
The PaymentService manages payment processing.


processPayment: Accepts payment details and processes the payment for an event.
getPaymentStatement: Accepts user ID, retrieves the payment statement for the user.




Utility Service
The UtilityService provides utility operations that support other services.


addLog: Accepts log details and stores them in the log database.






Interaction Details


The services interact with each other to form a cohesive system. For example:


Event Creation and Payment:


* A new event is created using the EventService.
* Attendees register for the event using the AttendeeService.
* The VenueService checks and books a venue for the event.
* Payments are processed through the PaymentService, which interacts with the EventService, AttendeeService, and VenueService to validate and complete the transaction.
* All actions and transactions are logged using the UtilityService.
* Communication Flow


Creating an Event:


1. Client sends a request to EventService.createEvent.
2. EventService processes the request and stores the event details in the database.
3. EventService responds with a confirmation.




Registering an Attendee:


* Client sends a request to AttendeeService.registerAttendee.
* AttendeeService processes the request and associates the attendee with the event.
* AttendeeService responds with a confirmation.




Booking a Venue:


* Client sends a request to VenueService.checkAvailableVenues.
* VenueService checks for available venues and responds with options.
* Client selects a venue and sends a request to VenueService.bookVenue.
* VenueService processes the request and books the venue for the event.
* VenueService responds with a confirmation.




Processing a Payment:


* Client sends a request to PaymentService.processPayment.
* PaymentService interacts with EventService, AttendeeService, and VenueService to validate the payment.
* PaymentService processes the payment and stores the transaction details.
* PaymentService responds with a confirmation and payment statement.
* UtilityService.addLog is called to log the payment transaction.
