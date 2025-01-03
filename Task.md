Implement the Expert (GRASP) principle to give responsibility to the proper objects.

__1.Create the classes:__.

* a. Create a User class that represents the user of the system.

* b. Create an Address class that contains information about the user's address.

__2.Configure the responsibilities:__.

* a. Give the User class responsibility for storing the user's address using an object of the Address class.

* b. The User class will have methods for working with the address, such as setAddress() and getAddress().

__3.Create a class to demonstrate:__.

* a. Create a Main class that contains the main() method.

* b. In the main() method, create an object of class User and an object of class Address.

* c. Set the address for the user object using the setAddress() method.

* d. Print the user's address to the console using the getAddress() method.

__4.Verify that you have done the following__

* a. Make sure that the user's address belongs to an object of the User class.

* b. Make sure that the User class is responsible for accessing the address and performing the necessary actions with it.

