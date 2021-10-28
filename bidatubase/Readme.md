# Bigarren adibidea
Proiektu hau Spring proiektu bat da, Hibernate eta JPA bidez, datu-base birekin konektatuko dena: Bata Postgresql, bestea MariaDb.
- application.properties-en, datu-base bietara konekzioa egiteko propietateak bikoiztu egin dira. Posible litzateke eta beharbada garbiagoa bi fitxategi desberdin sortzea 
- @Config bi dauzkagu: DbKonfigIn.java eta DbKonfigOut.java 
- PersistenceContext bi dauzkagu, beraz, batek entitate batzuk, besteak beste batzuk kudeatuko ditu. Pakete desberdinetan sartuz lortuko dugu, (EntityManager bakoitzak soilik dagozkion entitateak kudeatzea)
- Aplikazio nagusian, IOC container bi (applicationContext bi), bakoitzaren zehaztasunak Konfigurazio fitxategi batek zehaztua
