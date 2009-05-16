/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package scheduler;

/**
 *
 * @author tarek
 */
public class FairShare {
    
    User bigShot, fairEnough, notBad, poorThing;
    
    
    Process[] processes=new Process[8];

    public FairShare() {  

    initUsers();
    initProcesses();  

    }
    
    public void initUsers()
    {
        
        this.bigShot = new User("BigShot", 50);
        this.fairEnough = new User("FairEnough", 25);
        this.notBad = new User("NotBad", 20);
        this.poorThing = new User("PoorThing", 5);
        
    }
    
    public void initProcesses()
    {
        
         for(int i=0; i<processes.length; i++)
       {
           processes[i]=new Process();
        }

        this.processes[0] = new Process("A", 2, 0, bigShot);
        this.processes[1] = new Process("B", 2, 0, bigShot);
        this.processes[2] = new Process("C", 2, 0, fairEnough);
        this.processes[3] = new Process("D", 2, 0, fairEnough);
        this.processes[4] = new Process("E", 2, 0, fairEnough);
        this.processes[5] = new Process("F", 2, 0, notBad);
        this.processes[6] = new Process("G", 2, 0, notBad);
        this.processes[7] = new Process("H", 2, 0, poorThing);
        
        
        
    }
    
    public void start()
    {
       
    }

}
