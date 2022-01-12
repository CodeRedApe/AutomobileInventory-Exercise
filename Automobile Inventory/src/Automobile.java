import java.util.Scanner ;
import java.util.ArrayList ;
import java.io.BufferedWriter ;
import java.io.IOException ;
import java.io.FileWriter ;
import java.io.FileNotFoundException ;

public class Automobile {
private int vin ;
private int year ;
private String make ;
private String model ;
private int odometer ;
private String color ;
private ArrayList<Automobile> automobilelist ;
public Automobile() {
automobilelist = new ArrayList<>() ;
}

public Automobile
(   int vin, int year, String make, String model, int odometer, String color) {
this.vin = vin ;
this.year = year ;
this.make = make ;
this.model = model ;
this.odometer = odometer ;
this.color = color ;
}

public int getVin() {
return vin ;
}

public int getYear() {
return year ;
}

public String getMake() {
return make ;
}

public String getModel() {
return model ;
}

public int getOdometer() {
return odometer ;
}

public String getColor() {
return color ;
}

public void setVin(int vin) {
this.vin = vin ;
}

public void setYear(int year) {
this.year = year ;
}

public void setMake(String make) {
this.make = make ;
}

public void setModel(String model) {
this.model = model ;
}

public void setOdometer(int odometer) {
this.odometer = odometer ;
}

public void setColor(String color) {
this.color = color ;
}

public void addVehicle(Automobile vehicle) { //adds car
automobilelist.add(vehicle) ;
}

public void removeVehicle //removes cars previously added to inventory
(int vin, int year, String make, String model, int odometer, String color) {
for (int i=0 ; i<automobilelist.size() ; i++ ) {
Automobile vehicle = automobilelist.get( i ) ;
if (vehicle.getVin()==vin  
&& vehicle.getYear()==year 
&& vehicle.getMake().equalsIgnoreCase(make) 
&& vehicle.getModel().equalsIgnoreCase(model)
&& vehicle.getOdometer()==odometer 
&& vehicle.getColor().equalsIgnoreCase(color)) {
automobilelist.remove(vehicle) ;
}
}
}
public void updateVehicle //updates cars previously entered into inventory
(int vinOld, int yearOld, String makeOld, String modelOld, int odometerOld, String colorOld,
int vinNew, int yearNew, String makeNew, String modelNew, int odometerNew, String colorNew) {
for (int i=0 ; i<automobilelist.size() ; i++ ) {
Automobile vehicle = automobilelist.get( i ) ;
if (vehicle.getVin()==vinOld 
&& vehicle.getYear()==yearOld 
&& vehicle.getMake().equalsIgnoreCase(makeOld) 
&& vehicle.getModel().equalsIgnoreCase(modelOld)
&& vehicle.getOdometer()==odometerOld
&& vehicle.getColor().equalsIgnoreCase(colorOld)) 
{  
vehicle.setVin(vinNew) ;
vehicle.setYear(yearNew) ;
vehicle.setMake(makeNew) ;
vehicle.setModel(modelNew) ;
vehicle.setOdometer(odometerNew) ;
vehicle.setColor(colorNew) ;
}
}
}
public void Display() {
BufferedWriter bw = null ;
try {
// creates a file writer which writes a text file
FileWriter fw = new FileWriter("automobile_output.txt") ;
// creates a buffered file writer which writes a text file
bw = new BufferedWriter ( fw ) ;
System.out.println ("\nVehicles Information:\n") ;
for (int i=0  ; i<automobilelist.size() ; i++ ) {
Automobile vehicle = automobilelist.get( i ) ;
System.out.println ("Vehicle "+( i+1 )+":") ;
bw.write("Vehicle "+( i+1 )+":") ;
bw.newLine() ;

System.out.println ("Vin: " + vehicle.getVin()) ;
bw.write("Vin: " + vehicle.getVin()) ;
bw.newLine() ;

System.out.println ("Year: " + vehicle.getYear()) ;
bw.write("Year: " + vehicle.getYear()) ;
bw.newLine() ;

System.out.println ("Make: " + vehicle.getMake()) ;
bw.write("Make: " + vehicle.getMake()) ;
bw.newLine() ;

System.out.println ("Model: " + vehicle.getModel()) ;
bw.write("Model: " + vehicle.getModel()) ;
bw.newLine() ;

System.out.println ("Odometer: " + vehicle.getOdometer()) ;
bw.write("Odometer: " + vehicle.getOdometer()) ;
bw.newLine() ;

System.out.println ("Color: " + vehicle.getColor()) ;
bw.write("Color: " + vehicle.getColor()) ;
bw.newLine() ;

System.out.println ("") ;
}
bw.flush() ;// removes the file writer
} catch (FileNotFoundException e) {
} catch (IOException ioe) {
} catch (Exception e) {
} finally {
try {
if (bw != null) {
bw.close() ;
}
} catch (IOException e) {
}
}
}
public static void main(String[] args) {
Automobile automobile = new Automobile() ;
try (Scanner userInput = new Scanner(System.in)) {
while(true) {
    System.out.println ("\nChoose an option below:") ;
    System.out.println ("Input 1 to add a car to inventory") ;
    System.out.println ("Input 2 to update a car in the inventory") ;
    System.out.println ("Input 3 to remove a car from inventory") ;
    System.out.println ("Input 4 to display cars in inventory") ;
    System.out.println ("Input 5 to close inventory program") ;
    System.out.print ("Selected Option: ") ;
int option = userInput.nextInt() ;
userInput.nextLine() ;
if (option == 1) {
    System.out.println ("\nInput vehicle to inventory:") ;
               
    System.out.print ("Input the the last 4 digits of the vehicle's 17 digit VIN: ") ;
        int vin = userInput.nextInt() ;
        userInput.nextLine() ;
                
    System.out.print ("Input the year the vehicle was manufactured: ") ;
        int year = userInput.nextInt() ;
    userInput.nextLine() ;
                
    System.out.print ("Input the vehicle manufacturer: ") ;
        String make = userInput.nextLine() ;
                
    System.out.print ("Input the vehicle model: ") ;
        String model = userInput.nextLine() ;
                
    System.out.print ("Input the vehicle's odometer reading: ") ;
        int odometer = userInput.nextInt() ;
        userInput.nextLine() ;
                
    System.out.print ("Input the color of the vehicle: ") ;
        String color = userInput.nextLine() ;
        userInput.nextLine() ;
                
Automobile vehicle = new Automobile(vin, year, make, model, odometer, color) ;
automobile.addVehicle(vehicle) ;
} else if (option == 2) {
    System.out.println ("\nInput old vehicle information to update:") ;
                
    System.out.print ("Input the last 4 digits of the vehicle's 17 digit VIN: ") ;
        int vinOld = userInput.nextInt() ;
        userInput.nextLine() ;
                
    System.out.print ("Input the year the vehicle was manufactured: ") ;
        int yearOld = userInput.nextInt() ;
        userInput.nextLine() ;
                
    System.out.print ("Input the vehicle manufacturer: ") ;
        String MakeOld = userInput.nextLine() ;
                
    System.out.print ("Input the vehicle model: ") ;
        String modelOld = userInput.nextLine() ;
                
    System.out.print ("Input the vehicle's odometer reading: ") ;
        int odometerOld = userInput.nextInt() ;
        userInput.nextLine() ;
                
    System.out.print ("Input the color of the vehicle: ") ;
        String colorOld = userInput.nextLine() ;
                
    System.out.println ("\nInput New Vehicle Information to Update:") ;
                
    System.out.print ("Input the last 4 digits of the vehicle's 17 digit VIN: ") ;
        int vinNew = userInput.nextInt() ;
        userInput.nextLine() ;
                
    System.out.print ("Input the year the vehicle was manufactured: ") ;
        int yearNew = userInput.nextInt() ;
        userInput.nextLine() ;
                
    System.out.print ("Input the vehicle manufacturer: ") ;
        String makeNew = userInput.nextLine() ;
                
    System.out.print ("Input the vehicle model: ") ;
        String modelNew = userInput.nextLine() ;
                
    System.out.print ("Input the vehicle's odometer reading: ") ;
        int odometerNew = userInput.nextInt() ;
        userInput.nextLine() ;
                
    System.out.print ("Input the color of the vehicle: ") ;
        String colorNew = userInput.nextLine() ;
automobile.updateVehicle
(vinOld, yearOld, MakeOld, modelOld, odometerOld, colorOld,
vinNew, yearNew, makeNew, modelNew, odometerNew,colorNew) ;
            } else if (option == 3) {
    System.out.println ("\nInput the vehicle information in order to remove from inventory:") ;
               
    System.out.print ("Input the last 4 digits of the vehicle's 17 digit VIN: ") ;
        int vin = userInput.nextInt() ;
        userInput.nextLine() ;
                
    System.out.print ("Input the year the vehicle was manufactured: ") ;
        int year = userInput.nextInt() ;
        userInput.nextLine() ;
                
    System.out.print ("Input the vehicle manufacturer: ") ;
        String make = userInput.nextLine() ;
                
    System.out.print ("Input the vehicle model: ") ;
        String model = userInput.nextLine() ;
                
    System.out.print ("Input the vehicle's odometer reading: ") ;
        int odometer = userInput.nextInt() ;
        userInput.nextLine() ;
                
    System.out.print ("Input the color of the vehicle: ") ;
        String color = userInput.nextLine() ;
                
automobile.removeVehicle(vin, year, make, model, odometer, color) ;
    } else if (option == 4)
{
        automobile.Display() ;
    } else {
System.out.println ("Close") ;
break ;
}
}   }
}
}