package quiz.models;

import javax.persistence.*;

@Entity
@Table(name = "quiz_tags")
public class QuizTag {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generator")
    @SequenceGenerator(name = "id_generator", sequenceName = "quiz_tags_quiz_tag_id_seq", allocationSize = 1)
    @Column(name = "quiz_tag_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "tag_id", nullable = false)
    private Tags tag;

    @ManyToOne
    @JoinColumn(name = "quiz_id", nullable = false)
    private Quiz quiz;

    public Tags getTag() {
        return tag;
    }

    public QuizTag() { }

    public QuizTag(int id, Tags tag, Quiz quiz) {
        this.id = id;
        this.tag = tag;
        this.quiz = quiz;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public void setTag(Tags tag) {
        this.tag = tag;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public Quiz getQuiz() { return quiz; }

}
