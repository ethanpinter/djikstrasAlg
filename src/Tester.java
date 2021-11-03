/*
* @author ethan pinter - ethanpinter@psu.edu (ebp5232)
* Demostrates the link state networking algorithm using cities
* The diagram for these cities can be found in the readme file in git
 */

import java.util.*;

public class Tester {
    public static void main(String[] args) {
        
        Scanner scnr = new Scanner(System.in);
        System.out.print("Enter a start city: ");
        String start = scnr.nextLine();
        System.out.print("Enter a destintation city: ");
        String destination = scnr.nextLine();
        System.out.println();
        scnr.close();


        ShortestRouteFinder rb = new ShortestRouteFinder() // adds all routes' distances
                .route("pendleton", "pierre", 2)
                .route("pendleton", "pueblo", 8)
                .route("pendleton", "phoenix", 4)
                .route("phoenix", "pueblo", 3)
                .route("phoenix", "peoria", 4)
                .route("phoenix", "pensacola", 5)
                .route("phoenix", "pittsburgh", 10)
                .route("pueblo", "pierre", 3)
                .route("pueblo", "peoria", 3)
                .route("pittsburgh", "peoria", 5)
                .route("pittsburgh", "pensacola", 4)
                .route("pittsburgh", "princeton", 2)
                .route("pensacola", "princeton", 5);

        Map<String, Integer> shortestRoutesFrom =
                rb.computeShortestRoutesFrom(start);

        System.out.println("shortest distance from " + start + " to " + destination + ": " +
                shortestRoutesFrom.get(destination));
    }
}