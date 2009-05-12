/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package scheduler;

/**
 *
 * @author tarek
 */



public class Main{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
       Process[] processes=new Process[5];
       
       for(int i=0; i<processes.length; i++)
       {
           processes[i]=new Process("P"+(i+1),3, i, "tarek");
       }
       
        processes[0].name="A";  processes[0].Ta=0;  processes[0].Tr=3;
        processes[1].name="B";  processes[1].Ta=1;  processes[1].Tr=5;
        processes[2].name="C";  processes[2].Ta=3;  processes[2].Tr=2;
        processes[3].name="D";  processes[3].Ta=7;  processes[3].Tr=2;
        processes[4].name="E";  processes[4].Ta=10; processes[4].Tr=5;
       
       
      // startShortestTimeRemaining(processes);
        
        startMultilevelFeedback(processes);
       
       
     //System.out.println(getShortestTimeRemainingProcess(processes, 4, processes[0]).name);
        
    }
    
    public static Process getShortestTimeRemainingProcess(Process []p, int T, Process currentP) //returns the process allowed to run
    {
        
        //4 2 6 7
        
        Process shortest;
      /* for(int i=0;i<p.length; i++)
       {
            
           if(p[i].Ta<=T)   //process is available, check   shortest length
           {*/
              shortest=currentP;
              
               for(int j=0; j<p.length; j++) //get minumum
               {
                   if(shortest.Tr<0 && p[j].Ta<=T && p[j].Tr>-1)
                       shortest=p[j];
                      
                           
                   
                   if(p[j].Tr<shortest.Tr && p[j].Ta<=T && p[j].Tr>-1)
                       shortest=p[j];
                   
               }
               
           //}
       //}
       
       
       return shortest;
    }
    
    public static void startShortestTimeRemaining(Process[] p)
    {
        
        // System.out.println(getShortestTimeRemainingProcess(p, 3, p[0]).name);
        
        
        int totalTime=0;
        
        for(int i=0; i<p.length; i++)   //Get total time
        {
            totalTime+=p[i].Tr;
        }
        
        for(int i=0; i<totalTime; i++) //print timeline
        {
           System.out.print(i+"\t"); 
        }
        System.out.println("\n");
        
        Process current=p[0];
        
        for(int i=0; i<totalTime; i++)   //populate timeLine
        {
           current=getShortestTimeRemainingProcess(p, i, current);
          
           boolean run;
           
           if(!(run=current.run()))  //If process has finished, rollback time, next time it'll be skipped
               i--;
           else
           System.out.print(current.name+"\t");
          
            
        }
       
        
    }
   
        static Queue <Process> running = new Queue<Process>();
       static Queue <Process> q0 = new Queue<Process>();
       static Queue <Process> q1 = new Queue<Process>();
       static Queue <Process> q2 = new Queue<Process>();
       static Queue <Process> q3 = new Queue<Process>();
    
    public static void startMultilevelFeedback(Process[] p)
    {
        

        int totalTime=0;
        
        for(int i=0; i<p.length; i++)   //Get total time
        {
            totalTime+=p[i].Tr;
        }
        
                for(int i=0; i<totalTime; i++) //print timeline
        {
           System.out.print(i+"\t"); 
        }
            System.out.println("\n");
  /////////////////////////////////////////////////////////////////////
            ///////////////////////////////////////////////////
            ////////////////////////////////////////////////////////
            
        int count=totalTime;
        for(int i=0; i<totalTime; i++) ///////populate time line
        {
            
            
            for(int j=0; j<p.length; j++)  //check if any process has arrived at this instance
            {
                if(i==p[j].Ta){
                    q0.enqueue(p[j]);
                    //System.out.println("at t="+i+" "+p[j].name+" has been enqueued");
                    p[j].setQuantum(1);
                }
            }
            
            
                                            //start the actual work
            Process toRun;
            if((toRun=running.dequeue())==null)
                toRun=getQueuedProcess();
            
           //if(toRun.name.equals("E"))
                //System.out.println("E===> "+toRun.quantum+" and B===>"+p[1].quantum);
            
            
            
            if(toRun.quantum>0)
            {
               
              if(toRun.run())
              {
                  System.out.print(toRun.name+"\t");
                 
                  
                  // count--;
 
                 toRun.quantum--;  
              }
              else{
                  toRun.quantum=0;
                  i--;
                 // break;
              }
              
              
            }
            
            
            
            if(toRun.quantum==0)
            {
            switch(toRun.initQuantum)
            {
                case 1: q1.enqueue(toRun); toRun.setQuantum(2); break; 
                case 2: q2.enqueue(toRun); toRun.setQuantum(4); /*if(toRun.name.equals("B") || toRun.name.equals("E")) System.out.println("WILL PUTTT "+toRun.name);*/ break;
                case 4: q3.enqueue(toRun); toRun.setQuantum(8); break;
                case 8: q3.enqueue(toRun); break;
            }
            
            }
            else
            {
                //if(toRun.Tr>-1)
                    if(toRun.name.equals("E"))
                    System.out.print("W\t");
                running.enqueue(toRun);
            }
            
             
        
        }
        
        //System.out.println(getQueuedProcess().name);
            
           
        
    }
    
    
    
    public static Process getQueuedProcess()
    {
        Process toRun;
        
        if((toRun=q0.dequeue())==null)
            if((toRun=q1.dequeue())==null)
                if((toRun=q2.dequeue())==null)
                    if((toRun=q3.dequeue())==null);
                        
        
        
       
        
        return toRun;
    }

}
