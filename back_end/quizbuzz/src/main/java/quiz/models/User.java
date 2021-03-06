package quiz.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
	private int userId;
	
	@OneToMany(mappedBy="user", cascade=CascadeType.ALL)
	private List<Quiz> quizzes;
	
	@OneToMany(mappedBy="user", cascade=CascadeType.ALL)
	private List<Scores> scores;
	
	@Column
	private String username;
	
	@Column
	private String password;
	
	@Column(name="f_name")
	private String firstName;
	
	@Column(name="l_name")
	private String lastName;
	
	@Column(name="total_points")
	private int totalPoints;
	
	@Column(name="total_possible_points")
	private int totalPossible;
	
	@Column(name="point_percentage")
	private double pointPercentage;
	
	
	public User() { }

	public User(int userId) {
		this.userId = userId;
	}
	
	public User(int userId, List<Quiz> quizzes, List<Scores> scores, String username, String password, String firstName,
			String lastName, int totalPoints, int totalPossible, double pointPercentage) {

		this.userId = userId;
		this.quizzes = quizzes;
		this.scores = scores;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.totalPoints = totalPoints;
		this.totalPossible = totalPossible;
		this.pointPercentage = pointPercentage;
	}



	public User(int userId, List<Quiz> quizzes, List<Scores> scores, String username, String password, String firstName, String lastName, int totalPoints) {
		this.userId = userId;
		this.quizzes = quizzes;
		this.scores = scores;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.totalPoints = totalPoints;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public void setQuizzes(List<Quiz> quizzes) {
		this.quizzes = quizzes;
	}

	public void setScores(List<Scores> scores) {
		this.scores = scores;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getTotalPoints() {
		return totalPoints;
	}

	public void setTotalPoints(int totalPoints) {
		this.totalPoints = totalPoints;
	}

	public int getTotalPossible() {
		return totalPossible;
	}
	public void setTotalPossible(int totalPossible) {
		this.totalPossible = totalPossible;
	}
	
	public double getPointPercentage() {
		return pointPercentage;
	}
	public void setPointPercentage(int pointPercentage) {
		this.pointPercentage = pointPercentage;
	}

}
