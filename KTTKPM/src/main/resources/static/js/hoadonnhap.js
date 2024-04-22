
var ncc = JSON.parse(localStorage.getItem('ncc'));
var kh = JSON.parse(localStorage.getItem('kh'));
var listptn = JSON.parse(localStorage.getItem('listptn'));
var hdn = JSON.parse(localStorage.getItem('hdn'));



if (!ncc || Object.keys(ncc).length === 0) {
    alert("không có ")
    window.location.href = "ncc";
} else {
    document.getElementById('ten').innerText = ncc.ten;
    document.getElementById('sdt').innerText = ncc.sdt;
    document.getElementById('dchi').innerText = ncc.dchi;
}

console.log(kh.id) ;
// đặt ngày thành ngày hiện tại
const date = document.getElementById("date");
// Tạo một đối tượng Date để lấy ngày hiện tại
const currentDate = new Date();
// Format ngày hiện tại thành chuỗi "Ngày/Tháng/Năm"
const formattedDate = currentDate.toLocaleDateString();
// Gán chuỗi đã format vào phần tử span
date.textContent = formattedDate;

var taohoadon = document.getElementById("taohoadon") ;

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
                return response.text();
            })
            .then(data => {
                console.log(data) ;
                if (data === "Not ok") {
                    alert(data);
                } else {
                    // getidhd(data)
                    alert("Tạo Hóa Đơn Thành Công");
                }

            })
            .catch(error => {
                console.error("Error:", error);
                alert("An error occurred. Please try again later.");
            });



})



const nhapphutung = document.getElementById("nhapphutung") ;

nhapphutung.addEventListener("click", function (){
    fetch(`http://localhost:8080/api/hdn/${kh.id}`)
        .then( Response => {
            if(!Response.ok){
                throw new Error('Error');
            }
            return Response.json() ;
        })
        .then(data => {
            console.log(data)
            if(data){
                var hdn = {
                    id: data.id
                }
                localStorage.setItem('hdn', JSON.stringify(hdn)) ;
                // alert("oke");
                window.location.href = "/phutung"

            }
            else alert("Khong tim thay!") ;

        })
        .catch(error =>{
            console.error("Error:", error);
            alert("Nhập thông tin cần tìm. Hãy thử lại!");
        }) ;

})

renderPhuTungNhap(listptn)  ;
function  renderPhuTungNhap(Listptn){
    var tongtien = 0 ;

    const tableBody = document.getElementById("hoadonbody") ;
    Listptn.forEach(ptn => {
        const row = document.createElement("tr");
         const  mount = parseInt(ptn.soluong) ;
        const cost = parseFloat(ptn.gia);
        const subtotal = mount * cost ;

        tongtien += subtotal;

        row.innerHTML = `
                     
                    <td id="test">${ptn.id}</td>
                    <td>${ptn.phuTung.tenpt}</td>
                    <td >${ptn.phuTung.mota}</td>
                    <td>${ptn.soluong}</td>
                    <td>${ptn.gia}</td>
                `;
        tableBody.appendChild(row);
    })
    document.getElementById("total").innerText= tongtien.toFixed(2) ;
}


// update hoa don
const oke  = document.getElementById("oke")
oke.addEventListener("click", function (){
    const ngay = document.getElementById("date").innerText ;
    const total = parseFloat(document.getElementById("total").innerText) ;
    console.log(total)
    var data={
        ngay: ngay,
        thanhtien: total
    }
    fetch(`http://localhost:8080/api/hdn/update/${hdn.id}`, {
        method: "Put",
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
            if (data !== "update thanh cong") {
                alert(data); // Hiển thị thông báo lỗi
            } else {
                alert("Xac nhan hoa don thành công");

                window.location.href = "/home"
            }
        })
        .catch(error => {
            console.error("Error:", error);
            alert("An error occurred. Please try again later.");
        });

})






