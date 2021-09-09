import { UserScore } from "./scores";
import { Quiz } from "./quizzes";

export interface User {
    
    userId: number;
    username: string;
    password: string;
    firstName: string;
    lastName: string;
    total_points: number;
    total_possible_points: number;
    point_percentage: number;
    userScores: UserScore[];
    quizzes: Quiz[];
}