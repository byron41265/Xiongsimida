define(function(require, exports, module) {
  // 模块代码
	var $ = require("jquery");
	require("jquery-form");
	
	module.exports= {
		init: function(){
			
			$("form").form({
				validate: true,
				action: {
					processResult: function(result){
						if("success" == result){
							window.location ="/login";
						}else{
							$.message('danger',"Inconsistent password entered twice");
						}
						
					}
				}
				
			});
			
			
		}
	};
	
});
	