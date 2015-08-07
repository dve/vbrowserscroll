window.de_vegetweb_vbrowserscroll_BrowserScroll = function() {
	// Create the component
	var browserScroll = new browserscroll.BrowserScroll(this.getElement());

	// Handle changes from the server-side
	this.onStateChange = function() {
		browserScroll.setTopThreshold(this.getState().topThreshold);
	};

	// Pass user interaction to the server-side
	var self = this;
	browserScroll.onTop = function(scrollTop) {
		self.onTop(scrollTop);
	};
	
	browserScroll.notOnTop = function(scrollTop) {
		self.notOnTop(scrollTop);
	};
};