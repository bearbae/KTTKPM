document.addEventListener("DOMContentLoaded", function() {

    const btnTim = document.getElementById("timPt") ;

    var phutungId = null;
    // Lời gọi API fetch để lấy thông tin Phụ Tùng
    btnTim.addEventListener("click", function (){

        let tenpt = document.getElementById("tenpt").value;

        fetch(`http://localhost:8080/api/pt/ten/${tenpt}`)
            .then(response => {
                if (!response.ok) {
                    throw new Error('Error');
                }
                return response.json();
            })
            .then(data => {
                console.log(data);
                if(data){
                    renderPt(data)  ;
                }
                else {
                    alert("Không có thông tin Phụ Tùng cần tìm!") ;
                }
            })
            .catch(error => {
                console.error("Error:", error);
                alert("Nhập thông tin cần tìm. Hãy thử lại!");
            });
    });


    // in thong tin pt
    function renderPt(pt){
        const tableBody = document.getElementById("PhuTungTableBody");
        tableBody.innerHTML = ""  ;
        pt.forEach(PhuTung => {

            const row = document.createElement("tr");
            phutungId = PhuTung.id;
            row.innerHTML = `
                    <td >${PhuTung.id}</td>
                    <td>${PhuTung.tenpt}</td>
                    <td >${PhuTung.mota}</td>
                `;
            tableBody.appendChild(row);

        });

    }
    console.log(phutungId)  ;
    var hdn = JSON.parse(localStorage.getItem('hdn'));

    const xacnhan = document.getElementById("confirm") ;
    var hoadonnhapId = hdn.id ;
    console.log(hoadonnhapId)  ;


    xacnhan.addEventListener("click", function (){
        const tenpt = document.getElementById("tenpt").value ;
        const gia = document.getElementById("gia").value ;
        const soluong = document.getElementById("soluong").value ;
        var data = {
            idpt: phutungId,
            idhdn: hoadonnhapId,
            tenpt: tenpt,
            gia: gia,
            soluong: soluong
        }
        console.log(data)
        fetch("http://localhost:8080/api/npt/nhap", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(data)
        })
            .then(response => {

                if (!response.ok) {
                    throw new Error('Network response was not ok');
                }
                return response.text();
            })
            .then(data => {

                if (data === "Nhap phu tung khong thanh cong") {
                    alert(data);
                } else {
                    alert("Nhập phụ tùng thành công");

                    window.location.href = "/phutung"
                }
            })
            .catch(error => {
                console.error("Error:", error);
                alert("An error occurred. Please try again later.");
            });
    });


// lay list phu tung nhap

    const xong = document.getElementById("done") ;
    console.log(hoadonnhapId);
    xong.addEventListener("click", function (){
        fetch(`http://localhost:8080/api/npt/idhdn/${hoadonnhapId}`)
            .then(response => {
                if (!response.ok) {
                    throw new Error('Error');
                }
                return response.json();
            })
            .then(data => {
                console.log(data)
                // console.log(data.phuTung.tenpt)

                if(data){
                    localStorage.setItem("listptn", JSON.stringify(data)) ;
                    window.location.href = "/hoadonnhap"
                }
                else {
                    alert("Không có !") ;
                }
            })
            .catch(error => {
                console.error("Error:", error);
                alert("Nhập thông tin cần tìm. Hãy thử lại!");
            });
    })



}) ;

