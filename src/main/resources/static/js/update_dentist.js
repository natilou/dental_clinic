window.addEventListener('load', function () {

   const formulario = document.querySelector('#update_odontologo_form');

   formulario.addEventListener('submit', function (event) {
        event.preventDefault();

       let odontologoId = document.querySelector('#odontologo_id_update').value;


       const formData = {

           id: document.querySelector('#odontologo_id_update').value,

           firstName: document.querySelector('#nombre-update').value,

           lastName: document.querySelector('#apellido-update').value,

           registrationNumber: document.querySelector('#matricula-update').value,
       };

       const url = '/dentists';

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

        const url = '/dentists'+"/"+id;

        const settings = {

            method: 'GET'

        }

        fetch(url,settings)

        .then(response => response.json())

        .then(data => {

            let dentist = data;

            document.querySelector('#odontologo_id_update').value = dentist.id;

            document.querySelector('#nombre-update').value = dentist.firstName;

            document.querySelector('#apellido-update').value = dentist.lastName;

            document.querySelector('#matricula-update').value = dentist.registrationNumber;

            document.querySelector('#div_odontologo_updating').style.display = "block";

        }).catch(error => {

            alert("Error: " + error);

 })

}