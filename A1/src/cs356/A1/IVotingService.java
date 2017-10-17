package cs356.A1;

public interface IVotingService {
	public void reset();
	public void setQuestion(Question question);
	public int getSubmissionCount();
	public String getSubmittedAnswers();
	public Form requestForm(IStudent student);
	public void submitForm(Form form);
}
