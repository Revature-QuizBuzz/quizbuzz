
import { Quiz } from "./quizzes";
import { User } from "./users";

export interface UserScore {
    user?: User;
    id?: number;
    quiz?: Quiz;
    score?: number;
    completedOn?: Date;
}