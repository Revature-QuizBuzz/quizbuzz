package quiz.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="user_scores")
public class Scores {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="score_id")
	private int scoreId;
	
	@ManyToOne
	@JoinColumn(name="user_id", nullable=false)
	private User user;
	
	@ManyToOne
	@JoinColumn(name="quiz_id", nullable=false)
	private Quiz quiz;
	
	@Column(name="user_score")
	private int score;
	
	@Column(name="completed_on")
	private Date completedOn;
	
	public Scores() { }

	public Scores(int id, User user, Quiz quiz, int score, Date completedOn) {
		super();
		this.scoreId = id;
		this.user = user;
		this.quiz = quiz;
		this.score = score;
		this.completedOn = completedOn;
	}

	public Scores(int id) {
		this.scoreId = id;
	}

	public int getScoreId() {
		return scoreId;
	}

	public void setScoreId(int id) {
		this.scoreId = id;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Date getCompletedOn() {
		return completedOn;
	}

	public void setCompletedOn(Date completedOn) {
		this.completedOn = completedOn;
	}

}