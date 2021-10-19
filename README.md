# robert_campbell_p1

## Project Description

The Tuition Reimbursement Management System (TRMS) project was to create a Tuition Reimbursement Management System to manage applications submitted for reimbursement based on the type of the event and whether the employee passed. Types of events that are allowed include Certification, Technical Training, University Courses, Certification Preparation Courses, Seminars, and Other. Each of these had various degrees in how much would be reimbursed, for example, Certifications where 100% reimbursable while the Prep Courses for the Certification where on 75% reimbersable. The project allows for employess to apply for reimbursements and the Supervisor, Department Head, and Benefites Coordinator can approve or deny the application. 

## Technologies used

* Maven 4.0.0
* PostGreSQL 42.2.22
* Log4J 2.14.1
* Junit 4.11
* Servlet Api 4.0.1
* Jackson Databind 2.9.3
* Tomcat 9.0.50

## Features

* Login homepages for both Employees and Supervisors/Benco
 * Supervisor/Benco Homepage
  * View Profile
  * View pending Applications
  * Approve or Reject Pending Applications and give reason why
 * Employee Hompage
  * View Profile
  * View Pending Applications for the Employee
  * Apply for application
* Application for Reimbursements
  * Takes in the Employee's Full Name
  * Event Date
  * Event Location
  * Event Type Radio Selection to ensure Employees only apply for what is allowed
  * Justification Text Area
  * Grade Selection 
* Input Validation to ensure all fields are filled out and within a specific time


