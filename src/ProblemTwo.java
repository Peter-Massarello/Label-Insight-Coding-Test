import java.util.ArrayList;
import java.util.List;

public class ProblemTwo {

    public static class Particle {

        private char direction;
        private int speed, position;
        private boolean exited;

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

        public void printPosition(int ceiling){
            String outputLine = "";
            System.out.println("Position of Particle " + direction + " is " + position);

            for (int i = 0; i < ceiling; i++) {
                if (position != i)
                    outputLine += '.';
                else
                    outputLine += 'X';
            }

            System.out.println(outputLine);
        }


        public boolean positionCheck(int ceiling) {
            exited = (this.position > ceiling || this.position < 0);
            return exited;
        }

        public int getPosition(){
            return position;
        }

    }

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

    public static String[] animate(int speed, String init) {
        char[] charArray = init.toCharArray();
        List<Particle> pArray = new ArrayList<Particle>();
        String[] finalAnimation = {""};
        boolean notCompleted = true;
        int index;

        for (char c: charArray) {
            if (c == 'R' || c == 'L') {
                index = new String(charArray).indexOf(c);
                pArray.add(new Particle(c, speed, index));
                charArray[index] = 'X';
            }
        }

        System.out.println(printParticles(init.length(), pArray));

        while(notCompleted) {
            for (int i = pArray.size() - 1; i >= 0; i--) {
                //pArray.get(i).printPosition(init.length());
                pArray.get(i).movePosition();
                if (pArray.get(i).positionCheck(init.length())) {
                    pArray.remove(i);
                }
            }
            System.out.println(printParticles(init.length(), pArray));

            if (pArray.isEmpty()){
                notCompleted = false;
            }

        }

        return finalAnimation;
    }


    public static void main(String[] args) {
        animate(3, "RR..LRL");
        System.out.println();
        animate(2, "..R....");
        System.out.println();
        animate(2, "LRLR.LRLR");
        System.out.println();
        animate(10, "RLRLRLRLRL");
        System.out.println();
        animate(1, "...");
        System.out.println();
        animate(1, "LRRL.LR.LRR.R.LRRL.");
        System.out.println();
    }
}
