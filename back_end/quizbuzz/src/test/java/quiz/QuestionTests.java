package quiz;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import quiz.models.Answers;
import quiz.models.Question;

@SpringBootTest
public class QuestionTests {
	
	@Test
	public void testFindNewAnswers() {
        Answers a1 = new Answers();
        Answers a2 = new Answers();
        Answers a3 = new Answers();
        Answers a4 = new Answers();

        Answers b1 = new Answers();
        Answers b2 = new Answers();
        Answers b3 = new Answers();
        Answers b4 = new Answers();
        
        List<Answers> aList = new ArrayList<>();
        List<Answers> bList = new ArrayList<>();

        aList.add(a1);
        aList.add(a2);
        aList.add(a3);
        aList.add(a4);
        
        bList.add(a1);
        bList.add(a2);
        bList.add(b1);
        bList.add(b2);
        bList.add(b3);
        bList.add(b4);
        
        
        List<Answers> compare = new ArrayList<>();
        compare.add(b1);
        compare.add(b2);
        compare.add(b3);
        compare.add(b4);
        
        List<Answers> addedAnswers = Question.findNewAnswers(aList, bList);
       
        
        Assert.assertTrue(compare.size() == addedAnswers.size() && compare.containsAll(addedAnswers));
        
	}
	
	@Test
	public void testFindAnswerDeletions() {
		Answers a1 = new Answers();
		a1.setId(1);
        Answers a2 = new Answers();
        a2.setId(2);
        Answers a3 = new Answers();
        a3.setId(3);
        Answers a4 = new Answers();
        a4.setId(4);

        Answers b1 = new Answers();
        b1.setId(5);
        Answers b2 = new Answers();
        b2.setId(6);
        Answers b3 = new Answers();
        b3.setId(7);
        Answers b4 = new Answers();
        b4.setId(8);
        
        List<Answers> aList = new ArrayList<>();
        List<Answers> bList = new ArrayList<>();

        aList.add(a1);
        aList.add(a2);
        aList.add(a3);
        aList.add(a4);
        
        bList.add(a1);
        bList.add(a2);
        bList.add(b1);
        bList.add(b2);
        bList.add(b3);
        bList.add(b4);
        
        
        List<Integer> compare = new ArrayList<>();
        compare.add(a3.getId());
        compare.add(a4.getId());
        
        List<Integer> deletedAnswers = Question.findAnswerDeletions(aList, bList);

        
        Assert.assertTrue(compare.size() == deletedAnswers.size() && compare.containsAll(deletedAnswers));
	}

}
