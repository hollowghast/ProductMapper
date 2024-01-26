package com.productmapper.admin;

import com.productmapper.constants.PriceType;
import com.productmapper.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.time.*;
import java.util.ArrayList;
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
                new Address("1010", "Wien", "Mariahilferstraße"),
                new Address("8020", "Graz", "Jako"),
                new Address("3100", "St. Pölten", "Europaplatz"),
                new Address("1010", "Wien", "Marxergasse"),
                new Address("8020", "Graz", "Griesplatz"),
                new Address("3100", "St. Pölten", "Wiener Straße"),
                new Address("1010", "Wien", "Freyung"),
                new Address("8020", "Graz", "Elisabethstraße"),
                new Address("3100", "St. Pölten", "Waldstraße"),
                new Address("1010", "Wien", "Martinstraße")
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
                new Store(cs.get(1), as.get(0)),
                new Store(cs.get(2), as.get(0)),
                new Store(cs.get(0), as.get(1)),
                new Store(cs.get(1), as.get(1)),
                new Store(cs.get(2), as.get(1)),
                new Store(cs.get(0), as.get(2)),
                new Store(cs.get(1), as.get(2)),
                new Store(cs.get(2), as.get(2)),
                new Store(cs.get(0), as.get(3)),
                new Store(cs.get(1), as.get(3)),
                new Store(cs.get(2), as.get(3)),
                new Store(cs.get(0), as.get(4)),
                new Store(cs.get(1), as.get(4)),
                new Store(cs.get(2), as.get(4)),
                new Store(cs.get(0), as.get(5)),
                new Store(cs.get(1), as.get(5)),
                new Store(cs.get(2), as.get(5)),
                new Store(cs.get(0), as.get(6)),
                new Store(cs.get(1), as.get(6)),
                new Store(cs.get(2), as.get(6)),
                new Store(cs.get(0), as.get(7)),
                new Store(cs.get(1), as.get(7)),
                new Store(cs.get(2), as.get(7)),
                new Store(cs.get(0), as.get(8)),
                new Store(cs.get(1), as.get(8)),
                new Store(cs.get(2), as.get(8)),
                new Store(cs.get(0), as.get(9)),
                new Store(cs.get(1), as.get(9)),
                new Store(cs.get(2), as.get(9)),
                new Store(cs.get(0), as.get(10)),
                new Store(cs.get(1), as.get(10)),
                new Store(cs.get(2), as.get(10)),
                new Store(cs.get(0), as.get(11)),
                new Store(cs.get(1), as.get(11)),
                new Store(cs.get(2), as.get(11)),
                new Store(cs.get(0), as.get(12)),
                new Store(cs.get(1), as.get(12)),
                new Store(cs.get(2), as.get(12)),
                new Store(cs.get(0), as.get(13)),
                new Store(cs.get(1), as.get(13)),
                new Store(cs.get(2), as.get(13))
        );
        for(Store s : ss) entityManager.persist(s);

        //default opening hours
        /*
        List<OpeningHours> ohs = ()->{
            List<Store> oh = new ArrayList<>();
            for(OpeningHours oh : ss){
                oh.add(new OpeningHours(s,
                        OffsetTime.of(LocalTime.of(8, 0), ZoneOffset.ofHours(2)),
                        OffsetTime.of(LocalTime.of(18, 00), ZoneOffset.ofHours(2)),
                        LocalDate.now()));
            };
        return oh;
        };
        for(OpeningHours oh : ohs) entityManager.persist(oh);
        */

        List<Brand> bs = Arrays.asList(
                new Brand("Pepsi Co"),
                new Brand("Unilever Inc"),
                new Brand("Pringles Ltd")
        );
        for(Brand b : bs) entityManager.persist(b);

        List<BaseProduct> bps = Arrays.asList(
                new BaseProduct("Pepsi", bs.get(0)),
                new BaseProduct("Lipton", bs.get(1)),
                new BaseProduct("Pringles", bs.get(2))
        );
        for(BaseProduct b : bps) entityManager.persist(b);
        
        List<LocalProduct> lps = Arrays.asList(
                new LocalProduct(bps.get(0), ss.get(0)),
                new LocalProduct(bps.get(2), ss.get(0)),
                new LocalProduct(bps.get(0), ss.get(1)),
                new LocalProduct(bps.get(1), ss.get(1)),
                new LocalProduct(bps.get(2), ss.get(2))
        );
        for(LocalProduct l : lps) entityManager.persist(l);

        /*
        assuming that all store open at 8am, 08/20/2023 (same TZ)
         */
        List<Price> ps = Arrays.asList(
                new Price(lps.get(0), 0.98f,
                        OffsetDateTime.of(LocalDateTime.of(2023, 8, 20, 8, 0), ZoneOffset.ofHours(2)),
                        PriceType.BASE),
                new Price(lps.get(1), 2.99f,
                        OffsetDateTime.of(LocalDateTime.of(2023, 8, 20, 8, 0), ZoneOffset.ofHours(2)),
                        PriceType.BASE),
                new Price(lps.get(2), 1.12f,
                        OffsetDateTime.of(LocalDateTime.of(2023, 8, 20, 8, 0), ZoneOffset.ofHours(2)),
                        PriceType.BASE),
                new Price(lps.get(3), 1.49f,
                        OffsetDateTime.of(LocalDateTime.of(2023, 8, 20, 8, 0), ZoneOffset.ofHours(2)),
                        PriceType.BASE),
                new Price(lps.get(4), 3.84f,
                        OffsetDateTime.of(LocalDateTime.of(2023, 8, 20, 8, 0), ZoneOffset.ofHours(2)),
                        PriceType.BASE)
        );
        for(Price p : ps) entityManager.persist(p);
        entityManager.getTransaction().commit();

        entityManager.close();

    }

    public void importStore(MultipartFile file) {
        ListUtils.partition(ListUtils.emptyIfNull(storeCsvConverterService.readFromCSVFile(file)), 5)
                .forEach(this::importShopBatch);
    }

    @Transactional
    private void importShopBatch(List<Store> stores) {
        stores.forEach(storeRepository::save);
    }

    public void indexProductForCode(Long id) throws SolrServerException, IOException {
        solrService.indexBaseProduct(entityManagerFactory.createEntityManager().find(BaseProduct.class, id));
    }
}
