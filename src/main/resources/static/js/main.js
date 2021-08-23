$('document').ready(function(){

    $('#editDoctorModal').on('click', function(e){
        e.preventDefault;

        $('#editModal').modal('show');
    })

    $('#editModal').modal('hide');
})