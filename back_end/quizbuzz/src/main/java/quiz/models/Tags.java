package quiz.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tags")
public class Tags {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name="id_generator", sequenceName = "tags_tag_id_seq", allocationSize = 1)
    @Column(name="tag_id")
	private int tagId;
	
	@ManyToMany(mappedBy = "tags")
	private List<Quiz> quizzes;
	
	@Column
	private String name;

	public int getId() {
		return tagId;
	}
	
	public void setId(int id) {
		this.tagId = id;
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
