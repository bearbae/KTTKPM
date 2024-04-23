


document.getElementById("singupForm").addEventListener("submit", function(event) {
    event.preventDefault();

    const form = event.target;
    const formData = new FormData(form);

    const dangkyDto = {};
    formData.forEach(function(value, key) {
        dangkyDto[key] = value;
        console.log(dangkyDto[key] = value)
    });
    console.log(dangkyDto)
    fetch("http://localhost:8080/api/auth/dangky", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(dangkyDto)
    })

        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.text();
        })
        .then(data => {
            // Kiểm tra xem dữ liệu phản hồi là thông báo lỗi hay không
            if (data === "Tên Tài Khoản Hoặc Số Điện Thoại Đã Được Sử Dụng") {
                alert(data); // Hiển thị thông báo lỗi
                document.getElementById("singupForm").reset() ;
            } else {
                alert("Đăng ký thành công"); // Hiển thị thông báo đăng ký thành công
                // Chuyển hướng người dùng đến trang chủ sau khi đăng ký thành công
                window.location.href = "/dangnhap";
            }
        })
        .catch(error => {
            console.error("Error:", error);
            alert("An error occurred. Please try again later.");
        });
});

// Xac nhan mạt khau
document.addEventListener("DOMContentLoaded", function (){


    document.getElementById("cfpassword").addEventListener("input", function (){
        let password = document.getElementById("password").value ;
        let cfpass = this.value;
        if(password !==  cfpass){
            document.getElementById("passwordError").style.display = "block"  ;

        }
        else
        {
            document.getElementById("passwordError").style.display = "none" ;
        }
    }) ;

})