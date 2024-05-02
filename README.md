# **RESTAURANT RESERVATION SYSTEM**

This is a Spring boot Project , that handles the backend for Restaurent Reservation System .

It provides support for both Client side and Employee Management for the Restaurent .


# TO RUN PROJECT ON YOUR LOCAL SETUP :

First Fork and clone this repo . 

* Preffered IDE : IntelliJ , 

* Make all sure dependencies in POM.xml are in sync

* Make sure you Set up MySQL on your Local.

* Having Postman is also preffered for Testing Purposes

# Testing Your Set-Up 

  * Try creating a customer
    
          POST Request :

          localhost:8080/customers

          Pass Request Body :

          {
              "name" : "Deepak",
              "contactNumber" : "1234567890",
              "e-Mail" : "Deepak@Gmail.com"
          }

  * Try Getting All customers

          GET REQUEST :

          localhost:8080/customers

  * Try Getting customer with ID
   
          GET REQUEST :

          localhost:8080/customers/1

  * Update the Customer

          PATCH REQUEST :

          localhost:8080/customers/1

           Pass Request Body :

          {
              "name" : "Deepak",
              "contactNumber" : "1234567890",
              "e-Mail" : "Deepak@Yahoo.com"
          }

  * Delete a customer

          DELETE REQUEST :

          localhost:8080/customers/1


* **TESTING EMPLOYEE CREATION**

  * First Create all Role (CHEF,WAITER,MANAGER) like this:

          POST REQUEST :

          localhost:8080/role

          PASS BODY :

          {
             "roleType" : "CHEF",
             "salary"   : "700000"
          }


  * Now Create All departments You need :
 
        Post Request :

        localhost:8080/dapartment

        Pass Body :

        {
           "name" : "Managing"
        }

  * Now try Creating an Employee :
 
        Post Request :

        localhost:8080/employees

        Pass Body :

        {
           "name" : "Vishesh",
           "email" : "vishesh@gmail.com",
           "role"  : "MANAGER",
           "department" : "Managing"
        }


  * Now Try Accesing All Employees :
 
        GET REQUEST :

        localhost:8080/employees

  * Now Try Accesing employee with id :
 
        GET REQUEST :

        localhost:8080/employees/1

  * Try updating the Employee :
 
        PATCH REQUEST :

        localhost:8080/employees/1

        Pass the Body :

        {
           "name" : "Deepak",
           "email" : "deepak@gmail.com",
           "role"  : "MANAGER",
           "department" : "Managing"
        }


# MAKING A RESERVATION :

  * First create a few tables that are there in restaurent like this :

         POST REQUEST :

         localshost:8080/table

         Pass the body :

         {
           "capacity" : 5,
           "location" : "WINDOWSIDED"
         }

   * PS: location possible are : WINDOWSIDED, PRIVATECABIN , GENERAL

  * Now lets Create a Reservation :

         POST REQUEST :

         localhost:8080/reservations/

         Pass the Body :

         {
           "name" : "Deepak",
           "email" : deepak@gmail.com,
           "phoneNumber" : "1234567890",
           "guests" : "5",
           "date" : "2024-05-02",
           "startTime" : "10:00",
           "endTime" : "11:00"
         }

  * Updating a Reservation :

        Post Request :

        localhost:8080/reservations/1


        {
           "name" : "Vishesh",
           "email" : deepak@gmail.com,
           "phoneNumber" : "1234567890",
           "guests" : "5",
           "date" : "2024-05-02",
           "startTime" : "10:00",
           "endTime" : "12:00"
        }


   * Get all Reservations :

          GET REQUEST :

          localhost:8080/reservations


    * Get Reservation by Id :
 
           GET REQUEST :
 
           localhost:8080/reservations/1
