In this task, you need to implement the Factory Method design pattern to create different types of objects.

__1.Create an interface and its implementations:__.

* Create a Transport interface that contains methods for movement (for example, move()).

* Create two implementations of this interface: Car and Plane.

__2.Create an abstract Factory class:__.

* Create an abstract TransportFactory class that has an abstract createTransport() method that returns an object of type Transport.

__3.Implement specific factories:__.

* Create two concrete factories: CarFactory and PlaneFactory, which inherit from TransportFactory.

* Implement the createTransport() method in each factory so that it creates a Car object for CarFactory and a Plane object for PlaneFactory.

__4.Create a class for demonstration:__.

* Create a Client class that has a run() method.

* In the run() method, create instances of the factories (CarFactory and PlaneFactory) and call their createTransport() method to create vehicles.

* Call the movement methods for each vehicle you create.

__5.Verify the correctness of the work:__.

* Make sure that Car objects are created by CarFactory and Plane objects are created by PlaneFactory.

* Make sure that each vehicle is performing its own movement method.
