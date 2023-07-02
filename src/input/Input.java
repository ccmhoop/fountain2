package input;

public class Input {

    public static String checkMenuInput = "mismatch";

    //keeps while loop running in GameMenu if input is wrong
    public static boolean inputMenuMismatchCheck(){
        if (checkMenuInput.equals("mismatch")){
         checkMenuInput ="";
         return true;
     }
     checkMenuInput ="mismatch";
     return false;
    }


}
