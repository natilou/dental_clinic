window.addEventListener('load', function () {
    const formulario = document.querySelector('#add_new_appointment');

    const url = '/patients';
    const settings = {
    method: 'GET'
    }

    fetch(url,settings)
    .then(response => response.json())
    .then(data => {
    const selectPatient = document.querySelector("#select-patient-save");

      for(patient of data){
        selectPatient.innerHTML += `<option value=${patient.id}>${patient.firstName.toUpperCase()} ${patient.lastName.toUpperCase()}</option>`
      }
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
      const selectDentist = document.querySelector("#select-dentist-save");
      selectDentist.innerHTML += `<option value=${dentist.id}>${dentist.firstName.toUpperCase()} ${dentist.lastName.toUpperCase()}</option>`
      }
    })

    })
    .catch(error => {

        alert("Error: " + error);

    }),

    formulario.addEventListener('submit', function (event) {
       event.preventDefault();
       let select_patient = document.querySelector('#select-patient-save');
       let patient_appointment = select_patient.options[select_patient.selectedIndex].value;
       let select_dentist = document.querySelector('#select-dentist-save');
       let dentist_appointment = select_dentist.options[select_dentist.selectedIndex].value
       const formData = {
             patient: {
                   id: patient_appointment,
             },
             dentist: {
                   id: dentist_appointment,
             },
             date: document.querySelector("#appointment-date-save").value
       };

        const url = '/appointments';
        const settings = {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData)
        }

        fetch(url, settings)
            .then(response => response.json())
            .then(data => {

                 let successAlert = '<div class="alert alert-success alert-dismissible">' +
                     '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                     '<strong></strong> Appointment added </div>'

                 document.querySelector('#response').innerHTML = successAlert;
                 document.querySelector('#response').style.display = "block";
                 document.querySelector("#appointment-date-save").value = "";
            })
            .catch(error => {

                    let errorAlert = '<div class="alert alert-danger alert-dismissible">' +
                                     '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                                     '<strong> Error intente nuevamente</strong> </div>'
                    console.log(error);
                      document.querySelector('#response').innerHTML = errorAlert;
                      document.querySelector('#response').style.display = "block";

                     document.querySelector("#appointment-date-save").value = "";
            }),

    function(){
        let pathname = window.location.pathname;
        if(pathname === "/"){
            document.querySelector(".nav .nav-item a:first").addClass("active");
        } else if (pathname == "/appointmentList.html") {
            document.querySelector(".nav .nav-item a:last").addClass("active");
    }};
}) 

})



    