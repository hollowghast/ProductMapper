package com.productmapper.admin;

import com.productmapper.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.time.*;
import java.util.Arrays;
import java.util.List;

@Service
public class AdminService {
    @Autowired
    private EntityManagerFactory entityManagerFactory;


    /**
     * testing query:
     * select *
     * from address, base_product, brand, company, local_product, opening_hours, price, store;
     */
    public void insertTestData(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        List<Address> as = Arrays.asList(
                new Address("8020", "Graz", "Hans-Resel-Gasse"),
                new Address("3100", "St. Pölten", "Fuhrmannsgasse"),
                new Address("1010", "Wien", "Mariahilferstraße")
        );
        for(Address a : as) entityManager.persist(a);

        List<Company> cs = Arrays.asList(
                new Company("Billa"),
                new Company("Hofer"),
                new Company("Nah&Frisch")
        );
        for(Company c : cs) entityManager.persist(c);

        List<Store> ss = Arrays.asList(
                new Store(cs.get(0), as.get(0)),
                new Store(cs.get(1), as.get(1)),
                new Store(cs.get(2), as.get(2))
        );
        for(Store s : ss) entityManager.persist(s);

        List<Opening_Hours> ohs = Arrays.asList(
                new Opening_Hours(ss.get(0),
                        OffsetTime.of(LocalTime.of(6, 30), ZoneOffset.ofHours(2)),
                        OffsetTime.of(LocalTime.of(18, 30), ZoneOffset.ofHours(2))),
                new Opening_Hours(ss.get(1),
                        OffsetTime.of(LocalTime.of(6, 0), ZoneOffset.ofHours(2)),
                        OffsetTime.of(LocalTime.of(17, 30), ZoneOffset.ofHours(2))),
                new Opening_Hours(ss.get(2),
                        OffsetTime.of(LocalTime.of(7, 30), ZoneOffset.ofHours(2)),
                        OffsetTime.of(LocalTime.of(21, 30), ZoneOffset.ofHours(2)))
        );
        for(Opening_Hours oh : ohs) entityManager.persist(oh);

        List<Brand> bs = Arrays.asList(
                new Brand("Pepsi Co"),
                new Brand("Unilever Inc"),
                new Brand("Pringles Ltd")
        );
        for(Brand b : bs) entityManager.persist(b);

        List<Base_Product> bps = Arrays.asList(
                new Base_Product("Pepsi", bs.get(0)),
                new Base_Product("Lipton", bs.get(1)),
                new Base_Product("Pringles", bs.get(2))
        );
        for(Base_Product b : bps) entityManager.persist(b);
        
        List<Local_Product> lps = Arrays.asList(
                new Local_Product(bps.get(0), ss.get(0)),
                new Local_Product(bps.get(2), ss.get(0)),
                new Local_Product(bps.get(0), ss.get(1)),
                new Local_Product(bps.get(1), ss.get(1)),
                new Local_Product(bps.get(2), ss.get(2))
        );
        for(Local_Product l : lps) entityManager.persist(l);

        /*
        assuming that all store open at 8am, 08/20/2023 (same TZ)
         */
        List<Price> ps = Arrays.asList(
                new Price(lps.get(0), 0.98f,
                        OffsetDateTime.of(LocalDateTime.of(2023, 8, 20, 8, 0), ZoneOffset.ofHours(2)),
                        Price_Type.BASE),
                new Price(lps.get(1), 2.99f,
                        OffsetDateTime.of(LocalDateTime.of(2023, 8, 20, 8, 0), ZoneOffset.ofHours(2)),
                        Price_Type.BASE),
                new Price(lps.get(2), 1.12f,
                        OffsetDateTime.of(LocalDateTime.of(2023, 8, 20, 8, 0), ZoneOffset.ofHours(2)),
                        Price_Type.BASE),
                new Price(lps.get(3), 1.49f,
                        OffsetDateTime.of(LocalDateTime.of(2023, 8, 20, 8, 0), ZoneOffset.ofHours(2)),
                        Price_Type.BASE),
                new Price(lps.get(4), 3.84f,
                        OffsetDateTime.of(LocalDateTime.of(2023, 8, 20, 8, 0), ZoneOffset.ofHours(2)),
                        Price_Type.BASE)
        );
        for(Price p : ps) entityManager.persist(p);
        entityManager.getTransaction().commit();

        entityManager.close();

    }
}
