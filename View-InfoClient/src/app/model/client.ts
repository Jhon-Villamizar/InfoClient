export class Client {
    constructor(id = null, description = '', nit = '', fullname = '', address = '', phone = '', city = '', state = '', country = '', creditlim = null, avalcredit = null, visitsperc = null, date = '', representative = '', visit = null, descVisit = ''){
        this.id = id,
        this.description =description,
        this.nit =nit,
        this.fullname =fullname,
        this.address =address,
        this.phone =phone,
        this.city =city,
        this.state =state,
        this.country =country,
        this.creditlim =creditlim,
        this.avalcredit =avalcredit,
        this.visitsperc =visitsperc,
        this.date =date,
        this.representative =representative,
        this.visit =visit,
        this.descVisit =descVisit
    }
    id : number;
    description : string;
    nit : string;
    fullname : string;
    address : string;
    phone : string;
    city : string;
    state : string;
    country : string;
    creditlim : number;
    avalcredit : number;
    visitsperc : number;
    date : string;
    representative : string;
    visit : number;
    descVisit : string
}
