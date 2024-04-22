

document.getElementById("addpt").addEventListener("submit", function(event) {
    event.preventDefault();
    const form = event.target;
    const formData = new FormData(form);

    const pt = {};
    formData.forEach(function(value, key) {
        pt[key] = value;

    });
    console.log(pt)
    fetch("http://localhost:8080/api/pt/addpt", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(pt)
    })
        .then(response => {

            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.text();
        })
        .then(data => {
            console.log(data)
            if (data === "Thêm Phụ Tùng Thất Bại!") {
                alert(data);
            } else {
                alert("Thêm phụ tùng thành công");
                window.location.href = "/phutung"
            }
        })
        .catch(error => {
            console.error("Error:", error);
            alert("An error occurred. Please try again later.");
        });
});
