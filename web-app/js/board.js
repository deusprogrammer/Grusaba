function centerElement(selector) {
	var windowWidth = window.innerWidth;
	var windowHeight = window.innerHeight;
	var $element = $(selector);
	
	var horizontalOffset = $element.width() / 2;
	var verticalOffset   = $element.height() / 2;
	
	var horizontalMidpoint = windowWidth / 2;
	var verticalMidpoint   = windowHeight / 2;
	
	var top = verticalMidpoint - verticalOffset;
	var left = horizontalMidpoint - horizontalOffset;
	
	console.log("HOFFSET: " + horizontalOffset);
	console.log("VOFFSET: " + verticalOffset);
	console.log("HMID:    " + horizontalMidpoint);
	console.log("VMID:    " + verticalMidpoint);
	
	console.log("TOP:     " + top);
	console.log("LEFT:    " + left);
	
	$element.css("top", top);
	$element.css("left", left);
}

$(function () {
	centerElement("div.flash-message");
	
	$("button.flash-message").click(function() {
		$("div.flash-message").fadeOut("slow");
	})
})