$(document).ready(function() {
	$("#submitButton").click(function() {
		getResult();
	});
});
function getResult() {
	let formData = $("#urlShortenForm").serialize();
	$.ajax({
		method: 'POST',
		url: '/rest/url/shorten',
		data: formData,
		success: function(result) {
			$("#result").val(result);
		}
	});
}