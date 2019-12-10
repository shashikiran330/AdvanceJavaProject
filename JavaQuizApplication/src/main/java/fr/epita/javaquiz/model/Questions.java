package fr.epita.javaquiz.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Questions {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private int qId;
	private String question;
    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;
    private String correct;
	
    public int getqId() {
		return qId;
	}

	public void setqId(int qId) {
		this.qId = qId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer1() {
		return answer1;
	}

	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}

	public String getAnswer2() {
		return answer2;
	}

	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}

	public String getAnswer3() {
		return answer3;
	}

	public void setAnswer3(String answer3) {
		this.answer3 = answer3;
	}

	public String getAnswer4() {
		return answer4;
	}

	public void setAnswer4(String answer4) {
		this.answer4 = answer4;
	}

	public String getCorrect() {
		return correct;
	}

	public void setCorrect(String correct) {
		this.correct = correct;
	}

	@Override
	public String toString() {
		return "Questions:: Question=" + this.question + " Answer1=" + this.answer1 + " Answer2=" + this.answer2 +
				" Answer2=" + this.answer2 + " Answer3=" + this.answer3 +  "Answer4=" + this.answer4 + " Correct=" + this.correct;
	}

}
