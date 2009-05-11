/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package scheduler;

/**
 *
 * @author tarek
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        Process A=new Process("A", 5, "Tarek");
        Process B=new Process("B", 2, "Tarek");
        Process C=new Process("C", 10, "Tarek");
        
        
       while(A.run())
       {
           System.out.print(A.name);
           
       }
        
               while(B.run())
       {
           System.out.print(B.name);
           
       }
        
               while(C.run())
       {
           System.out.print(C.name);
           
       }
    }

}
