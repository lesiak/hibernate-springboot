import com.example.sandbox.hibernatespringboot.HibernateSpringbootApplication;
import com.example.sandbox.hibernatespringboot.model.common.User;
import com.example.sandbox.hibernatespringboot.repo.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= HibernateSpringbootApplication.class)
public class UserRepositoryTest  {

    @Autowired
    private UserRepository repository;

    @Test
    public void testSaveAndFindAll() {


        Iterable<User> findAll = repository.findAll();

        assertThat(findAll).hasSize(1);
        //webBooking.setId(1L);
        //assertThat(findAll).containsOnly(webBooking);
    }
}