package cs356.A1;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class Question implements Randomizable, Cloneable
{
	private String questionString;
	private UUID questionId;
	private List<String> possibleAnswers;
	private static final int NUMBER_OF_RANDOM_ANSWERS = 5;
	
	public Question(){
		questionId = UUID.randomUUID();
	}
	
	public Question(String questionString){
		questionId = UUID.randomUUID();
		setQuestion(questionString);
	}
	
	public void setQuestion(String questionString){
		questionId = UUID.randomUUID();
		this.questionString = questionString;
	}
	
	public String getQuestionString() {
		return questionString;
	}
	
	public void setPossibleAnswers(List <String> possibleAnswers) {
		this.possibleAnswers = possibleAnswers;
	}
	
	public List<String> getPossibleAnswers() {
		List<String> copyOfAnswers = new ArrayList<>();
		for (int i = 0; i < possibleAnswers.size(); i++) {
			copyOfAnswers.add(possibleAnswers.get(i));
		}
		return copyOfAnswers;
	}
	
	
	public String getID() {
		return questionId.toString();
	}
	
	@Override
	public void randomize() {
		setQuestion("This is a random question");
		possibleAnswers = new ArrayList<>();
		for (int i = 0; i < NUMBER_OF_RANDOM_ANSWERS; i++) {
			Character c = (char) (i+'A');
			possibleAnswers.add(c.toString());
		}
	}
	
	public abstract Form createForm();
	public abstract Question clone();
	
	protected void setId(String questionIdString) {
		this.questionId = UUID.fromString(questionIdString);
	}
}