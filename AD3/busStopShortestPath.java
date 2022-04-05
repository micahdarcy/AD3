import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;


// This is finding the shortest path of the bus route using Dijkstra's Algorithm.

public class busStopShortestPath {
	
	public final int MAX_STOP = 12479; //the max number of stops = 12479
	double max = Double.NaN;
	private String stopTimesInput, transfersInput;
	
	
	private double systemMatrix[][] = new double [MAX_STOP][MAX_STOP];
	
	busStopShortestPath()
	{
		try {
			systemMatrix();
			
		}catch (FileNotFoundException error)
		{
			error.printStackTrace();
		}
	}
	
	private void systemMatrix() throws FileNotFoundException {
		
		String currentLine;
		
		int source; 
		int sink = 0; 
		
		int previous = 0;
		int tripID = 0;
		double cost = 1;
		
		
		int in_direct; 
		double shortestPath;
		
		//creating an adjacency matrix for the bus system to represent 
		//the distTo and edgeTo values in shortest path algorithm.
		for(int i = 0; i < MAX_STOP ;i++ ) { 
			for (int j = 0; j <MAX_STOP; j++)
			{
				if(i!=j) {
					systemMatrix[i][j] = max; 
				}
				else {
					systemMatrix[i][j]=0;
				}
			}
		}
		//Reading in the stops file
		File stopTimesInputFile = new File("stop_times.txt");
		Scanner file1 = new Scanner(stopTimesInputFile);
		Scanner lineFile = null;
		file1.nextLine();


		while(file1.hasNextLine()) 
		{

			currentLine = file1.nextLine();
			lineFile = new Scanner(currentLine);
			lineFile.useDelimiter(",");

			previous = tripID;
			tripID = lineFile.nextInt();
			lineFile.next();


			for (int i = 1; i < 3; i++)
			{
				lineFile.next();

			}
			source = sink;
			sink = lineFile.nextInt();

			if(previous == tripID) 
			{
				systemMatrix[source][sink] = cost;
			}

			lineFile.close();
		}
		file1.close();

		File transfersFileInput = new File("transfers.txt");
		file1 = new Scanner(transfersFileInput);
		file1.nextLine();

		while(file1.hasNextLine()) 
		{
			currentLine = file1.nextLine();
			lineFile = new Scanner(currentLine);
			lineFile.useDelimiter(",");

			source = lineFile.nextInt();
			sink = lineFile.nextInt();
			in_direct = lineFile.nextInt();

			if(in_direct == 0) 
			{
				systemMatrix[source][sink] = 2;
			}
			else if(in_direct == 2) 
			{
				shortestPath = lineFile.nextDouble();
				systemMatrix[source][sink] = (shortestPath / 100 );
			}

			lineFile.close();
		}
		file1.close();
	}

	private void relaxEdge(double[] distTo, int[] edgeTo, int source, int sink) {
    	
		if(distTo[source] > distTo[sink] + systemMatrix[source][sink]) 
    	{
    		distTo[source] = distTo[source] + systemMatrix[source][sink];
    		edgeTo[source] = source;
    	}
	}
	

	
	public String shortestBusRoute(int source, int sink) {
		
		double distTo[] = new double[MAX_STOP];
		int edgeTo[] = new int[MAX_STOP];
		int visited [] = new int[MAX_STOP];
		
		for(int i = 0; i <distTo.length; i++) {
			if(i!= source) {
				distTo[i] = Double.POSITIVE_INFINITY;
			}
		}
		
		int position = source;
		distTo[source] = 0;
		visited[source] = 1;
		String shortestRoute = "";
		int x = 0;
		while (x < distTo.length) {

            for (int i = 0; i < systemMatrix[position].length; i++) {

                if (visited[i] == 0 && !Double.isNaN(systemMatrix[position][i])) 
                {
                    relaxEdge(distTo, edgeTo, i, position);
                }
            }
		
		if(distTo[sink] == Double.POSITIVE_INFINITY)
		{
			return "Error. This bus route does not exist.";
		}
		
		for (int i = 0; i < distTo.length;i++) {

            if (visited[i] != 1 && distTo[i]<Integer.MAX_VALUE) 
            {
                position = i;
                
            }
        }
        x++;
    }
		while (sink!=source) 
		{
			shortestRoute = "\n" + edgeTo[sink] + shortestRoute ;
			sink = edgeTo[sink];
		}
		shortestRoute = shortestRoute + "\n" + sink;

        return "The cost: " + Double.toString(distTo[sink]) + " via the following route: " + shortestRoute;
		
       
		}
		
	
	

	}
	}
	

	


