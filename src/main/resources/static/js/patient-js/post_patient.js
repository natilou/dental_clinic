window.addEventListener('load', function () {

    const formulario = document.querySelector('#add_new_patient');

    formulario.addEventListener('submit', function (event) {
         event.preventDefault();

       //creamos un JSON que tendrá los datos de un nuevo paciente
        const formData = {
            firstName: document.querySelector('#nombre-paciente').value,
            lastName: document.querySelector('#apellido-paciente').value,
            dni: document.querySelector('#dni').value,
            address: {
                street: document.querySelector('#street').value,
                number: document.querySelector('#number-street').value,
                location: document.querySelector('#location').value,
                province: document.querySelector('#province').value
            }
        }

        const url = '/patients';
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
                     '<strong></strong> Patient added </div>'

                 document.querySelector('#response').innerHTML = successAlert;
                 document.querySelector('#response').style.display = "block";
                 resetUploadForm();
            })
            .catch(error => {

                    let errorAlert = '<div class="alert alert-danger alert-dismissible">' +
                                     '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                                     '<strong> Error. Try again</strong> </div>'
                    console.log(error);
                      document.querySelector('#response').innerHTML = errorAlert;
                      document.querySelector('#response').style.display = "block";
                     resetUploadForm();})
    });


    function resetUploadForm(){
        document.querySelector('#nombre-paciente').value = "";
        document.querySelector('#apellido-paciente').value = "";
        document.querySelector('#dni').value = "";
        document.querySelector('#street').value = "";
        document.querySelector('#number-street').value = "";
        document.querySelector('#location').value = "";
        document.querySelector('#province').value = "";
    }

    (function(){
        let pathname = window.location.pathname;
        if(pathname === "/"){
            document.querySelector(".nav .nav-item a:first").addClass("active");
        } else if (pathname == "/patientList.html") {
            document.querySelector(".nav .nav-item a:last").addClass("active");
    }});
});