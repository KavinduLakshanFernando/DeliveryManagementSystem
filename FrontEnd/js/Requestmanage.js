
const fetchRequestData = () => {
    $.ajax({
        url: "http://localhost:8080/api/vi/request/getRequest",
        method: "GET",
        success: (res) => {
            // Empty the existing content in customerTableBody
            $('#requestTableBody').empty();

            // Iterate over the response and build the row for each customer
            res.forEach((request) => {
                $('#requestTableBody').append(`
                    <div class="row align-items-center request-row">
                        <div class="col-2 ps-4">#${request.reqId}</div>
                        <div class="col-2">${request.username}</div>
                        <div class="col-2 request-status">${request.status}</div>
                        <div class="col-2">
                            <button class="btn btn-view">View</button>
                        </div>
                        <div class="col-4">
                            <button class="btn btn-deactive me-2">DeActive</button>
                            <button class="btn btn-active">Active</button>
                        </div>
                    </div>
                `);
            });
        },
        error: (err) => {
            console.log(err);
        }
    });
};

// Call the function to fetch data when needed
fetchRequestData();

