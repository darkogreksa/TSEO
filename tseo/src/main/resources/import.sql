INSERT INTO ispitni_rokovi (naziv, datum_pocetka, datum_zavrsetka) VALUES ('Januarski', '2021-01-15', '2021-01-31');
INSERT INTO ispitni_rokovi (naziv, datum_pocetka, datum_zavrsetka) VALUES ('Februarski', '2021-02-01', '2019-02-20');
INSERT INTO ispitni_rokovi (naziv, datum_pocetka, datum_zavrsetka) VALUES ('Junski', '2021-06-14', '2019-06-30');
INSERT INTO ispitni_rokovi (naziv, datum_pocetka, datum_zavrsetka) VALUES ('Julski', '2021-07-01', '2021-07-20');
INSERT INTO ispitni_rokovi (naziv, datum_pocetka, datum_zavrsetka) VALUES ('Septembarski', '2021-09-01', '2021-09-20');

INSERT INTO korisnici (datum, lozinka, korisnicko_ime) VALUES ('2021-06-10', '123', 'a');
INSERT INTO korisnici (datum, lozinka, korisnicko_ime) VALUES ('2021-06-10', '123', 'b');

INSERT INTO studenti (ime, prezime, jmbg, mesto, smer, br_indeksa) VALUES ('Pera', 'Peric', '0203569371826','Novi Sad', 'SIIT', 'sf012016');
INSERT INTO studenti (ime, prezime, jmbg, mesto, smer, br_indeksa, korisnik) VALUES ('Marko', 'Markovic', '2304879312456', 'Beograd', 'E1', 'e122018', 1);

INSERT INTO nastavnici (ime, prezime, jmbg, mesto, obrisan) VALUES ('Lazar', 'Lazarevic', '5203493876301', 'Novi Sad', false);
INSERT INTO nastavnici (ime, prezime, jmbg, mesto, obrisan, korisnik) VALUES ('Mira', 'Markovic', '7954316278934', 'Novi Sad', false, 1);

INSERT INTO uplate (iznos, datum, student_id, obrisan) VALUES (4000, '2021-06-10', 1, false);
INSERT INTO uplate (iznos, datum, student_id, obrisan) VALUES (2000, '2021-06-10', 2, false);

INSERT INTO predmet (naziv, espb, sifra_predmeta, godina, smer) VALUES ('Osnove programiranja', '8', 'SIT03', 1, 1);
INSERT INTO predmet (naziv, espb, sifra_predmeta, godina, smer) VALUES ('Platforme za objektno programiranje', '8', 'SIT020', 2, 1);
INSERT INTO predmet (naziv, espb, sifra_predmeta, godina, smer) VALUES ('Tehnologije i sistemi eObrazovanja', '6', 'SIT333', 3, 1);

INSERT INTO izvedbe (pocetak, kraj, obrisan, predmet_id) VALUES ('2021-01-20', '2021-06-15', false, 1);
INSERT INTO izvedbe (pocetak, kraj, obrisan, predmet_id) VALUES ('2021-01-20', '2021-06-15', false, 2);
INSERT INTO izvedbe (pocetak, kraj, obrisan, predmet_id) VALUES ('2021-01-20', '2021-06-15', false, 3);

INSERT INTO predavanja (obrisan, izvedba_id, nastavnik_id) VALUES (false, 1, 1);
INSERT INTO predavanja (obrisan, izvedba_id, nastavnik_id) VALUES (false, 3, 1);
INSERT INTO predavanja (obrisan, izvedba_id, nastavnik_id) VALUES (false, 2, 2);

INSERT INTO ispit (datum, ucionica, vrsta, predmet_id, rok_id) VALUES ('2021-06-21', 'JUG112', 'Ispit', 1, 3);
INSERT INTO ispit (datum, ucionica, vrsta, predmet_id, rok_id) VALUES ('2021-06-24', 'JUG103', 'Kolokvijum', 2, 3);

INSERT INTO izlasci (bodovi, ocena, polozio, ispit_id, student_id ) VALUES (81, 8, true, 1, 1);
INSERT INTO izlasci (bodovi, ocena, polozio, ispit_id, student_id ) VALUES (20, 5, false, 2, 1);

INSERT INTO pohadjanja(izvedba_id, student_id, obrisan) VALUES (1,1,false);
INSERT INTO pohadjanja(izvedba_id, student_id, obrisan) VALUES (2,1,false);
INSERT INTO pohadjanja(izvedba_id, student_id, obrisan) VALUES (2,2,false);