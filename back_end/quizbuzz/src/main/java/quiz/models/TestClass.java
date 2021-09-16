package quiz.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="testanswers")
public class TestClass {
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generator")
    @SequenceGenerator(name="id_generator", sequenceName = "testanswers_id_seq", allocationSize = 1)
    @Column(name="id")
	private int id;
	
	@Column(name="selectedanswers")
	private String selectedanswers;
	
	@Column(name="notselectedanswers")
	private String notselectedanswers;
	
	
	private TestClass() {
		super();
	}

	private TestClass(String selectedanswer) {
		super();
		this.selectedanswers = selectedanswer;
	}

	private TestClass(String selectedanswer,String notselectedanswers) {
		super();
		this.selectedanswers = selectedanswer;
		this.notselectedanswers = notselectedanswers;
		
	}
	@Override
	public String toString() {
		return "TestClass [id=" + id + ", selectedanswers=" + selectedanswers + ", notselectedanswers="
				+ notselectedanswers + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSelectedanswers() {
		return selectedanswers;
	}

	public void setSelectedanswers(String selectedanswers) {
		this.selectedanswers = selectedanswers;
	}

	public String getNotselectedanswers() {
		return notselectedanswers;
	}

	public void setNotselectedanswers(String notselectedanswers) {
		this.notselectedanswers = notselectedanswers;
	}
	
	
	
	
	

}
