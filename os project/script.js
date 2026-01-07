// Maximum buffer size
const bufferSize = 5;

// Load buffer from localStorage or start empty
let buffer = JSON.parse(localStorage.getItem("buffer")) || [];

/**
 * Save current buffer to localStorage
 */
function saveBuffer() {
    localStorage.setItem("buffer", JSON.stringify(buffer));
}

/**
 * Produce an item
 */
function produce() {
    if (buffer.length >= bufferSize) {
        showMessage("Buffer Full! Cannot Produce");
        return;
    }

    buffer.push("item"); // Add item
    saveBuffer();        // Save buffer
    updateBuffer();
    showMessage("Item Produced Successfully");
}

/**
 * Consume an item
 */
function consume() {
    if (buffer.length === 0) {
        showMessage("Buffer Empty! Cannot Consume");
        return;
    }

    const bufferDiv = document.getElementById("buffer");
    const lastItem = bufferDiv.lastElementChild;

    if (lastItem) {
        lastItem.classList.add("remove"); // Animate removal

        setTimeout(() => {
            buffer.pop();   // Remove item
            saveBuffer();   // Save buffer
            updateBuffer();
            showMessage("Item Consumed Successfully");
        }, 400); // matches CSS remove animation
    }
}

/**
 * Update the buffer visually
 */
function updateBuffer() {
    const bufferDiv = document.getElementById("buffer");
    bufferDiv.innerHTML = "";

    // Show items
    buffer.forEach(() => {
        const div = document.createElement("div");
        div.className = "item";
        bufferDiv.appendChild(div);
    });

    // Show empty slots
    const emptySlots = bufferSize - buffer.length;
    for (let i = 0; i < emptySlots; i++) {
        const div = document.createElement("div");
        div.className = "empty-slot";
        bufferDiv.appendChild(div);
    }
}

/**
 * Show temporary message with fade animation
 */
function showMessage(msg) {
    const message = document.getElementById("message");
    message.innerText = msg;

    // Reset animation
    message.style.animation = "none";
    message.offsetHeight; // trigger reflow
    message.style.animation = "fadeMsg 0.5s ease";
}

// Initialize buffer on page load
document.addEventListener("DOMContentLoaded", updateBuffer);
