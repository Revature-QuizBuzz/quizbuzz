package quiz.models;


import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "quizzes")
public class Quiz {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="quiz_id")
	private int quizId;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@OneToMany(mappedBy="quiz", cascade=CascadeType.MERGE)
	private List<Scores> scores;
	
	@OneToMany(mappedBy="quiz", cascade=CascadeType.MERGE)
	private List<Question> questions;
	
	@ManyToMany
	@JoinTable(name="quiz_tags", joinColumns = { @JoinColumn(name="quiz_id") }, inverseJoinColumns = { @JoinColumn(name="tag_id") })
	private List<Tags> tags;

	@Column
	private String name;

	@Column
	private String description;

	@Column(name = "total_score")
	private int totalScore;
	
	@Column(name="created_date")
	private Date createdDate = new Date();
	
	@Column(name="date_modified")
	private Date dateModified;

	public Quiz() {
	}

	public Quiz(int id) {
		this.quizId = id;
	}

	public Quiz(int id, User user, List<Scores> scores, List<Question> questions, List<Tags> tags, String name, String description, int totalScore, Date dateModified) {
		this.quizId = id;
		this.user = user;
		this.scores = scores;
		this.questions = questions;
		this.tags = tags;
		this.name = name;
		this.description = description;
		this.totalScore = totalScore;
		this.dateModified = dateModified;
	}

	public Quiz(int id, User user, List<Scores> scores, List<Question> questions, List<Tags> tags, String name, String description, int totalScore, Date createdDate, Date dateModified) {
		this.quizId = id;
		this.user = user;
		this.scores = scores;
		this.questions = questions;
		this.tags = tags;
		this.name = name;
		this.description = description;
		this.totalScore = totalScore;
		this.createdDate = createdDate;
		this.dateModified = dateModified;
	}

	public int getQuizId() {
		return quizId;
	}

	public void setQuizId(int id) {
		this.quizId = id;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Scores> getScores() {
		return scores;
	}

	public void setScores(List<Scores> scores) {
		this.scores = scores;
	}

	public List<Tags> getTags() {
		return tags;
	}

	public void setTags(List<Tags> tags) {
		this.tags = tags;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getDateModified() {
		return dateModified;
	}

	public void setDateModified(Date dateModified) {
		this.dateModified = dateModified;
	}

}
