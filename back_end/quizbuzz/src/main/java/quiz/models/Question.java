package quiz.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "questions")
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="question_id")
	private int questionId;
	
	@ManyToOne
	@JoinColumn(name = "quiz_id")
	private Quiz quiz;

	@OneToMany(mappedBy = "question", cascade = CascadeType.MERGE)
	private List<Answers> answers;

	@Column
	private String question;

	@Column(name = "possible_points")
	private float possiblePoints;

	@Column(name = "question_type")
	private String type;
	
	public Question() { }

	public Question(int id) {
		this.questionId = id;
	}

	public Question(int id, Quiz quiz, List<Answers> answers, String question, float possiblePoints, String type) {
		this.questionId = id;
		this.quiz = quiz;
		this.answers = answers;
		this.question = question;
		this.possiblePoints = possiblePoints;
		this.type = type;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int id) {
		this.questionId = id;
	}
	
//	public Quiz getQuiz() {
//		return this.quiz;
//	}
	
	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}


	public List<Answers> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answers> answers) {
		this.answers = answers;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public float getPossiblePoints() {
		return possiblePoints;
	}

	public void setPossiblePoints(float possiblePoints) {
		this.possiblePoints = possiblePoints;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", quiz=" + quiz + ", answers=" + answers + ", question="
				+ question + ", possiblePoints=" + possiblePoints + ", type=" + type + "]";
	}
}
