$(document).on('submit', '#pet-form', function (event) {
    event.preventDefault();
    var formData = $('#pet-form').serialize();
    $.post({
        url: '/user/addPet',
        data: formData,
        success: function () {
            $('#addPet').modal('hide');
            $('#Success').modal('show');
        },
        error: function () {
            $('#pet-form-alert').removeClass('d-none');
        }
    });
    return true;
});

$(document).on('submit', '#pet-form-by-Id', function (event) {
    event.preventDefault();
    var formData = $('#pet-form-by-Id').serialize();
    $.post({
        url: '/user/addPetById',
        data: formData,
        success: function () {
            $('#addPetById').modal('hide');
            $('#Success').modal('show');
        }
    });
    return true;
});

$(document).on('submit', '#del-pet-by-id-form', function (event) {
    event.preventDefault();
    var formData = $('#del-pet-by-id-form').serialize();
    $.post({
        url: '/user/delPetById',
        data: formData,
        success: function () {
            $('#deletePetID').modal('hide');
            $('#SuccessDelete').modal('show');
        }
    });
    return true;
});

$(document).on('submit', '#go-to-doctor-form', function (event) {
    event.preventDefault();
    var formData = $('#go-to-doctor-form').serialize();
    $.post({
        url: '/user/addAnAppointment',
        data: formData,
        success: function () {
            $('#goToDoctor').modal('hide');
            $('#SuccessWrite').modal('show');
        }
    });
    return true;
});

$(document).on('submit', '#add-diagnoses-form', function (event) {
    event.preventDefault();
    var form = $('#add-diagnoses-form');
    var formData = form.serialize();
    var id = $('#addDiagnoses').attr('diagnos-id');
    $.post({
        url: '/doctor/addDiagnoses/'+id,
        data: formData,
        success: function () {
            $('#addDiagnoses').modal('hide');
            $('#Success1').modal('show');

        }
    });
    return true;
});

$('.diagnos-add').click(function () {
    var modalForm = $('#addDiagnoses');
    modalForm.attr('diagnos-id', $(this).attr('id'));
    modalForm.modal('show');
    return false;
});


$('#modal-close-button').click(function () {
    location.reload()
});

$('#modal-close-button-write').click(function () {
    location.reload()
});


$('#modal-close-button-delete').click(function () {
    location.reload()
});




