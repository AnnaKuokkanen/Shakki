### Tällä viikolla toteutettuja toiminnallisuuksia:

Tällä viikolla kirjoitin Javadocit kaikille sitä vaativille metodeille ja korvasin HashMap-tietorakenteen omalla tietorakenteella.
Lisäksi muokkasin bottia niin, että se voi (periaatteessa) pelata itseään vastaan. Käytännössä se kuitenkin jumittuu usein paikoilleen, 
koska samoja siirtoja pääsee tekemään edestakaisin.

### Sovelluksen tilanne

Tällä hetkellä kuninkaan shakkitilanteen tarkistaminen toimii ja botti tekee suurimmaksi osaksi laillisia siirtoja. Tornitusta 
ja nappuloiden korotusta ei kuitenkaan ole toteutettu. Laittomat siirrot johtuvat enää siitä, että nappuloiden korotusta ei ole
ohjelmassa toteutettu, mutta Xboard kuitenkin korottaa sotilaan automaattisesti kuningattareksi, jolloin botti saattaa yrittää 
liikuttaa kuningastaan laittomaan ruutuun. Huomasin myös, että olin unohtanut sisällyttää vastapuolen kuninkaan shakkitilanteen 
tarkistamisessa, mutta tämä virhe on nyt korjattu. 

### Ongelmia

Huomasin, että botti jumittuu välillä shakkitilanteissa paikoilleen, vaikka sillä olisi siirtoja. Se ei yritä tehdä väärää 
siirtoa, vaan jää paikoilleen tekemättä mitään. Kaikki nämä tilanteet ovat tulleet vastaan kun kuningas on ollut shakissa. 
Mallinsin yhden pöytätilanteista testeissä ja botti kyllä sisälsi oikeat siirrot, mutta jostain syystä pelissä se ei tee mitään.
Tämä täytyy selvittää seuraavaksi. Syynä vaikuttaa olevan algoritmi ja erityisesti tilanne, missä hakusyvyys on suurempi kuin 
olemassaolevat siirrot.

### Edit deadlinen jälkeen

Löysin algoritmista virheen, joka aiheutti NullPointerExceptionin, jos hakusyvyys oli suurempi kuin mahdollisten 
siirtojen määrä: tällöin Tile start ja Tile finish jäivät nulliksi. Tämän virheen pitäisi olla nyt korjattu. 

Lisäksi löysin virheen kuninkaan shakkitilanteen tarkistamisessa: kun vastapuolen nappuloita etsittiin vaaka- ja pystysuorassa sekä 
vinosti, tiellä oleva vastapuolen nappula ei "suojannut" shakilta vaikka todellisuudessa näin on. Tällöin esim. jos valkoisen kuninkaan 
ja mustan lähetin välissä ollut valkoinen ratsu suojasi botin mielestä kuningasta shakilta, mutta musta ratsu ei. Tämäkin ongelma pitäisi 
olla korjattu.

Olen myös huomannut, että kun ajan omaa tekoälyäni muita xboardissa olevia valmiita tekoälyjä vastaan, oma tekoälyni tekee välillä laittomia 
siirtoja. Kuitenkin kun mallinnan samat pelitilanteet testeissä, kaikki toimii. En ole keksinyt muuta selitystä kuin että oma bottini 
ehkä menee sekaisin kun vastustaja tornittaa. Tornituksessa siirto on muodossa esim. "e1g1" valkoisilla. Tämä kuvaa kuninkaan liikettä kaksi 
tai kolme ruutua sivusuunnassa. Samalla torni hyppää kuninkaan yli. Oma bottini ei kuitenkaan millään tavalla tarkista vastustajan siirtoja,
ottaa vain lähtöruudussa olleen nappulan ja siirtää sen kohderuutuun. Tornituksessa kuningas siis siirtyy, mutta tornin sijainti jää päivittymättä.

Tähän sekä nappuloiden korotukseen voisi luoda ehtolauseet vastapuolen siirrot vastaanottavaan metodiin, niin botti ei ainakaan hämäänny tornituksesta
ja nappuloiden korotuksista.

Tunteja käytetty: 14
