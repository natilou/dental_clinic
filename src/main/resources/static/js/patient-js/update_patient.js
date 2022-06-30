window.addEventListener('load', function () {

   const formulario = document.querySelector('#update_patient_form');

   formulario.addEventListener('submit', function (event) {
        event.preventDefault();

       let odontologoId = document.querySelector('#patient_id_update').value;


       const formData = {

           id: document.querySelector('#patient_id_update').value,
           firstName: document.querySelector('#first-name-update').value,
           lastName: document.querySelector('#last-name-update').value,
           dni: document.querySelector('#dni-update').value,
           address: {
                street: document.querySelector('#street-update').value,
                number: document.querySelector('#number-update').value,
                location: document.querySelector('#location-update').value,
                province: document.querySelector('#province-update').value,
           }
       };

       const url = '/patients';

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

        const url = '/patients'+"/"+id;

        const settings = {

            method: 'GET'

        }

        fetch(url,settings)

        .then(response => response.json())

        .then(data => {

            let patient = data;

            document.querySelector('#patient_id_update').value = patient.id;
            document.querySelector('#first-name-update').value = patient.firstName;
            document.querySelector('#last-name-update').value = patient.lastName;
            document.querySelector('#dni-update').value = patient.dni;
            document.querySelector('#street-update').value = patient.address.street;
            document.querySelector('#number-update').value = patient.address.number;
            document.querySelector('#location-update').value = patient.address.location;
            document.querySelector('#province-update').value = patient.address.province;
            document.querySelector('#div_patient_updating').style.display = "block";

        }).catch(error => {

            alert("Error: " + error);

 })

}