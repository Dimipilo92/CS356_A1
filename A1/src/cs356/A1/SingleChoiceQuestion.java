package cs356.A1;

import java.util.ArrayList;
import java.util.List;

public class SingleChoiceQuestion extends Question 
{
	
	public SingleChoiceQuestion(){
		super();
	}
	
	public SingleChoiceQuestion(String questionString){
		super(questionString);
	}

	@Override
	public Form createForm() {
		return new SingleChoiceForm(this.clone());
	}
	
	@Override
	public SingleChoiceQuestion clone() {
		
		SingleChoiceQuestion newQuestion = new SingleChoiceQuestion(
				this.getQuestionString());
		List<String> copyOfAnswers = new ArrayList<>();
		for (int i = 0; i < this.getPossibleAnswers().size(); i++) {
			copyOfAnswers.add(this.getPossibleAnswers().get(i));
		}
		newQuestion.setPossibleAnswers(copyOfAnswers);
		newQuestion.setId(this.getID());
		
		return newQuestion;
	}
}
