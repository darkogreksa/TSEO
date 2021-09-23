
INSERT INTO studenti (ime, prezime, jmbg, mesto, smer, br_indeksa,korisnik) VALUES ('Ljubica', 'Ljubicic', '98565978', 'Subotica', 'GRID', 'gr9', 3);
INSERT INTO studenti (ime, prezime, jmbg, mesto, smer, br_indeksa) VALUES ('Jana', 'Janic', '23564964', 'Beograd', 'E1', 'e25');
INSERT INTO studenti (ime, prezime, jmbg, mesto, smer, br_indeksa) VALUES ('Darko', 'Greksa', '23564964', 'Sid', 'SIIT', 'sf24');


INSERT INTO authority (name) VALUES ('ADMIN');
INSERT INTO authority (name) VALUES ('STUDENT');
INSERT INTO authority (name) VALUES ('NASTAVNIK');

INSERT INTO nastavnici (ime, prezime, korisnik, jmbg, mesto, obrisan) VALUES ('Petar', 'Petrovic', 2, '2415511234567', 'Novi Sad', false);
INSERT INTO nastavnici (ime, prezime, jmbg, mesto, obrisan) VALUES ('Ana', 'Markovic', '4156112345678', 'Novi Sad', false );
UPDATE `eobrazovanje`.`nastavnici` SET `korisnik`='2' WHERE  `id`=1;

INSERT INTO uplate (datum, iznos, obrisan, student_id) VALUES ('2019-01-03', 15000, false, 1);
INSERT INTO uplate (datum, iznos, obrisan, student_id) VALUES ('2019-02-03', 10000, false, 2);
INSERT INTO uplate (datum, iznos, obrisan, student_id) VALUES ('2019-03-03', 12000, false, 3);

INSERT INTO korisnici (datum, lozinka, korisnicko_ime) VALUES ('2019-03-03', '$2a$10$uAJxjAToe7LUtqZMEXrZsOB5bgjisBcMBztDSaQ1kzj/A2xnpg41y', 'a');
INSERT INTO korisnici (datum, lozinka, korisnicko_ime) VALUES ('2019-03-03', '$2a$10$uAJxjAToe7LUtqZMEXrZsOB5bgjisBcMBztDSaQ1kzj/A2xnpg41y', 'b');
INSERT INTO korisnici (datum, lozinka, korisnicko_ime) VALUES ('2019-03-03', '$2a$10$uAJxjAToe7LUtqZMEXrZsOB5bgjisBcMBztDSaQ1kzj/A2xnpg41y', 'c');

