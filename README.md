# Online-Exam-System
E-Exam is a System for students to get their exams online that has 3 main users:
* The admin is responsible for adding and editing subjects and professors and make an approval for the professors.
* Professors prepare for their subjects' exams with adding and editing questions and identifying the correct answer and the level of difficulty for each question.
* Students take the exam with different random questions and the results are stored to be shown for the student and professor.

## Types of Users

1. Admin: is basically a professor with Administrating Authentications.
2. Professor: is responsible for The Structure of the Exam and its content.
3. Student: takes the Exam and then directly notified with his own result.

## Technologies and Techniques: 

Technologies and Techniques overview: Java, JFrame, PhpMyAdmin, SQL, design patterns, object-oriented programming.

Patterns used: 
* Simple Factory Pattern: In Factory pattern, we create object without exposing the creation logic to the client and refer to newly created object using a common interface.
This pattern delegates the responsibility of initializing a class from the client to a particular factory class by creating a type of virtual constructor.
To achieve this, we rely on a factory which provides us with the objects, hiding the actual implementation details. The created 
* Facade pattern: To hides the complexities of the system and provides an interface to the client using which the client can access the system. This type of design pattern comes under structural pattern as this pattern adds an interface to existing system to hide its complexities.
This pattern involves a single class which provides simplified methods required by client and delegates calls to methods of existing system classes.
* Singleton pattern: simplest design patterns in Java. This type of design pattern comes under creational pattern as this pattern provides one of the best ways to create an object.
This pattern involves a single class which is responsible to create an object while making sure that only single object gets created. 
This class provides a way to access its only object which can be accessed directly without need to instantiate the object of the class.

Database: used PhpMyAdmin intgrated with sql

<img src="https://user-images.githubusercontent.com/72973609/127523139-e50fbcd0-01d4-4186-ad3e-e8f9565b8285.jpg" alt="database" width="600" height="200">

## Class Digram

<img src="https://user-images.githubusercontent.com/72973609/127523735-d4ebacfb-9508-4337-b817-c4b58be68571.png" alt="class digram" width="900" height="500">
