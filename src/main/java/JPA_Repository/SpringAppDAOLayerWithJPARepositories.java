package JPA_Repository;

import JPA_Repository.model.Person;
import JPA_Repository.model.PersonPrimaryKey;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringAppDAOLayerWithJPARepositories implements CommandLineRunner {
    @PersistenceContext
    private EntityManager entityManager;


    public static void main(String[] args) {

        SpringApplication application = new SpringApplication(SpringAppDAOLayerWithJPARepositories.class);
        application.run(args);
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        //feelTheTable();
    }

    @Transactional
    public void feelTheTable() {
        Person firstPerson = Person.builder()
                .personPrimaryKey(PersonPrimaryKey.builder().age(25).name("Nikola").surname("Holopenya").build())
                .city("Moscow")
                .phone("2123311")
                .build();
        entityManager.persist(firstPerson);

        Person secondPerson = Person.builder()
                .personPrimaryKey(PersonPrimaryKey.builder().age(56).name("Sofa").surname("Solochak").build())
                .city("London")
                .phone("421124")
                .build();
        entityManager.persist(secondPerson);

        Person thirdPerson = Person.builder()
                .personPrimaryKey(PersonPrimaryKey.builder().age(21).name("Bolon").surname("Derraw").build())
                .city("Moscow")
                .phone("990012")
                .build();
        entityManager.persist(thirdPerson);

        Person fourthPerson = Person.builder()
                .personPrimaryKey(PersonPrimaryKey.builder().age(12).name("Kris").surname("NOlf").build())
                .city("Moscow")
                .phone("212331212")
                .build();
        entityManager.persist(fourthPerson);

        Person fifthPerson = Person.builder()
                .personPrimaryKey(PersonPrimaryKey.builder().age(87).name("Bakka").surname("Nox").build())
                .city("SPB")
                .phone("992912213")
                .build();
        entityManager.persist(fifthPerson);
    }
}
