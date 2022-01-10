# Online shop
## Magazin online de postere

Aplicatia isi propune implementarea unui magazin online de postere si fotografii. Vor fi disponibile doua tipuri de utilizatori: administrator si client. 

 
- adauga/sterge/editeaza produse
- se pot introduce noi utilizatori - administrator / client
- introduce numarul de produse disponibile pentru fiecare item
- adauga comanda
- fiecare utilizator are un cos de cumparaturi in care isi poate adauga produse
- edita tipul unui uitilzator
- adauga lot nou de produse
- listeaza toti utilizatorii
- se listeaza numarut de produse disponibile fiecarui tip
- produsele sunt impartite in categorii/ se afiseaza produsele fiecarei categorii
- fiecare utilizator are o adresa
- se listeaza produsele fiecarui client


## Modul de functionare al aplicatiei

Initial se vor implementa cele doua tipuri de utilizator. 

Fiecare client are disponibil cate un cos de cumparaturi. In acesta se adauga produse de catre utilizator. In momentul plasarii comenzii, cosul de cumparaturi se goleste. De aseamena, fiecare client are asociata cate o adresa.

### Relatii
- One to one: fiecare utilizator are asociata o adresa (User - Address)
- Many to one: fiecare produs adaugat in cos este asociat unui cos (CartItem - Cart, CartItem- cart)
- One to many: fiecare produs este asociat unei categorii (Product - Category)
- One to one: fiecare comanda are asociata un cos de cumparaturi
- One to one: fiecare lot are asociat un produs
