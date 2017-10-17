package cs356.A1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LocalVotingService implements IVotingService {
	
	private Map<String, Form> submissions;
	private Question question;
	
	
	public LocalVotingService(){
		submissions = new HashMap<>();
	}
	

	@Override
	public void reset() {
		submissions = new HashMap<>();
	}

	@Override
	public void setQuestion(Question question) {
		this.question = question;
		reset();
	}

	@Override
	public int getSubmissionCount() {
		return submissions.size();
	}

	@Override
	public String getSubmittedAnswers() {
		int[] totals = null;
		StringBuilder sb = new StringBuilder();
		for (String id : submissions.keySet()) {
			List<Integer> answers = submissions.get(id).getSelectedAnswers();
			if (totals == null) {
				totals = new int[answers.size()];
			}
			for (int i = 0; i < answers.size(); i++) {
				totals[i]+=answers.get(i);
			}
		}
		
		List<String> questionList = question.getPossibleAnswers();
		for (int i = 0; i < questionList.size(); i++) {
			sb.append(questionList.get(i));
			sb.append(":"+totals[i]+", ");
		}
		sb.deleteCharAt(sb.length()-1);
		return sb.toString();
	}

	@Override
	public Form requestForm(IStudent student) {
		String studentId = student.getStudentId().toString();
		if (submissions.containsKey(studentId)){
			return submissions.get(studentId).clone();
		}
		else {
			Form newForm = question.createForm();
			student.signForm(newForm);
			submissions.put(studentId, newForm);
			return newForm.clone();
		}
	}

	@Override
	public void submitForm(Form form) {
		submissions.put(form.getStudentId(), form);
	}

}
