function setFocus(){
    document.getElementById("first").focus();
}
function showHide() {
    var lblLevelJapans = document.getElementsByClassName('lbl-level-japan');
    for(let i = 0; i < lblLevelJapans.length; i ++)
        if(lblLevelJapans[i].style.display == "")
            lblLevelJapans[i].style.display = "none";
        else lblLevelJapans[i].style.display = "";
}

function showDeleteDialog (message, userId) {
    if (!confirm(message)){
        return false;
    } else {
    	var formDelete = document.createElement("form");
    	formDelete.method = "post";
    	formDelete.action = "DeleteUserInfor.do";
    	var userIdElement = document.createElement("input");
    	userIdElement.type='hidden';
    	userIdElement.name="userId";
    	userIdElement.value=userId;
    	formDelete.appendChild(userIdElement);
    	document.body.appendChild(formDelete);
    	formDelete.submit();
    }
}