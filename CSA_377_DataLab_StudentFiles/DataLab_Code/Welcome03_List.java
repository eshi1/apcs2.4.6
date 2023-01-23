/*
 * Arrays of objects
 */

import core.data.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Welcome03_List {
   public static String lowlat;
   public static void main(String[] args) {
      DataSource ds = DataSource.connect("http://weather.gov/xml/current_obs/index.xml").load();
      ArrayList<WeatherStation> allstns = ds.fetchList("WeatherStation", "station/station_name", 
             "station/station_id", "station/state",
             "station/latitude", "station/longitude");
      System.out.println("Total stations: " + allstns.size());
      
      Scanner sc = new Scanner(System.in);
      System.out.println("Enter a state abbreviation: ");
      String state = sc.next();
      System.out.println("Stations in " + state);
      
      int counter = 0;
      for (WeatherStation ws : allstns) {
         if (ws.isLocatedInState(state)) {
            counter +=1;
         }
      }
      System.out.println(counter);
      
      String[] array;
      double[] arraylat;
      array = new String[counter];
      arraylat = new double[counter];
      int location = 0;
      for (WeatherStation ws : allstns) {
         if (ws.isLocatedInState(state)) {
            String station = ("  " + ws.getId() + ": " + ws.getName());
            double lat = (ws.getLat());
            //System.out.println(station);
            array[location] = station;
            arraylat[location] = lat;
            location +=1;
         }
      }
      //System.out.print(Arrays.toString(array));
      //System.out.print(Arrays.toString(arraylat));
      for (int i=1; i<counter; i++){
         if (arraylat[i]<arraylat[i-1]){
            lowlat = array[i]+", Lat: "+arraylat[i];
         }
      }
      System.out.println(lowlat);
      
   }
}