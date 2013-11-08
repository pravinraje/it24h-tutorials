//	<ul class="menu_right">
//		<li class="dropdown" id="header_notification_bar">
//			<span class="badge" id="id_badge"></span>
//			<ul class="dropdown-menu-extended-notification">
//				<li>
//					<p> You have 14 new notification</p>
//				</li>
//				<li>
//					aaaaaaaaaaaaaaaaaaaaaaaaaaa
//				</li>
//			</ul>
//		</li>
//	</ul>
//		{{#header_notification_bar}}
//			<span {{data 'notifications'}} class="badge">{{number_notification}}</span>
//			<ul class="dropdown-menu-extended-notification">
//				<li>
//					{{notification}}
//				</li>
//			</ul>
//		{{/header_notification_bar}}

var Notification = can.Model.extend({
    findAll: 'GET /notification',
    findOne: 'GET /notification/{id}',
    create:  function( attrs ){
        return $.ajax("/notification/",{
        	type: "POST",
        	processData: false,
        	data: JSON.stringify(attrs),
        	dataType: 'json',
        	contentType: "application/json; charset=utf-8"
        });
    },
//    update: "/notification/{id}",
    update:  function(id, attrs ){
        return $.ajax("/notification/" + id,{
        	type: "PUT",
        	processData: false,
        	data: JSON.stringify(attrs),
        	dataType: 'json',
        	contentType: "application/json; charset=utf-8"
        });
    },
    destroy:"/notification/{id}" 
    
}, {});

var Notification_bar = can.Control.extend({
	"init" : function(element, options) {
		var el = $("#header_notification_bar");
		var el2 = $("#id_badge");
		Notification.findAll({}, function(notifications){
			console.log(notifications.length),
			console.log(notifications)
			
			var data = new can.Map({
			    number_notification: notifications.length,
			});	
			el2.html(can.view("template", {id_badge : data}));
			el.html(can.view("template", {header_notification_bar : notifications}));
		})
	}
});

var Badge = can.Control.extend({

});

var Routing = can.Control.extend({
	"init" : function() {
		//new Badge("#id_badge");
		new Notification_bar("#header_notification_bar");
	}
});

function toggle_visibility(id) {
    var e = document.getElementById(id);
    if(e.style.display == 'block')
       e.style.display = 'none';
    else
       e.style.display = 'block';
 }

function hide_visibility(id) {
    var e = document.getElementById(id);
    e.style.display = 'none';
 }

function show_visibility(id) {
    var e = document.getElementById(id);
    e.style.display = 'block';
 }

new Routing(document.body);
can.route.ready()