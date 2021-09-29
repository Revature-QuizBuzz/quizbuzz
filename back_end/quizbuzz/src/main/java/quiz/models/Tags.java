package quiz.models;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="tags")
public class Tags {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//    @SequenceGenerator(name="id_generator", sequenceName = "tags_tag_id_seq", allocationSize = 1)
    @Column(name="tag_id")
	private int tagId;
	
	@ManyToMany(mappedBy = "tags")
	private List<Quiz> quizzes;
	
	@Column
	private String name;

	public int getTagId() {
		return tagId;
	}
	
	public void setTagId(int tagId) {
		this.tagId = tagId;
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
