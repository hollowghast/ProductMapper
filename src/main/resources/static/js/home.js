let mapCenter = [47.07, 15.44];
let mapDefaultZoom = 13;
let map = undefined;
let mapActiveMarker = undefined;


function injectBootstrap() {
    Array.from(document.getElementsByTagName('ul'))
        .forEach(ul => ul.classList.add("list-group"));
    Array.from(document.getElementsByTagName('li'))
        .forEach(li => li.classList.add("list-group-item"));
}

function loadMap() {
    map = L.map('map').setView(mapCenter, mapDefaultZoom);

    L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
        attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/">OpenStreetMap</a> contributors',
        maxZoom: 18,
    }).addTo(map);
}

function loadPage(url) {
    window.location.href = url;
}

function changeShowButton(id, newText, nextOnclick) {
    let btn = document.getElementById(id);
    btn.textContent = newText;
    btn.onclick = nextOnclick;
}

function showAddresses() {
    changeShowButton('btn_showAllAddresses', "Hide all addresses", hideAddresses);

    let addresses = fetch('/address/all');

    //let view = document.getElementById('viewAllAddresses');

    addresses.then(response => response.json())
        .then(data => {
            let html = "";
            data.forEach(item => {
                html += `<ul onclick="setMarker('${item.zipcode} ${item.city}, ${item.street}')" >`;
                console.log(`${item.zipcode}` + `${item.city}` + `${item.street}`);
                html += `<li>${item.zipcode}</li>`;
                html += `<li>${item.city}</li>`;
                html += `<li>${item.street}</li>`;
                html += '</ul>';
                html += "<hr>";
            });


            document.getElementById('view_allAddresses').innerHTML = html;
            injectBootstrap();
        });
    //.then(data => JSON.parse(data))
    //.then(x => view.appendChild(x));
}

function hideAddresses() {
    changeShowButton('btn_showAllAddresses', "Show all addresses", showAddresses);
    document.getElementById('view_allAddresses').innerHTML = "";
    //document.getElementById('view_allAddresses').style.display = 'none';
}


function showStores() {
    changeShowButton('btn_showAllStores', "Hide all stores", hideStores);

    let stores = fetch('/store/all');

    stores.then(response => response.json())
        .then(data => {
            let html = "<table class='table'>";
            html += "<thead>";
            html += "<tr>";
            html += "<th>Company name</th>";
            html += "<th>City</th>";
            html += "</tr>";
            html += "</thead>";
            html += "<tbody>";
            data.forEach(item => {
                html += `<tr onclick="loadPage('html/store.html?id=${item.id}')" >`;
                html += `<td>${item.company.name}</td>`;
                html += `<td>${item.address.city}</td>`;
                html += '</tr>';
            });
            html += "</tbody>";
            html += "</table>";

            document.getElementById('view_allStores').innerHTML = html;
            injectBootstrap();
        });
    //.then(data => JSON.parse(data))
    //.then(x => view.appendChild(x));
}

function hideStores() {
    changeShowButton('btn_showAllStores', "Show all stores", showStores);
    document.getElementById('view_allStores').innerHTML = "";
}


function showCompanies() {
    changeShowButton('btn_showAllCompanies', "Hide all companies", hideCompanies);

    let companies = fetch('/company/all');

    //let view = document.getElementById('viewAllBaseProducts');

    companies.then(response => response.json())
        .then(data => {
            let html = "";
            data.forEach(item => {
                html += `<ul>`;
                html += `<li>${item.logo}</li>`;
                html += `<li>${item.name}</li>`;
                html += '</ul>';
                html += "<hr>";
            });

            document.getElementById('view_allCompanies').innerHTML = html;
            injectBootstrap();
        });
    //.then(data => JSON.parse(data))
    //.then(x => view.appendChild(x));
}

function hideCompanies() {
    changeShowButton('btn_showAllCompanies', "Show all companies", showCompanies);
    document.getElementById('view_allCompanies').innerHTML = "";
}


