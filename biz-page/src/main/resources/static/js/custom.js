$("#login").click(function() {
	var username = $("#username").val();
	var password = $("#password").val();
	var json = {userName:username,password:password};
	var obj = JSON.stringify(json);
	
	$.ajax({
        type: "POST",
        url: "/api/login",
        data: obj,
        contentType: "application/json; charset=utf-8",
        dataType: 'json',
        success: function(data)
        {
        	alert(data);
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
	var json = {id:dataId,address:address,phoneNumber:phoneNumber,email:email};
	var obj = JSON.stringify(json);
	$.ajax({
		type: "PUT",
	    url: "/api/contact/" + dataId,
	    data:obj, 
	    contentType: "application/json; charset=utf-8",
        dataType: 'json',
	    success :function(result) {
	    	var json = JSON.stringify(result);
	    	var contact = JSON.parse(json);
	    	$('#example1 tbody tr').empty();
	    	$('#example1 tbody tr').html(
	    			'<td style="display: none;" data-id="'+contact.id+'">'+contact.id+'</td>'
	    			+ '<td id="address" style="width:500px;max-width: 500px;word-break: break-all;white-space: pre-wrap;">'+contact.address+'</td>'
	    			+ '<td id="phoneNumber" style="width:200px;max-width: 200px;word-break: break-all;white-space: pre-wrap;">'+contact.phoneNumber+'</td>'
	    			+ '<td id="email" style="width:200px;max-width: 200px;word-break: break-all;white-space: pre-wrap;">'+contact.email+'</td>'
	    			+ '<td id="function" style="width:100px;max-width: 200px;word-break: break-all;white-space: pre-wrap;">'
	    			+ '<button id="btn-edit" type="button" class="btn btn-light">Sửa</button>'
	    			+ '<button id="btn-xoa" type="button" class="btn btn-light">Xóa</button>'
	    			+ '</td>');
	    	toastr.success('Cập nhật thành công!');
	    },
	    error: function (e) {
	    	toastr.error('Cập nhật thất bại!');
	    }
	});
});
$(document).on('click','#btn-xoa',function(){
	if(confirm("Bạn có muốn xóa dòng này ?")) {
		var dataId = $('#example1 tbody tr td').data("id");
		$.ajax({
			type: "DELETE",
		    url: "/api/contact/" + dataId,
		    success :function(result) {
		    	if(result) {
		    		$('#btn-xoa').closest("tr").remove();
			    	toastr.success('Xóa bản ghi thành công!');
		    	} else {
		    		toastr.error('Xoá bản ghi thất bại!');
		    	}
		    },
			error: function (e) {
		    	toastr.error('Xoá bản ghi thất bại!');
		    }
		});
	}
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
//	    		    	window.location.href = `/detail`;
//	    		    	var json =  JSON.parse(data);
//	    		    	alert(json);
//	    		    	alert(data.client);
//	    		    	$("#client").show().html(json.client);
//	    		    	$('#client').text(json.client);
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