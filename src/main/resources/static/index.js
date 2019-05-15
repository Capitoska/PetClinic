$(document).on('submit', '#pet-form', function (event){
    event.preventDefault();
    var formData = $('#pet-form').serialize();
    $.post({
        url: '/user/addPet',
        data: formData,
        success: function(){
            $('#addPet').modal('hide');
            $('#Success').modal('show');
        },
        error: function(){
            $('#pet-form-alert').removeClass('d-none');
        }
    });
    return true;
});

$(document).on('submit', '#pet-form-by-Id', function (event){
    event.preventDefault();
    var formData = $('#pet-form-by-Id').serialize();
    $.post({
        url: '/user/addPetById',
        data: formData,
        success: function(){
            $('#addPetById').modal('hide');
            $('#Success').modal('show');
        }
    });
    return true;
});

$('#modal-close-button').click(function () {
    location.reload()
});


