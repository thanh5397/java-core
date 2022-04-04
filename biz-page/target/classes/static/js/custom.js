$( "#login").click(function() {
	var username = $("#username").val();
	var password = $("#password").val();
	var json = '{"userName":"'+username+'","password":"'+password+'"}';
	var obj = jQuery.parseJSON(json);
	
	$.ajax({
        type: "POST",
        url: "/login",
        data: username,
        	  password,
//        contentType: "application/json; charset=utf-8",
        dataType: 'text',
        success: function(data)
        {
//        	alert(JSON.stringify(data));
        }
    });
});