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
public class Main {
    
    public static void main(String[] args) {
        
        int[][][] inputs = Perceptron.INPUT_DATA;        //Training data
        double[] weights = Perceptron.INITIAL_WEIGHTS;
        double threshold = Perceptron.THRESHOLD_VALUE;
        
        Main obj = new Main();  
        Perceptron perceptron = new Perceptron();   //Instantiation of Perceptron class
        
        int round = 0;
        boolean errorOutput = true;        
        double difference;   //Desired output - actual output
        double[] updatedWeights = null;
        
        while(errorOutput){
            
            obj.printHead(round++);
            
            errorOutput = false;
            difference = 0;
            
            for (int i = 0; i < inputs.length; i++) {
                
                double weightedSum = perceptron.calWeightedSum(inputs[i][0], weights);  //Calc weighted sum
                int result = perceptron.actualResult(weightedSum);      //Display actual result -Y
                
                difference = inputs[i][1][0] - result;      //D-Y
                
                if(difference != 0)     //If D != Y
                    
                    errorOutput = true;     //There is a difference between two outputs
                
                    updatedWeights = perceptron.updateWeights(inputs[i][0], weights, difference);
                    
                    obj.printDetails(inputs[i], weights, result, difference, weightedSum, updatedWeights, threshold);
                    weights = updatedWeights;       //Assign new values to w
                
            }
        }  
    }
    
    
    /*---------------Printing the heading of the output --------------------------------------*/
    public void printHead(int roundNo){
        System.out.println("\n");
        System.out.println("   w1  |   w2   |  x1  |  x2  | Desired Out(D) | Threshold |  W_Sum | Actual Out(Y) | Error(D-Y) | new_w1 | new_w2 ");
        System.out.println("-------------------------------------------------------------------------------------------------------------------");
        
    }
    
    public void printDetails(int[][] data, double[] weights, int result, double differ, double weightedSum, double[] currentWeights, double threshold){
    
        System.out.println(" " + String.format("%.2f", weights[0]) + "  |  "            // w1
                               + String.format("%.2f", weights[1]) + "  |  "            // w2
                               + data[0][0] + "   |  "                                  // x1
                               + data[0][1] + "   |        "                            // x2
                               + data[1][0] + "       |    "                            // D
                               + threshold + "    |  "                                  // Threshold
                               + String.format("%.2f", weightedSum) + "  |       "      // Weighted Sum
                               + result + "       |     "                               // Y
                               + differ + "    |  "                                     // D - Y
                               + String.format("%.2f", currentWeights[0]) + "  |  "     // Current w1
                               + String.format("%.2f", currentWeights[1]));             // Current w2
        
    }
    
}

