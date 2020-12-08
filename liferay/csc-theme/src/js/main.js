AUI().ready(

	/*
	This function gets loaded when all the HTML, not including the portlets, is
	loaded.
	*/

	function() {
	}
);

Liferay.Portlet.ready(

	/*
	This function gets loaded after each and every portlet on the page.

	portletId: the current portlet's id
	node: the Alloy Node object of the current portlet
	*/

	function(portletId, node) {
	}
);

Liferay.on(
	'allPortletsReady',

	/*
	This function gets loaded when everything, including the portlets, is on
	the page.
	*/

	function() {
	}
);

AUI().ready('anim', 'class-toggle', 'event-onscreen', 'yui-throttle', function(
	A
) {
	var BODY = A.getBody();

	var HTML = A.one('html');

	var WIN = A.getWin();

	var bannerHeight = 0;

	var banner = A.one('#navigation');

	if (banner) {
		bannerHeight = banner.get('clientHeight');
	}

	var triggerPos = 200;

	BODY.delegate(
		'click',
		function(event) {
			var node = event.currentTarget;

			var section = A.one(node.get('hash'));

			if (!section) {
				return;
			}

			event.preventDefault();

			var offset = parseInt(node.attr('data-offset'), 10);

			var scrollTo = parseInt(section.getY(), 10);

			if (scrollTo - window.scrollY < triggerPos) {
				scrollTo -= bannerHeight;
			}

			if (offset) {
				scrollTo -= offset;
			}

			new A.Anim({
				duration: 0.5,
				easing: 'easeBoth',
				node: 'win',
				to: {
					scroll: [0, scrollTo]
				}
			}).run();

			window.history.pushState('', '', node.get('hash'));
		},
		'.animate-scroll'
	);
});

$(document).ready(function() { 
	$("input[type='submit']" ).on("click", function(evt) {
		evt.stopImmediatePropagation();
		progressbar();
    }); 
});

function progressbar(){
	$(".loader").show();
}

$(document).ajaxStart(function(){
	progressbar();
});   

$(document).ajaxComplete(function(){
	$(".loader").fadeOut("slow");
});