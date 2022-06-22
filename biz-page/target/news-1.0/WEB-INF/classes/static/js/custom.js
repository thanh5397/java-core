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
$("#contact").click(function() {
	$('#content').load('contact');
});
var data_before;
$(document).on('click','#btn-edit',function(){
	    data_before = $('#example1 tbody tr').html();
		$('#example1 tbody tr').css("background-color", "White");
		$('#address').attr('contenteditable', 'true');
		$("#phoneNumber").attr('contenteditable', 'true');
		$("#email").attr('contenteditable', 'true');
		$('#function').empty();
		$('#function').append('<button id="btn-dongy" type="button" class="btn btn-light">Đồng ý</button><button id="btn-huy" type="button" class="btn btn-light">Hủy</button>');
});
$(document).on('click','#btn-huy',function(){
		$('#example1 tbody tr').html(data_before);
		$('#example1 tbody tr').trigger('change');
		$('#example1 tbody tr').css("background-color", "DarkGrey");
		$('#address').attr('contenteditable', 'false');
		$("#phoneNumber").attr('contenteditable', 'false');
		$("#email").attr('contenteditable', 'false');
});
$(document).on('click','#btn-dongy',function(){
	var dataId = $('#example1 tbody tr td').data("id");
	var address = $('#address').text();
	var phoneNumber = $('#phoneNumber').text();
	var email = $('#email').text();
	var json = '{"address":"'+address+'","phoneNumber":"'+phoneNumber+'","email":"'+email+'"}';
	alert(json);
	var obj = JSON.stringify(json);
	alert(obj);
	$.ajax({
		type: "PUT",
	    url: "/api/contact/" + dataId,
	    data:obj, 
	    contentType: "application/json; charset=utf-8",
        dataType: 'json',
	    success :function(result) {
	    	
	    }  
	});
});
$(".portfolio-wrap figure a").on("click", function(){
        var dataId = $(this).data("id");
        	if(!!dataId) {
        		window.location.href = '/detail/' + dataId;
//	        	$.get(
//	    		    `/api/detail/${dataId}`,
//	    		    function (data) {
//	    		    	$.ajax({
//	    		    		type: "POST",
//	    		    	    url: "/detail",
//	    		    	    data:data, 
//	    		    	    contentType: "application/json; charset=utf-8",
//	    		            dataType: 'json',
//	    		    	    success :function(result) {
//	    		    	         }  
//	    		    	});
//	    		    	$.session.set("data", data);
//	    		    	window.location.href = `/detail`;
//	    		    	var json =  JSON.stringify(data, null, 4)
//	    		    	alert(json);
//	    		    	alert(data.client);
//	    		    	$("#client").show().html(data.client);
//	    		    	$('#client').text(data.client);
//	    		    }
//	        	);
        	}
//        $.ajax({
//	        type: "GET",
//	        url: "/detail/" + dataId,
//	        data: dataId,
//	        contentType: "application/text; charset=utf-8",
//	        dataType: 'text',
//	        success: function()
//	        {
//	        	
//			},
//	        error: function (e) {
//	
//	        }
//    	});
});