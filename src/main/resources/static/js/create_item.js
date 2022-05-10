function onSubmit() {
    fetch('/rss22/insert', {
        method: "POST",
        body: document.getElementById("item").value,
        headers: {"Content-type": "application/xml; charset=UTF-8"}
    })
        .then(response => response.text())
        .then(data => {
            const createdItem = document.getElementById('created_item');
            createdItem.innerText = `Ces informations (Article créé) seront disaprus après 10 secondes : \n\n ${data} \n`;
            setTimeout(() => {
                window.location.reload();
            }, 10000);
        })
        .catch(err => console.log(err));
}