var timeCheck;
const notifications = document.getElementById("notifications");

document.addEventListener("DOMContentLoaded", () => {
	getTable();
	//requests for the table every 5 seconds
	setInterval(getTable, 5000);
});

function getTable() {
	const target = document.getElementById("tableplaceholder");
	fetch("./application?action=ranklog")
		.then(response => response.text())
		.then((response) => {
			target.innerHTML = response
		})
		.catch(err => console.log(err))
}

function makeRank() {
	let timeLeft = ((new Date() - timeCheck) / 1000);


	if ((timeLeft > 10) || (isNaN(timeLeft))) {
		let xhr = new XMLHttpRequest();
		xhr.open('GET', "./application?action=makerank", true);
		xhr.send();
		notifications.style.color = "green";
		notifications.innerText = `Ranklist Creation Started`;
		timeCheck = new Date();

	} else {
		notifications.style.color = "red";
		notifications.innerText = `Wait ${(10-timeLeft).toFixed(1)} Seconds to create new ranklist`;
	}
}