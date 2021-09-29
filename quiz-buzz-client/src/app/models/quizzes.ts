import { User } from './users';
import { UserScore } from './scores';
import { Question } from './questions';
import { Tag } from './tags'

export interface Quiz {
    
    quizId?: number;
    user?: User;
    scores?: UserScore[];
    questions?: Question[];
    tags?: Tag[];
    name?: string;
    description?: string;
    totalScore?: number;
    createdDate?: Date;
    dateModified?: Date;

<<<<<<< HEAD
}
=======
}

>>>>>>> 61bcad626f4f30ac554db28be1bd22fc809621dd
