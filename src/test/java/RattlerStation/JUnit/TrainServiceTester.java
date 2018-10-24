package RattlerStation.JUnit;

import com.slandshow.DTO.TrainDTO;
import com.slandshow.configuration.HibernateConfig;
import com.slandshow.configuration.SecurityApplicationInitializer;
import com.slandshow.exceptions.BusinessLogicException;
import com.slandshow.exceptions.ExceptionsInfo;
import com.slandshow.models.Train;
import com.slandshow.service.TrainService;
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
public class TrainServiceTester {

    Train train;
    TrainDTO trainDTO;

    @Autowired
    private TrainService trainService;

    @Before
    public void setUp() {
        train = new Train();
        trainDTO = new TrainDTO();

    }

    @Test
    public void addNotUniqueTrain() {
        trainDTO.setName("Aqua");
        try {
            trainService.add(trainDTO);
        } catch (Exception e) {
            if (e instanceof BusinessLogicException) {
                Assert.assertEquals(ExceptionsInfo.TRAIN_IS_ALREADY_USED, ((BusinessLogicException) e).getErrorMessage());
            }
        }
    }

    @Test
    public void addTrainWithWrongParameters() {
        trainDTO.setName("Aqua2");
        trainDTO.setCarriageCount(-1);
        try {
            trainService.add(trainDTO);
        } catch (Exception e) {
            if (e instanceof BusinessLogicException) {
                Assert.assertEquals(ExceptionsInfo.INVALID_CARRIAGE_COUNT, ((BusinessLogicException) e).getErrorMessage());
            }
        }
    }

    @Test
    public void deleteNull() {
        try {
            trainService.delete("Keep your waiting, huh?");
        } catch (Exception e) {
            if (e instanceof BusinessLogicException) {
                Assert.assertEquals(ExceptionsInfo.TRAIN_IS_NULL, ((BusinessLogicException) e).getErrorMessage());
            }
        }
    }

    @Test
    public void deleteInvalid() {
        try {
            trainService.delete("Spb trains #1");
        } catch (Exception e) {
            if (e instanceof BusinessLogicException) {
                Assert.assertEquals(ExceptionsInfo.CANNOT_DELETE_INVALID_TRAIN, ((BusinessLogicException) e).getErrorMessage());
            }
        }
    }

    @Test
    public void updateNotUniqueTrain() {
        trainDTO.setName("Aqua");
        trainDTO.setNewName("Mars");
        try {
            trainService.update(trainDTO);
        } catch (Exception e) {
            if (e instanceof BusinessLogicException) {
                Assert.assertEquals(ExceptionsInfo.TRAIN_IS_NOT_UNIQUE, ((BusinessLogicException) e).getErrorMessage());
            }
        }
    }

    @Test
    public void getAll() {
        Assert.assertTrue(trainService.getAll().size() > 0);
    }

    @Test
    public void getAllTrains() {
        Assert.assertTrue(trainService.getAllTrains().size() > 0);
    }

    @Test
    public void getById() {
        Assert.assertNotNull(trainService.getById(3L));
    }

    @Test
    public void getByName() {
        Assert.assertNotNull(trainService.getByName("Aqua"));
    }

    @Test
    public void getLastPositionTrain() {
        Assert.assertNotNull(trainService.getLastPositionTrain());
    }

    @Test
    public void getAllDeletedTrains() {
        Assert.assertTrue(trainService.getAllDeletedTrains().size() > 0);
    }

    @Test
    public void getTrainsName() {
        Assert.assertTrue(trainService.getTrainsName().size() > 0);
    }
}
