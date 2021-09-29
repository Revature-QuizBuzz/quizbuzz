import { LoginComponent } from "../login/login.component";

export class User {
    id: number;
    username: string;
    password: string;
    firstName: string;
    lastName: string;
    totalPoints: number;

    constructor(id:number, username:string, password:string, firstName:string, lastName:string, totalPoints:number) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.totalPoints = totalPoints;
    }

}