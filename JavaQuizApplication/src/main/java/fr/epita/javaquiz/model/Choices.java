package fr.epita.javaquiz.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Choices {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;

	int qId;

	@ManyToOne
	Questionaire questionaire;
	String choiceList[];
	String text;
	String isCorrect;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getqId() {
		return qId;
	}

	public void setqId(int qId) {
		this.qId = qId;
	}

	public Questionaire getQuestionaire() {
		return questionaire;
	}

	public void setQuestionaire(Questionaire questionaire) {
		this.questionaire = questionaire;
	}

	public String[] getChoiceList() {
		return choiceList;
	}

	public void setChoiceList(String[] choiceList) {
		this.choiceList = choiceList;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getIsCorrect() {
		return isCorrect;
	}

	public void setIsCorrect(String isCorrect) {
		this.isCorrect = isCorrect;
	}

	@Override
	public String toString() {
		return " " + text + " : " + choiceList;
	}

}
