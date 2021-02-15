
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

function renderDashboard() {
		var watchlist = getWatchlist();
		for (var key in watchlist) {
			var watchdata = watchlist[key];
			var card = $('<div class="card" style="width: 30rem; height: 500px;"></div>').appendTo("#widget-row");
			var cardBody = $('<div class="card-body"></div>').appendTo(card).attr('id', 'card-body-'+key);
			$('<h5 class="card-title"></h5>').text(watchdata.brand + ' ' + watchdata.properties + ' ' + watchdata.description).appendTo(cardBody);
			
			getPriceHist(key, function(data, labels, cdata, xdata) {
				var cardBodyId = "#card-body-"+xdata.sku;
				var canvas = $("<canvas style='width: 100%;height: 300px;'></canvas>").appendTo(cardBodyId);
				var removeButton = $('<button class="btn btn-danger" aria-label="Left Align"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span>Remove</button>');
				removeButton.appendTo(cardBodyId);
				removeButton.click(() => {
					deleteFromWatchlist(key);
					$("#widget-row").empty();
					renderDashboard();
				});
				var ctx = canvas[0].getContext("2d");
				chartData(ctx, labels, cdata);
			});
		}
	if (Object.keys(watchlist).length == 0) {
		var html = `<div class="alert alert-primary" role="alert">
			Your watchlist is empty, click <a href="/pricelist.html">here</a> to monitor prices.
		</div>`
		$("#widget-row").html(html);
	}
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

function getNav(idx) {
	return `
<nav class="navbar sticky-top navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand" href="/">Pricelist Scrubber</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
  	<ul class="navbar-nav">
      <li class="nav-item ${idx == 0 ? 'active' : ''}">
        <a class="nav-link" href="/">Dashboard</a>
      </li>
      <li class="nav-item ${idx == 1 ? 'active' : ''}">
        <a class="nav-link" href="/pricelist.html">Price List</a>
      </li>
      <li class="nav-item ${idx == 2 ? 'active' : ''}">
        <a class="nav-link" href="/canvas.html">PC Canvas Helper</a>
      </li>
    </ul>
  </div>
</nav>
	`;
}

