new Vue({
	el:"#login_page",
	data: {
		error: { display: "block"},
		msg: { display: "block"}
	},
	methods:{
		close: function(opt) {
			if(opt == "error") {
				this.error.display = "none";
			} else if(opt == "msg") {
				this.msg.display = "none";
			}
		}
	}
});