export class Country {
    constructor(id = null, name = '', countries=[]){
        this.id = id,
        this.name =name,
        this.countries=countries
    }
    id : number;
    name : string;
    countries: any[];
}
