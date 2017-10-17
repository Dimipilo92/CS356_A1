package cs356.A1;

import java.io.IOException;
import java.util.Scanner;

public class SimulationDriver {
	
	public static final Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		
		SimulationDriver s = new SimulationDriver();
		s.run();
	}
	
	public SimulationDriver() {}
	
	
	public void run() {
		displayMetaData();
		boolean repeat = true;
		while (repeat) {
			startPrompt();
			runSimulation();
			repeat = queryUserForRerun();
		}
	}
	
	private void displayMetaData() {
		System.out.println("IVote Simulator 2017\n" + 
				"By Dimitri Pierre-Louis\n");
	}
	private void startPrompt(){
		System.out.println("Press enter to start simulation...");
		try {
			System.in.read();
		}
		catch(IOException e) {
			System.out.println("Input Stream is corrupt!");
		}
	}

	private void runSimulation() {
		
		final int NUMBER_OF_TESTS = 10;
		
		System.out.println("Generating Questions and Submissions...");
		System.out.println("Results:");
		
		VotingServiceSimulator votingSim = new VotingServiceSimulator(
				NUMBER_OF_TESTS);	
		
		System.out.println("Single Choice:");
		
		runTests(votingSim, new SingleChoiceQuestion());
		
		System.out.print("\nMultiple Choice:");
		runTests(votingSim, new MultipleChoiceQuestion());
		
	}
	
	private void runTests(VotingServiceSimulator votingSim, Question q) {
		for (int i = 0; i < 2; i ++) {
			System.out.print("Trial " + i+": ");
			votingSim.runSimulationBasedOnQuestion(q);
			System.out.print(votingSim.getResults()+"\n");
			System.out.println("Student Count: " + 
					votingSim.getStudentCount());
			System.out.println("Saved Submissions: " + 
					votingSim.getAttemptedSubmissionCount());
			System.out.println("Total Submissions: " + 
					votingSim.getServiceSubmissionCount());
			
		}
	}
	
	private boolean queryUserForRerun() {
		System.out.print("Rerun (y/n)?\n:");
		//clearConsoleInputStream();
		String response = in.next();
		while(!isValidResponse(response)) {
			System.out.println("Response not recognized.");
			System.out.print("Rerun (y/n)?\n:");
			response = in.next();
		}
		return (response.toUpperCase().equals("Y") );
	}
	
	/*
	private void clearConsoleInputStream() {
		while (in.hasNext()) {
			in.next();
		}
	}
	*/
	
	private boolean isValidResponse(String response) {
		return (response.toUpperCase().equals("Y") ||
				response.toLowerCase().equals("N"));
	}

}
