type Actor = {
  firstName : string,
  lastName : string
}
type Details = {
  id : string,
  details : string,
}
export class Movie {

  id? : string;
  name :string;
  year : number;
  director : string;
  actors?: Array<Actor> = [];
  details?: Details ;

  constructor(id:string,name:string, year: number,director: string) {
    this.id = id;
    this.name = name;
    this.year = year;
    this.director = director;
  }
}
