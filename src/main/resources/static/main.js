var outputId = "output"

var artistBtn = document.querySelector('.button1');

function queryArtists(){
    var request = new XMLHttpRequest();
    request.open('GET', 'http://localhost:8080/api/artists', true);
    var data;
    request.onload = function() {
        data = JSON.parse(this.response)
        if (request.status >= 200 && request.status < 400) { 
            data = response.json();
        }
    }
    console.log(data);
    return data;
}

artistBtn.addEventListener('click', function(){
    var output = document.getElementById(outputId);
    const data = queryArtists();
    output.innerHTML = 
    `<p>
    ${data.map(function(item) {
        return `<p>${item.name}</p>`
    }).join('')} <\p>`;
})

var albumsBtn = document.querySelector('.button2');

albumsBtn.addEventListener('click', function(){
    var output = document.getElementById(outputId);
    output.innerHTML = "<p>ASDSA<\p>"
})