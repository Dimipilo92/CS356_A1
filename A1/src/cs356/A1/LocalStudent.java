package cs356.A1;

import java.util.UUID;

public class LocalStudent implements IStudent {
	
	private UUID studentID;
	
	public LocalStudent(){
		studentID = UUID.randomUUID();
	}

	@Override
	public String getStudentId() {
		return studentID.toString();
	}

	@Override
	public Form signForm(Form form) {
		form.sign(studentID.toString());
		return form;
	}

}
