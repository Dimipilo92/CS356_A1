package cs356.A1;

import java.util.ArrayList;
import java.util.List;

public class SingleChoiceForm extends Form {
	
	private int answer;
	
	public SingleChoiceForm(Question q){
		super(q);
	}
	
	@Override
	public void selectAnswer (int answer){
		int oldAnswer = this.answer;
		this.selectedAnswers.set(oldAnswer, 0);
		super.selectAnswer(answer);
	}

	@Override
	public void randomize() {
		answer = (int)(Math.random()*(double)this.getPossibleAnswers().size());
		selectAnswer(answer);
	}

	@Override
	public SingleChoiceForm clone() {
		
		SingleChoiceQuestion newQuestion = new SingleChoiceQuestion(
				this.getQuestionString());
		List<String> copyOfAnswers = new ArrayList<>();
		for (int i = 0; i < this.getPossibleAnswers().size(); i++) {
			copyOfAnswers.add(this.getPossibleAnswers().get(i));
		}
		newQuestion.setPossibleAnswers(copyOfAnswers);
		newQuestion.setId(this.getQuestionID());
		
		SingleChoiceForm f = new SingleChoiceForm(newQuestion);
		f.sign(this.getStudentId());
		for (int i = 0; i < this.getSelectedAnswers().size(); i++) {
			if(this.getSelectedAnswers().get(i) == 1) {
				f.selectAnswer(i);
			}
		}
		
		return f;
	}
	
}
