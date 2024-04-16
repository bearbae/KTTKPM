// Lấy thông tin người dùng từ localStorage
var kh = JSON.parse(localStorage.getItem('kh'));

// Kiểm tra xem kh có giá trị hay không
if (!kh || Object.keys(kh).length === 0) {
    // Nếu userInfo trống, chuyển hướng đến trang đăng nhập
    window.location.href = "dangnhap";
} else {
    // Hiển thị thông tin người dùng trong trang

    document.getElementById('welcome-message').innerText = 'Chào, ' + kh.hoten;

}

// dang xuat
document.addEventListener("DOMContentLoaded", function() {
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


