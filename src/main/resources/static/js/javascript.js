var is_url=false;
function search_url(){
	var url=document.getElementById("search_url").value.replace(/(^\s*)|(\s*$)/g, '');
	var but=document.getElementById("search_but");
	if(url!==undefined&&url!==''&&url!=null){
		is_url=true;
		but.setAttribute("style","border-color: #0073eb;background-color: #0073eb;color: #fff;");
	}
	else{
		is_url=false;
		but.setAttribute("style","border-color: #606060;background-color: rgba(0,0,0,.45);color: black;");
	}
}
function search_but(){
	if(is_url){
		document.getElementById("background").style.backgroundImage="url("+document.getElementById("search_url").value+")";
	}
}
function search_local(){
	document.getElementById("background").style.backgroundImage="url("+window.URL.createObjectURL(document.getElementById("search_local").files.item(0))+")";
	var file = document.getElementById("search_local").files[0];
	var fromDada = new FormData();
	fromDada.append("file", file);

	$.ajax({
		"url": "/picture",
		"type": "POST",
		"data": fromDada,
		contentType: false,
		processData: false,
		"success": function () {
			alert("ok");
		},
		error: function () {
			alert("error");
		}
	});
}