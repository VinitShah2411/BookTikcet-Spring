package com.seed;
import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bean.SeatBean;
import com.repository.SeatRepository;

@Component
public class SeatSeed {
	
	@Autowired
	SeatRepository seatRepository;
	
	@PostConstruct
	void createSeat() {

		SeatBean seat = seatRepository.findBySeatName("S1");
		if (seat == null) {
			SeatBean seat1 = new SeatBean();
			seat1.setSeatName("S1");
			seatRepository.save(seat1);

			SeatBean seat2 = new SeatBean();
			seat2.setSeatName("S2");
			seatRepository.save(seat2);
			
			SeatBean seat3 = new SeatBean();
			seat3.setSeatName("S3");
			seatRepository.save(seat3);

			SeatBean seat4 = new SeatBean();
			seat4.setSeatName("S4");
			seatRepository.save(seat4);
			
			SeatBean seat5 = new SeatBean();
			seat5.setSeatName("S5");
			seatRepository.save(seat5);

			SeatBean seat6 = new SeatBean();
			seat6.setSeatName("S6");
			seatRepository.save(seat6);
			
			SeatBean seat7 = new SeatBean();
			seat7.setSeatName("S7");
			seatRepository.save(seat7);

			SeatBean seat8 = new SeatBean();
			seat8.setSeatName("S8");
			seatRepository.save(seat8);
			
			SeatBean seat9 = new SeatBean();
			seat9.setSeatName("S9");
			seatRepository.save(seat9);

			SeatBean seat10 = new SeatBean();
			seat10.setSeatName("S10");
			seatRepository.save(seat10);
			System.out.println("Role Added.....");

		} else {
			System.out.println("Seat Already Exists....");
		}
	}
}
