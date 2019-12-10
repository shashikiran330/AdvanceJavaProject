package fr.epita.javaquiz.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Questionaire {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private int qId;

	private String questionaire;

	private String[] choiceList;

	private String correctAnswer;

	public int getqId() {
		return qId;
	}

	public void setqId(int qId) {
		this.qId = qId;
	}

	public String getQuestionaire() {
		return questionaire;
	}

	public void setQuestionaire(String questionaire) {
		this.questionaire = questionaire;
	}

	public String[] getChoiceList() {
		return choiceList;
	}

	public void setChoiceList(String[] choiceList) {
		this.choiceList = choiceList;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(questionaire);
		for (String option : choiceList) {
			sb.append("\n");
			sb.append(option);
		}
		return sb.toString();
	}

}