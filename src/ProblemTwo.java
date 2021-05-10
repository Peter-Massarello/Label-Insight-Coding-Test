public class ProblemTwo {

    public static class Particle {

        private char direction;
        private int speed, position;

        public Particle(char direction, int speed, int position) {
            this.direction = direction;
            this.speed = speed;
            this.position = position;
        }

        public void movePosition(int newPosition) {
            this.position = newPosition;
        }

        public void printPosition(){
            System.out.println(position);
        }

    }

    public static void animate(int speed, String init) {
        char[] charArray = init.toCharArray();
        Particle[] pArray = new Particle[init.length()];
        int indexCounter = 0;

        for (char c: charArray) {
            if (c == 'R' || c == 'L') {
                System.out.println("Found particle");
                pArray[indexCounter] = new Particle(c, speed, init.indexOf(c));
                indexCounter++;
            }
        }

        for (Particle p: pArray) {
            p.printPosition();
        }
    }


    public static void main(String[] args) {
        animate(2, "..R.L.R.");
    }
}
