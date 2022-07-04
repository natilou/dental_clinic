

window.addEventListener('load', function () {
  const formulario = document.querySelector('#update_appointment_form');
  formulario.addEventListener('submit', function (event) {
    event.preventDefault();

    let appointmentId = document.querySelector('#appointment_id_update').value;
    let select_patient = document.querySelector('#select-patient');
    let patient_appointment = select_patient.options[select_patient.selectedIndex].value;
    let select_dentist = document.querySelector('#select-dentist');
    let dentist_appointment = select_dentist.options[select_dentist.selectedIndex].value
    const formData = {
      id: appointmentId,
      patient: {
            id: patient_appointment,
      },
      dentist: {
            id: dentist_appointment,
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
    document.querySelector("#appointment-date-update").value = appointment.date.toISOString().split('T')[0];
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

