
# Phone Contacts Application
The Phone Contacts Application allows users to manage their contact information, including contact names, emails, and phone numbers. Users can register, log in, and perform various operations on their contacts, such as adding, editing, and deleting. The application provides a RESTful web service interface and ensures data security and access control using Spring Security.

# Features
User Registration: Users can create an account by providing their login and password credentials.  
User Login: Registered users can log in to the application using their credentials.  
Add New Contact: Users can add a new contact with a unique contact name, along with one or more email addresses and phone numbers.  
Edit Contact: Users can edit the details of an existing contact, including contact name, email addresses, and phone numbers.  
Delete Contact: Users can delete a contact from their contact list.  
Get Contact List: Users can retrieve a list of all their existing contacts.  
# Technology Stack
The Phone Contacts Application is built using the following technologies:  

Java  
Spring Boot  
Spring Web  
Spring Security  
Spring Data JPA (with Hibernate)  
PostgreSQL (Relational Database)  
Lombok (for code simplification)  
# Getting Started
To run the Phone Contacts Application on your local machine, follow these steps:  

Clone the application repository from GitHub.  
Configure the application's database connection settings in the application.properties file, including the PostgreSQL database URL, username, and password.  
Build the application using your preferred build tool (e.g., Maven or Gradle).  
Run the application using the generated executable or by executing the main class.  
Access the application's RESTful API endpoints using a client of your choice (e.g., Postman, cURL).  
# API Endpoints
The following API endpoints are available in the Phone Contacts Application:  

POST /registration: Create a new user account by providing login and password credentials.  
POST /auth: Log in to the application using the provided login and password.  
POST /api/v1/contacts: Add a new contact with the specified contact details.  
PUT /api/v1/contacts/{id}: Update an existing contact with the specified contact details.  
DELETE /api/v1/contacts/{id}: Delete the contact with the given ID.  
GET /api/v1/contacts: Retrieve a list of all existing contacts of authenticated user.  
GET /api/v1/contacts/all: Retrieve a list of all existing contacts.  
# Security
The Phone Contacts Application ensures data security and user authentication using Spring Security. Only authorized users can access the application's API endpoints. Passwords are securely stored using encryption algorithms to protect user data.

# Database Schema
The database schema for the Phone Contacts Application is designed to support the 1st and 2nd normal forms. The schema includes tables for storing user information, contact details, email addresses, and phone numbers. PostgreSQL is used as the relational database.
