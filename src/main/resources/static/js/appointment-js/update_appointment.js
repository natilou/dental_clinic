

window.addEventListener('load', function () {
  const formulario = document.querySelector('#update_appointment_form');
  formulario.addEventListener('submit', function (event) {
    event.preventDefault();

    let appointmentId = document.querySelector('#appointment_id_update').value;
    let selectPatient = document.querySelector('#select-patient');
    let patientAppointment = selectPatient.options[selectPatient.selectedIndex].value;
    let selectDentist = document.querySelector('#select-dentist');
    let dentistAppointment = selectDentist.options[selectDentist.selectedIndex].value
    const formData = {
      id: appointmentId,
      patient: {
            id: patientAppointment,
      },
      dentist: {
            id: dentistAppointment,
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
     let date_appointment = new Date(appointment.date)
    document.querySelector('#appointment_id_update').value = appointment.id;
    document.querySelector("#appointment-date-update").value = date_appointment.toISOString().split('T')[0] + " " + date_appointment.toISOString().split('T')[1].slice(0, 5);
    document.querySelector('#div_appointment_updating').style.display = "block";
    return appointment;
  })
  .then((appointment) => {
    const url = '/patients';
    const settings = {
    method: 'GET'
    }

    fetch(url,settings)
    .then(response => response.json())
    .then((data) => {
    const selectPatient = document.querySelector("#select-patient");

      for(patient of data){
        selectPatient.innerHTML += `<option value=${patient.id} ${appointment.patient.id == patient.id ? 'selected' : ""}>${patient.firstName.toUpperCase()} ${patient.lastName.toUpperCase()}</option>`
      }
    
    })
    return appointment;
  })
  .then((appointment) => {
    const url = '/dentists';
    const settings = {
      method: 'GET'
    }

    fetch(url,settings)
    .then(response => response.json())
    .then(data => {
      for(dentist of data){
      const selectDentist = document.querySelector("#select-dentist");
      selectDentist.innerHTML += `<option value=${dentist.id} ${appointment.dentist.id == dentist.id ? 'selected' : ""}>${dentist.firstName.toUpperCase()} ${dentist.lastName.toUpperCase()}</option>`
      }
    })

  })
  .catch(error => {

    alert("Error: " + error);

})

}

