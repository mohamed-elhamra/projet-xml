fetch('/rss22/resume/html')
    .then(response => response.text())
    .then(data => {
        const parser = new DOMParser();
        let tr = [];
        tr.push('<table border="1" class="table table-striped table-responsive-md mt-2" id="table">')
        tr.push('<thead class="thead-dark">')
        tr.push('<tr>')
        tr.push('<th>Guid</th>')
        tr.push('<th>Titre</th>')
        tr.push('<th>Date</th>')
        tr.push('<th>Actions</th>')
        tr.push('</tr>');
        tr.push('</thead>')
        const xml = parser.parseFromString(data, "application/xml");
        const itemObject = xml.documentElement.childNodes;
        for (let i = 0; i < itemObject.length; i++) {
            tr.push('<tr>');
            tr.push('<td>' + itemObject[i].childNodes[0].textContent + '</td>');
            tr.push('<td>' + itemObject[i].childNodes[1].textContent + '</td>');
            tr.push('<td>' + itemObject[i].childNodes[2].textContent + '</td>');
            tr.push(
                `<td>` +
                `<input onclick="itemDetails('${itemObject[i].childNodes[0].textContent}');" class="btn btn-success mr-2" type="button" value="Détails"/>` +
                `<input onclick="itemXml('${itemObject[i].childNodes[0].textContent}');" class="btn btn-info mr-2" type="button" value="Affichage format XML"/>` +
                `<input onclick="deleteItem('${itemObject[i].childNodes[0].textContent}');" class="btn btn-danger mr-2" type="button" value="Supprimer"/>` +
                `</td>`
            )
            tr.push('</tr>');
        }
        tr.push('</tbody>')
        tr.push('</table>')
        document.getElementById("div").innerHTML = tr.join('')
    })
    .catch(console.error);

const deleteItem = (guid) => {
    const fetchInit = {method: 'DELETE'};
    fetch(`/rss22/delete/${guid}`, fetchInit)
        .then(response => response.text())
        .then(data => {
            let deleteItemDiv = document.getElementById("deletedItem");
            deleteItemDiv.innerText = `Ces informations (Article supprimé) seront disaprus après 10 secondes : \n\n ${data} \n`;
            setTimeout(() => {
                window.location.href = '/items_list';
            }, 10000);
        })
        .catch(console.error);
}

const itemDetails = (guid) => {
    window.location.href = `/item_details/${guid}`;
}

const itemXml = (guid) => {
    window.location.href = `/rss22/resume/xml/${guid}`;
}
