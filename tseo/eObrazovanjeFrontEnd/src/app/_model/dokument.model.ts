export interface Dokument{
    id: number,
    naziv: string,
    tip: string,
    data: Blob
}


export class Dokument {
    
    constructor(
        id: number,
        naziv: string,
        tip: string
    ){}

}