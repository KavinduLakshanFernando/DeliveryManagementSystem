$("#loggin").on("click", function() {
    console.log("Register button");
    let email = $("#email").val();
    let password = $("#password").val();

    $.ajax({
        url: 'http://localhost:8080/api/v1/auth/authenticate',
        method: 'POST',
        contentType: 'application/json',  // Set content type to JSON
        data: JSON.stringify({
            email: email,
            password: password,
        }),
        success: function(data) {
            window.location.href = "../VehicleRegistration.html"
        },
        error: function(xhr, status, error) {
            // Handle errors
        }
    });
});