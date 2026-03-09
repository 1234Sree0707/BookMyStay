# BookMyStay
BookMyStay is a hotel booking application built as a teaching project for Core Java and data structures.
It models a real-world hotel reservation system where guests can search, reserve, and enhance bookings with add-on services.
The system ensures data consistency, fairness, and atomic inventory updates to prevent double-booking.
Use Cases
UC1:
- Room Inventory Setup & Management
- Data Structures: HashMap for room counts and prices
- Goal: Maintain a single source of truth for inventory
UC2:
- Room Search & Availability Check
- Data Structures: HashMap lookups
- Goal: Allow guests to search rooms without altering inventory
UC3:
- Booking Request (First-Come-First-Served)
- Data Structures: Queue (LinkedList)
- Goal: Ensure fairness during peak demand
UC4:
- Reservation Confirmation & Room Allocation
- Data Structures: Set for booked room IDs, HashMap for room type → assigned rooms
- Goal: Guarantee zero double-booking
UC5:
- Add-On Service Selection
- Data Structures: Map for reservation ID → list of services
- Goal: Enhance bookings with optional services like breakfast, spa, pickup
UC6:
- Booking History & Reporting
- Data Structures: List of reservations
- Goal: Maintain complete booking history for reporting and customer support
