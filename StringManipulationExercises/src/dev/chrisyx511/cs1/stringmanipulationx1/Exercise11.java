package dev.chrisyx511.cs1.stringmanipulationx1;


public class Exercise11 {
    public static void main(String[] args) {

        String baseSentence = "I am travelling from Washington to Montreal";
        String updatedSentence = baseSentence.substring(0, 21) + "Toronto" + baseSentence.substring(31, 35) + "Ottawa";


        System.out.println(updatedSentence);
    }



}
