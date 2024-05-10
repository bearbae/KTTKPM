document.addEventListener("DOMContentLoaded", function() {

    const btnTim = document.getElementById("tim") ;

    // Lời gọi API fetch để lấy thông tin nhà cung cấp
    btnTim.addEventListener("click", function (){

            let tenncc = document.getElementById("supplierName").value;

            fetch(`http://localhost:8080/api/ncc/ten/${tenncc}`)
                .then(response => {
                    if (!response.ok) {
                        throw new Error('Error');

                    }
                    return response.json();
                })
                .then(data => {
                    console.log(data)
                    if(data){
                        renderNcc(data)  ;
                    }
                    else {
                        alert("Không có thông tin nhà cung cấp cần tìm!") ;
                    }
                })
                .catch(error => {
                    console.error("Error:", error);
                    alert("Nhập thông tin cần tìm. Hãy thử lại!");
                });
    });


        // in thong tin ncc
    function renderNcc(InforNcc){
        const tableBody = document.getElementById("supplierTableBody");
        tableBody.innerHTML = ""  ;
        InforNcc.forEach(supplier => {
            const row = document.createElement("tr");
            row.innerHTML = `
                    <td id="test">${supplier.id}</td>
                    <td>${supplier.ten}</td>
                    <td >${supplier.dchi}</td>
                    <td>${supplier.sdt}</td>
                    <td >
                         <button id="select" onclick="chon(this)" data-id="${supplier.id}" >Chọn</button>
                    </td>
                `;
            tableBody.appendChild(row);

        });
    }
}) ;

function chon(button){
    const Idncc = button.dataset.id;
    // const select = document.getElementById("select") ;
    // select.addEventListener("click", function (){
        let ValueIdncc = parseInt(Idncc);
        fetch(`http://localhost:8080/api/ncc/id/${ValueIdncc}`)
            .then( Response => {
                    if(!Response.ok){
                        throw new Error('Error');
                    }
                    return Response.json() ;
                })
            .then(data => {
                if(data){
                    const ncc = {
                        id: Idncc,
                        ten: data.ten,
                        sdt: data.sdt,
                        dchi: data.dchi
                    };
                    localStorage.setItem('ncc', JSON.stringify(ncc)) ;
                    alert("Nhà Cung Cấp: " + data.ten) ;

                    window.location.href =('/phutung') ;
                }
                else alert("Khong tim thay!") ;

            })
            .catch(error =>{
                console.error("Error:", error);
                alert("Nhập thông tin cần tìm. Hãy thử lại!");
                }) ;

    // }) ;



}