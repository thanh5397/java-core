$( "#login").click(function() {
	var username = $("#username").val();
	var password = $("#password").val();
	var json = '{"userName":"'+username+'","password":"'+password+'"}';
	var obj = jQuery.parseJSON(json);
	
	$.ajax({
        type: "POST",
        url: "/api/login",
        data: json, 
        contentType: "application/json; charset=utf-8",
        dataType: 'json',
        success: function(data)
        {
//        	$.each(data, function(index, currEmp) {
                console.log(data); //to print name of employee
//            }); 
        }
    });
});