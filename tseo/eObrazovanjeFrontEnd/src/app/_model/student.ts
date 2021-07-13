import { Korisnik } from './korisnik.model';

export interface Student{
    id: number,
    ime: string,
    prezime: string,
    jmbg: string,
    mestoStanovanja: string,
    smer: string,
    brIndeksa: string,
    korisnik: any
}


export class Student {
    
    constructor(
    id: number,
    ime: string,
    prezime: string,
    jmbg: string,
    mestoStanovanja: string,
    smer: string,
    brIndeksa: string,
    korisnik: Korisnik
    ){}

}
