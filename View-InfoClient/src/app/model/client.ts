import { Country } from './country';

export class Client {
    constructor(id = null, description = '', nit = '', name = '', address = '', phone = '', city = null, state = null, country = null, creditlim = null, avalcredit = null, visitsperc = null, date = '', representative = '', visit = null, descVisit = '',countries=[]){
        this.id = id,
        this.description =description,
        this.nit =nit,
        this.name =name,
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
        this.descVisit =descVisit,
        this.countries=countries
    }
    id : number;
    description : string;
    nit : string;
    name : string;
    address : string;
    phone : string;
    city : number;
    state : number;
    country : number;
    creditlim : number;
    avalcredit : number;
    visitsperc : number;
    date : string;
    representative : string;
    visit : number;
    descVisit : string;
    countries : Array<Country>;
}
