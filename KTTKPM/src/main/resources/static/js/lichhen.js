

document.getElementById("lichhenForm").addEventListener("submit", function(event) {
    event.preventDefault();
    const form = event.target;
    const formData = new FormData(form);

    const LichhenDto = {};
    formData.forEach(function(value, key) {
        LichhenDto[key] = value;

    });
    console.log(LichhenDto)
    fetch("http://localhost:8080/api/lichhen", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(LichhenDto)
    })
        .then(response => {

            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.text();
        })
        .then(data => {

            if (data === "Đặt lịch hẹn không thành công") {
                alert(data); // Hiển thị thông báo lỗi
            } else {
                alert("đặt thành công"); // Hiển thị thông báo thành công
                // Chuyển hướng người dùng đến trang chủ
                window.location.href = "/home"
            }
        })
        .catch(error => {
            console.error("Error:", error);
            alert("An error occurred. Please try again later.");
        });
});

// lay thong tin khach hang
// Lấy thông tin người dùng từ localStorage
var kh = JSON.parse(localStorage.getItem('kh'));

// Kiểm tra xem kh có giá trị hay không
if (!kh || Object.keys(kh).length === 0) {
    // Nếu userInfo trống, chuyển hướng đến trang home
    window.location.href = "home";
} else {
    // Hiển thị thông tin người dùng trong trang

    document.getElementById('hoten').value =  kh.hoten;
    document.getElementById('sdt').value =  kh.sdt;
    document.getElementById('dchi').value =  kh.dchi;


}
