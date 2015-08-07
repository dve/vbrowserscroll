// Define the namespace
var browserscroll = browserscroll || {};

browserscroll.BrowserScroll = function(element) {
	var self = this; // Can't use this inside the function

	this.topThreshold = 0;
	this.firedOnTop = false;
	this.firedNotOnTop = false;

	$(".v-ui")
			.scroll(
					function() {
						var scrollTop = $(".v-ui").scrollTop();

						if (scrollTop <= self.topThreshold
								&& self.firedOnTop == false) {
							self.firedOnTop = true;
							self.firedNotOnTop = false;
							self.onTop(scrollTop);
						} else if (scrollTop > self.topThreshold
								&& self.firedNotOnTop == false) {
							self.firedOnTop = false;
							self.firedNotOnTop = true;
							self.notOnTop(scrollTop);
						}
					});

	this.onTop = function(scrollTop) {
		alert("Error: Must implement onTop(scrollTop) method");
	};

	this.notOnTop = function(scrollTop) {
		alert("Error: Must implement notOnTop(scrollTop) method");
	};

	this.setTopThreshold = function(topThreshold) {
		this.topThreshold = topThreshold;
	}

	this.getTopThreshold = function() {
		return this.topThreshold;
	}
}
