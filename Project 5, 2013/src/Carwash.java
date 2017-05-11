import java.io.File;
import java.util.Random;
import java.util.Scanner;

import stacks.*;

public class Carwash {
	
//  Information for that is for this code
	public static Entry[] Carwash = new Entry[100];
	public static int i, j,k, index, arivetime, ServiceIn, WaitTime, waitT1, AverageWait;
	public static int operand2	= 0;
	public static int totalV	= 0;
	public static String amks;
	static int value;
	static Random arivaltime =	new Random ();
	static Random servicetime=	new Random ();
	
	static BoundedStackInterface<Integer> WaitStack = new ArrayStack<Integer>(500);
	static  int []  LongWait = new int [500];
	static BoundedQueueInterface<Integer> AriveQueue= new ArrayBndQueue<Integer>(4);
	
	
	public static class Entry{
		//  Integers used to separate the values
		//  from the file that will be called
		public int hours, mins, customers;
	}
	
	public static int readFile(String fileName) throws Exception{
		// Read in a file to have set start and finish time, and
		// have a set value for that job
		File f = new File(fileName);
		Scanner fileIn = new Scanner(f);
		Entry TheCarwash;
		int HoursToMins	= 0;
		int TotalMins	= 0;
		
		TheCarwash	= new Entry();
		index 	= 0;
		
		for(i=1; i < Carwash.length && fileIn.hasNextInt();i++){
			TheCarwash 				= new Entry();
			TheCarwash.hours		= fileIn.nextInt();
			TheCarwash.mins			= fileIn.nextInt();
			TheCarwash.customers	= fileIn.nextInt();
			
			Carwash[i]	= TheCarwash;
			index++;			
		}
		for(i=1;i<=index;i++){
			// calculate mins total
			HoursToMins = Carwash[i].hours * 60;
			TotalMins	= Carwash[i].mins + HoursToMins;
		}
		return TotalMins;
	}
	
	public static void main(String[] args) throws Exception {
		int totaltime		= readFile("Carwash.txt");
		int StartTime		= 0;
		int StartSerivce	= 0;
		int bypass			= 0;
		int servicecount	= 0;
		int idle			= 0;
		int carcounter		= 0;
			k				= 0;
		int NextAriveTime	= arivaltime.nextInt(6)+1;
		int NextService		= servicetime.nextInt(3)+2;
		
		
		System.out.println("Total number of minutes this car wash is open: " + totaltime);
		for(i=1;i<=index;i++){
			// loop the carwash over total time
			int NumWaiting = Carwash[i].customers;
			for(j=0;j<=NumWaiting;j++){
				if(j>=1 && j<=4){
					AriveQueue.enqueue(StartTime);
					carcounter++;
				}
				if(j>4){
					bypass++;
					System.out.println("A customer bypassed the car wash 0 minutes in.");
					System.out.print(" " + carcounter + " cars in line \n");
				}
			}
		}
		for(int time=0; time<=totaltime;time++){
			// car arriving
			if(time == NextAriveTime){
				if(AriveQueue.isFull()){
					System.out.println("A customer bypassed the car wash " + time + " minutes in.");
					bypass++;
				}
				else{
					System.out.println("A new customer has arrived " + time +" minutes in.");
					AriveQueue.enqueue(time);
					carcounter++;
					
				}
				System.out.print(" " + carcounter + " cars in line \n");
				arivetime = arivaltime.nextInt(6)+1;
				NextAriveTime = arivetime + time;
			}
			
			if(time == NextService){
				// car being serviced
				if(!AriveQueue.isEmpty()){
					System.out.println("Customer started service at " + time + " minutes in.");
					arivetime	= AriveQueue.dequeue();
					WaitTime	= time - arivetime;
					WaitStack.push(WaitTime);
					LongWait[k] = (WaitTime);
					k++;
					ServiceIn = servicetime.nextInt(3)+2;
					NextService = ServiceIn + time;
					servicecount++;
					carcounter= carcounter - 1;
					System.out.print(" " + carcounter + " cars in line \n");
				}
				else{
					idle++;
					NextService = time+1;
					System.out.println(" " + carcounter + " cars in line... Car wash is idle");
				}
			}
		}
		while(!AriveQueue.isEmpty()){
			// if no cars in line
				AriveQueue.dequeue();
				carcounter--;
				System.out.println("The customer bypassed the car wash because the Car Wash is closed.");
				System.out.print(" " + carcounter + " cars in line \n");
				bypass++;
		}
		
		// Print out the results
		System.out.println("\nNumber of costomers serviced: " + servicecount);
		System.out.println("Number of minutes the car wash was idle: " + idle + " minutes");
		
		while(!WaitStack.isEmpty()){
			waitT1 = WaitStack.top();
			WaitStack.pop();
			operand2 = operand2 + waitT1;
		}
		AverageWait = operand2/servicecount;
		
		System.out.println("Average wait time in minutes: " + AverageWait + " minutes");
		
		for(i=0; i<k;i++){
			if(LongWait[0]<LongWait[i])
				LongWait[0] = LongWait[i];
		}
			
		System.out.println("Longest wait time: " + LongWait[0] + " minutes");
		System.out.println("Number of customers bypassed the car wash: " + bypass);
	}

}
