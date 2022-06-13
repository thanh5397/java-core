function changeMonthBirth() {
	Month = document.getElementById("MonthBirth").value;
	Year = document.getElementById("YearBirth").value
	var day;
	switch (Month) {
	case "1":
	case "3":
	case "5":
	case "7":
	case "8":
	case "10":
	case "12":
		day = 31;

		break;
	case "4":
	case "6":
	case "9":
	case "11":
		day = 30;

		break;

	default:
		if (Year % 4 == 0)
			day = 29;
		else
			day = 28;
		break;
	}
	document.getElementById("DayBirth").innerHTML = "";
	document.getElementById("DayBirth").innerHTML += '<option select = "selected"> '
			+ String(1).padStart(2, "0") + '</option>'
	for (var i = 2; i <= day; i++) {
		document.getElementById("DayBirth").innerHTML += '<option> '
				+ String(i).padStart(2, "0") + '</option>'
	}
}

function changeMonthStart() {
	Month = document.getElementById("MonthStart").value;
	Year = document.getElementById("YearStart").value
	var day;
	switch (Month) {
	case "1":
	case "3":
	case "5":
	case "7":
	case "8":
	case "10":
	case "12":
		day = 31;

		break;
	case "4":
	case "6":
	case "9":
	case "11":
		day = 30;

		break;

	default:
		if (Year % 4 == 0)
			day = 29;
		else
			day = 28;
		break;
	}
	document.getElementById("DayStart").innerHTML = "";
	document.getElementById("DayStart").innerHTML += '<option select = "selected"> '
			+ String(1).padStart(2, "0") + '</option>'
	for (var i = 2; i <= day; i++) {
		document.getElementById("DayStart").innerHTML += '<option> '
				+ String(i).padStart(2, "0") + '</option>'
	}
}

function changeMonthEnd() {
	Month = document.getElementById("MonthEnd").value;
	Year = document.getElementById("YearEnd").value
	var day;
	switch (Month) {
	case "1":
	case "3":
	case "5":
	case "7":
	case "8":
	case "10":
	case "12":
		day = 31;

		break;
	case "4":
	case "6":
	case "9":
	case "11":
		day = 30;

		break;

	default:
		if (Year % 4 == 0)
			day = 29;
		else
			day = 28;
		break;
	}
	document.getElementById("DayEnd").innerHTML = "";
	document.getElementById("DayEnd").innerHTML += '<option select = "selected"> '
			+ String(1).padStart(2, "0") + '</option>'
	for (var i = 2; i <= day; i++) {
		document.getElementById("DayEnd").innerHTML += '<option> '
				+ String(i).padStart(2, "0") + '</option>'
	}
}

function hideAndShow() {
	var x = document.getElementById("hS0");
	if (x.style.display === "none") {
		x.style.display = "inline";
		x.style = "labelTitle";
	} else {
		x.style.display = "none";
	}

	x = document.getElementById("hS1");
	if (x.style.display === "none") {
		x.style.display = "inline";
		x.style = "labelTitle";
	} else {
		x.style.display = "none";
	}

	x = document.getElementById("hS2");
	if (x.style.display === "none") {
		x.style.display = "inline";
		x.style = "labelTitle";
	} else {
		x.style.display = "none";
	}

	x = document.getElementById("hS3");
	if (x.style.display === "none") {
		x.style.display = "inline";
		x.style = "labelTitle";
	} else {
		x.style.display = "none";
	}
}

/**
 * Method Xử lý delete cho trường hợp click vào button delete
 * 
 * @param message
 *            Nội dung confirm
 * @param URL
 *            Địa chỉ URL
 */
function deleteConfirm(message, userId) {
	var result = confirm(message);
	if (result) {
		// Tạo form
		var form = document.createElement("form");
		document.body.appendChild(form);
		// Gán giá trị cho các thuộc tính của form
		form.method = "post";
		form.action = "deleteUser.do";
		// Tạo thẻ input
		var input = document.createElement("input");
		// Gán giá trị cho các thuộc tính của thẻ input
		input.type = "hidden";
		input.name = "userId";
		input.value = userId;
		// Thêm thẻ input vào form đã tạo ở trên
		form.appendChild(input);
		// Submit form
		form.submit();
	}
}
