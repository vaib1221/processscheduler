Java Project to Simulate 4 types of Operating Systems process scheduling techniques:

  * Shortest Remaining-Time Next
  * Multilevel Feedback
  * Lottery Scheduling
  * Fair-Share Scheduling

### Shortest Remaining-Time Next ###
Scheduler considers which process to run on the arrival of a new process.

### Multilevel Feedback ###
Assume four priority levels. The quantum length for the highest priority is one time unit and is doubled as we move down the priority levels.

### Lottery Scheduling ###
Assume a quantum length of two time units. The number of tickets given to a process is proportional to its priority.

### Fair Share Scheduling ###
Assume a round-robin strategy and a quantum length of two time units. A user's share of CPU time should be proportional to their priority.