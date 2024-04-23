document.getElementById("loginForm").addEventListener("submit", function (event){

    event.preventDefault() ;
    var username = document.getElementById("username").value ;
    var password = document.getElementById("password").value ;

    var data= {
        username: username,
        password: password
    } ;
    console.log(data) ;
    //Post deend API
    fetch('http://localhost:8080/api/auth/dangnhap', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)

    })

        .then(response => {
            // console.log(data) ;
            if (response.status === 401) {
                throw new Error('Sai tên người dùng hoặc mật khẩu');
            } else if(!response.ok) {
                throw new Error('Đã xảy ra lỗi khi kết nối đến máy chủ.');
            }
            return response.json();
        })
        .then(data => {
            if (data) {
                console.log(data)

                var kh = {
                    id: data.taiKhoan.id,
                    hoten: data.hoten,
                    dchi: data.dchi,
                    sdt: data.sdt,
                    vaitro: data.taiKhoan.vaitro
                };
                    localStorage.setItem('kh', JSON.stringify(kh));
                    window.location.href = "/home";


        } else{
                alert("Dang nhap khong thanh cong. Vui long thu lai!") ;
            }
        })
        .catch(error => {
            console.error('Error:', error);

        });

});