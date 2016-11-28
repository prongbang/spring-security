new Vue({
	el:"#login_page",
	data: {
		error: { display: "block"},
		msg: { display: "block"},
		expired: { display: "block" },
		duplicate: { display: "block" }
	},
	methods:{
		close: function(opt) {
			if(opt == "error") {
				this.error.display = "none";
			} else if(opt == "msg") {
				this.msg.display = "none";
			} else if(opt == "expired") {
				this.expired.display = "none";
			} else if(opt == "duplicate") {
				this.duplicate.display = "none";
			}
		}
	}
});