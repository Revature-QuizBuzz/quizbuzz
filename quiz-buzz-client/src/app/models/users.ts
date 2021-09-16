import { UserScore } from "./scores";
import { Quiz } from "./quizzes";
import { LoginComponent } from "../login/login.component";

export interface User {
    
    id?: number;
    username?: string;
    password?: string;
    firstName?: string;
    lastName?: string;
    total_points?: number;
    totalPossiblePoints?: number;
    pointPercentage?: number;
    userScores?: UserScore[];
    quizzes?: Quiz[];
}
