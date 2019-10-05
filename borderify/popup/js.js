
function getCurrentURL(){
  function onGot(tabsInfo) {
    console.log(tabsInfo);
    var tab = tabsInfo[0]
    console.log(tab);
    console.log(tab.url);



  }

  function onError(error) {
    console.log(`Error: ${error}`);
  }
  var gettingCurrent = browser.tabs.query({currentWindow: true, active: true});
  gettingCurrent.then(onGot, onError);
  //console.log(url)
  //window.open(url);
}
document.getElementById('add_entry').onclick = getCurrentURL;
