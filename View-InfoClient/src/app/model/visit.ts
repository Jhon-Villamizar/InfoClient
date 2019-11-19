export class Visit {
    constructor(clientId = null, date = null, srId = '', net = '', visitTotal = '', description = null){
        this.clientId = clientId,
        this.date =date,
        this.srId =srId,
        this.net =net,
        this.visitTotal =visitTotal,
        this.description =description
    }
    clientId : number;
    date : Date;
    srId : string;
    net : string;
    visitTotal : string;
    description : number;
}
