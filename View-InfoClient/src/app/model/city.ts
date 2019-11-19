export class City {
    constructor(id = null, name = '', stateId = null){
        this.id = id,
        this.name =name,
        this.stateId =stateId
    }
    id : number;
    name : string;
    stateId : number;
}