INSERT INTO predmet (espb, naziv, sifra_predmeta, godina, smer) VALUES ('4', 'Engleski 1', 'SIT01', 2021, 1);
INSERT INTO predmet (espb, naziv, sifra_predmeta, godina, smer) VALUES ('8', 'Matematika 1', 'SIT02', 2021, 1);
INSERT INTO predmet (espb, naziv, sifra_predmeta, godina, smer) VALUES ('8', 'Osnove programiranja', 'SIT03', 2021, 1);
INSERT INTO predmet (espb, naziv, sifra_predmeta, godina, smer) VALUES ('6', 'Osnove racunara', 'SIT04', 2021, 1);
INSERT INTO predmet (espb, naziv, sifra_predmeta, godina, smer) VALUES ('4', 'Osnove organizacije i menadzmenta', 'SIT05', 2021, 1);
INSERT INTO predmet (espb, naziv, sifra_predmeta, godina, smer) VALUES ('8', 'Matematika 2', 'SIT06', 2021, 1);
INSERT INTO predmet (espb, naziv, sifra_predmeta, godina, smer) VALUES ('4', 'Engleski 2', 'SIT07', 2021, 1);
INSERT INTO predmet (espb, naziv, sifra_predmeta, godina, smer) VALUES ('8', 'Uvod u objektno programiranje', 'SIT08', 2021, 1);
INSERT INTO predmet (espb, naziv, sifra_predmeta, godina, smer) VALUES ('5', 'Uvod u razvoj softvera', 'SIT010', 2021, 1);
INSERT INTO predmet (espb, naziv, sifra_predmeta, godina, smer) VALUES ('6', 'Sistemski softver', 'SIT011', 2021, 1);
INSERT INTO predmet (espb, naziv, sifra_predmeta, godina, smer) VALUES ('6', 'Web dizajn', 'ISIT2D', 2021, 1);
INSERT INTO predmet (espb, naziv, sifra_predmeta, godina, smer) VALUES ('8', 'Platforme za objektno programiranje', 'SIT020', 2021, 1);
INSERT INTO predmet (espb, naziv, sifra_predmeta, godina, smer) VALUES ('6', 'Internet mreze', 'SIT021', 2021, 1);
INSERT INTO predmet (espb, naziv, sifra_predmeta, godina, smer) VALUES ('6', 'Osnove baza podataka', 'SIT022', 2021, 1);
INSERT INTO predmet (espb, naziv, sifra_predmeta, godina, smer) VALUES ('6', 'Osnove web programiranja', 'SIT023', 2021, 1);
INSERT INTO predmet (espb, naziv, sifra_predmeta, godina, smer) VALUES ('4', 'Upravljanje projektima', 'SIT026', 2021, 1);
INSERT INTO predmet (espb, naziv, sifra_predmeta, godina, smer) VALUES ('6', 'Osnove softverskih arhitektura', 'SIT027', 2021, 1);
INSERT INTO predmet (espb, naziv, sifra_predmeta, godina, smer) VALUES ('4', 'Informaciona bezbednost', 'SIT028', 2021, 1);
INSERT INTO predmet (espb, naziv, sifra_predmeta, godina, smer) VALUES ('8', 'XML tehnologije', 'SIT029', 2021, 1);
INSERT INTO predmet (espb, naziv, sifra_predmeta, godina, smer) VALUES ('6', 'Programiranje mobilnih sistema i uredjaja', 'SIT02B', 2021, 1);


INSERT INTO izvedbe (pocetak, kraj, obrisan, predmet_id) VALUES ('2021-01-20', '2021-06-15', false, 1);
INSERT INTO izvedbe (pocetak, kraj, obrisan, predmet_id) VALUES ('2021-01-20', '2021-06-15', false, 2);
INSERT INTO izvedbe (pocetak, kraj, obrisan, predmet_id) VALUES ('2021-01-20', '2021-06-15', false, 3);
INSERT INTO izvedbe (pocetak, kraj, obrisan, predmet_id) VALUES ('2021-01-20', '2021-06-15', false, 4);
INSERT INTO izvedbe (pocetak, kraj, obrisan, predmet_id) VALUES ('2021-01-20', '2021-06-15', false, 5);
INSERT INTO izvedbe (pocetak, kraj, obrisan, predmet_id) VALUES ('2021-01-20', '2021-06-15', false, 6);

INSERT INTO predavanja (obrisan, izvedba_id, nastavnik_id) VALUES (false, 1, 1);
INSERT INTO predavanja (obrisan, izvedba_id, nastavnik_id) VALUES (false, 3, 1);
INSERT INTO predavanja (obrisan, izvedba_id, nastavnik_id) VALUES (false, 2, 2);
INSERT INTO predavanja (obrisan, izvedba_id, nastavnik_id) VALUES (false, 4, 1);
INSERT INTO predavanja (obrisan, izvedba_id, nastavnik_id) VALUES (false, 5, 1);

