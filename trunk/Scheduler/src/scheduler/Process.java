/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package scheduler;

/**
 *
 * @author tarek
 */
public class Process {
    
    String name;
    int Ta;
    int Tr;
    String username;
    int quantum;
    int initQuantum;
    
    public Process(String name, int Tr, int Ta, String username)
    {
        this.name=name;
        this.Ta=Ta;
        this.Tr=Tr;
        this.username=username;  
    }
    
     public Process(String name, int Tr, int Ta, String username, int quantum)
    {
        this.name=name;
        this.Ta=Ta;
        this.Tr=Tr;
        this.username=username;  
        this.quantum=quantum;
        this.initQuantum=quantum;
    }
     
     public void setQuantum(int quanta)
     {
        quantum=quanta;
        initQuantum=quanta;
         
         
     }
     
    
    public boolean run()
    {
        Tr--;
        
        if(Tr>-1)
            return true;
        return false;
        
    }

}
