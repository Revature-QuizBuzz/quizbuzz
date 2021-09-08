package quiz.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tags")
public class Tags {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generator")
    @SequenceGenerator(name="id_generator", sequenceName = "tags_tag_id_seq", allocationSize = 1)
    @Column(name="tag_id")
	private int id;
	
	@OneToMany(mappedBy="tag")
	private List<QuizTag> quizTag;
	
	@Column
	private String name;

	public void setQuizTag(List<QuizTag> quizTag) {
		this.quizTag = quizTag;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	
	
}
