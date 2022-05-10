function onSubmit() {
    fetch('/rss22/insert', {
        method: "POST",
        body: document.getElementById("item").value,
        headers: {"Content-type": "application/xml; charset=UTF-8"}
    })
        .then(response => response.text())
        .then(data => document.documentElement.append(data))
        .catch(err => console.log(err));
    setTimeout(() => {
        window.location.reload();
    }, 5500);
}