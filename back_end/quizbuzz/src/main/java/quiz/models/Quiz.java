package quiz.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name = "quizzes")
public class Quiz {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//    @SequenceGenerator(name="id_generator", sequenceName = "quizzes_quiz_id_seq", allocationSize = 1)
    @Column(name="quiz_id")
	private int quizId;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
	
	@OneToMany(mappedBy="quiz", cascade= {CascadeType.MERGE, CascadeType.REMOVE}, fetch=FetchType.LAZY)
	private List<Scores> scores;
	
	@OneToMany(mappedBy="quiz", cascade={CascadeType.MERGE, CascadeType.REMOVE})
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
	
	public void add(Question tempQuestion) {
		if(this.questions == null) {
			this.questions = new ArrayList<>();
		
		}
		this.questions.add(tempQuestion);
		tempQuestion.setQuiz(this);
	}


	public int calculateTotalScore (List<Question> questions) {
		int total = 0;
		for( Question element: questions) {
			total += element.getPossiblePoints();
		}
		return total;
	}

	// returns a list of ids to call deleteAllByIdInBatch() on
	public static List<Integer> findQuestionDeletions(List<Question> oldList, List<Question> newList) {
		List<Integer> toDelete = new ArrayList<>();
		for (Question oldQuestion: oldList) {
			if (!newList.contains(oldQuestion)) {
				toDelete.add(oldQuestion.getQuestionId());
			}
		}
		return toDelete;
	}

	public static List<Question> findNewQuestions(List<Question> oldList, List<Question> newList) {
		List<Question> newQuestions = new ArrayList<>();
		for (Question newQuestion: newList) {
			if (!oldList.contains(newQuestion)) {
				newQuestions.add(newQuestion);
			}
		}
		return newQuestions;
	}

	public static List<String> findTagCreations(List<Tags> oldList, List<Tags> newList) {
		List<String> toCreate = new ArrayList<>();
		List<String> oldNames = new ArrayList<>();
		for(Tags oldTag: oldList) {
			oldNames.add(oldTag.getName());
		}
		for (Tags newTag: newList) {
			if(!oldNames.contains(newTag.getName())) {
				toCreate.add(newTag.getName());
			}
		}
		return toCreate;
	}
	
	public static List<Integer> getListIds(List<Question> questions) {
		List<Integer> ids = new ArrayList<>();
		for(Question question: questions) {
			ids.add(question.getQuestionId());
		}
		return ids;
	}
	
}
