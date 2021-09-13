import { Quiz } from './quizzes'
import { Answer } from './answers'


export interface Question {
    
    questionId: number;
    quizId: Quiz;
    answers: Answer[];
    question: string;
    possiblePoints: number;
    questionType: string;
    
}