import {Question} from './questions'

export interface Answer {
        id?: number;
        question?: Question;
        answer?: string;
        correct?: boolean;
    }
