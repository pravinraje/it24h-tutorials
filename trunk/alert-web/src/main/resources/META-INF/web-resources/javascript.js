// Setup the model to work with dummy todos because we don't have a service
// Only findAll and update are used.
var TODOS = [
    {id: 1, title: "wake up", completed: true},
    {id: 2, title: "take out trash", completed: false},
    {id: 3, title: "do dishes", completed: false}
];

var Todo = can.Model.extend({
    findAll: 'GET /todos',
    findOne: 'GET /todos/{id}',
    create:  function( attrs ){
        return $.ajax("/todos/",{
        	type: "POST",
        	processData: false,
        	data: JSON.stringify(attrs),
        	dataType: 'json',
        	contentType: "application/json; charset=utf-8"
        });
    },
//    update: "/todos/{id}",
    update:  function(id, attrs ){
        return $.ajax("/todos/" + id,{
        	type: "PUT",
        	processData: false,
        	data: JSON.stringify(attrs),
        	dataType: 'json',
        	contentType: "application/json; charset=utf-8"
        });
    },
    destroy:"/todos/{id}" 
    
}, {});
//var Todo = can.Model.extend({
//    findAll : function(){
//      return $.Deferred().resolve(TODOS);
//    },
//    findOne : function(params){
//      return $.Deferred().resolve(TODOS[(+params.id)-1]);
//    },
//    update  : function(id, attrs){
//        // update TODOS with the new attrs
//        $.extend(TODOS[id -1], attrs);
//        return $.Deferred().resolve()
//    },
//    destroy : function(){
//        return $.Deferred().resolve()
//    }
//},
//{});
var _addtodo = new Todo({title: "this is new"});
	_addtodo.bind("created", function(ev, created) {
	console.log("Event: ");
	console.log(ev);
	console.log("Created: ");
	console.log(created);
	console.log(this);
});
_addtodo.save();

var Todos = can.Control.extend({
	"init" : function(element, options) {
		var el = $("#todos"); //= this.element; 
		Todo.findAll({}, function(todos) {
			console.log("findAll");
			TODOS = todos;
			todos.bind("remove", function( ev, oldVals, indx ) {
				
			    console.log(oldVals)
			})
			el.html(can.view("todosEjs", {todos: todos}));
		});
	},
	
	"tr click" : function(tr) {
		tr.trigger("selected", tr.data("todo"));
//		console.log("hello the <tr>");
	},
	
	"tr .destroy click" : function(el, ev) {
//		alert("Ban da delete: "+el.closest('tr').data('todo').title);
		var todo = el.closest('tr').data('todo');
		console.log(TODOS);
		console.log(todo);
		todo.destroy(function(destroyed) {
			console.log(destroyed);
		}, function(xhr) {
			console.log(xhr);
			console.log("failed to destroyed");
		});
		
		
		ev.stopPropagation();
	},
});

var Editor = can.Control.extend({
	"todo" : function(todo) {
		this.options.todo = todo;
		this.on();
		this.settitle();
	},
	settitle : function(){
		this.element.val(this.options.todo.title);
	},
	"change" : function() {
		var todo = this.options.todo;
		todo.attr('title', this.element.val());
		todo.save();
	}
}); 

var Add = can.Control.extend({
	"init" : function(element, options) {
		console.log("hello aa");
	},
	"span click" : function(span) {
		alert("aaaaaaaaaaaa");
		console.log("hello aaaaa");
	},
});

var Routing = can.Control.extend({
	"init" : function() {
		this.editor = new Editor("#editor");
		new Todos("#todos");
		new Add("#addtitle");
	},
	//the index page
	"route" : function() {
		$("#editor").hide();
	},
	"todos/:id route" : function(data) {
		$("#editor").show();
		Todo.findOne(data, $.proxy(function(todo){
			this.editor.todo(todo);
		}, this));
	},
	"tr selected" : function(el, ev, todo) {
		can.route.attr("id", todo.id);
	}
}) ;

new Routing(document.body);

can.route.ready()