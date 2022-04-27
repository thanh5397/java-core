$("#login").click(function() {
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
$(".portfolio-wrap figure a").on("click", function(){
        var dataId = $(this).data("id");
        $.get(
		    `/detail/${dataId}`,
		    function (data) {
		        window.location.href = `/detail/${dataId}`;
		    }
		);
//        $.ajax({
//	        type: "GET",
//	        url: "/detail/" + dataId,
//	        data: dataId,
//	        contentType: "application/text; charset=utf-8",
//	        dataType: 'text',
//	        success: function()
//	        {
	        	
//			},
//	        error: function (e) {
	
//	        }
//    	});
});