// Sample Order Data
const orders = [
    { id: 1, user: "John Doe", milk: "5", time: "10:30 AM", status: "Pending" },
    { id: 2, user: "Alice Smith", milk: "10", time: "11:00 AM", status: "Approved" },
    { id: 3, user: "Bob Williams", milk: "7", time: "12:15 PM", status: "Pending" },
    { id: 4, user: "Emma Brown", milk: "3", time: "01:00 PM", status: "Rejected" }
];

// Function to Load Orders in Table
function loadOrders() {
    const table = document.getElementById("orderTable");
    table.innerHTML = "";
    
    orders.forEach(order => {
        let row = `
            <tr>
                <td>${order.id}</td>
                <td>${order.user}</td>
                <td>${order.milk}</td>
                <td>${order.time}</td>
                <td>
                    <span class="${order.status === 'Approved' ? 'text-success' : order.status === 'Rejected' ? 'text-danger' : 'text-warning'}">
                        ${order.status}
                    </span>
                </td>
                <td>
                    <button class="btn-approve" onclick="updateStatus(${order.id}, 'Approved')">Approve</button>
                    <button class="btn-reject" onclick="updateStatus(${order.id}, 'Rejected')">Reject</button>
                </td>
            </tr>
        `;
        table.innerHTML += row;
    });
}

// Function to Update Order Status
function updateStatus(id, status) {
    const order = orders.find(o => o.id === id);
    if (order) {
        order.status = status;
        loadOrders();
    }
}

// Function to Search Orders
function searchOrders() {
    const searchText = document.getElementById("searchInput").value.toLowerCase();
    const tableRows = document.getElementById("orderTable").getElementsByTagName("tr");

    for (let row of tableRows) {
        let textContent = row.innerText.toLowerCase();
        row.style.display = textContent.includes(searchText) ? "" : "none";
    }
}

// Load Orders on Page Load
window.onload = loadOrders;
