import { User } from './users';
import { UserScore } from './scores';
import { Question } from './questions';
import { Tag } from './tags'

export interface Quiz {
    
    quizId?: number;
    userId?: number;
    name?: string;
    description?: string;
    totalScore?: number;
    createdDate?: Date;
    dateModified?: Date;
    
}
