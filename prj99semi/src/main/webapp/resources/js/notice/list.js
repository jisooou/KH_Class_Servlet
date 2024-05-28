$.ajax({
	url: "http://127.0.0.1:8888/app/rest/notice/list",
	method: "GET",
	data: {
		pno: 1
	},
	success: function(x) {
		console.log("통신 성공");
		console.log(x);

		let str = "";

		for (let i = 0; i < x.length; i++) {
			str += "<tr>";
			str += "<td>" + x[i].no + "</td>";
			str += "<td>" + x[i].title + "</td>";
			str += "<td>" + x[i].writerNick + "</td>";
			str += "<td>" + x[i].hit + "</td>";
			str += "<td>" + x[i].createDate + "</td>";
			str += "</tr>";
		}
		
		const tbody = document.querySelector("main table>tbody");
		tbody.innerHTML = str;

	},
	fail: function() {
		console.log("통신 실패");
	},
});