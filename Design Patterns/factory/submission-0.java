interface Vehicle {
    String getType();
}

class Car implements Vehicle {
    @Override
    public String getType() {
        return "Car";
    }
}

class Bike implements Vehicle {
    @Override
    public String getType() {
        return "Bike";
    }
}

class Truck implements Vehicle {
    @Override
    public String getType() {
        return "Truck";
    }
}

abstract class VehicleFactory {
    abstract Vehicle createVehicle();
}

class CarFactory extends VehicleFactory {
    // Write your code here
    CarFactory(){
        createVehicle();
    }
    public Vehicle createVehicle(){

        return new Car();
        
    }
    
}

class BikeFactory extends VehicleFactory {
    // Write your code here
    BikeFactory(){
         createVehicle();
    }
     public Vehicle createVehicle(){

        return new Bike();
        
    }
   
}

class TruckFactory extends VehicleFactory {
    // Write your code here

    TruckFactory(){
         createVehicle();
    }
     public Vehicle createVehicle(){

        return new Truck();
        
    }
   
}
