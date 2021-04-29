const notifications = document.getElementById("notifications");
const courseSelector = document.getElementById("courseSelect");

const radioBtn1 = document.getElementById("5");
const radioBtn2 = document.getElementById("10");
const radioBtn3 = document.getElementById("20");
const radioBtn4 = document.getElementById("40");
const radioBtn5 = document.getElementById("80");

const submitButton = document.getElementById("formSubmit");
submitButton.addEventListener("click", formValidate);

function formValidate(e) {
	let msg = [];
	if ((radioBtn1.checked || radioBtn2.checked || radioBtn3.checked || radioBtn4.checked || radioBtn5.checked) == false) {
		msg.push("select number of rows");
		e.preventDefault();
	}

	var selectedValue = courseSelector.options[courseSelector.selectedIndex].value;
	if (selectedValue == "nocourse") {
		msg.push("Please select a course");
		e.preventDefault();
	}

	notifications.style.color = "red";
	notifications.innerText = msg.join(", ");
}