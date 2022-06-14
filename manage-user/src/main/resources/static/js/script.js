//function setFocus(){
//    document.getElementById("first").focus();
//}
function showHide() {
    var lblLevelJapans = document.getElementsByClassName('lbl-level-japan');
    for(let i = 0; i < lblLevelJapans.length; i ++)
        if(lblLevelJapans[i].style.display == "")
            lblLevelJapans[i].style.display = "none";
        else lblLevelJapans[i].style.display = "";
};

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
};
$(document).on("click",".btn_login",function() {
	var username = $("#loginName").val();
	var password = $("#password").val();
	alert(username);
	alert(password);
	$.ajax({
        type: "POST",
        url: "/Login.do",
        data: {
			    "loginName" : username,
			    "password" : password
			   },
        contentType: "application/text; charset=UTF-8",
        dataType: 'text',
        success: function(data)
        {
        	alert("true");
       		var json = "<h4>Ajax Response</h4>&lt;pre&gt;"
                + JSON.stringify(data, null, 4) + "&lt;/pre&gt;";
			$('#feedback').html(json);
            console.log("SUCCESS : ", data);
		},
        error: function (e) {

            var json = "<h4>Ajax Response</h4>&lt;pre&gt;"
                + e.responseText + "&lt;/pre&gt;";
            $('#feedback').html(json);

            console.log("ERROR : ", e);

        }
    });
});