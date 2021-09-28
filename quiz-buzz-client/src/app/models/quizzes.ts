import { User } from './users';
import { UserScore } from './scores';
import { Question } from './questions';
import { Tag } from './tags'

export interface Quiz {
    
    id?: number;
    user?: User;
    scores?: UserScore[];
    questions?: Question[];
    tags?: Tag[];
    name?: string;
    description?: string;
    totalScore?: number;
    createdDate?: Date;
    dateModified?: Date;

}