
function decideNav() {
var style = document.getElementById("mySidebar").style.display;
if (style === "none"){
openNav();
}
else if (style === "block") {
closeNav();
}
}

function openNav() {

  document.getElementById("mySidebar").style.display = "block";
}
function closeNav() {
  document.getElementById("mySidebar"). style.display = "none";
}