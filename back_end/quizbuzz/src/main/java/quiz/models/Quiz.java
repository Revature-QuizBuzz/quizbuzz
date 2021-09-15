package quiz.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="quizzes")
public class Quiz {
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generator")
    @SequenceGenerator(name="id_generator", sequenceName = "quizzes_quiz_id_seq", allocationSize = 1)
    @Column(name="quiz_id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="user_id", nullable=false)
	private User user;
	
	@OneToMany(mappedBy="quiz", cascade=CascadeType.ALL)
	private List<Scores> scores;
	
	@OneToMany(mappedBy="quiz", cascade=CascadeType.ALL)
	private List<Question> questions;

	@ManyToMany
	@JoinTable(name="quiz_tags", joinColumns = { @JoinColumn(name="quiz_id") }, inverseJoinColumns = { @JoinColumn(name="tag_id") })
	private List<Tags> tags;

	@Column
	private String name;
	
	@Column
	private String description;
	
	@Column(name="total_score")
	private int totalScore;
	
	@Column(name="created_date")
	private Date createdDate;
	
	@Column(name="date_modified")
	private Date dateModified;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getUser() {return this.user;}

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


	public int calculateTotalScore (List<Question> questions) {
		int total = 0;
		for( Question element: questions) {
			total += element.getPossiblePoints();
		}
		return total;
	}

	// returns a list of ids to call deleteAllByIdInBatch() on
	public List<Integer> findDeletions(List<Question> oldList, List<Question> newList) {
		List<Integer> toDelete = new ArrayList<>();
		for (Question oldQuestion : oldList) {
			for (Question newQuestion: newList) {
				if (oldQuestion.getId() == newQuestion.getId()) {
					break;
				}
			}
			toDelete.add(oldQuestion.getId());
		}
		return toDelete;
	}
	
}
