
function getPriceHist(sku, callback) {
	$.get("/api/pchub?sku=" + sku, function(data) {
		var labels = [];
		var cdata = [];
		for (var i = 0; i < data.length; i++) {
			var currData = data[i];
			labels.push(new Date(currData.recordedDate)
					.toLocaleDateString("en-US"));
			cdata.push(currData.cashPrice);
		}
		xdata = data[data.length-1];
		callback(data, labels, cdata, xdata);
		
	});
}

function getWatchlist() {
	var watchlist = store.get("watchlist");
	if (!watchlist) {
		watchlist = {};
		store.set("watchlist", watchlist);
	}
	return watchlist;
}

function saveWatchlist(watchlist) {
	store.set("watchlist", watchlist);
}

function addToWatchlist(key, value) {
	var watchlist = getWatchlist();
	watchlist[key] = value;
	saveWatchlist(watchlist);
}

function deleteFromWatchlist(key) {
	var watchlistStore = getWatchlist();
	delete watchlistStore[key];
	saveWatchlist(watchlistStore);
}

function chartData(ctx, labels, cdata) {
	new Chart(ctx, {
					type : 'line',
					data : {
						labels : labels,
						datasets : [ {
							label : 'Amount',
							data : cdata,
							fill : false,
							borderColor : 'rgba(250, 100, 100, 1)',
							lineTension : 0,
						} ]
					},
					options : {
						responsive : false,
						maintainAspectRatio : false,
						legend : {
							onClick : null,
							display: false
						}
					}
				});
}