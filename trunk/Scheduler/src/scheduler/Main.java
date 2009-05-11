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
       
       Process[] processes=new Process[5];
       
       for(int i=0; i<processes.length; i++)
       {
           processes[i]=new Process("P"+i,3, i, "tarek");
       }
       
       
       
       startShortestTimeRemaining(processes);
     
        
    }
    
    public static Process getShortestTimeRemaining(Process p)
    {
        
        
    return p;    
    }
    
    public static void startShortestTimeRemaining(Process[] p)
    {
        
        int totalTime=0;
        
        for(int i=0; i<p.length; i++)
        {
            totalTime+=p[i].Tr;
        }
        
        System.out.println(totalTime);
        
    }

}
