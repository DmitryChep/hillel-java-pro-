__1.Implementation of the Singleton class:__
* Create a Logger class that will represent a singleton for recording logging messages.

* Implement a private constructor to prevent the creation of new instances of the class from the outside.

* Add a static getInstance() method that will return a single instance of the Logger class. The first call to this method should create an instance of the class, and all subsequent calls should return the same instance.

__2.Using the Singleton class:__

* Call the getInstance() method of the Logger class from different parts of the program to get a single instance of the logger.

* Use this instance to record logging messages in different parts of the program.

__3.Functionality checks:__

* Verify that all calls to the getInstance() method return the same instance of the Logger class.

* Check that all logging records that are made through one instance of the Logger are saved and displayed correctly.
