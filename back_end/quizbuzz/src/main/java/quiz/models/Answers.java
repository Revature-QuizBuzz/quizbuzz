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
import javax.persistence.Transient;

@Entity
@Table(name="answers")
public class Answers {
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generator")
    @SequenceGenerator(name="id_generator", sequenceName = "answers_answer_id_seq", allocationSize = 1)
    @Column(name="answer_id")
	private int id;
	
	
	@ManyToOne
	@JoinColumn(name="question_id", nullable=false)
	private Question question;
	
	@Column
	private String answer;
	
	@Column
	private boolean correct;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public int getQuestionId() {
		return question.getId();
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
