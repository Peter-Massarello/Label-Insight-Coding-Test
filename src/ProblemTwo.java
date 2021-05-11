import java.util.ArrayList;
import java.util.List;

public class ProblemTwo {

    // Particle Class used to hold data for each particle
    public static class Particle {

        private char direction; // Direction particle is moving, either 'L' or 'R'
        private int speed, position; // Speed and initial position variables given in the object construction
        private boolean exited; // If the Particle has exceeded the bounds of the array aka 'exited'

        // Constructor which gives the particle its direction, speed, and position
        public Particle(char direction, int speed, int position) {
            this.direction = direction;
            this.speed = speed;
            this.position = position;
        }

        // Moves the particle according to its speed
        public void movePosition() {
            if (this.direction == 'L')
                this.position -= speed;
            else if (this.direction == 'R')
                this.position += speed;
        }

        // Checks to see if particle has moved outside of the bounds of the array, if so return true
        public boolean positionCheck(int ceiling) {
            exited = (this.position > ceiling || this.position < 0);
            return exited;
        }

        // Gets position variable for checking purposes
        public int getPosition(){
            return position;
        }

    }

    /*  Printing Method
        - Method takes in List of particles and the ceiling of the original String.
        - Iterates through going from 0 to the ceiling and for each Particle
          the program will check to see if the current position of 'i' matches
          the position of any particle, if so append 'X' to outputLine, break out of loop
          and switch 'particleFound' to true.
        - If a particle has not been found at that position the outputLine then appends '.' and continues on.
        - Returns outputLine as a String.
     */
    public static String printParticles(int ceiling, List<Particle> pArray) {
        StringBuilder outputLine = new StringBuilder();
        boolean particleFound = false;

        for (int i = 0; i < ceiling; i++) {
            for (Particle p: pArray) {
                if (p.getPosition() == i){
                    outputLine.append('X');
                    particleFound = true;
                    break;
                }
            }
            if (!particleFound)
                outputLine.append('.');

            particleFound = false;
        }

       return outputLine.toString();
    }

    /* Animate Function
        - Creates two lists, one to hold all particles and one to hold all animation Strings.
        - Creates a char array of the init String to better loop through.
        - Creates an index variable to give to the objects of the Particle Class.
        - Iterates through each char in charArray and if a 'L' or 'R' is found save its index
          and create a new elements of the Particle list at that index.
        - Then move into a while loop that goes until broken out of
           - In while loop, iterate from size of pArray down to 0
           - Move the position of each Particle and check to see if the position is out of bounds
             if so, remove Particle from List.
           - If pArray is now empty then break out of while loop otherwise, add new entry to animation
             List and continue through while loop.
     */
    public static List<String> animate(int speed, String init) {
        List<Particle> pArray = new ArrayList<Particle>();
        List<String> finalAnimation = new ArrayList<String>();
        char[] charArray = init.toCharArray();
        int index;

        for (char c: charArray) {
            if (c == 'R' || c == 'L') {
                index = new String(charArray).indexOf(c); // Converts character place into an index
                pArray.add(new Particle(c, speed, index));
                charArray[index] = 'X'; // Sets found 'L' or 'R' index to X so that program wont get stuck on same char
            }
        }

        finalAnimation.add(printParticles(init.length(), pArray));
        //System.out.println(printParticles(init.length(), pArray));
        // ^ Above line used for debugging purposes

        while(true) {
            for (int i = pArray.size() - 1; i >= 0; i--) {
                pArray.get(i).movePosition();
                if (pArray.get(i).positionCheck(init.length())) {
                    pArray.remove(i);
                }
            }

            if (pArray.isEmpty()){
                break;
            }

            finalAnimation.add(printParticles(init.length(), pArray));
            //System.out.println(printParticles(init.length(), pArray));
            // ^ Above line used for debugging purposes
        }

        return finalAnimation;
    }

    // Main function
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        System.out.println(animate(3, "RR..LRL"));
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("Duration to complete - " + duration);

        startTime = System.nanoTime();
        System.out.println(animate(2, "..R...."));
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        System.out.println("Duration to complete - " + duration);

        startTime = System.nanoTime();
        System.out.println(animate(2, "LRLR.LRLR"));
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        System.out.println("Duration to complete - " + duration);

        startTime = System.nanoTime();
        System.out.println(animate(10, "RLRLRLRLRL"));
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        System.out.println("Duration to complete - " + duration);

        startTime = System.nanoTime();
        System.out.println(animate(1, "..."));
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        System.out.println("Duration to complete - " + duration);

        startTime = System.nanoTime();
        System.out.println(animate(1, "LRRL.LR.LRR.R.LRRL."));
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        System.out.println("Duration to complete - " + duration);

        startTime = System.nanoTime();
        System.out.println(animate(1, "LRRL.LR.LRR.R.LRRL.LRRL.LR.LRR.R.LRRL.LRRL.LR.LRR.R.LRRL."));
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        System.out.println("Duration to complete - " + duration);

    }
}
