-- SQL --> ZADANIE NR 1

create table pracownicy (
 id int auto_increment primary key,
 imie  varchar (50),
 nazwisko varchar (50) not null,
 wyplata decimal (15,2),
 data_urodzenia date,
 stanowisko varchar(50)
 );

insert into pracownicy values
     (1, 'Katarzyna', 'Kozak', 7777.00, '1965-01-01', 'programista'), 
     (2, 'Agnieszka', 'Ząbek', 7777.00, '1970-01-01', 'programista'), 
     (3, 'Izabella', 'Chrzęszczyk', 8888.00, '1975-01-01', 'scrum master'), 
     (4, 'Barbara', 'Odważna', 3333.00, '1980-01-01', 'tester'), 
     (5, 'Maja', 'Szalona', 3333.00, '1985-01-01', 'tester'), 
     (6, 'Nina', 'Radosna', 3333.00, '1990-01-01', 'tester'),
     
select * from pracownicy order by nazwisko;

select * from pracownicy where stanowisko = 'tester';

select * from pracownicy where extract(year from now()) - extract(year from data_urodzenia) >= 30;

update pracownicy set wyplata = wyplata * 1.1 where stanowisko = 'tester';

delete from pracownicy where data_urodzenia = (select max(data_urodzenia) from pracownicy); 



-- SQL --> ZADANIE NR 2

create table pracownicy (
 id int auto_increment primary key,
 imie  varchar (50),
 nazwisko varchar (50) not null,
 id_stanowisko int,
 id_adres int
 );

  create table stanowiska (
 id int auto_increment primary key,
 stanowisko  varchar (50) not null,
 opis varchar (50),
 wyplata decimal (15,2),
 );
 
create table adres (
 id int auto_increment primary key,
 kod_pocztowy int,
 miejscowosc varchar(50),
 ulica_i_numer_lokalu varchar(40),
 );
 
insert into pracownicy(id, imie, nazwisko, id_stanowisko, id_adres) values 
	(1001, 'Katarzyna', 'Kozak', 2001, 3001), 
	(1002, 'Izabella', 'Chrzęszczyk' 2002, 3002), 
    (1003, 'Barbara',' Odważna' 2003, 3003);
	
insert into stanowiska(id, stanowisko, opis, wyplata) values 
	(2001, 'programista', 'wysokie ryzyko utraty kluczowego pracownika', 7777.00), 
	(2002, 'scrum master', 'niski poziom ryzyka odejścia', 8888.00), 
    (2003, 'tester', 'nadmiarowa ilość pracowników', 3333.00);
	
insert into adresy(id, kod_pocztowy, miejscowosc, ulica_i_numer_lokalu) values 
	(3001, 54438, 'Wrocław', 'Rogowska 1/1'), 
	(3002, 59101, 'Polkowice', 'Miedziana 2/2'), 
    (3003, 90210 , 'Łódź', 'Rybacka 3/3');
 	
select p.imie, p.nazwisko, a.kod_pocztowy, a.miejscowosc, a.ulica_i_numer_lokalu, s.stanowisko, s.opis, s.wyplata
from pracownicy p
left join stanowiska s on p.id_stanowisko = s.id
left join adresy a on p.id_adres = a.id;

select sum(wyplata) as MiesiecznaSumaWyplatPracownikow from stanowiska;

select p.* from pracownicy p
join adresy a on a.id = p.id_adres
where a.kod_pocztowy = 	90210;
