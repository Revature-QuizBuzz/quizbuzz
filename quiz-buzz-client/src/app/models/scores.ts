import { Quiz } from "./quizzes";

export interface UserScore {
    id?: number;
    quiz?: Quiz;
    score?: number;
    completedOn?: Date;
}