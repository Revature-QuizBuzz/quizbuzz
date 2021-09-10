package quiz.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generator")
    @SequenceGenerator(name="id_generator", sequenceName = "users_user_id_seq", allocationSize = 1)
    @Column(name="user_id")
	private int id;
	
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

	public User() { }

	public User(int id) {
		this.id = id;
	}


	public User(int id, List<Quiz> quizzes, List<Scores> scores, String username, String password, String firstName, String lastName, int totalPoints) {
		this.id = id;
		this.quizzes = quizzes;
		this.scores = scores;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.totalPoints = totalPoints;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getUser(){
		return getId();
	}


	
}
