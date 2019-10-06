//variable


//funktionen
function getCurrentURL(){
  function onGot(tabsInfo) {
    var tab = tabsInfo[0]
    save(tabsInfo[0])
    if (localStorage.check == 1){
      download()
    }
  }

  function onError(error) {
    console.log(`Error: ${error}`);
  }
  if(typeof browser !== 'undefined'){
  var gettingCurrent = browser.tabs.query({currentWindow: true, active: true});
  gettingCurrent.then(onGot, onError);
  }
  else{
    chrome.tabs.query({ active: true, currentWindow: true },onGot);
  }
}

function load(){
  var content = localStorage.links ;
  console.log(content)
  var list = JSON.parse(content);
  return list
  }
function show_list(){
  var X = document.getElementById("tabelle")
  X.innerHTML = ""
  var Z = load()
  for(i=0;i<Z.length;i++){
  var title = Z[i].title
  if (title.length > 50){
    title = title.substring(0,49)+"..."
  }
  X.innerHTML  += "<tr><td>"+title+"</td>"+/*<td><button id='"+i+"'></button></td>*/"</tr>"
  }
/*
  for(i=0;i<Z.length;i++){
  document.getElementById(i).onclick = function (e){
    e.target.parentNode.parentNode.RemoveChild(e.target.parentNode);
  };
  }
  */
}
function save(tab){
  var Linkliste = load()
    Linkliste.push({url:tab.url, title:tab.title})
    localStorage.links = JSON.stringify(Linkliste);
    show_list()
}
function clear(){
  var Linkliste = [];
  localStorage.links = JSON.stringify(Linkliste);
  show_list()
}
function loeschen(i){
alert("error"+i)
}
function download(){
JSON.parse(content)

}

function download() {
  var element = document.createElement('a');
  var content = localStorage.links
  element.setAttribute('href', 'data:LOL;charset=utf-8,' + encodeURIComponent(content));
  element.setAttribute('download', "shitSheet.json");

  element.style.display = 'none';
  document.body.appendChild(element);

  element.click();

  document.body.removeChild(element);
}
function check_checkbox(){
  var c=document.getElementById("check");
  if (c.checked) {
    localStorage.check = 1
  } else {
    localStorage.check = 0
  }
}
function load_checkbox(){
  var c=document.getElementById("check")
    if (localStorage.check == 1){
      c.checked = true
    }
    else{
      c.checked = false
    }
}
//Autostart

document.getElementById('add_entry').onclick = getCurrentURL;
document.getElementById('clear').onclick = clear;
document.getElementById('download').onclick = download;
document.getElementById('check').onclick = check_checkbox;
show_list()
load_checkbox()
