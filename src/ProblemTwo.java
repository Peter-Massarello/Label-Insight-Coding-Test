import java.util.ArrayList;
import java.util.List;

public class ProblemTwo {

    public static class Particle {

        private char direction;
        private int speed, position;

        public Particle(char direction, int speed, int position) {
            this.direction = direction;
            this.speed = speed;
            this.position = position;
        }

        public void movePosition() {
            if (this.direction == 'L')
                this.position -= speed;
            else if (this.direction == 'R')
                this.position += speed;
        }

        public void printPosition(){
            System.out.println(position);
        }

    }

    public static String[] animate(int speed, String init) {
        char[] charArray = init.toCharArray();
        List<Particle> pArray = new ArrayList<Particle>();
        String[] finalAnimation = {""};

        for (char c: charArray) {
            if (c == 'R' || c == 'L') {
                System.out.println("Found particle");
                pArray.add(new Particle(c, speed, init.indexOf(c)));
            }
        }

        for (int i = 0; i < 4; i++) {
            for (Particle p: pArray) {
                p.printPosition();
                p.movePosition();
            }
        }
        for (Particle p: pArray) {
            p.printPosition();
        }

        return finalAnimation;
    }


    public static void main(String[] args) {
        animate(2, "..R....");
    }
}
