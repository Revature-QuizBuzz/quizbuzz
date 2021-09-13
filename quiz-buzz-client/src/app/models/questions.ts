import { Quiz } from './quizzes'
import { Answer } from './answers'


export interface Question {
    
    id?: number;
    quiz?: Quiz;
    answers?: Answer[];
    question?: string;
    possiblePoints?: number;
    type?: string;
    
}