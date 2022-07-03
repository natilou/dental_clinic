

window.addEventListener('load', function () {
  const formulario = document.querySelector('#update_appointment_form');
  formulario.addEventListener('submit', function (event) {
    event.preventDefault();

    let appointmentId = document.querySelector('#appointment_id_update').value;
    let select_patient = document.querySelector('#select-patient');
    let patient_appointment = select_patient.options[select_patient.selectedIndex].value;
    let select_dentist = document.querySelector('#select-dentist');
    let dentist_appointment = select_patient.options[select_dentist.selectedIndex].value
    const formData = {
      id: appointmentId,
      patient: {
            id: patient_appointment,
//            lastName: patient_appointment.lastName,
//            firstName: patient_appointment.firstName,
//            entryDate: patient_appointment.entryDate,
      },
      dentist: {
            id: dentist_appointment,
//            registrationNumber: dentist_appointment.registrationNumber,
//            firstName: dentist_appointment.firstName,
//            lastName: dentist_appointment.lastName,
      },
      date: document.querySelector("#appointment-date-update").value
    };

    const url = '/appointments';
    const settings = {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(formData)
      }
    fetch(url,settings)
    .then(response => response.json())
    .then(() => location.reload());
   })
})

function findBy(id) {
  const url = '/appointments'+"/"+id;
  const settings = {
    method: 'GET'
  }
  fetch(url,settings)
  .then(response => response.json())
  .then(data => {
    let appointment = data;
    document.querySelector('#appointment_id_update').value = appointment.id;
    document.querySelector("#appointment-date-update").value = appointment.date;
    document.querySelector('#div_appointment_updating').style.display = "block";
  })
  .then(() => {
    const url = '/patients';
    const settings = {
    method: 'GET'
    }

    fetch(url,settings)
    .then(response => response.json())
    .then(data => {
    const selectPatient = document.querySelector("#select-patient");

      for(patient of data){
        selectPatient.innerHTML += `<option value=${patient.id}>${patient.firstName.toUpperCase()} ${patient.lastName.toUpperCase()}</option>`
      }
    })

  })
  .then(() => {
    const url = '/dentists';
    const settings = {
      method: 'GET'
    }

    fetch(url,settings)
    .then(response => response.json())
    .then(data => {
      for(dentist of data){
      const selectDentist = document.querySelector("#select-dentist");
      selectDentist.innerHTML += `<option value=${dentist.id}>${dentist.firstName.toUpperCase()} ${dentist.lastName.toUpperCase()}</option>`
      }
    })

  })
  .catch(error => {

    alert("Error: " + error);

})

}

   
   //            document.querySelector('#appointment_id_update').value = patient.id;
   //            document.querySelector('#first-name-update').value = patient.firstName;
   //            document.querySelector('#last-name-update').value = patient.lastName;
   //            document.querySelector('#dni-update').value = patient.dni;
   //            document.querySelector('#street-update').value = patient.address.street;
   //            document.querySelector('#number-update').value = patient.address.number;
   //            document.querySelector('#location-update').value = patient.address.location;
   //            document.querySelector('#province-update').value = patient.address.province;
   //            document.querySelector('#div_patient_updating').style.display = "block";

