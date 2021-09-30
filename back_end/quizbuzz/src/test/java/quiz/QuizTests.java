//package quiz;
//
//import org.junit.Assert;
//import org.junit.jupiter.api.Test;
//import org.junit.platform.commons.util.CollectionUtils;
//import org.springframework.boot.test.context.SpringBootTest;
//import quiz.models.Answers;
//import quiz.models.Question;
//import quiz.models.Quiz;
//import quiz.models.Tags;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.Assert.assertEquals;
//
//@SpringBootTest
//public class QuizTests {
//
//    @Test
//    void testCalculateTotalScore() {
//        Answers a1 = new Answers();
//        Answers a2 = new Answers();
//        Answers a3 = new Answers();
//        Answers a4 = new Answers();
//
//        Answers b1 = new Answers();
//        Answers b2 = new Answers();
//        Answers b3 = new Answers();
//        Answers b4 = new Answers();
//
//        Question qA = new Question();
//        qA.setQuestion("question A");
//        qA.setType("multiple choice");
//        qA.setPossiblePoints(25);
//
//        Question qB = new Question();
//        qB.setQuestion("question B");
//        qB.setType("multiple choice");
//        qB.setPossiblePoints(25);
//
//        a1.setAnswer("answerA1");
//        a1.setCorrect(true);
//        a1.setQuestion(qA);
//
//        a2.setAnswer("answerA2");
//        a2.setCorrect(false);
//        a2.setQuestion(qA);
//
//        a3.setAnswer("answerA3");
//        a3.setCorrect(false);
//        a3.setQuestion(qA);
//
//        a4.setAnswer("answerA4");
//        a4.setCorrect(false);
//        a4.setQuestion(qA);
//
//        b1.setAnswer("answerB1");
//        b1.setCorrect(true);
//        b1.setQuestion(qB);
//
//        b2.setAnswer("answerB2");
//        b2.setCorrect(false);
//        b2.setQuestion(qB);
//
//        b3.setAnswer("answerB3");
//        b3.setCorrect(false);
//        b3.setQuestion(qB);
//
//        b4.setAnswer("answerB4");
//        b4.setCorrect(false);
//        b4.setQuestion(qB);
//
//        List<Answers> aList = new ArrayList<>();
//        List<Answers> bList = new ArrayList<>();
//
//        aList.add(a1);
//        aList.add(a2);
//        aList.add(a3);
//        aList.add(a4);
//
//        qA.setAnswers(aList);
//
//        bList.add(b1);
//        bList.add(b2);
//        bList.add(b3);
//        bList.add(b4);
//
//        qB.setAnswers(bList);
//
//        List<Question> qList = new ArrayList<>();
//        qList.add(qA);
//        qList.add(qB);
//
//        Quiz testQuiz = new Quiz();
//        testQuiz.setQuestions(qList);
//
//        assertEquals(50, testQuiz.calculateTotalScore(testQuiz.getQuestions()));
//    }
//
//    @Test
//    void testFindQuestionDeletions() {
//
//        List<Question> oldQuestions = new ArrayList<>();
//        List<Question> newQuestions = new ArrayList<>();
//
//        Question q1 = new Question();
//        q1.setId(1);
//        Question q2 = new Question();
//        q2.setId(2);
//        Question q22 = new Question();
//        q22.setId(22);
//        Question q23 = new Question();
//        q23.setId(23);
//
//        oldQuestions.add(q1);
//        oldQuestions.add(q2);
//        oldQuestions.add(q22);
//        oldQuestions.add(q23);
//
//        Question q11 = new Question();
//        q11.setId(11);
//        Question q14 = new Question();
//        q14.setId(14);
//
//        newQuestions.add(q1);
//        newQuestions.add(q2);
//        newQuestions.add(q11);
//        newQuestions.add(q14);
//
//        List<Integer> compare = new ArrayList<>();
//        compare.add(22);
//        compare.add(23);
//
//        List<Integer> deletions = Quiz.findQuestionDeletions(oldQuestions, newQuestions);
//
//        Assert.assertTrue(compare.size() == deletions.size() && compare.containsAll(deletions));
//
//    }
//
//    @Test
//    void testFindNewQuestions() {
//
//        List<Question> oldQuestions = new ArrayList<>();
//        List<Question> newQuestions = new ArrayList<>();
//
//        Question q1 = new Question();
//        q1.setId(1);
//        Question q2 = new Question();
//        q2.setId(2);
//        Question q22 = new Question();
//        q22.setId(22);
//        Question q23 = new Question();
//        q23.setId(23);
//
//        oldQuestions.add(q1);
//        oldQuestions.add(q2);
//        oldQuestions.add(q22);
//        oldQuestions.add(q23);
//
//        Question q11 = new Question();
//        q11.setId(11);
//        Question q14 = new Question();
//        q14.setId(14);
//
//        newQuestions.add(q1);
//        newQuestions.add(q2);
//        newQuestions.add(q11);
//        newQuestions.add(q14);
//
//        List<Question> compare = new ArrayList<>();
//        compare.add(q11);
//        compare.add(q14);
//
//        List<Question> addedQuestions = Quiz.findNewQuestions(oldQuestions, newQuestions);
//
//        Assert.assertTrue(compare.size() == addedQuestions.size() && compare.containsAll(addedQuestions));
//    }
//    
//    @Test
//    void testFindTagCreations() {
//    	
//        List<Tags> oldTags = new ArrayList<>();
//        List<Tags> newTags = new ArrayList<>();
//        
//        Tags t1 = new Tags();
//        t1.setName("tag1");
//        Tags t2 = new Tags();
//        t2.setName("tag2");
//        Tags t3 = new Tags();
//        t3.setName("tag3");
//        
//        oldTags.add(t1);
//        oldTags.add(t2);
//        oldTags.add(t3);
//        
//        Tags t10 = new Tags();
//        t10.setName("tag10");
//        Tags t11 = new Tags();
//        t11.setName("tag11");
//        
//        newTags.add(t1);
//        newTags.add(t2);
//        newTags.add(t10);
//        newTags.add(t11);
//        
//        // should return the list of names that represent the new tags
//        List<String> addedTags = Quiz.findTagCreations(oldTags, newTags);
//        
//        List<String> compare = new ArrayList<>();
//        compare.add("tag10");
//        compare.add("tag11");
//  
//        
//        Assert.assertTrue(compare.size() == addedTags.size() && compare.containsAll(addedTags));
//        
//        
//    	
//    }
//}
