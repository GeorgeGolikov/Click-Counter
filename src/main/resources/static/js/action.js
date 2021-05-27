document.getElementById("clicker").onclick = updateCount;

getCount();

function getCount() {
    let xhr = new XMLHttpRequest();
    xhr.open("GET", '/click-counter/value', false)
    xhr.setRequestHeader('Content-type', 'application/json; charset=utf-8');
    xhr.send();

    if (xhr.status == 200) {
        document.getElementById("count").value = JSON.parse(xhr.response).value;
    }
}

function updateCount() {
    let xhr = new XMLHttpRequest();
    xhr.open("POST", '/click-counter/update', false)
    xhr.setRequestHeader('Content-type', 'application/json; charset=utf-8');
    xhr.send();

    if (xhr.status == 200) {
        getCount();
    }
}