package com.clinicadental;

import com.clinicadental.clinica.model.Dentist;
import com.clinicadental.clinica.service.AddressTest;
import com.clinicadental.clinica.service.DentistTest;
import com.clinicadental.clinica.service.PatientTest;
import com.clinicadental.clinica.service.ShiftTest;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
		AddressTest.class,
		DentistTest.class,
		PatientTest.class,
		ShiftTest.class
})
@SpringBootTest
class ClinicaDentalApplicationTests {

	@Test
	void contextLoads() {
	}

}
