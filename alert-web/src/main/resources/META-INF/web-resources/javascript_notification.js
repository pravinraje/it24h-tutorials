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

//var Notification = can.Model.extend({
//    findAll: 'GET /notification',
//    findOne: 'GET /notification/{id}',
//    create:  function( attrs ){
//        return $.ajax("/notification/",{
//        	type: "POST",
//        	processData: false,
//        	data: JSON.stringify(attrs),
//        	dataType: 'json',
//        	contentType: "application/json; charset=utf-8"
//        });
//    },
////    update: "/notification/{id}",
//    update:  function(id, attrs ){
//        return $.ajax("/notification/" + id,{
//        	type: "PUT",
//        	processData: false,
//        	data: JSON.stringify(attrs),
//        	dataType: 'json',
//        	contentType: "application/json; charset=utf-8"
//        });
//    },
//    destroy:"/notification/{id}" 
//    
//}, {});
//
//var Badge = can.Control.extend({
//	"init" : function(element, options) {
//		var el = $("id_badge");
//		Notification.findAll({}, function(notification){
//			el.
//		});
//		
//	}
//});
//
//
//var Routing = can.Control.extend({
//	"init" : function() {
//		this.id_badge = new Badge("#id_badge");
//	}
//});
//
//new Routing(document.body);
//can.route.ready()

var data = new can.Map({
    user: 'Tina Fey',
    messages: 0
});

var template = can.view("#template", data)
document.body.appendChild(template);