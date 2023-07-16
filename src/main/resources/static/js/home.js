let addresses = undefined;

let map = undefined;
let mapActiveMarker = undefined;

function injectBootstrap() {
    Array.from(document.getElementsByTagName('ul'))
        .forEach(ul => ul.classList.add("list-group"));
    Array.from(document.getElementsByTagName('li'))
        .forEach(li => li.classList.add("list-group-item"));
}

function loadMap() {
    map = L.map('map').setView([47.07, 15.44], 13);

    L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
        attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/">OpenStreetMap</a> contributors',
        maxZoom: 18,
    }).addTo(map);
}

function showAddresses() {
    addresses = fetch('/address/all');

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

            document.getElementById('viewAllAddresses').innerHTML = html;
            injectBootstrap();
        });
    //.then(data => JSON.parse(data))
    //.then(x => view.appendChild(x));
}


function showStores() {
    stores = fetch('/store/all');

    stores.then(response => response.json())
        .then(data => {
            let html = "";
            data.forEach(item => {
                html += `<ul>`;
                html += `<li>${item.company.name}</li>`;
                html += `<li>${item.address.city}</li>`;
                html += '</ul>';
                html += "<hr>";
            });

            document.getElementById('viewAllStores').innerHTML = html;
            injectBootstrap();
        });
    //.then(data => JSON.parse(data))
    //.then(x => view.appendChild(x));
}



function showCompanies() {
    addresses = fetch('/company/all');

    //let view = document.getElementById('viewAllAddresses');

    addresses.then(response => response.json())
        .then(data => {
            let html = "";
            data.forEach(item => {
                html += `<ul>`;
                html += `<li>${item.logo}</li>`;
                html += `<li>${item.name}</li>`;
                html += '</ul>';
                html += "<hr>";
            });

            document.getElementById('viewAllCompanies').innerHTML = html;
            injectBootstrap();
        });
    //.then(data => JSON.parse(data))
    //.then(x => view.appendChild(x));
}

function showBaseProducts() {
    addresses = fetch('/base_product/all');

    //let view = document.getElementById('viewAllAddresses');

    addresses.then(response => response.json())
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

            document.getElementById('viewAllBaseProducts').innerHTML = html;
            injectBootstrap();
        });
    //.then(data => JSON.parse(data))
    //.then(x => view.appendChild(x));
}

function showBrands() {
    addresses = fetch('/brand/all');

    //let view = document.getElementById('viewAllAddresses');

    addresses.then(response => response.json())
        .then(data => {
            let html = "";
            data.forEach(item => {
                html += `<ul>`;
                html += `<li>${item.name}</li>`;
                html += '</ul>';
                html += "<hr>";
            });

            document.getElementById('viewAllBrands').innerHTML = html;
            injectBootstrap();
        });
    //.then(data => JSON.parse(data))
    //.then(x => view.appendChild(x));
}

function fetchGpsCoordinates(address) {
    fetch('https://nominatim.openstreetmap.org/search/' + encodeURIComponent(address) + '?format=json')
        .then(response => response.json())
        .then(data => {
            if (data.length > 0) {
                let lat = parseFloat(data[0].lat);
                let lon = parseFloat(data[0].lon);
                return [lat, lon];
            }
        });
}

function setMarker(address) {
    if (address == null) address = 'Griesplatz 1, 8020 Graz';

    fetch('https://nominatim.openstreetmap.org/search/' + encodeURIComponent(address) + '?format=json')
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

window.addEventListener('load',
    function() {
        loadMap();
    }
);