import {Question} from './questions'

export interface Answer {
        answerId?: number;
        question?: Question;
        answer?: string;
        correct?: boolean;
    }