INSERT INTO ispitni_rokovi (naziv, datum_pocetka, datum_zavrsetka) VALUES ('januarski', '2021-01-20', '2021-02-10');
INSERT INTO ispitni_rokovi (naziv, datum_pocetka, datum_zavrsetka) VALUES ('februarski', '2021-02-11', '2021-02-28');
INSERT INTO ispitni_rokovi (naziv, datum_pocetka, datum_zavrsetka) VALUES ('junski', '2021-06-11', '2021-06-30');
INSERT INTO ispitni_rokovi (naziv, datum_pocetka, datum_zavrsetka) VALUES ('julski', '2021-07-01', '2021-07-14');
INSERT INTO ispitni_rokovi (naziv, datum_pocetka, datum_zavrsetka) VALUES ('septembarski', '2021-09-01', '2021-09-14');

INSERT INTO ispit (datum, ucionica, vrsta, predmet_id, rok_id) VALUES ('2021-06-21', 'JUG112', 'Ispit', 1, 1);
INSERT INTO ispit (datum, ucionica, vrsta, predmet_id, rok_id) VALUES ('2021-06-14', 'JUG103', 'Kolokvijum', 3, 1);
INSERT INTO ispit (datum, ucionica, vrsta, predmet_id, rok_id) VALUES ('2021-06-22', 'A2', 'Ispit', 2, 2);
INSERT INTO ispit (datum, ucionica, vrsta, predmet_id, rok_id) VALUES ('2021-06-22', 'A2', 'Ispit', 5, 2);
INSERT INTO ispit (datum, ucionica, vrsta, predmet_id, rok_id) VALUES ('2021-06-22', 'A2', 'Ispit', 6, 1);
INSERT INTO ispit (datum, ucionica, vrsta, predmet_id, rok_id) VALUES ('2021-06-22', 'A2', 'Kolokvijum', 4, 1);
INSERT INTO ispit (datum, ucionica, vrsta, predmet_id, rok_id) VALUES ('2021-06-22', 'A2', 'Kolokvijum', 5, 1);
INSERT INTO ispit (datum, ucionica, vrsta, predmet_id, rok_id) VALUES ('2021-06-22', 'A2', 'Ispit', 5, 1);


INSERT INTO izlasci (bodovi, ocena, polozio, ispit_id, student_id ) VALUES (80, null, null, 1, 1);
INSERT INTO izlasci (bodovi, ocena, polozio, ispit_id, student_id ) VALUES (20, 5, false, 2, 1);
INSERT INTO izlasci (bodovi, ocena, polozio, ispit_id, student_id ) VALUES (50, 6, true, 3, 2);
INSERT INTO izlasci (bodovi, ocena, polozio, ispit_id, student_id ) VALUES (50, 6, false, 2, 3);
INSERT INTO izlasci (bodovi, ocena, polozio, ispit_id, student_id ) VALUES (50, 6, false, 3, 3);
INSERT INTO izlasci (bodovi, ocena, polozio, ispit_id, student_id ) VALUES (61, 7, true, 3, 1);
INSERT INTO izlasci (bodovi, ocena, polozio, ispit_id, student_id ) VALUES (85, 9, true, 1, 1);

INSERT INTO user_authority (user_id, authority_id) VALUES (1, 1);
INSERT INTO user_authority (user_id, authority_id) VALUES (3, 2);
INSERT INTO user_authority (user_id, authority_id) VALUES (2, 3);


INSERT INTO pohadjanja(izvedba_id, student_id, obrisan) VALUES (1,1,false);
INSERT INTO pohadjanja(izvedba_id, student_id, obrisan) VALUES (2,1,false);
INSERT INTO pohadjanja(izvedba_id, student_id, obrisan) VALUES (2,2,false);
INSERT INTO pohadjanja(izvedba_id, student_id, obrisan) VALUES (3,3,false);
INSERT INTO pohadjanja(izvedba_id, student_id, obrisan) VALUES (3,1,false);
INSERT INTO pohadjanja(izvedba_id, student_id, obrisan) VALUES (4,1,false);
INSERT INTO pohadjanja(izvedba_id, student_id, obrisan) VALUES (5,1,false);