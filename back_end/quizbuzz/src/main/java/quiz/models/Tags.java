package quiz.models;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="tags")
public class Tags {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name="id_generator", sequenceName = "tags_tag_id_seq", allocationSize = 1)
    @Column(name="tag_id")
	private int id;
	
	@ManyToMany(mappedBy = "tags")
	private List<Quiz> quizzes;
	
	@Column
	private String name;

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public void setQuizzes(List<Quiz> quizzes) {
		this.quizzes = quizzes;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
