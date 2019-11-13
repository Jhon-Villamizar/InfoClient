export class Client {
    constructor(id = 0, description = '', nit = '', fullname = '', adress = '', phone = '', city = '', state = '', country = '', creditlim = 0, avalcredit = 0, visitsperc = 0, date = '', representative = '', visit = 0, descVisit = ''){
        this.id = id,
        this.description =description,
        this.nit =nit,
        this.fullname =fullname,
        this.adress =adress,
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
    adress : string;
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
