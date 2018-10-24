package RattlerStation.JUnit;


import com.slandshow.configuration.HibernateConfig;
import com.slandshow.configuration.SecurityApplicationInitializer;
import com.slandshow.service.RoleService;
import com.sun.org.apache.xerces.internal.parsers.SecurityConfiguration;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {HibernateConfig.class, SecurityConfiguration.class, SecurityApplicationInitializer.class})
@ActiveProfiles("test")

@WebAppConfiguration
public class RoleServiceTester {

    @Autowired
    private RoleService roleService;

    @Test
    public void getRole() {
        Assert.assertNotNull(roleService.getRole());
    }
}
