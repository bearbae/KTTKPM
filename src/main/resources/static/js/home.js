
var kh = JSON.parse(localStorage.getItem('kh'));
var ptn = JSON.parse(localStorage.getItem('listptn'));
var hdn = JSON.parse(localStorage.getItem('hdn'));


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

            fetch(`http://localhost:8080/api/hdn/idhd/${hdn.id}`)
                .then(response => response.json())
                .then(data => {
                    console.log(data)
                    // Lưu data được trả về
                    // Trả về danh sach dịch hẹn
                    const listItem = document.createElement("li");
                    listItem.textContent = data.nhaCungCap.ten;
                    // listItem.dataset.id = data.id;
                    listItem.addEventListener("click", () => {

                        showInfoHD(data);
                    });
                    ListHD.appendChild(listItem) ;

                })
                .catch(error => console.error("Error fetching data:", error));

            function showInfoHD(hd) {
                HDInfor.innerHTML = `
            <p>Nhà Cung Cấp: ${hd.nhaCungCap.ten}</p>
            <p>Ngày: ${hd.ngay}</p>
            <p>Tổng Tiền: ${hd.thanhtien} $</p>
        
            
            
        `;

                hoadon.style.display = "block";
            }
            closeHoaDon.addEventListener("click", () => {
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
            window.location.href = "/dangnhap"; // Chuyển hướng đến trang đăng nhập sau khi đăng xuất
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
            console.log(lhSaveId)
            modal.style.display = "block";
        }


        closeModal.addEventListener("click", () => {
            modal.style.display = "none";
        });




    });