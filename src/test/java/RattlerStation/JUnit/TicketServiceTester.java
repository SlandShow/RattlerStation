package RattlerStation.JUnit;

import com.slandshow.DTO.SeatDTO;
import com.slandshow.DTO.TicketDTO;
import com.slandshow.configuration.HibernateConfig;
import com.slandshow.configuration.SecurityApplicationInitializer;
import com.slandshow.exceptions.BusinessLogicException;
import com.slandshow.models.Schedule;
import com.slandshow.models.Seat;
import com.slandshow.models.User;
import com.slandshow.service.ScheduleService;
import com.slandshow.service.SeatService;
import com.slandshow.service.TicketService;
import com.slandshow.service.UserService;
import com.slandshow.utils.UtilsManager;
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

import java.text.ParseException;
import java.util.Date;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {HibernateConfig.class, SecurityConfiguration.class, SecurityApplicationInitializer.class})
@ActiveProfiles("test")

@WebAppConfiguration
public class TicketServiceTester {

    @Autowired
    private TicketService ticketService;

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private UserService userService;

    @Autowired
    private SeatService seatService;

    private TicketDTO ticketDTO;

    private User userA;
    private User userB;

    @Before
    public void init() {
        userA = userService.findUserByEmail("slandshow@mail.ru");
        userB = userService.findUserByEmail("appledragon@gmail.com");
        ticketDTO = new TicketDTO();
        SeatDTO seatDTO = new SeatDTO();
        seatDTO.setCarriage(2);
        seatDTO.setSeat(6);
        ticketDTO.setScheduleId(81L);
        ticketDTO.setSeatDTO(seatDTO);
    }

    @Test
    public void getAll() {
        Assert.assertNotNull(ticketService.getAll());
    }

    @Test
    public void getById() {
        Assert.assertNotNull(ticketService.getById(16L));
    }

    @Test
    public void getBookingSeatsBySchedule() {
        Schedule schedule = scheduleService.getById(81L);
        Assert.assertNotNull(ticketService.getBookingSeatsBySchedule(schedule));
    }

    @Test
    public void checkUserUntilBooking() {
        User user = userService.findUserByEmail("billgates@microsoft.com");
        Schedule schedule = scheduleService.getById(81L);
        Assert.assertFalse(ticketService.checkUserUntilBooking(user, schedule));
    }

    @Test
    public void checkSeatUntilBooking() {
        Seat seat = seatService.getById(46L);
        Schedule schedule = scheduleService.getById(81L);
        Assert.assertFalse(ticketService.checkSeatUntilBooking(seat, schedule));
    }

    @Test
    public void getBySchedules() {
        Schedule schedule = scheduleService.getById(10L);
        Assert.assertTrue(ticketService.getBySchedules(schedule).size() > 0);
    }

    @Test
    public void getByScheduleId() {
        Assert.assertTrue(ticketService.getByScheduleId(10L).size() > 0);
    }

    @Test
    public void getByDate() throws ParseException {
        Date date = UtilsManager.parseToDate("2018-10-30");
        Assert.assertTrue(ticketService.getByDate(date).size() > 0);
    }


    /**
     * concurrency test by booking ticket
     * @throws InterruptedException
     * @throws BrokenBarrierException
     */

    @Test
    public void add() throws InterruptedException, BrokenBarrierException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        try {
            System.out.println("******************************");
            System.out.println(userA.getFirstName() + " try to book ticket ...");
            System.out.println("******************************");
            executorService.submit((Runnable) ticketService.add(ticketDTO, userA));
        } catch (Exception e) {
            if (e instanceof BusinessLogicException) {
                System.out.println(((BusinessLogicException) e).getError());
                System.out.println("***************Oops..************");
                System.out.println(userA.getFirstName() + " didn't booked ticket ...");
                System.out.println("*********************************");
            }
        }
        try {
            System.out.println("******************************");
            System.out.println(userB.getFirstName() + " try to book ticket ...");
            executorService.submit((Runnable) ticketService.add(ticketDTO, userB));
            System.out.println("******************************");
        } catch (Exception e) {
            if (e instanceof BusinessLogicException) {
                System.out.println(((BusinessLogicException) e).getError());
                System.out.println("***************Oops..************");
                System.out.println(userB.getFirstName() + " didn't book ticket");
                System.out.println("*********************************");
            }
        }
        executorService.awaitTermination(10, TimeUnit.MILLISECONDS);
    }
}