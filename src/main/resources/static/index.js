$(document).on('submit', '#pet-form', function (event) {
    event.preventDefault();
    var formData = $('#pet-form').serialize();
    $.post({
        url: '/user/pet',
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
    var id = $('#pet-id').val();
    $.post({
        url: '/user/pet/'+ id,
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
        url: '/doctor/addDiagnoses/' + id,
        data: formData,
        success: function () {
            $('#addDiagnoses').modal('hide');
            $('#Success1').modal('show');
        }
    });
    return true;
});

// $('#choose-owner-registration').click(function () {
//     // alert("this code is valid");
//     $.get({
//         url: '/sign-up',
//         success: function (govno, test) {
//             document.documentElement.innerHTML = govno;
//             $("#sign-up-page .doctor-feature").remove();
//         },
//     })
// });



$('.diagnos-add').click(function () {
    var modalForm = $('#addDiagnoses');
    modalForm.attr('diagnos-id', $(this).attr('id'));
    modalForm.modal('show');
    return false;
});

// $('#choose-doctor-registration').click(function () {
//     $.get( "/sign-up", {backend: 'govno'}, function( data ) {
//     }).done(function (data) {
//         $('body').html(data);
//         window.location = '/sign-up';
//     });
// });

// $('#choose-owner-registration').click(function () {
//     $.get( "/sign-up", function( data ) {
//     }).done(function (data) {
//         $('body').html(data);
//
//         window.location = '/sign-up';
//         $('select').remove();
//     });
// });
//
// $("#choose-doctor-registration").click(function () {
//     $.get({
//         url:"/sign-up",
//         success: function (htmlCode) {
//             document.documentElement.innerHTML = htmlCode;
//
//         },
//     })
// });

//
// $('#modal-close-button').click(function () {
//     location.reload()
// });

// $('#modal-close-button-write').click(function () {
//     location.reload()
// });

$('.reload-button').click(function () {
    location.reload()
});
//
// $('#modal-close-button-delete').click(function () {
//     location.reload()
// });




