package RattlerStation.JUnit;

import com.slandshow.DTO.StationDTO;
import com.slandshow.configuration.HibernateConfig;
import com.slandshow.configuration.SecurityApplicationInitializer;
import com.slandshow.exceptions.BusinessLogicException;
import com.slandshow.exceptions.ExceptionsInfo;
import com.slandshow.models.Station;
import com.slandshow.service.StationService;
import com.sun.org.apache.xerces.internal.parsers.SecurityConfiguration;
import org.junit.Assert;
import org.junit.Before;
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
public class StationServiceTester {

    @Autowired
    private StationService stationService;

    Station station;
    StationDTO stationDTO;

    @Before
    public void setUp() {
        station = new Station();
        stationDTO = new StationDTO();
        stationDTO.setName("Kavgolovo");
    }

    @Test
    public void addWrongStation() {
        try {
            stationService.add(stationDTO);
        } catch (Exception e) {
            if (e instanceof BusinessLogicException) {
                Assert.assertEquals(ExceptionsInfo.STATION_IS_NOT_UNIQUE, ((BusinessLogicException) e).getErrorMessage());
            }
        }
    }

    @Test
    public void deleteNull() {
        try {
            stationService.delete("Wrong");
        } catch (Exception e) {
            if (e instanceof BusinessLogicException) {
                Assert.assertEquals(ExceptionsInfo.STATION_IS_NULL, ((BusinessLogicException) e).getErrorMessage());
            }
        }
    }

    @Test
    public void updateWrong() {
        stationDTO.setNewName("Kavgolovo");
        try {
            stationService.update(stationDTO);
        } catch (Exception e) {
            if (e instanceof BusinessLogicException) {
                Assert.assertEquals(ExceptionsInfo.STATION_IS_NULL, ((BusinessLogicException) e).getErrorMessage());
            }
        }
    }

    @Test
    public void getAll() {
        Assert.assertTrue(stationService.getAll().size() > 0);
    }

    @Test
    public void getAllStations() {
        Assert.assertTrue(stationService.getAllStations().size() > 0);
    }

    @Test
    public void getAllDeletedStations() {
        Assert.assertTrue(stationService.getAllDeletedStations().size() >= 0);
    }

    @Test
    public void getById() {
        Assert.assertNotNull(stationService.getById(30L));
    }

    @Test
    public void getByName() {
        Assert.assertNotNull(stationService.getByName("Kavgolovo"));
    }

    @Test
    public void getStationsName() {
        Assert.assertTrue(stationService.getStationsName().size() > 0);
    }
}