

document.getElementById("addncc").addEventListener("submit", function(event) {
    event.preventDefault();
    const form = event.target;
    const formData = new FormData(form);

    const ncc = {};
    formData.forEach(function(value, key) {
        ncc[key] = value;

    });
    console.log(ncc)
    fetch("http://localhost:8080/api/addncc", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(ncc)
    })
        .then(response => {

            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.text();
        })
        .then(data => {

            if (data === "khong") {
                alert(data);
            } else {
                alert("Thêm Nhà Cung Cấp Thành Công");

                window.location.href = "/ncc"
            }
        })
        .catch(error => {
            console.error("Error:", error);
            alert("An error occurred. Please try again later.");
        });
});
