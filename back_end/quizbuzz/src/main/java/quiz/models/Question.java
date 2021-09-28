package quiz.models;

import java.util.ArrayList;
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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.data.annotation.Transient;

@Entity
@Table(name = "questions")
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generator")
	@SequenceGenerator(name = "id_generator", sequenceName = "questions_question_id_seq", allocationSize = 1)
	@Column(name = "question_id")
	private int id;
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
		this.id = id;
	}

	public Question(int id, Quiz quiz, List<Answers> answers, String question, float possiblePoints, String type) {
		this.id = id;
		this.quiz = quiz;
		this.answers = answers;
		this.question = question;
		this.possiblePoints = possiblePoints;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
//	public Quiz getQuiz() {
//		return this.quiz;
//	}
	
	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}


//	public List<Answers> getAnswers() {
//		return answers;
//	}

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

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

	public static List<Integer> findAnswerDeletions(List<Answers> oldList, List<Answers> newList) {
		List<Integer> toDelete = new ArrayList<>();
		
		for(Answers oldAnswer: oldList) {
			if(!newList.contains(oldAnswer)) {
				toDelete.add(oldAnswer.getId());
			}
		}
		
		return toDelete;
	}

	public static List<Answers> findNewAnswers(List<Answers> oldList, List<Answers> newList) {
		List<Answers> newAnswers = new ArrayList<>();
		
		for(Answers newAnswer: newList) {
			if(!oldList.contains(newAnswer)) {
				newAnswers.add(newAnswer);
			}
		}

		return newAnswers;
	}

}
