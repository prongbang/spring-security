new Vue({
	el:"#authoritity",
	data: {
		roles:[],
		error:null,
		isLoading: ""
	},
	methods: {
		init: function() {
			
		},
		loadAuthoritity: function(url) {
			this.$http.get(url).then(function(response) { 
				if(!!response.body) {
					this.roles = response.body;
					this.isLoading = "";
				}
			}, function(response) {
				this.error = response;
				this.isLoading = "";
			});
		},
		load: function() {
			this.isLoading = "is-loading";
			this.loadAuthoritity("./authorities/find-all");
		}
	},
	created: function() {
		this.init();
	}
});