function log(msg) {
      var messagesDiv = document.getElementById('messages');
      var elem = document.createElement('div');
      var txt = document.createTextNode(msg);
      elem.appendChild(txt);
      messagesDiv.append(elem);
}
window.addEventListener('load', function (e) {
    log("window has loaded.");
    var eventSource = new EventSource('http://localhost:8080/consume/interval');  
        eventSource.addEventListener('message', function (e) {
            e.preventDefault();
            log(e.data);
        });
    eventSource.addEventListener('error', function (e) { 
        e.preventDefault();
        log('closing the EventSource...');
        eventSource.close();
    }); 
});