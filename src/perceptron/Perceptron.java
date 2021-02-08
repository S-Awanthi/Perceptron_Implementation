/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perceptron;

/**
 *
 * @author USER
 */
public class Perceptron {

   public static final int[][][] INPUT_DATA = {  {{0,0},{0}}, 
                                                 {{0,1},{1}}, 
                                                 {{1,0},{1}}, 
                                                 {{1,1},{1}}    };   //Data patterns to be trained
   
   public static final double LEARNING_RATE = 0.6;      //Learning rate
   
   public static final double[] INITIAL_WEIGHTS = {0.5,0.2};    //Initial connection weights
   
   public static final double THRESHOLD_VALUE = 0.6;    //Threashold value   
   
   
   /*--------------------Calcuate the total input Weighted sum -----------------------*/
   public double calWeightedSum(int[] pattern, double[] weights){
   
       double weightedSum = 0;
       
       for (int i = 0; i < pattern.length; i++) {
           weightedSum += pattern[i] * weights[i];
       }
       return weightedSum;
   }
   
   
   /*----------------------- Define actual output -------------------------------------*/
   public int actualResult(double weighted_Sum){     
       
       int result = 0;
       
       if(weighted_Sum > THRESHOLD_VALUE) {
           result = 1;
       }
       return result;
   }
   
   
   /*---------------------- Finding the updated weights / current status ---------------------*/
   public double[] updateWeights(int[] pattern, double[] weights, double outputDiff){
       
       double[] newWeights;     //Declare a new array for new weights
       newWeights = new double[weights.length];     //Create array with the size of existing weights 
       
       for (int i = 0; i < weights.length; i++) {
           
           double weightDiff = LEARNING_RATE * outputDiff * pattern[i];    //Perception learning rule
           newWeights[i] =  weightDiff + weights[i];    //New weight
       }
       
       return newWeights;
   }    
}