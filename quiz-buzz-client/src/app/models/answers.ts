import {Question} from './questions'

export interface Answer {
        answerId: number;
        questionId: Question;
        answer: string;
        correct: boolean;
    }