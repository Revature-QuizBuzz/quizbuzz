import { User } from "./user";

export class Quiz {
    id: number;
    name: string;
    description: string;
    totalScore: number;
    createdDate: Date;
    dateModified: Date;
    user: User;
    scores: Scores[];
    tags: QuizTag[];

    constructor(id:number, name:string, description:string, totalScore:number, createdDate:Date, dateModified:Date, user:User, scores:Scores[], tags:QuizTag[]) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.totalScore = totalScore;
        this.createdDate = createdDate;
        this.dateModified = dateModified;
        this.user = user;
        this.scores = scores;
        this.tags = tags;
    }
}