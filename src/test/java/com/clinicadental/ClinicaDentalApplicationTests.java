package com.clinicadental;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
		com.clinicadental.AddressTest.class,
		com.clinicadental.DentistTest.class,
		com.clinicadental.PatientTest.class,
		com.clinicadental.AppointmentTest.class
})
@SpringBootTest
class ClinicaDentalApplicationTests {

	@Test
	void contextLoads() {
	}

}
