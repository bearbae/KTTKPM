

document.addEventListener("DOMContentLoaded", function() {
    var ncc = JSON.parse(localStorage.getItem('ncc'));
    var kh = JSON.parse(localStorage.getItem('kh'));

    // tao hoa don
    var taohoadon = document.getElementById("taohoadon") ;
    var id_hoadon = null ;
    taohoadon.addEventListener("click", function (){
        var id_ncc = ncc.id ;
        var id_tk = kh.id ;
        console.log(id_ncc)
        var data = {
            id_ncc: id_ncc,
            id_tk: id_tk
        }
        fetch("http://localhost:8080/api/hdn/taohd", {
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
                return response.json();
            })
            .then(data => {
                if(data){
                    var hdn = {
                        id: data.id
                    }
                    localStorage.setItem('hdn', JSON.stringify(hdn)) ;
                     id_hoadon = hdn.id;
                    // id_hoadon = data.id ;
                    alert("Hóa đơn được tạo thành công: "+ id_hoadon) ;
                    window.location.href = "/phutung" ;
                }
                else
                {
                    alert("looix") ;
                }
                console.log(data.thanhtien) ;

            })
            .catch(error => {
                console.error("Error:", error);
                alert("An error occurred. Please try again later.");
            });

    });

    const btnTim = document.getElementById("timPt") ;

    var phutungId = null ;
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
                    console.log(phutungId)  ;

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
    };

    var hdn = JSON.parse(localStorage.getItem('hdn'));
    console.log(hdn.id) ;
    const NPT = document.getElementById("NPT") ;
                // nhap phu tung
    NPT.addEventListener("click", function (){
        console.log(hdn.id) ;
        const tenpt = document.getElementById("tenpt").value ;
        const gia = document.getElementById("gia").value ;
        const soluong = document.getElementById("soluong").value ;
        var data = {
            idpt: phutungId,
            idhdn: hdn.id,
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

    xong.addEventListener("click", function (){
        fetch(`http://localhost:8080/api/npt/idhdn/${hdn.id}`)
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
    });


    var ptn = JSON.parse(localStorage.getItem('listptn'));
    console.log(ptn) ;

    function  renderPhuTungNhap(Listptn){
        var tongtien = 0 ;

        const tableBody = document.getElementById("ptung") ;
        Listptn.forEach(ptn => {
            const row = document.createElement("tr");
            const  mount = parseInt(ptn.soluong) ;
            const cost = parseFloat(ptn.gia);
            const subtotal = mount * cost ;

            tongtien += subtotal;

            row.innerHTML = `

                    <td >${ptn.id}</td>
                    <td>${ptn.phuTung.tenpt}</td>
                    <td >${ptn.phuTung.mota}</td>
                    <td>${ptn.soluong}</td>
                    <td>${ptn.gia}</td>
                `;
            tableBody.appendChild(row);
        })
    }
    renderPhuTungNhap(ptn)  ;





}) ;

