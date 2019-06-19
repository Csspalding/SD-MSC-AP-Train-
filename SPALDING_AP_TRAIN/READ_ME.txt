@author Cassie Spalding 2140148s  AP Coursework March 2019

I realise my program is over complex, I have tried to make my program as flexible as possible, 
so it would be easy to create a return journey or to amend the route by removing/adding new 
stations or track segments. As creating multiple Threads can be costly to memory, I included a max
number of Trains to be created in the Train Generator.
Currently my RailwayLine class has an issue when tested as it is not receiving trains in tracks 
lists despite creating the TrainGenerator, so my updateDisplay is not printing out train names. 
The issue may be with how I implement Handler class that add/removes trains.
When the track class is tested with a main initialising new trains all the methods work. 
The Train class currently prints out and demonstrates trains passing each other on tracks so also works as expected. 
  In addition to solving the issue with RailwayLine, to improve my program I would look into:
1)Using an Executor Service for a Thread Pool in Train Generator
2)Test if each method is called throughout and refactor the code by removing any methods not called/ 
or not seen as needed for future hooks.
3)Refactor the code further by use of iterators 
4)Reduce coupling and increase cohesion by further abstraction 
e.g. Track could be designed to be an abstract class, maybe also check all the program behaviors are handled by interfaces.
5)Use Enum for variables that only have a few options e.g. Train class variable  speed and cap that have only a few variable options
6)Make more attributes final by passing them through constructors where possible.