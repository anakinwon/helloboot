package tobyspring.helloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Transactional
public class HelloRepositoryTest {
    @Autowired JdbcTemplate jdbcTemplate;
    @Autowired HelloRepository helloRepository;

    @Test
    void findHelloFailed() {

        System.out.println("\n\nhelloRepository.findHello(Toby)) = " + helloRepository.findHello("Toby")+"\n\n");

        assertThat(helloRepository.findHello("Toby")).isNull();
    }

    @Test
    void incraseCount() {

        assertThat(helloRepository.countOf("Toby")).isEqualTo(0);
        System.out.println("\n1. helloRepository.countOf(Toby)) = " + helloRepository.countOf("Toby")+"\n");

        helloRepository.increaseCount("Toby");
        assertThat(helloRepository.countOf("Toby")).isEqualTo(1);
        System.out.println("\n2. helloRepository.countOf(Toby)) = " + helloRepository.countOf("Toby")+"\n");

        helloRepository.increaseCount("Toby");
        assertThat(helloRepository.countOf("Toby")).isEqualTo(2);
        System.out.println("\n3. helloRepository.countOf(Toby)) = " + helloRepository.countOf("Toby")+"\n");
    }

}
