
function getCurrentURL(){
  function onGot(tabsInfo) {
    console.log(tabsInfo);
    var tab = tabsInfo[0]
    console.log(tab.url);



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
document.getElementById('add_entry').onclick = getCurrentURL;