function showBaseProducts() {
    changeShowButton('btn_showAllBaseProducts', "Hide all products", hideBaseProducts);

    let baseProducts = fetch('/base_product/all');

    //let view = document.getElementById('viewAllBaseProducts');

    baseProducts.then(response => response.json())
        .then(data => {
            let html = "";
            data.forEach(item => {
                html += `<ul>`;
                html += `<li>${item.barcode}</li>`;
                html += `<li>${item.serial_number}</li>`;
                html += `<li>${item.name}</li>`;
                html += `<li>${item.price_unit}</li>`;
                html += `<li>${item.net_mass}</li>`;
                html += `<li>${item.currency}</li>`;
                html += `<li>${item.mass_unit}</li>`;
                html += `<li>${item.brand.name}</li>`;
                html += '</ul>';
                html += "<hr>";
            });

            document.getElementById('view_allBaseProducts').innerHTML = html;
            injectBootstrap();
        });
    //.then(data => JSON.parse(data))
    //.then(x => view.appendChild(x));
}

function hideBaseProducts() {
    changeShowButton('btn_showAllBaseProducts', "Show all products", showBaseProducts);
    document.getElementById('view_allBaseProducts').innerHTML = "";
}

function showBrands() {
    changeShowButton('btn_showAllBrands', "Hide all brands", hideBrands);

    let brands = fetch('/brand/all');

    //let view = document.getElementById('viewAllBaseProducts');

    brands.then(response => response.json())
        .then(data => {
            let html = "";
            data.forEach(item => {
                html += `<ul>`;
                html += `<li>${item.name}</li>`;
                html += '</ul>';
                html += "<hr>";
            });

            document.getElementById('view_allBrands').innerHTML = html;
            injectBootstrap();
        });
    //.then(data => JSON.parse(data))
    //.then(x => view.appendChild(x));
}

function hideBrands() {
    changeShowButton('btn_showAllBrands', "Show all brands", showBrands);
    document.getElementById('view_allBrands').innerHTML = "";
}


async function fetchGpsCoordinates(address) {
    let coords = null;
    await fetch('https://nominatim.openstreetmap.org/search/' + convertAddressForURI(address) + '?format=json')
        .then(response => response.json())
        .then(data => {
            if (data.length > 0) {
                let lat = parseFloat(data[0].lat);
                let lon = parseFloat(data[0].lon);
                coords = [lat, lon];
            }
        });
    return coords;
}

function convertAddressForURI(address) {
    const tokens = address.replaceAll(",", "").split(" ");

    let res = "";
    for (let i = 0; i < tokens.length; i++) {
        res += encodeURIComponent(tokens[i]);
        if (i != tokens.length - 1) res += '+';
    }

    return res;
}

function setMarker(address) {
    if (address == null) address = 'Griesplatz 1, 8020 Graz';

    fetch('https://nominatim.openstreetmap.org/search/' +
            /*encodeURIComponent(address) + */
            convertAddressForURI(address) +
            '?format=json')
        .then(response => response.json())
        .then(data => {
            if (data.length > 0) {
                let lat = parseFloat(data[0].lat);
                let lon = parseFloat(data[0].lon);

                // Create a marker at the coordinates
                if (mapActiveMarker != undefined) map.removeLayer(mapActiveMarker);
                mapActiveMarker = L.marker([lat, lon]);
                mapActiveMarker.addTo(map);
                // Set the map view to the marker location
                map.setView([lat, lon], 13);
            } else {
                console.log('No results found for the address');
            }
        })
        .catch(error => {
            console.error('Error:', error);
        });
}

async function centerMapOn(city) {
    //const city = prompt("Hey, mind sharing your city with us? \nWould look better if we showed you stores near you",
    //    "8010 Graz");

    if (city == null || city.trim() == "") return;
    const coords = await fetchGpsCoordinates(city);
    if (coords == null || coords.length == 0) return;
    mapCenter = coords;
    map.setView(mapCenter, mapDefaultZoom);
}


window.addEventListener('load',
    function() {
        loadMap();
        //askAddress();
    }
);