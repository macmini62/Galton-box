import java.util.*;
class run{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of slots in the Galton Box: ");
        int slots = sc.nextInt();
        System.out.println("Enter number of balls to launch: ");
        int balls = sc.nextInt();
        System.out.println("-----------------------------------------");
        System.out.println("-----------------------------------------");

        int [] layers = new int [slots - 1];
        int [] slotsArr = new int [slots];
        int [] ballsArr = new int [balls];

        slotsArray(slots, slotsArr);

        /*for(int i : slotsArr){
            System.out.print(i+" ");
        }
        System.out.println("---");*/

        ballsArray(ballsArr);
        for(int ball: ballsArr){
            updateLayers(layers);

            /*for(int no : layers){
                System.out.print(no+" ");
            } 
            System.out.println("---");*/

            for(int slot : slotsArray(slots, slotsArr)){
                if(slot == fallSlot(layers)){
                    System.out.print(" O ");
                }
                else{
                    System.out.print(" _ ");
                }
            }
            
            System.out.println();

            // System.out.println(fallSlot(layers));
            // System.out.println("------------");
        }
    }

    // Creates an array with the total number of balls launched.
    public static int [] ballsArray(int[] ballsArr){
        for(int i = 1; i < ballsArr.length; i++){
            ballsArr[i] = i;
        }
        return ballsArr;
    }

    // 50% chance either the ball goes to the right or the left when it bounces off the nail.
    private static int returnSide(){
        Random random = new Random();
        int randomSide = 0;
        if (random.nextInt(2) == 0) {
            randomSide = -1;  //ball falls towards the left side
        }else{
            randomSide = 1;   //ball falls towards the right side
        }
        return randomSide;
    }

    // updates the layers array with the possible directions the ball falls towards.
    private static void updateLayers (int[] layers){
        for(int i = 0; i < layers.length; i++){
            layers[i] = returnSide();
        }
    }

    // updates the slotsArr with possible outcome slots of the ball.
    private static int[] slotsArray(int slots, int[] slotsArr){
        int value = 1 - slots;
        for(int i = 0; i < slotsArr.length; i++){
            slotsArr[i] = value;
            value += 2;
        }
        return slotsArr;
    } 
    
    // slot the ball falls into.
    private static int fallSlot(int[] layers){
        int slot = 0;
        for(int i = 0; i < layers.length; i++){
            slot = slot + layers[i];
        }
        return slot;
    }
}