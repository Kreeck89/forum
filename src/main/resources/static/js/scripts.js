$(document).ready(function () {
    $(function () {
        $('#model_trigger').click(function () {
            $('#model_1').show();
            $('#overlay').show();
        });
        $('#close').click(function () {
            $('#model_1').hide();
            $('#overlay').hide();
        });
    });
});

$(document).ready(function () {
    $('#customerData').validate({
        rules: {}
    });

    $('#regBtn').on('submit', function () {
        var elementsFromForm = [
            'customerName',
            'customerNick',
            'customerEmail',
            'customerPassword',
            'customerAge'
        ];

        elementsFromForm.forEach(function (element) {
            var name = '#' + element;
            if (!$(name).valid) {
                $(name).parent().addClass('has-error');
            } else {
                $(name).parent().removeClass('has-error').addClass('has-success');
            }
        });
    });
});


// $('#regBtn').on('submit', function () {
// var customerName = document.forms.customerData.elements.customerName.value;
// var customerNick = document.forms.customerData.elements.customerNick.value;
// var customerEmail = document.forms.customerData.elements.customerEmail.value;
// var customerPassword = document.forms.customerData.elements.customerPassword.value;
// var customerAge = document.forms.customerData.elements.customerAge.value;
// });