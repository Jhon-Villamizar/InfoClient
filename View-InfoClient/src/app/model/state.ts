export class State {
    constructor(id = null, name = '', countryId = null){
        this.id = id,
        this.name =name,
        this.countryId =countryId
    }
    id : number;
    name : string;
    countryId : number;
}
