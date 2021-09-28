<<<<<<< HEAD

=======
>>>>>>> 61bcad626f4f30ac554db28be1bd22fc809621dd
import { Quiz } from "./quizzes";
import { User } from "./users";

export interface UserScore {
    user?: User;
    id?: number;
    quiz?: Quiz;
    score?: number;
    completedOn?: Date;
}