import { Quiz } from "./quizzes";
import { User } from "./users";

export interface UserScore {
    user: User;
    scoreId: number;
    quiz: Quiz;
    score: number;
    completedOn: Date;    
}