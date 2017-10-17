package cs356.A1;

import java.util.ArrayList;
import java.util.List;

public class MultipleChoiceQuestion extends Question {
	
	public MultipleChoiceQuestion(){
		super();
	}
	
	public MultipleChoiceQuestion(String questionString){
		super(questionString);
	}

	@Override
	public Form createForm() {
		return new MultipleChoiceForm(this.clone());
	}
	

	@Override
	public MultipleChoiceQuestion clone() {
		MultipleChoiceQuestion newQuestion = new MultipleChoiceQuestion(
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