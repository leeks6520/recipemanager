document.addEventListener("DOMContentLoaded", () => {
    const startButton = document.getElementById("start-button");
    const statusElement = document.getElementById("status");

    function showStatus(message, isError = false) {
        if (statusElement) {
            statusElement.textContent = message;
            statusElement.style.color = isError ? "red" : "green";
        }
    }

    if (startButton) {
        startButton.addEventListener("click", () => {
            showStatus("Please run the Java application in your terminal.");
        });
    }
});
