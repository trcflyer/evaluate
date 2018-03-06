function checkInput (size){

	var num=$("input[checked]").length;
	if(num == size){
		return true;
	}else{
		$("#message").html("您尚有选项没有进行评价");
		return false;
	}
}
function myCheck(obj){
	//alert(obj.value); 
	$(obj).siblings().attr("checked",false);
	if(!$(obj).checked){
		$(obj).attr("checked",true);
	}
}