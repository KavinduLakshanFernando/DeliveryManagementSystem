$("#nextBtn").on("click", function() {
    console.log("Register button");
    let name = $("#name").val();
    let userName = $("#username").val();
    let nic = $("#nic").val();
    let phone = $("#mobile").val();
    let email = $("#email").val();
    let address = $("#address").val();
    let password = $("#password").val();
    let ConfirmPassword = $("#confirm-password").val();

    $.ajax({
        url: 'http://localhost:8080/api/v1/user/register',
        method: 'POST',
        contentType: 'application/json',  // Set content type to JSON
        data: JSON.stringify({
            name: name,
            username:userName,
            nic: nic,
            phone: phone,
            email: email,
            address: address,
            password: password,
            confirmPassword: ConfirmPassword
        }),
        success: function(data) {
            if (password === ConfirmPassword) {
                alert("Registration successful!");
            }else {
                alert("Password does not match!");
            }

        },
        error: function(xhr, status, error) {
            // Handle errors
        }
    });
});