function getCountry(input) {
	let text = input.value;

	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : '/api/countries',
		// Using of JSON.stringify is here IMPORTANT
		data : JSON.stringify({
			'substring' : text,
			'size' : 10
		}),
		dataType : "json",
		complete : function(data) {
			let response = data.responseJSON;
			let output = "";
			for (var i = 0; i < response.length; i++) {
				output += response[i]["countryName"] + "<br>";

			}
			$("#output").html(output);

		}
	});

}

function getCountry_Auto(input) {
	let text = input.value;
	let encodedURL = "http://localhost:8080/countries/search/findCountriesByCountryNameContains?sunstring="
			+ encodeURIComponent(text) + "&page=0&size=10";

	$.getJSON(encodedURL, function(data) {

		let response = data._embedded.countries;
		let output = "";
		for (var i = 0; i < response.length; i++) {
			output += response[i]["countryName"] + "<br>";

		}
		$("#output").html(output);

	});

}





function getCountry_OurJSON(input) {
	let text = input.value;

	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : '/api/countries',
		// Using of JSON.stringify is here IMPORTANT
		data : JSON.stringify({
			'substring' : text,
			'size' : 10
		}),
		dataType : "json",
		complete : function(data) {
			console.log(data);
			let response = data.responseJSON;
			let output = "";
			for (var i = 0; i < response.length; i++) {
				output += response[i]["countryName"] + "<br>";

			}
			$("#output").html(output);

		}
	});

}
