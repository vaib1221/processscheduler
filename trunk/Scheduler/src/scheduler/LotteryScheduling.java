/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scheduler;

/**
 *
 * @author tarek
 */
public class LotteryScheduling {

    User bigShot, fairEnough, notBad, poorThing;
    //Process A, B, C, D, E, F, G;
    
    Process[] processes=new Process[7];

    public LotteryScheduling() {
    
        this.bigShot = new User("BigShot", 4);
        this.fairEnough = new User("FairEnough", 3);
        this.notBad = new User("NotBad", 2);
        this.poorThing = new User("PoorThing", 1);

        for(int i=0; i<processes.length; i++)
       {
           processes[i]=new Process();
        }
        
        /*
         * 
         * 
        
         */
        this.processes[0] = new Process("A", 3, 0, bigShot);
        this.processes[1] = new Process("B", 5, 0, bigShot);
        this.processes[2] = new Process("C", 2, 1, fairEnough);
        this.processes[3] = new Process("D", 1, 3, fairEnough);
        this.processes[4] = new Process("E", 5, 5, notBad);
        this.processes[5] = new Process("F", 4, 6, notBad);
        this.processes[6] = new Process("G", 2, 7, poorThing);

    }

    public void init() {
    }
    static int[]tickets=new int[100];
    static int ticketsTaken=0;
    
    public int getNewTicket()
    {
        ticketsTaken++;
        return tickets[ticketsTaken-1];
        
    }

    public void start() {
        
         
        
        
        int totalTime=0;
        
        for(int i=0; i<processes.length; i++)
        {
            totalTime+=processes[i].Tr;
        }
        
        System.out.println("Total Runtime: "+totalTime);
        
        for (int T = 0; T < totalTime; T++) {  //START RUNNING

            for (int i = 0; i < processes.length; i++) { 
        //loop all process to check who arrived, and assign them a ticket according to their priority
                if(processes[i].Ta==T) //If a process has arrived exactly at the current time, give it tickets
                {
                   for(int j=0; j<processes[i].tickets.length; i++)  //give tickets according to their prioriy
                   {
                       processes[i].tickets[j]=getNewTicket();
                   }
                }
            }

        }
    }
}
