# VirtualKeyRepository
VIRTUAL KEY REPOSITORIES
Description: 
This Software allows Client to handle various File operations such as searching File, accessing File and Inserting File by providing User Interface in Command Line Interface.
Proposed System:
•	Generic features and three operations: 
•	Retrieving the file names in an ascending order
•	Business-level operations:
•	Option to add a user specified file to the application
•	Option to delete a user specified file from the application
•	Option to search a user specified file from the application
•	Navigation option to close the current execution context and return to the main context
•	Option to close the application
 
Existing System:
•	Generic features and three operations: 
•	Retrieving the file names in an ascending order
•	Business-level operations:
•	Option to add a user specified file to the application
•	Option to delete a user specified file from the application
•	Option to search a user specified file from the application
•	Navigation option to close the current execution context and return to the main context
•	Option to close the application
In the existing System, we are currently allowing only .txt Files and the Data for the .txt files can be Inserted and also be retrieved using out specified User Interface.


Requirements:
For running the Application , JRE is necessary.
For development, the Technologies used are:
•	JDK 1.8.
•	Eclipse (IDE).
Technical Specifications:
•	UML Diagram:
 
Class Structure:
POJOs used: Virtual File
Interface used: VirtualFileInterface
Interface Implementation: VirtuaFileService
Driver Class: LockedMe
Sprint:
We planned One Sprint for a week which Included day-wise Tasks.
 Task List:
1. Creation of class structure.
2. Creation of Domain class (pojo class), Interface.
3. Implement that Interface.
4. Create a main driver class & create a command line user Interface.
5. Integrate that Interface.
6. Unit Testing
7. Testing.

Concepts used:
We used List Data Structure to store the Virtual File Objects.
Each Virtual  File Object contains File Name and File Path
And for Sorting, we used Library Function called Collection.sort();
Github Link:



