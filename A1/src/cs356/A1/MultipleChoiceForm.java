package cs356.A1;

import java.util.ArrayList;
import java.util.List;

public class MultipleChoiceForm extends Form {
	
	public MultipleChoiceForm(Question q){
		super(q);
	}
	
	public void deselectAnswer (int answer) {
		this.selectedAnswers.set(answer, 0);
	}
	
	@Override
	public void randomize() {
		this.clearSelectedAnswers();
		for(int i = 0; i < this.getSelectedAnswers().size(); i++) {
			if (Math.random() > 0.5) {
				this.selectAnswer(i);
			}
		}
	}

	@Override
	public Form clone() {
		
		MultipleChoiceQuestion newQuestion = new MultipleChoiceQuestion(
				this.getQuestionString());
		List<String> copyOfAnswers = new ArrayList<>();
		for (int i = 0; i < this.getPossibleAnswers().size(); i++) {
			copyOfAnswers.add(this.getPossibleAnswers().get(i));
		}
		newQuestion.setPossibleAnswers(copyOfAnswers);
		newQuestion.setId(this.getQuestionID());
		
		MultipleChoiceForm f = new MultipleChoiceForm(newQuestion);
		f.sign(this.getStudentId());
		for (int i = 0; i < this.getSelectedAnswers().size(); i++) {
			if(this.getSelectedAnswers().get(i) == 1) {
				f.selectAnswer(i);
			}
		}
		
		return f;
	}

}
