const mgunoRadio = document.getElementById("mguno");
const admnoRadio = document.getElementById("admno");
const nameRadio = document.getElementById("name");

const searchInput = document.getElementById("queryBox");
const submitButton = document.getElementById("searchbtn");

const notifications = document.getElementById("notifications");

submitButton.addEventListener("click", formValidate);
function formValidate(e) {
	let msg = [];
	if ((mgunoRadio.checked || admnoRadio.checked || nameRadio.checked) === false) {
		msg.push("select any options");
		e.preventDefault();
	}

	if (searchInput.value === "") {
		msg.push("Empty search Query");
		e.preventDefault();
	}

	if ((mgunoRadio.checked || admnoRadio.checked) === true) {
		if (isNaN(searchInput.value)) {
			msg.push("MGU,Applications numbers must be digits");
			e.preventDefault();
		}
	}

	notifications.style.color = "red";
	notifications.innerText = msg.join(", ");
}