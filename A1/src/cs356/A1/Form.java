package cs356.A1;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class Form implements Randomizable, Cloneable
{
	private UUID studentId;
	private UUID questionId;
	private String questionString;
	private List <String> possibleAnswers;
	protected List <Integer> selectedAnswers;
	
	public Form(Question q) {
		questionString = q.getQuestionString();
		questionId = UUID.fromString(q.getID());
		possibleAnswers = q.getPossibleAnswers();
		clearSelectedAnswers();
	}
	
	public void sign(String studentId){
		this.studentId = UUID.fromString(studentId);
	}
	
	public String getStudentId() {
		return studentId.toString();
	}
	
	public String getQuestionID() {
		return questionId.toString();
	}
	
	public String getQuestionString() {
		return questionString;
	}
	
	public List<String> getPossibleAnswers() {
		List<String> copyOfAnswers = new ArrayList<>();
		for (int i = 0; i < possibleAnswers.size(); i++) {
			copyOfAnswers.add(possibleAnswers.get(i));
		}
		return copyOfAnswers;
	}
	
	public void selectAnswer(int i) {
		selectedAnswers.set(i, 1);
	}
	
	public boolean checkSelected(int i) {
		return selectedAnswers.get(i) == 1;
	}
	
	public void clearSelectedAnswers() {
		selectedAnswers = new ArrayList<>();
		for (int i = 0; i < possibleAnswers.size(); i++){
			selectedAnswers.add(0);
		}
	}
	
	public List<Integer> getSelectedAnswers(){
		List<Integer> copyOfAnswers = new ArrayList<>();
		for (int i = 0; i < selectedAnswers.size(); i++) {
			copyOfAnswers.add(selectedAnswers.get(i));
		}
		return copyOfAnswers;
	}
	
	public abstract Form clone();
	
	protected void setQuestionId(String Id) {
		questionId = UUID.fromString(Id);
	}
}
