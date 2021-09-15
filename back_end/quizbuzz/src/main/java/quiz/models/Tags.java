package quiz.models;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="tags")
public class Tags {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generator")
    @SequenceGenerator(name="id_generator", sequenceName = "tags_tag_id_seq", allocationSize = 1)
    @Column(name="tag_id")
	private int id;
	
	@ManyToMany(mappedBy="tags")
	private List<Quiz> quizzes;
	
	@Column
	private String name;

	public void setQuizTag(List<Quiz> quizzes) {
		this.quizzes = quizzes;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	
	
}
