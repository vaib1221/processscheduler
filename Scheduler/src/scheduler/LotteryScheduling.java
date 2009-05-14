/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package scheduler;

/**
 *
 * @author tarek
 */
import java.util.Random;

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
        
        this.ticketsTaken=0;

    }

    public void init() {
    }
  
    
    int ticketsTaken;
    
    public int getNewTicket()
    {
        ticketsTaken++;
        return ticketsTaken-1;
    }
    
   public void printTimeLine(int T)
   {
       for(int i=0; i<T; i++)
       {
           System.out.print(i+"\t");
       }
       System.out.println();
   }

    public void start() {
        
         
        
        
        int totalTime=0;
        
        for(int i=0; i<processes.length; i++)
        {
            totalTime+=processes[i].Tr;
        }
        
        
        
        System.out.println("Total Runtime: "+totalTime);
        
        printTimeLine(totalTime);
        
        for (int T = 0; T < totalTime; T++) {  //START RUNNING

            for (int i = 0; i < processes.length; i++) { 
        //loop all process to check who arrived, and assign them a ticket according to their priority
                if(processes[i].Ta==T) //If a process has arrived exactly at the current time, give it tickets
                {
                   
                   for(int j=0; j<processes[i].tickets.length; j++)  //give tickets according to their prioriy
                   {
                       processes[i].tickets[j]=getNewTicket();
                   }
                }
            }
            
            
            Process winner;
            do{
            //And the winning ticket is::
            Random number = new Random();
            int winningticket = number.nextInt(ticketsTaken); //pick a ticket and make sure it's taken
            
            //Now find the ticket owner
            winner=getWinnerProcess(winningticket);
          
            }
            while(!winner.run());
            
            System.out.print(winner.name+"\t");
            
           
            

        }   

        
    }
    
    public Process getWinnerProcess(int winningTicket)
    {
         for(int i=0; i<processes.length; i++)
            {
                for(int j=0; j<processes[i].tickets.length; j++)
                {
                    if(processes[i].tickets[j]==winningTicket)
                        return processes[i];
                }
            }
        
         return null;
    }
}
