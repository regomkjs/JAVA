$(".btn").click(()=>{
	let title = $("#title")[0].value;
	let writer = $("#writer")[0].value;
	let content = $("#content")[0].value;
	if(!title || !writer || !content){
		alert("빈 항목이 있습니다.")
		return false;
	}
	count++;
	let inputTable;
	if($(".list-body").find("th").text()=="아직 등록된 글이 없습니다"){
		$(".list-body").empty();
	}
	let num = count;
	
	inputTable = `<tr class="tr"><td class="num">${num}</td><td><a href="#" class="a">${title}</a></td><td>${writer}</td><td class="view">0</td></tr>`
	$(".list-body").prepend(inputTable)
	inputTitle = `<h2 class="title-content box${num}">${title}</h2>`
	inputWriter = `<div class="writer-content box${num}"> 작성자 : ${writer}</div>`
	inputContent = `<div class="content box${num}">${content}</div>`
	$(".content-container").append(inputTitle)
	$(".content-container").append(inputWriter)
	$(".content-container").append(inputContent)
	$("#title")[0].value = ""
	$("#writer")[0].value = ""
	$("#content")[0].value = ""
	
	$(".tr").click(function(){
		$(".modal").show()
		$(this).find(".view")[0].innerText = `${parseInt($(this).find(".view")[0].innerText)+1}`;
		let boxNum = $(this).find(".num")[0].innerText;
		$(".content-container").children().not(`.box${boxNum}`).hide();
		$(".btn-close").show();
		console.log(boxNum)
		$(`.box${boxNum}`).show();
		stop(aaa);
	})
	$(".btn-close").click(()=>{
		$(".modal").hide();
	})
	
	return false;
	
	
})