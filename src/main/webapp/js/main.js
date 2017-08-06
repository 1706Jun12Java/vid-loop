var vid = document.getElementsByTagName("video");
[].forEach.call(vid, function (item) {
    item.addEventListener('mouseover', hoverVideo, false);
    item.addEventListener('mouseout', hideVideo, false);
});

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
  document.getElementById("mySidebar").style.display = "none";
}
function hoverVideo(e) {   
console.log(e.target);
    this.play();
}
function hideVideo(e) {
    this.pause();
}