package cs356.A1;

import java.util.ArrayList;
import java.util.List;

public class VotingServiceSimulator {
	
	private IVotingService votingService;
	private int attemptedSubmissions;
	private List<IStudent> studentList;
	
	public VotingServiceSimulator(int numberOfStudents){
		votingService = new LocalVotingService();
		attemptedSubmissions = 0;
		setStudentCount(numberOfStudents);
	}
	
	public void setStudentCount(int numberOfStudents) {
		studentList = new ArrayList<IStudent>();
		for (int i = 0; i < numberOfStudents; i++)
			studentList.add(new LocalStudent());
	}

	public void runSimulationBasedOnQuestion(Question q) {
		attemptedSubmissions = 0;
		q.randomize();
		votingService.setQuestion(q);
		createSubmissions();
	}
	
	public int getStudentCount() {
		return studentList.size();
	}
	
	public int getAttemptedSubmissionCount() {
		return attemptedSubmissions;
	}

	public int getServiceSubmissionCount() {
		return votingService.getSubmissionCount();
	}
	
	public String getResults() {
		return votingService.getSubmittedAnswers();
	}
	
	private void createSubmissions(){
		for (int i = 0; i < studentList.size(); i++) {
			Form retrievedForm = votingService.requestForm(
					studentList.get(i));
			retrievedForm.randomize();
			votingService.submitForm(retrievedForm);
			attemptedSubmissions++;
		}
	}
	
}
