
var kh = JSON.parse(localStorage.getItem('kh'));
// var ptn = JSON.parse(localStorage.getItem('listptn'));
// var hdn = JSON.parse(localStorage.getItem('hdn'));


if (!kh || Object.keys(kh).length === 0) {
    window.location.href = "dangnhap";
} else {
    document.getElementById('welcome-message').innerText = 'Chào, ' + kh.hoten;
    var result  = kh.vaitro ;
    console.log(result) ;

    if(result === "1"){
        document.getElementById("khachhang").style.display = "none" ;
        document.addEventListener("DOMContentLoaded", function() {
            // in thong tin hoa don
            const ListHD = document.getElementById("ListHD");
            const HDInfor = document.getElementById("HDInfor");
            const hoadon = document.getElementById("hoadon");
            var kh = JSON.parse(localStorage.getItem('kh'));
            let HDArr = [];
            let HDSaveId;
            let id_kh  = kh.id ;
// hien thi danhs sach hoa don
            function renderListHD() {
                // xóa ds hiện có
                ListHD.innerHTML = "";
                // Trả về danh sách HD
                HDArr.forEach(hd => {
                    const listItem = document.createElement("li");
                    listItem.textContent = hd.nhaCungCap.ten;
                    listItem.dataset.id = hd.id;
                    listItem.addEventListener("click", () => {
                        HDSaveId = hd.id;
                        // getPtn(HDSaveId) ;
                        showInfoHD(hd);
                    });
                    ListHD.appendChild(listItem);
                });

            }
// lay danh sach hoa don
            fetch(`http://localhost:8080/api/hdn/idhd/${id_kh}`)
                .then(response => response.json())
                .then(data => {
                    HDArr = data ;
                    renderListHD() ;

                })
                .catch(error => console.error("Error fetching data:", error));
// in thong tin hoa don
//             var listptn = JSON.parse(localStorage.getItem('ListPtn'));
            function showInfoHD(hd) {
                HDInfor.innerHTML = `
                    <p>Nhà Cung Cấp: ${hd.nhaCungCap.ten}</p>
                    <p>Ngày: ${hd.ngay}</p>
                    <p>Tổng Tiền: ${hd.thanhtien} $</p> 
                `;
                // alert("oke") ;
                getPtn(hd.id) ;
                hoadon.style.display = "block";
            };
// dong item
            closeHoaDon.addEventListener("click", () => {
                // localStorage.removeItem("ListPtn") ;
                const tableBody = document.getElementById("hoadonbody");
                while (tableBody.firstChild) {
                    tableBody.removeChild(tableBody.firstChild);
                }
                hoadon.style.display = "none";

            });

        });
    }
    else if(result === "0"){
        document.getElementById("admin").style.display = "none" ;
    }
}


document.addEventListener("DOMContentLoaded", function() {
// dang xuat
        var logoutButton = document.getElementById("logout-button");
        logoutButton.addEventListener("click", function() {
            localStorage.removeItem('kh');
            window.location.href = "/dangnhap";
        });

// hien thi danh sach lich hen
        const ListLH = document.getElementById("ListLH");
        const LHInfor = document.getElementById("LHInfor");
        const modal = document.getElementById("modal");
        const closeModal = document.getElementById("closeModal");


        let lhSaveId; // Biến để lưu trữ ID của lichhen được chọn
        let LHArr = []; // Mảng để lưu trữ danh sách lich hen
        // lấy sdt kh
        let sdt = kh.sdt

// Hàm trả về list Lịch hẹn
        function renderListLH() {
            // xóa ds hiện có
            ListLH.innerHTML = "";
// Trả về danh sách lh
            LHArr.forEach(lh => {
                const listItem = document.createElement("li");
                listItem.textContent = lh.loinhan;
                listItem.dataset.id = lh.id; // Set data-id attribute with the ID
                listItem.addEventListener("click", () => {
                    lhSaveId = lh.id;
                    showInfoLH(lh);
                });
                ListLH.appendChild(listItem);
            });
        }


        fetch(`http://localhost:8080/api/list/${sdt}`)
            .then(response => response.json())
            .then(data => {
                LHArr = data; // Lưu data được trả về
                // Trả về danh sach dịch hẹn
                renderListLH();
            })
            .catch(error => console.error("Error fetching data:", error));

// Thông tin lịch hẹn
        function showInfoLH(lh) {
                LHInfor.innerHTML = `
                <p>Ngày: ${lh.ngay}</p>
                <p>Giờ: ${lh.gio}</p>
                <p>Lời Nhắn: ${lh.loinhan}</p>  
            `;

            modal.style.display = "block";
        }


        closeModal.addEventListener("click", () => {
                modal.style.display = "none";
        });

});

function getPtn(idhdn){
    fetch(`http://localhost:8080/api/npt/idhdn/${idhdn}`)
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
                // localStorage.setItem("ListPtn", JSON.stringify(data)) ;
                renderPhuTungNhap(data)  ;
            }
            else {
                alert("Không có !") ;
            }
        })
        .catch(error => {
            console.error("Error:", error);
            alert("Nhập thông tin cần tìm. Hãy thử lại!");
        });
}

function  renderPhuTungNhap(ListPTN){
    const tableBody = document.getElementById("hoadonbody") ;
    ListPTN.forEach(ptn => {
        const row = document.createElement("tr");
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