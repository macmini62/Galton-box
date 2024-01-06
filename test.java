import java.util.*;
class test{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of slots: ");
        int slots = sc.nextInt();
        System.out.println("Enter number of balls to launch: ");
        int balls = sc.nextInt();

        int [] layers = new int [slots - 1];
        int [] slotsArr = new int [slots];

        updateLayers(layers);
        int ballSlot = fallSlot(layers);
        slotsArray(slots, slotsArr);

        // for(int i : slotsArr){
        //     System.out.println(i);
        // }

        // System.out.println("-------------------------");

        // for(int no : layers){
        //     System.out.println(no);
        // }   
        System.out.println("--------------------------");
        System.out.println(ballSlot);

    }

    // 50% either the ball goes to the right or the left when it bounces on the nail.
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
        int item = 1 - slots;
        for(int i = 0; i < slotsArr.length; i++){
            slotsArr[i] = item;
            item += 2;
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