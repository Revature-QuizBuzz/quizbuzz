package quiz.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "answers")
public class Answers {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name="id_generator", sequenceName = "answers_answer_id_seq", allocationSize = 1)
    @Column(name="answer_id")
	private int answerId;
	
	@ManyToOne
	@JoinColumn(name = "question_id", nullable = false)
	private Question question;

	@Column
	private String answer;

	@Column
	private boolean correct;

	public Answers() {
	}

	public Answers(int answerId) {
		this.answerId = answerId;
	}

	public Answers(int answerId, Question question, String answer, boolean correct) {
		this.answerId =answerId;
		this.question = question;
		this.answer = answer;
		this.correct = correct;
	}

	public int getAnswerId() {
		return answerId;
	}

	public void setAnswerId(int answerId) {
		this.answerId =answerId;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}
	
//	public Question getQuestion() {
//		return this.question;
//	}

	public int getQuestionId() {
		return question.getQuestionId();
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public boolean isCorrect() {
		return correct;
	}

	public void setCorrect(boolean correct) {
		this.correct = correct;
	}

}
