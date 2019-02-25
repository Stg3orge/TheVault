class AlertBox extends HTMLElement {
	constructor() {

		super();
		
		var shadow = this.attachShadow({ mode: "open" });

		var box = document.createElement("div");
		box.setAttribute("class", "box");

		var text = this.getAttribute("text");
		box.innerText = text;

		var styletag = document.createElement("style");
		styletag.textContent = ".box{padding:20px;border:1px solid #CCCCF}";

		shadow.appendChild(styletag);
		shadow.appendChild(box);
	}
}